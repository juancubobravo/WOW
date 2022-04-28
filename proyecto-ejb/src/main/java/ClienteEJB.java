import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import exceptions.ClienteNoEncontrado;
import exceptions.ContraseniaInvalida;
import exceptions.CuentasActivas;
import exceptions.DatosException;
import exceptions.NoAdministradorException;
import exceptions.UsuarioException;
import exceptions.UsuarioNoEncontrado;
import uma.wow.proyecto.*;

@Stateless
public class ClienteEJB implements GestionCliente{

	@EJB
	private AccesoEJB acceso;
    @PersistenceContext(unitName="WOWEJB")
    private EntityManager em;

    //R2
    @Override
    public void altaCliente(Empresa cliente, Usuario usuario) throws UsuarioException, UsuarioNoEncontrado, ContraseniaInvalida, NoAdministradorException{
    	
    	acceso.loginAdministrador(usuario);

        Empresa busc = em.find(Empresa.class, cliente.getId());

        if(busc != null){
            throw new UsuarioException();
        }

        em.persist(cliente);
    }
    
    public void altaCliente(Individual cliente, Usuario usuario) throws UsuarioException, UsuarioNoEncontrado, ContraseniaInvalida, NoAdministradorException{
    	
    	acceso.loginAdministrador(usuario);

        Individual busc = em.find(Individual.class, cliente.getId());

        if(busc != null){
            throw new UsuarioException();
        }

        em.persist(cliente);
    }

    //R3
  
    @Override
    public void modificaCliente(Empresa cliente,Usuario usuario) throws ClienteNoEncontrado, UsuarioNoEncontrado, ContraseniaInvalida, NoAdministradorException{
    	acceso.loginAdministrador(usuario);
        Empresa oldCliente = em.find(Empresa.class, cliente.getId());

        if(oldCliente == null){
            throw new ClienteNoEncontrado();
        }

    
            oldCliente.setIdentificacion(cliente.getIdentificacion());
            oldCliente.setTipoCliente(cliente.getTipoCliente()); // ACABAR (QUE PASA SI SE CAMBIA DE EMPRESA A INDIVIDUAL)
            oldCliente.setEstado(cliente.getEstado());
            oldCliente.setFechaAlta(cliente.getFechaAlta());
            oldCliente.setFechaBaja(cliente.getFechaBaja());
            oldCliente.setDireccion(cliente.getDireccion());
            oldCliente.setCiudad(cliente.getCiudad());
            oldCliente.setCodigoPostal(cliente.getCodigoPostal());
            oldCliente.setPais(cliente.getPais());
            oldCliente.setCuentas(cliente.getCuentas());
            oldCliente.setUsuario(cliente.getUsuario());
            oldCliente.setRazon_Social(cliente.getRazon_Social());
           
        
    }
    
    //R3
	@Override
	public void modificaCliente(Individual cliente, Usuario usuario) throws ClienteNoEncontrado, UsuarioNoEncontrado, ContraseniaInvalida, NoAdministradorException {
    	acceso.loginAdministrador(usuario);
        Individual oldCliente = em.find(Individual.class, cliente.getId());

        if(oldCliente == null){
            throw new ClienteNoEncontrado();
        }

    
            oldCliente.setIdentificacion(cliente.getIdentificacion());
            oldCliente.setTipoCliente(cliente.getTipoCliente()); // ACABAR (QUE PASA SI SE CAMBIA DE EMPRESA A INDIVIDUAL)
            oldCliente.setEstado(cliente.getEstado());
            oldCliente.setFechaAlta(cliente.getFechaAlta());
            oldCliente.setFechaBaja(cliente.getFechaBaja());
            oldCliente.setDireccion(cliente.getDireccion());
            oldCliente.setCiudad(cliente.getCiudad());
            oldCliente.setCodigoPostal(cliente.getCodigoPostal());
            oldCliente.setPais(cliente.getPais());
            oldCliente.setCuentas(cliente.getCuentas());
            oldCliente.setUsuario(cliente.getUsuario());
            oldCliente.setNombre(cliente.getNombre());
            oldCliente.setApellido(cliente.getApellido());
            oldCliente.setFecha_nacimiento(cliente.getFechaNacimiento());
		
	}

    // R4
    @Override
    public void bajaCliente(Cliente c) throws ClienteNoEncontrado, CuentasActivas{
        Cliente cliente = em.find(Cliente.class, c.getId());
        if(cliente == null){
            throw new ClienteNoEncontrado();
        }

        List<CuentaFintech> listCuentas = cliente.getCuentas();

        int ok = 0;

        for (CuentaFintech cuenta: listCuentas) {
            if(cuenta.getEstado().equals("ACTIVO")){
                ok = 1;
            }
        }

        if(ok == 1){
            throw new CuentasActivas();
        }

        cliente.setEstado("BAJA");

    }


}
