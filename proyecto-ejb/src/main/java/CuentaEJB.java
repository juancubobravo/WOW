import exceptions.*;
import uma.wow.proyecto.*;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.ClientInfoStatus;
import java.util.List;

@Stateless
public class CuentaEJB implements GestionCuenta {

	@EJB
	AccesoEJB acceso;
    @PersistenceContext(unitName="WOWEJB")
    private EntityManager em;

    // R5
    //@Override
    public void creaCuenta(PooledAccount cuentaNueva, Empresa c, Usuario usuario) throws CuentaEncontrada, ClienteNoEncontrado, UsuarioNoEncontrado, ContraseniaInvalida, NoAdministradorException {
    	acceso.loginAdministrador(usuario);
        PooledAccount cuenta = em.find(PooledAccount.class, cuentaNueva.getIban());

        if(cuenta != null){
            throw new CuentaEncontrada();
        }

        Empresa cliente = em.find(Empresa.class, c.getId());

        if(cliente == null){
            throw new ClienteNoEncontrado();
        } else {
            List<CuentaFintech> listCuenta = cliente.getCuentas();
            listCuenta.add(cuentaNueva);
            cliente.setCuentas(listCuenta);
            em.persist(cuentaNueva);
        }
    }
    
    // R5
    //@Override
    public void creaCuenta(Segregada cuentaNueva, Empresa c, Usuario usuario) throws CuentaEncontrada, ClienteNoEncontrado, UsuarioNoEncontrado, ContraseniaInvalida, NoAdministradorException {
    	acceso.loginAdministrador(usuario);
        Segregada cuenta = em.find(Segregada.class, cuentaNueva.getIban());

        if(cuenta != null){
            throw new CuentaEncontrada();
        }

        Empresa cliente = em.find(Empresa.class, c.getId());

        if(cliente == null){
            throw new ClienteNoEncontrado();
        } else {
            List<CuentaFintech> listCuenta = cliente.getCuentas();
            listCuenta.add(cuentaNueva);
            cliente.setCuentas(listCuenta);
            em.persist(cuentaNueva);
        }
    }
    
    //R5
    @Override
    public void creaCuenta(PooledAccount cuentaNueva, Individual c, Usuario usuario) throws CuentaEncontrada, ClienteNoEncontrado, UsuarioNoEncontrado, ContraseniaInvalida, NoAdministradorException {
    	acceso.loginAdministrador(usuario);
        PooledAccount cuenta = em.find(PooledAccount.class, cuentaNueva.getIban());

        if(cuenta != null){
            throw new CuentaEncontrada();
        }

        Individual cliente = em.find(Individual.class, c.getId());

        if(cliente == null){
            throw new ClienteNoEncontrado();
        } else {
            List<CuentaFintech> listCuenta = cliente.getCuentas();
            listCuenta.add(cuentaNueva);
            cliente.setCuentas(listCuenta);
            em.persist(cuentaNueva);
        }
    }
    
    // R5
    //@Override
    public void creaCuenta(Segregada cuentaNueva, Individual c, Usuario usuario) throws CuentaEncontrada, ClienteNoEncontrado, UsuarioNoEncontrado, ContraseniaInvalida, NoAdministradorException {
    	acceso.loginAdministrador(usuario);
        Segregada cuenta = em.find(Segregada.class, cuentaNueva.getIban());

        if(cuenta != null){
            throw new CuentaEncontrada();
        }

        Individual cliente = em.find(Individual.class, c.getId());

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