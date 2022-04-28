import static org.junit.Assert.fail;

import java.sql.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.naming.NamingException;

import org.junit.Before;
import org.junit.Test;

import exceptions.ClienteNoEncontrado;
import exceptions.ClienteYaExistente;
import exceptions.ContraseniaInvalida;
import exceptions.EJBException;
import exceptions.NoAdministradorException;
import exceptions.UsuarioException;
import exceptions.UsuarioNoEncontrado;
import uma.wow.proyecto.*;

public class RF2Pr {
	
private static final Logger LOG = Logger.getLogger(RF2Pr.class.getCanonicalName());
	
	private static final String CLIENTE_EJB = "java:global/classes/ClienteEJB";
	private static final String ACCESO_EJB = "java:global/classes/AccesoEJB";
	private static final String UNIDAD_PERSITENCIA_PRUEBAS = "WOWEJBTest";
	
	private GestionCliente gestionCliente;
	private GestionAcceso gestionAcceso;
	
	@Before
	public void setup() throws NamingException{
		gestionCliente = (GestionCliente) SuiteTest.ctx.lookup(CLIENTE_EJB);
		gestionAcceso = (GestionAcceso) SuiteTest.ctx.lookup(ACCESO_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
		
	}
	
	@Test
	public void testDarAltaIndividualCorrecto(){
		
		Individual individual = new Individual();
		individual.setIdentificacion("12345");
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
		
		Usuario administrador = new Usuario();
		administrador.setNombreUsuario("Alvaro");
		administrador.setPassword("perro");
		administrador.setTipo("ADMIN");
		
		try {			
			
			gestionCliente.altaCliente(individual, administrador);		
			
		}catch(ClienteYaExistente e) {
			fail("No debería saltar error, el cliente es diferente");
			
		}catch(EJBException e) {
			fail("Excepción no controlada");
		}				
	}
	
	@Test
	public void testDarAltaEmpresaCorrecto(){
		
		Empresa empresa = new Empresa();
		empresa.setIdentificacion("35466");
		empresa.setTipoCliente("JURIDICO");
		empresa.setEstado("ACTIVO");
		empresa.setFechaAlta(Date.valueOf("2021-07-16"));
		empresa.setFechaBaja(null);
		empresa.setDireccion("Calle Francia");
		empresa.setCiudad("Malaga");
		empresa.setCodigoPostal("29019");
		empresa.setPais("España");
		empresa.setRazon_Social("Anti-ayudas");
		
		Usuario administrador = new Usuario();
		administrador.setNombreUsuario("Alvaro");
		administrador.setPassword("perro");
		administrador.setTipo("ADMIN");
		
		try {			
			
			gestionCliente.altaCliente(empresa, administrador);		
			
		}catch(ClienteYaExistente e) {
			fail("No debería saltar error, el cliente es diferente");
			
		}catch(EJBException e) {
			fail("Excepción no controlada");
		}				
	}
	
	@Test
	public void testDarAltaIndividualIncorrecto(){
		
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
		
		Usuario administrador = new Usuario();
		administrador.setNombreUsuario("Alvaro");
		administrador.setPassword("perro");
		administrador.setTipo("ADMIN");
		
		try {			
			
			gestionCliente.altaCliente(individual, administrador);		
			
		}catch(ClienteYaExistente e) {
			//OK
			
		}catch(EJBException e) {
			fail("Excepción no controlada");
		}				
	}
	
	@Test
	public void testDarAltaEmpresaIncorrecto(){
		
		Empresa empresa = new Empresa();
		empresa.setIdentificacion("98756");
		empresa.setTipoCliente("JURIDICO");
		empresa.setEstado("ACTIVO");
		empresa.setFechaAlta(Date.valueOf("2021-07-16"));
		empresa.setFechaBaja(null);
		empresa.setDireccion("Calle España");
		empresa.setCiudad("Malaga");
		empresa.setCodigoPostal("29009");
		empresa.setPais("España");
		empresa.setRazon_Social("Ayudas");
		
		Usuario administrador = new Usuario();
		administrador.setNombreUsuario("Alvaro");
		administrador.setPassword("perro");
		administrador.setTipo("ADMIN");
		
		try {			
			
			gestionCliente.altaCliente(empresa, administrador);		
			
		}catch(ClienteYaExistente e) {
			//OK
			
		}catch(EJBException e) {
			fail("Excepción no controlada");
		}				
	}
}
