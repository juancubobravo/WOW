import exceptions.*;
import uma.wow.proyecto.*;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class TransaccionEJB implements GestionTransaccion{

    @PersistenceContext(unitName="WOWEJB")
    private EntityManager em;

    //R14
    public void transaccionClienteAutorizado(Individual ind, PersonaAutorizada persAuto, String IBANdestino, String IBANorigen, double saldo)
            throws ClienteNoEncontrado, PersonaAutorizadaNoEncontrada {
        Individual individual = em.find(Individual.class, ind.getId());
        if(individual == null){
            throw new ClienteNoEncontrado();
        }

        PersonaAutorizada personaAutorizada = em.find(PersonaAutorizada.class, persAuto.getId());
        if(personaAutorizada == null){
            throw new PersonaAutorizadaNoEncontrada();
        }

        //  estado de las cuentas, personas, cuentas


    }




}