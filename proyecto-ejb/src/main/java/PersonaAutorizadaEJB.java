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

    //R6
    @Override
    public void anyadirPersonaAutorizada(PooledAccount c, PersonaAutorizada pers, Usuario user) throws ClienteNoEncontrado, CuentaNoEncontrada, NoEsEmpresaException, UsuarioNoEncontrado, ContraseniaInvalida, NoAdministradorException {
        acceso.loginAdministrador(user);
    	PooledAccount cuenta = em.find(PooledAccount.class, c.getIban());
        if(cuenta == null){
            throw new CuentaNoEncontrada();
        }

        Cliente cliente = cuenta.getCliente();
        if(cliente == null){
            throw new ClienteNoEncontrado();
        }

        if(cliente.getTipoCliente().equals("EMPRESA")){
            List<Autorizacion> listaAutorizaciones = ((Empresa) cliente).getAutori();
            Autorizacion auto = new Autorizacion();
            auto.setEmpresa((Empresa)cliente);
            auto.setIdAutorizada(pers);
            AutorizacionPK pk = new AutorizacionPK();
            pk.setEmpresaId(cliente.getId());
            pk.setPersonaAutorizadaId(pers.getId());
            auto.setId(pk);
            auto.setTipo("");
            listaAutorizaciones.add(auto);
            ((Empresa) cliente).setAutori(listaAutorizaciones);
        } else {
        	throw new NoEsEmpresaException();
        }
    }
    
    //R6
    @Override
    public void anyadirPersonaAutorizada(Segregada c, PersonaAutorizada pers, Usuario user) throws ClienteNoEncontrado, CuentaNoEncontrada, NoEsEmpresaException, UsuarioNoEncontrado, ContraseniaInvalida, NoAdministradorException {
        acceso.loginAdministrador(user);
    	Segregada cuenta = em.find(Segregada.class, c.getIban());
        if(cuenta == null){
            throw new CuentaNoEncontrada();
        }

        Cliente cliente = cuenta.getCliente();
        if(cliente == null){
            throw new ClienteNoEncontrado();
        }

        if(cliente.getTipoCliente().equals("EMPRESA")){
            List<Autorizacion> listaAutorizaciones = ((Empresa) cliente).getAutori();
            Autorizacion auto = new Autorizacion();
            auto.setEmpresa((Empresa)cliente);
            auto.setIdAutorizada(pers);
            AutorizacionPK pk = new AutorizacionPK();
            pk.setEmpresaId(cliente.getId());
            pk.setPersonaAutorizadaId(pers.getId());
            auto.setId(pk);
            auto.setTipo("");
            listaAutorizaciones.add(auto);
            ((Empresa) cliente).setAutori(listaAutorizaciones);
        } else {
        	throw new NoEsEmpresaException();
        }
    }

    //R7
    @Override
    public void modificaPersonaAutorizada(PersonaAutorizada nuevosDatos) throws PersonaAutorizadaNoEncontrada {
        PersonaAutorizada personaAutorizada = em.find(PersonaAutorizada.class, nuevosDatos.getId());
        if(personaAutorizada == null){
            throw new PersonaAutorizadaNoEncontrada();
        }

        if(nuevosDatos.getIdentificacion() != null && nuevosDatos.getNombre() != null &&
                nuevosDatos.getApellidos() != null && nuevosDatos.getDireccion() != null){
            personaAutorizada.setIdentificacion(nuevosDatos.getIdentificacion());
            personaAutorizada.setNombre(nuevosDatos.getNombre());
            personaAutorizada.setApellidos(nuevosDatos.getApellidos());
            personaAutorizada.setDireccion(nuevosDatos.getDireccion());
            personaAutorizada.setFechaNacimiento(nuevosDatos.getFechaNacimiento());
            personaAutorizada.setEstado(nuevosDatos.getEstado());
            personaAutorizada.setFechaInicio(nuevosDatos.getFechaInicio());
            personaAutorizada.setFechaFin(nuevosDatos.getFechaFin());
          //  personaAutorizada.setAutorizacionesPersona(nuevosDatos.getAutorizacionesPersona());
            personaAutorizada.setUsuario(nuevosDatos.getUsuario());
        }

    }



    // R8
    @Override
    public void borraPersonaAutorizada(String IBAN, PersonaAutorizada pers) throws ClienteNoEncontrado, CuentaNoEncontrada {
        CuentaFintech cuenta = em.find(CuentaFintech.class, IBAN);
        if(cuenta == null){
            throw new CuentaNoEncontrada();
        }

        Cliente cliente = cuenta.getCliente();
        if(cliente == null){
            throw new ClienteNoEncontrado();
        }

        if(cliente.getTipoCliente().equals("PERSONA_JURIDICA")){
           // Set<Autorizacion> listaAutorizaciones = ((Empresa) cliente).getAutorizacionesEmpresa();
           // Autorizacion aux = new Autorizacion(pers, (Empresa) cliente);
          //  if (listaAutorizaciones.contains(aux)) listaAutorizaciones.remove(aux);
        }
    }

}