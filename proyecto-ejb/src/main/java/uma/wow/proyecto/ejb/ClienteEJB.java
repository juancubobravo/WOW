package uma.wow.proyecto.ejb;
import uma.wow.proyecto.ejb.exceptions.*;

import java.time.LocalDate;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


import uma.wow.proyecto.*;

@Stateless
public class ClienteEJB implements GestionCliente{

	
	
    @PersistenceContext(unitName="WOWEJB")
    private EntityManager em;

    //R2
    @Override
    public void altaCliente(Empresa cliente, Usuario usuario) throws UsuarioException, UsuarioNoEncontrado, ContraseniaInvalida, NoAdministradorException, ClienteNoEncontrado, ClienteYaExistente{
    	
    	

        Empresa busc = em.find(Empresa.class, cliente.getId());

        Usuario admin = em.find(Usuario.class, usuario.getNombreUsuario());
        
        if(admin.getPersonaAutorizada()!=null) {
        	throw new NoAdministradorException();
        }
        
        if(busc != null){
            throw new ClienteYaExistente();
        }
        
        busc.setFechaAlta(LocalDate.now().toString());
        busc.setEstado("ACTIVA");
        busc.setTipoCliente("JURIDICO");
        
        em.persist(cliente);
    }
    
    public void altaCliente(Individual cliente, Usuario usuario) throws UsuarioException, UsuarioNoEncontrado, ContraseniaInvalida, NoAdministradorException, ClienteNoEncontrado, ClienteYaExistente{
    	
    	

        Individual busc = em.find(Individual.class, cliente.getId());

        Usuario admin = em.find(Usuario.class, usuario.getNombreUsuario());
        
        if(admin.getPersonaAutorizada()!=null) {
        	throw new NoAdministradorException();
        }
        
        if(busc != null){
            throw new ClienteYaExistente();
        }
        
        busc.setFechaAlta(LocalDate.now().toString());
        busc.setEstado("ACTIVA");
        busc.setTipoCliente("FISICA");
        
        em.persist(cliente);
    }

    //R3
  
    @Override
    public void modificaCliente(Empresa cliente,Usuario usuario) throws ClienteNoEncontrado, UsuarioNoEncontrado, ContraseniaInvalida, NoAdministradorException{
    
    	
    	Usuario admin = em.find(Usuario.class, usuario.getNombreUsuario());
    	
    	if(admin == null) {
    		throw new NoAdministradorException();
    	}
    	
        Empresa oldCliente = em.find(Empresa.class, cliente.getId());

        if(oldCliente == null){
            throw new ClienteNoEncontrado();
        }

        cliente.setEstado(oldCliente.getEstado());
        cliente.setFechaAlta(oldCliente.getFechaAlta().toString());
        cliente.setTipoCliente(oldCliente.getTipoCliente());
      
        if( oldCliente.getFechaBaja()!=null) {
            	 oldCliente.setFechaBaja((String) cliente.getFechaBaja());
                 
          }
            
        em.merge(cliente);
        
    }
    
    //R3
	@Override
	public void modificaCliente(Individual cliente, Usuario usuario) throws ClienteNoEncontrado, UsuarioNoEncontrado, ContraseniaInvalida, NoAdministradorException {
    	
		
        Usuario admin = em.find(Usuario.class, usuario.getNombreUsuario());
    	
    	if(admin == null) {
    		throw new NoAdministradorException();
    	}
		
		
        Individual oldCliente = em.find(Individual.class, cliente.getId());

        if(oldCliente == null){
            throw new ClienteNoEncontrado();
        }

        cliente.setEstado(oldCliente.getEstado());
        cliente.setFechaAlta(oldCliente.getFechaAlta().toString());
        cliente.setTipoCliente(oldCliente.getTipoCliente());
       
            if(cliente.getFechaBaja()!=null) {
            	cliente.setFechaBaja((String) cliente.getFechaBaja());
            }
            
            em.merge(cliente);
	}

    // R4
    @Override
    public void bajaCliente(Individual c, Usuario usuario) throws ClienteNoEncontrado, CuentasActivas, UsuarioNoEncontrado, ContraseniaInvalida, NoAdministradorException, CuentaDeBaja{
    	
    	
    	  Usuario admin = em.find(Usuario.class, usuario.getNombreUsuario());
      	
      	if(admin == null) {
      		throw new NoAdministradorException();
      	}
    	
        Individual cliente = em.find(Individual.class, c.getId());
        if(cliente == null){
            throw new ClienteNoEncontrado();
        }
        
        if(c.getEstado().equals("BAJA")) {
        	throw new CuentaDeBaja();
        }

        List<CuentaFintech> listCuentas = cliente.getCuentas();

        boolean cuenta_activa = false;

        if(listCuentas!=null) {
        	
        	 for (CuentaFintech cuenta: listCuentas) {
                 if(cuenta.getEstado().equals("ACTIVO")){
                     cuenta_activa = true;
                 }
             }

             if(cuenta_activa){
                 throw new CuentasActivas();
             }
        }
        c.setEstado("BAJA");

    }
    
    // R4
    @Override
    public void bajaCliente(Empresa c, Usuario usuario) throws ClienteNoEncontrado, CuentasActivas, UsuarioNoEncontrado, ContraseniaInvalida, NoAdministradorException{
    
    	Usuario admin = em.find(Usuario.class, usuario.getNombreUsuario());
        	
        if(admin == null) {
        		throw new NoAdministradorException();
        }
    	
        Empresa cliente = em.find(Empresa.class, c.getId());
        if(cliente == null){
            throw new ClienteNoEncontrado();
        }

        List<CuentaFintech> listCuentas = cliente.getCuentas();

        boolean cuenta_activa = false;

        if(listCuentas!=null) {
        	
       	 for (CuentaFintech cuenta: listCuentas) {
                if(cuenta.getEstado().equals("ACTIVO")){
                    cuenta_activa = true;
                }
            }

            if(cuenta_activa){
                throw new CuentasActivas();
            }
       }

        c.setEstado("BAJA");

    }
    
    @Override
    public List<Individual> devolverTodosClientesIndividuales(){
        TypedQuery<Individual> query = em.createQuery("SELECT c FROM Individual c", Individual.class);
        List<Individual> clientes= query.getResultList();
        return clientes;
    }
    
    @Override
    public List<Empresa> devolverTodosClientesEmpresa(){
        TypedQuery<Empresa> query = em.createQuery("SELECT c FROM Empresa c", Empresa.class);
        List<Empresa> clientes= query.getResultList();
        return clientes;
    }
    
    @Override
    public Empresa devolverEmpresa(String identificacion) throws ClienteNoEncontrado {
        Empresa cliente = em.find(Empresa.class, identificacion);
        if(cliente == null) {
            throw new ClienteNoEncontrado();
        }
        return cliente;
    }
    
    @Override
    public Individual devolverIndividual(String identificacion) throws ClienteNoEncontrado {
        Individual cliente = em.find(Individual.class, identificacion);
        if(cliente == null) {
            throw new ClienteNoEncontrado();
        }
        return cliente;
    }
    
    


}
