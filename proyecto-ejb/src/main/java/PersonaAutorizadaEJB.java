import exceptions.*;
import uma.wow.proyecto.*;

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

    @PersistenceContext(unitName="WOWEJB")
    private EntityManager em;

    //R6
    @Override
    public void anyadirPersonaAutorizada(String IBAN, PersonaAutorizada pers) throws ClienteNoEncontrado, CuentaNoEncontrada {
        CuentaFintech cuenta = em.find(CuentaFintech.class, IBAN);
        if(cuenta == null){
            throw new CuentaNoEncontrada();
        }

        Cliente cliente = cuenta.getCliente();
        if(cliente == null){
            throw new ClienteNoEncontrado();
        }

        if(cliente.getTipoCliente().equals("EMPRESA")){
            //List<Autorizacion> listaAutorizaciones = ((Empresa) cliente).getListAutorizaciones();
           // listaAutorizaciones.add(new Autorizacion(pers, (Empresa) cliente));
           // ((Empresa) cliente).setListAutorizaciones(listaAutorizaciones);
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