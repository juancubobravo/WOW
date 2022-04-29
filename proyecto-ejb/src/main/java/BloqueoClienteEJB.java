import exceptions.*;
import uma.wow.proyecto.*;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

public class BloqueoClienteEJB implements GestionBloqueoCliente{

	@EJB
	AccesoEJB acceso;
    @PersistenceContext(unitName="WOWEJB")
    private EntityManager em;


    // R16 
    @Override
    public void bloqueoPersonaFisica(Individual c,Usuario admin) throws ClienteNoEncontrado, CuentaDeBaja, UsuarioNoEncontrado, ContraseniaInvalida, NoAdministradorException{
        
    	acceso.loginAdministrador(admin);
    	Individual cliente = em.find(Individual.class, c.getId());
    	if(cliente == null) {
    		throw new ClienteNoEncontrado();
    	}
    	if(cliente.getEstado().equals("BAJA")) {
    		throw new CuentaDeBaja();
    	}
    	cliente.setEstado("BLOQUEADO");

    }

    @Override
    public void bloqueoAutorizado(PersonaAutorizada c,Usuario admin) throws ClienteNoEncontrado, CuentaDeBaja, UsuarioNoEncontrado, ContraseniaInvalida, NoAdministradorException{
        
    	acceso.loginAdministrador(admin);
    	PersonaAutorizada cliente = em.find(PersonaAutorizada.class, c.getId());
    	if(cliente == null) {
    		throw new ClienteNoEncontrado();
    	}
    	if(cliente.getEstado().equals("BAJA")) {
    		throw new CuentaDeBaja();
    	}
    	cliente.setEstado("BLOQUEADO");

    }
    
    @Override
    public void bloqueoEmpresa(Empresa c,Usuario admin) throws ClienteNoEncontrado, CuentaDeBaja, UsuarioNoEncontrado, ContraseniaInvalida, NoAdministradorException{
        
    	acceso.loginAdministrador(admin);
    	Empresa cliente = em.find(Empresa.class, c.getId());
    	if(cliente == null) {
    		throw new ClienteNoEncontrado();
    	}
    	if(cliente.getEstado().equals("BAJA")) {
    		throw new CuentaDeBaja();
    	}
    	cliente.setEstado("BLOQUEADO");
    	
    	List<Autorizacion> autorizacionList = cliente.getAutori();
    	List<PersonaAutorizada> listaPersonasAutorizadas = new ArrayList<>();
    	
    	if(!autorizacionList.isEmpty()) {
        	for (Autorizacion auto: autorizacionList) {
                listaPersonasAutorizadas.add(auto.getIdAutorizada());
            }
        	for (PersonaAutorizada p:listaPersonasAutorizadas) {
        		PersonaAutorizada autorizado = em.find(PersonaAutorizada.class, p.getId());
        		autorizado.setEstado("BLOQUEADO");
        	}
    	}

    }
    
    @Override
    public void desbloqueoPersonaFisica(Individual c,Usuario admin) throws ClienteNoEncontrado, CuentaDeBaja, UsuarioNoEncontrado, ContraseniaInvalida, NoAdministradorException{
        
    	acceso.loginAdministrador(admin);
    	Individual cliente = em.find(Individual.class, c.getId());
    	if(cliente == null) {
    		throw new ClienteNoEncontrado();
    	}
    	if(cliente.getEstado().equals("BAJA")) {
    		throw new CuentaDeBaja();
    	}
    	cliente.setEstado("ACTIVO");

    }
    
    @Override
    public void desbloqueoAutorizado(PersonaAutorizada c,Usuario admin) throws ClienteNoEncontrado, CuentaDeBaja, UsuarioNoEncontrado, ContraseniaInvalida, NoAdministradorException{
        
    	acceso.loginAdministrador(admin);
    	PersonaAutorizada cliente = em.find(PersonaAutorizada.class, c.getId());
    	if(cliente == null) {
    		throw new ClienteNoEncontrado();
    	}
    	if(cliente.getEstado().equals("BAJA")) {
    		throw new CuentaDeBaja();
    	}
    	cliente.setEstado("ACTIVO");

    }
    
    @Override
    public void desbloqueoEmpresa(Empresa c,Usuario admin) throws ClienteNoEncontrado, CuentaDeBaja, UsuarioNoEncontrado, ContraseniaInvalida, NoAdministradorException{
        
    	acceso.loginAdministrador(admin);
    	Empresa cliente = em.find(Empresa.class, c.getId());
    	if(cliente == null) {
    		throw new ClienteNoEncontrado();
    	}
    	if(cliente.getEstado().equals("BAJA")) {
    		throw new CuentaDeBaja();
    	}
    	cliente.setEstado("ACTIVO");
    	
    	List<Autorizacion> autorizacionList = cliente.getAutori();
    	List<PersonaAutorizada> listaPersonasAutorizadas = new ArrayList<>();
    	
    	if(!autorizacionList.isEmpty()) {
        	for (Autorizacion auto: autorizacionList) {
                listaPersonasAutorizadas.add(auto.getIdAutorizada());
            }
        	for (PersonaAutorizada p:listaPersonasAutorizadas) {
        		PersonaAutorizada autorizado = em.find(PersonaAutorizada.class, p.getId());
        		autorizado.setEstado("ACTIVO");
        	}
    	}

    }
    
   

}
