import static org.junit.Assert.fail;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.naming.NamingException;

import org.junit.Before;
import org.junit.Test;

import es.uma.informatica.sii.anotaciones.Requisitos;
import uma.wow.proyecto.*;
import uma.wow.proyecto.ejb.exceptions.*;
import uma.wow.proyecto.ejb.*;

/*	La aplicación permitirá a un administrativo cerrar una cuenta bancaria. 
 * Solo se puede cerrar una cuenta que tenga saldo 0 (en todas sus divisas). 
 * Una cuenta cerrada no se elimina, por si es necesario reportarla en algún informe.
*/

public class RF9Pr {
	
private static final Logger LOG = Logger.getLogger(RF9Pr.class.getCanonicalName());
	
	private static final String CUENTA_EJB = "java:global/classes/CuentaEJB";
	private static final String UNIDAD_PERSITENCIA_PRUEBAS = "WOWEJBTest";
	
	private GestionCuenta gestionCuenta;
	
	@Before
	public void setup() throws NamingException{
		gestionCuenta = (GestionCuenta) SuiteTest.ctx.lookup(CUENTA_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
		
	}
	
	@Requisitos({"RF9"})
	@Test
	public void testCerrarCuentaCorrecto(){
		
		Usuario administrador = new Usuario();
		administrador.setNombreUsuario("Alvaro");
		administrador.setPassword("perro");
		administrador.setTipo("ADMIN");
		
		Individual individual = new Individual();
		individual.setIdentificacion("654987");
		individual.setTipoCliente("FISICA");
		individual.setEstado("ACTIVO");
		individual.setFechaAlta(Date.valueOf("2021-03-14"));
		individual.setFechaBaja(null);
		individual.setDireccion("Avenida Correcaminos");
		individual.setCiudad("Malaga");
		individual.setCodigoPostal("29001");
		individual.setPais("España");
		individual.setNombre("Jammal");
		individual.setApellido("Hasbullah");
		individual.setFecha_nacimiento(null);
		
		CuentaReferencia cuentaVacia = new CuentaReferencia();
		cuentaVacia.setIban("538888");
		cuentaVacia.setSwift("482");
		cuentaVacia.setSaldo(0);
		
		PooledAccount pooled = new PooledAccount();
		pooled.setIban("1453134534528");
		pooled.setSwift("4512");
		pooled.setClasificacion("POOLED");
		pooled.setCliente(individual);
		pooled.setDepositaEn(null);
		pooled.setEstado("ABIERTA");
		pooled.setFechaApertura(Date.valueOf("2020-09-12"));
		pooled.setFechaCierre(null);
		
		
		DepositadaEn dep = new DepositadaEn();
		dep.setId2(pooled);
		dep.setId1(cuentaVacia);
		dep.setSaldo(cuentaVacia.getSaldo());
		
		List<DepositadaEn> lista = new ArrayList<DepositadaEn>();
		lista.add(dep);
		pooled.setDepositaEn(lista);
		
		Segregada segregada = new Segregada();
		segregada.setIban("1888134538888");
		segregada.setSwift("4582");
		segregada.setClasificacion("SEGREGADA");
		segregada.setCliente(individual);
		segregada.setEstado("ABIERTA");
		segregada.setFechaApertura(Date.valueOf("2020-05-27"));
		segregada.setFechaCierre(null);
		segregada.setCuentaReferencia(cuentaVacia);
		
		try {			
			gestionCuenta.cierraCuenta(pooled,administrador);	
			gestionCuenta.cierraCuenta(segregada,administrador);	
		}catch(CuentaNoEncontrada e) {			
			fail("No debería saltar error, la cuenta está a 0");
		}catch(SaldoException e) {
			fail("No debería saltar error, la cuenta está a 0");
			
		}catch(EJBException e) {
			fail("Excepción no controlada");
		}
		
	}	
	
	@Requisitos({"RF9"})
	@Test
	public void testCerrarCuentaIncorrecto(){
		
		Usuario administrador = new Usuario();
		administrador.setNombreUsuario("Alvaro");
		administrador.setPassword("perro");
		administrador.setTipo("ADMIN");
		
		Individual individual = new Individual();
		individual.setIdentificacion("654987");
		individual.setTipoCliente("FISICA");
		individual.setEstado("ACTIVO");
		individual.setFechaAlta(Date.valueOf("2021-03-14"));
		individual.setFechaBaja(null);
		individual.setDireccion("Avenida Correcaminos");
		individual.setCiudad("Malaga");
		individual.setCodigoPostal("29001");
		individual.setPais("España");
		individual.setNombre("Jammal");
		individual.setApellido("Hasbullah");
		individual.setFecha_nacimiento(null);
		
		CuentaReferencia cuentaLlena = new CuentaReferencia();
		cuentaLlena.setIban("9999");
		cuentaLlena.setSwift("4812");
		cuentaLlena.setSaldo(1000000);
		
		PooledAccount pooled = new PooledAccount();
		pooled.setIban("1453134534528");
		pooled.setSwift("4512");
		pooled.setClasificacion("POOLED");
		pooled.setCliente(individual);
		pooled.setDepositaEn(null);
		pooled.setEstado("ABIERTA");
		pooled.setFechaApertura(Date.valueOf("2020-09-12"));
		pooled.setFechaCierre(null);
		
		
		DepositadaEn dep = new DepositadaEn();
		dep.setId2(pooled);
		dep.setId1(cuentaLlena);
		dep.setSaldo(cuentaLlena.getSaldo());
		
		List<DepositadaEn> lista = new ArrayList<DepositadaEn>();
		lista.add(dep);
		pooled.setDepositaEn(lista);
		
		Segregada segregada = new Segregada();
		segregada.setIban("1888134538888");
		segregada.setSwift("4582");
		segregada.setClasificacion("SEGREGADA");
		segregada.setCliente(individual);
		segregada.setEstado("ABIERTA");
		segregada.setFechaApertura(Date.valueOf("2020-05-27"));
		segregada.setFechaCierre(null);
		segregada.setCuentaReferencia(cuentaLlena);
		
		try {			
			gestionCuenta.cierraCuenta(pooled,administrador);	
			gestionCuenta.cierraCuenta(segregada,administrador);	
		}catch(CuentaNoEncontrada e) {			
			fail("No debería saltar error, la cuenta está a 0");
		}catch(SaldoException e) {
			//OK			
		}catch(EJBException e) {
			fail("Excepción no controlada");
		}	
	}
}
