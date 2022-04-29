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
    
    @Override
    public void cierraCuenta(Segregada c, Usuario admin) throws SaldoException, CuentaNoEncontrada, UsuarioNoEncontrado, ContraseniaInvalida, NoAdministradorException {
    	acceso.loginAdministrador(admin);
        Segregada cuenta = em.find(Segregada.class, c.getIban());
        if(cuenta == null){
            throw new CuentaNoEncontrada();
        }
        
        if(cuenta.getCuentaReferencia().getSaldo() > 0){
            throw new SaldoException();
        }

        cuenta.setEstado("BAJA");
    }
    
    public void cierraCuenta(PooledAccount c, Usuario admin) throws SaldoException, CuentaNoEncontrada, UsuarioNoEncontrado, ContraseniaInvalida, NoAdministradorException {
    	acceso.loginAdministrador(admin);
        PooledAccount cuenta = em.find(PooledAccount.class, c.getIban());
        if(cuenta == null){
            throw new CuentaNoEncontrada();
        }
        
		for (DepositadaEn de : cuenta.getDepositaEn()) {

			if (de.getSaldo() != 0) {

				throw new SaldoException();
			}
		}
        

        cuenta.setEstado("BAJA");
    }



}