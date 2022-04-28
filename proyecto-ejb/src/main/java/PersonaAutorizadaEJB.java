import exceptions.*;
import uma.wow.proyecto.*;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

@Stateless
public class PersonaAutorizadaEJB implements GestionPersonaAutorizada{
	
	@EJB
	AccesoEJB acceso;

    @PersistenceContext(unitName="WOWEJB")
    private EntityManager em;

    //R6 y R15
    @Override
    public void anyadirPersonaAutorizada(PooledAccount c, PersonaAutorizada pers, Usuario user, String tipo) throws ClienteNoEncontrado, CuentaNoEncontrada, NoEsEmpresaException, UsuarioNoEncontrado, ContraseniaInvalida, NoAdministradorException {
        acceso.loginAdministrador(user);
    	PooledAccount cuenta = em.find(PooledAccount.class, c.getIban());
        if(cuenta == null){
            throw new CuentaNoEncontrada();
        }

        Cliente cl = cuenta.getCliente();
        Empresa cliente = em.find(Empresa.class, cl.getId()); 
        if(cliente == null){
            throw new ClienteNoEncontrado();
        }

        if(cliente.getTipoCliente().equals("EMPRESA")){
            List<Autorizacion> listaAutorizaciones = cliente.getAutori();
            Autorizacion auto = new Autorizacion();
            auto.setEmpresa(cliente);
            auto.setIdAutorizada(pers);
            AutorizacionPK pk = new AutorizacionPK();
            pk.setEmpresaId(cliente.getId());
            pk.setPersonaAutorizadaId(pers.getId());
            auto.setId(pk);
            auto.setTipo(tipo);
            listaAutorizaciones.add(auto);
            cliente.setAutori(listaAutorizaciones);
            em.persist(pk);
            em.persist(auto);
            
        } else {
        	throw new NoEsEmpresaException();
        }
    }
    
    //R6 y //R15
    @Override
    public void anyadirPersonaAutorizada(Segregada c, PersonaAutorizada pers, Usuario user, String tipo) throws ClienteNoEncontrado, CuentaNoEncontrada, NoEsEmpresaException, UsuarioNoEncontrado, ContraseniaInvalida, NoAdministradorException {
        acceso.loginAdministrador(user);
    	Segregada cuenta = em.find(Segregada.class, c.getIban());
        if(cuenta == null){
            throw new CuentaNoEncontrada();
        }

        Cliente cl = cuenta.getCliente();
        Empresa cliente = em.find(Empresa.class, cl.getId()); 
        if(cliente == null){
            throw new ClienteNoEncontrado();
        }

        if(cliente.getTipoCliente().equals("EMPRESA")){
            List<Autorizacion> listaAutorizaciones = cliente.getAutori();
            Autorizacion auto = new Autorizacion();
            auto.setEmpresa(cliente);
            auto.setIdAutorizada(pers);
            AutorizacionPK pk = new AutorizacionPK();
            pk.setEmpresaId(cliente.getId());
            pk.setPersonaAutorizadaId(pers.getId());
            auto.setId(pk);
            auto.setTipo(tipo);
            listaAutorizaciones.add(auto);
            cliente.setAutori(listaAutorizaciones);
            em.persist(pk);
            em.persist(auto);
            
        } else {
        	throw new NoEsEmpresaException();
        }
    }

    //R7
    @Override
    public void modificaPersonaAutorizada(PersonaAutorizada nuevosDatos, Usuario user) throws PersonaAutorizadaNoEncontrada, UsuarioNoEncontrado, ContraseniaInvalida, NoAdministradorException {
        acceso.loginAdministrador(user);
    	PersonaAutorizada personaAutorizada = em.find(PersonaAutorizada.class, nuevosDatos.getId());
        if(personaAutorizada == null){
            throw new PersonaAutorizadaNoEncontrada();
        }


            personaAutorizada.setIdentificacion(nuevosDatos.getIdentificacion());
            personaAutorizada.setNombre(nuevosDatos.getNombre());
            personaAutorizada.setApellidos(nuevosDatos.getApellidos());
            personaAutorizada.setDireccion(nuevosDatos.getDireccion());
            personaAutorizada.setFechaNacimiento(nuevosDatos.getFechaNacimiento());
            personaAutorizada.setEstado(nuevosDatos.getEstado());
            personaAutorizada.setFechaInicio(nuevosDatos.getFechaInicio());
            personaAutorizada.setFechaFin(nuevosDatos.getFechaFin());
            personaAutorizada.setAutori(nuevosDatos.getAutori());
            personaAutorizada.setUsuario(nuevosDatos.getUsuario());

    }



    // R8
    @Override
    public void borraPersonaAutorizada(PersonaAutorizada pers, Usuario user) throws PersonaAutorizadaNoEncontrada,UsuarioNoEncontrado, ContraseniaInvalida, NoAdministradorException {
    	acceso.loginAdministrador(user);
    	PersonaAutorizada persona = em.find(PersonaAutorizada.class, pers.getId());
    	if(persona == null) {
    		throw new PersonaAutorizadaNoEncontrada();
    	}
    	persona.setEstado("BAJA");

    }

}