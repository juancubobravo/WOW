import static org.junit.Assert.fail;

import java.sql.Date;
import java.util.logging.Logger;

import javax.naming.NamingException;

import org.junit.Before;
import org.junit.Test;

import exceptions.*;
import uma.wow.proyecto.Cuenta;
import uma.wow.proyecto.Individual;
import uma.wow.proyecto.PooledAccount;
import uma.wow.proyecto.Segregada;
import uma.wow.proyecto.Usuario;

/* 	La aplicación permitirá a un administrativo la apertura de una cuenta y asociarla a un cliente. 
 * La cuenta podrá ser agrupada (pooled) o segregada (segregated). En ambos casos la(s) cuenta(s) 
 * externa(s) asociada(s) se añade(n) como información, no se hace nada más. Será necesario que 
 * haya más de una cuenta externa en el caso de una cuenta agrupada con varias divisas.
*/

public class RF5Pr {
	
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
	public void testAbrirCuentaPooledCorrecto(){
		
		Individual individual = new Individual();
		individual.setIdentificacion("1211345");
		individual.setTipoCliente("FISICA");
		individual.setEstado("ACTIVO");
		individual.setFechaAlta(Date.valueOf("2020-03-24"));
		individual.setFechaBaja(null);
		individual.setDireccion("Avenida Casa");
		individual.setCiudad("Cadiz");
		individual.setCodigoPostal("29020");
		individual.setPais("España");
		individual.setNombre("Pep");
		individual.setApellido("Josep");
		individual.setFecha_nacimiento(Date.valueOf("1990-03-24"));
		
		PooledAccount pooled = new PooledAccount();
		pooled.setIban("1422224555528");
		pooled.setSwift("4892");
		pooled.setClasificacion("POOLED");
		pooled.setCliente(individual);
		pooled.setDepositaEn(null);
		pooled.setEstado("ABIERTA");
		pooled.setFechaApertura(Date.valueOf("2020-02-12"));
		pooled.setFechaCierre(null);
		
		Usuario administrador = new Usuario();
		administrador.setNombreUsuario("Alvarooo");
		administrador.setPassword("perrrro");
		administrador.setTipo("ADMIN");
		
		try {			
			gestionCuenta.creaCuenta(pooled, individual, administrador);		
			
		}catch(CuentaEncontrada e) {
			fail("No debería saltar error, la cuenta es diferente");
			
		}catch(EJBException e) {
			fail("Excepción no controlada");
		}
		
	}
	
	@Test
	public void testAbrirCuentaPooledIncorrecto(){
		
		Individual individual = new Individual();
		individual.setIdentificacion("122345");
		individual.setTipoCliente("FISICA");
		individual.setEstado("ACTIVO");
		individual.setFechaAlta(Date.valueOf("2021-01-10"));
		individual.setFechaBaja(null);
		individual.setDireccion("Avenida Casa");
		individual.setCiudad("Lima");
		individual.setCodigoPostal("29000");
		individual.setPais("Peru");
		individual.setNombre("Ale");
		individual.setApellido("Jandro");
		individual.setFecha_nacimiento(Date.valueOf("2000-03-24"));
		
		PooledAccount pooled = new PooledAccount();
		pooled.setIban("1453134534528");
		pooled.setSwift("4512");
		pooled.setClasificacion("POOLED");
		pooled.setCliente(individual);
		pooled.setDepositaEn(null);
		pooled.setEstado("ABIERTA");
		pooled.setFechaApertura(Date.valueOf("2020-09-12"));
		pooled.setFechaCierre(null);
		
		Usuario administrador = new Usuario();
		administrador.setNombreUsuario("Alllvaro");
		administrador.setPassword("perro");
		administrador.setTipo("ADMIN");
		
		try {			
			gestionCuenta.creaCuenta(pooled, individual, administrador);		
			
		}catch(CuentaEncontrada e) {
			//OK
			
		}catch(EJBException e) {
			fail("Excepción no controlada");
		}
		
	}
	
	@Test
	public void testAbrirCuentaSegregadaCorrecto(){
		
		Individual individual = new Individual();
		individual.setIdentificacion("12343445");
		individual.setTipoCliente("FISICA");
		individual.setEstado("ACTIVO");
		individual.setFechaAlta(Date.valueOf("2021-03-14"));
		individual.setFechaBaja(null);
		individual.setDireccion("Avenida Casa");
		individual.setCiudad("Barcelona");
		individual.setCodigoPostal("29000");
		individual.setPais("España");
		individual.setNombre("Pepe");
		individual.setApellido("Jose");
		individual.setFecha_nacimiento(null);
		
		Segregada segregada = new Segregada();
		segregada.setIban("1422224555528");
		segregada.setSwift("48992");
		segregada.setClasificacion("POOLED");
		segregada.setCliente(individual);
		segregada.setEstado("ABIERTA");
		segregada.setFechaApertura(Date.valueOf("2020-02-12"));
		segregada.setFechaCierre(null);
		
		Usuario administrador = new Usuario();
		administrador.setNombreUsuario("Aaalvaro");
		administrador.setPassword("perro");
		administrador.setTipo("ADMIN");
		
		try {			
			gestionCuenta.creaCuenta(segregada, individual, administrador);		
			
		}catch(CuentaEncontrada e) {
			fail("No debería saltar error, la cuenta es diferente");
			
		}catch(EJBException e) {
			fail("Excepción no controlada");
		}
		
	}	
	
	@Test
	public void testAbrirCuentaSegregadaIncorrecto(){
		
		Individual individual = new Individual();
		individual.setIdentificacion("123045");
		individual.setTipoCliente("FISICA");
		individual.setEstado("ACTIVO");
		individual.setFechaAlta(Date.valueOf("2021-03-14"));
		individual.setFechaBaja(null);
		individual.setDireccion("Avenida Casa");
		individual.setCiudad("Barcelona");
		individual.setCodigoPostal("29000");
		individual.setPais("España");
		individual.setNombre("Pepe");
		individual.setApellido("Jose");
		individual.setFecha_nacimiento(null);
		
		Segregada segregada = new Segregada();
		segregada.setIban("1888134538888");
		segregada.setSwift("4582");
		segregada.setClasificacion("SEGREGADA");
		segregada.setCliente(individual);
		segregada.setEstado("ABIERTA");
		segregada.setFechaApertura(Date.valueOf("2020-05-27"));
		segregada.setFechaCierre(null);
		
		Usuario administrador = new Usuario();
		administrador.setNombreUsuario("Alvaro");
		administrador.setPassword("perro");
		administrador.setTipo("ADMIN");
		
		try {			
			gestionCuenta.creaCuenta(segregada, individual, administrador);		
			
		}catch(CuentaEncontrada e) {
			//OK
			
		}catch(EJBException e) {
			fail("Excepción no controlada");
		}
		
	}
	
}
