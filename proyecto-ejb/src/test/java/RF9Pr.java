import static org.junit.Assert.fail;

import java.sql.Date;
import java.util.logging.Logger;

import javax.naming.NamingException;

import org.junit.Before;
import org.junit.Test;

import exceptions.*;
import uma.wow.proyecto.CuentaReferencia;
import uma.wow.proyecto.Individual;
import uma.wow.proyecto.PooledAccount;
import uma.wow.proyecto.Segregada;
import uma.wow.proyecto.Usuario;

/*	La aplicación permitirá a un administrativo cerrar una cuenta bancaria. 
 * Solo se puede cerrar una cuenta que tenga saldo 0 (en todas sus divisas). 
 * Una cuenta cerrada no se elimina, por si es necesario reportarla en algún informe.
*/

public class RF9Pr {
	
private static final Logger LOG = Logger.getLogger(RF5Pr.class.getCanonicalName());
	
	private static final String CUENTA_EJB = "java:global/classes/CuentaEJB";
	private static final String UNIDAD_PERSITENCIA_PRUEBAS = "WOWEJBTest";
	
	private GestionCuenta gestionCuenta;
	
	@Before
	public void setup() throws NamingException{
		gestionCuenta = (GestionCuenta) SuiteTest.ctx.lookup(CUENTA_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
		
	}
	
	@Test
	public void testCerrarCuentaCorrecto(){
		
		CuentaReferencia cuentaVacia = new CuentaReferencia();
		cuentaVacia.setIban("985443");
		cuentaVacia.setSaldo(0);
		
		try {			
			gestionCuenta.cierraCuenta(cuentaVacia.getIban());		
			
		}catch(SaldoException e) {
			fail("No debería saltar error, la cuenta está a 0");
			
		}catch(EJBException e) {
			fail("Excepción no controlada");
		}
		
	}	
	
	@Test
	public void testCerrarCuentaIncorrecto(){
		
		CuentaReferencia cuentaLlena = new CuentaReferencia();
		cuentaLlena.setIban("444443");
		cuentaLlena.setSaldo(11);
		
		try {			
			gestionCuenta.cierraCuenta(cuentaLlena.getIban());		
			
		}catch(SaldoException e) {
			//OK
			
		}catch(EJBException e) {
			fail("Excepción no controlada");
		}
		
	}	
	
}
