import exceptions.*;
import uma.wow.proyecto.*;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.ClientInfoStatus;
import java.util.List;

@Stateless
public class CuentaEJB implements GestionCuenta {

    @PersistenceContext(name="WOWEJB")
    private EntityManager em;

    // R5
    //@Override
    public void creaCuenta(CuentaFintech cuentaNueva, Cliente c) throws CuentaEncontrada, ClienteNoEncontrado {
        CuentaFintech cuenta = em.find(CuentaFintech.class, cuentaNueva.getIban());

        if(cuenta != null){
            throw new CuentaEncontrada();
        }

        Cliente cliente = em.find(Cliente.class, c.getId());

        if(cliente == null){
            throw new ClienteNoEncontrado();
        } else {
            List<CuentaFintech> listCuenta = cliente.getCuentas();
            listCuenta.add(cuentaNueva);
            cliente.setCuentas(listCuenta);
            em.persist(cuentaNueva);
        }
    }

    // R9
    // TODO -- Revisar (¿a qué saldo se refiere el requisito?)
    @Override
    public void cierraCuenta(String IBAN) throws SaldoException, CuentaNoEncontrada {
        CuentaReferencia cuenta = em.find(CuentaReferencia.class, IBAN);
        if(cuenta == null){
            throw new CuentaNoEncontrada();
        }

        if(cuenta.getSaldo() > 0){
            throw new SaldoException();
        }

        cuenta.setEstado("BAJA");
    }



}