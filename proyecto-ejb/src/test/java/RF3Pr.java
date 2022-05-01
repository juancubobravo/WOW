import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.sql.Date;
import java.util.logging.Logger;

import javax.naming.NamingException;

import org.junit.Before;
import org.junit.Test;

import es.uma.informatica.sii.anotaciones.Requisitos;
import uma.wow.proyecto.*;
import uma.wow.proyecto.ejb.exceptions.*;
import uma.wow.proyecto.ejb.*;


public class RF3Pr {
	
private static final Logger LOG = Logger.getLogger(RF2Pr.class.getCanonicalName());
	
	private static final String CLIENTE_EJB = "java:global/classes/ClienteEJB";
	private static final String UNIDAD_PERSITENCIA_PRUEBAS = "WOWEJBTest";
	
	private GestionCliente gestionCliente;
	
	
	@Before
	public void setup() throws NamingException{
		gestionCliente = (GestionCliente) SuiteTest.ctx.lookup(CLIENTE_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
		
	}
	
	@Requisitos({"RF3"})
	@Test
	public void testModificaClienteEmpresa() throws ClienteNoEncontrado, UsuarioNoEncontrado, ContraseniaInvalida, NoAdministradorException{
		
		Usuario administrador = new Usuario();
		administrador.setNombreUsuario("Alvaro");
		administrador.setPassword("perro");
		administrador.setTipo("ADMIN");
		
		Empresa empresa = new Empresa();
		empresa.setId("98756");
		empresa.setIdentificacion("6556f");
		empresa.setTipoCliente("JURIDICO");
		empresa.setEstado("ACTIVO");
		empresa.setFechaAlta(Date.valueOf("2021-07-16"));
		empresa.setFechaBaja(null);
		empresa.setDireccion("Calle Malaga");
		empresa.setCiudad("Malaga");
		empresa.setCodigoPostal("29009");
		empresa.setPais("España");
		empresa.setRazon_Social("Ayudas");
		
		
		try {
			
			gestionCliente.modificaCliente(empresa, administrador);
			Cliente cliente = gestionCliente.devolverEmpresa(empresa.getId());
			
			assertEquals(cliente.getDireccion(),empresa.getDireccion());
			
		}catch(ClienteNoEncontrado e) {
			fail("Cliente no encontrado");
		}catch(UsuarioNoEncontrado e) {
			fail("Usuario no encontrado");
		}catch(ContraseniaInvalida e) {
			fail("Constrasenia erroenea");
		}catch(EJBException e) {
			fail("Excepción no controlada");
		}
		
	}
	
	@Requisitos({"RF3"})
	@Test
    public void testModificaClienteIndividual() throws ClienteNoEncontrado, UsuarioNoEncontrado, ContraseniaInvalida, NoAdministradorException{
    	
		Usuario administrador = new Usuario();
		administrador.setNombreUsuario("Alvaro");
		administrador.setPassword("perro");
		administrador.setTipo("ADMIN");
		
		Individual individual = new Individual();
		individual.setId("654987");
		individual.setIdentificacion("1111");
		individual.setTipoCliente("FISICA");
		individual.setEstado("ACTIVO");
		individual.setFechaAlta(Date.valueOf("2021-03-14"));
		individual.setFechaBaja(null);
		individual.setDireccion("Avenida Correcaminos");
		individual.setCiudad("Malaga");
		individual.setCodigoPostal("29007");
		individual.setPais("España");
		individual.setNombre("Jammal");
		individual.setApellido("Hasbullah");
		individual.setFecha_nacimiento(null);
		
		try {
			
			gestionCliente.modificaCliente(individual, administrador);
			Cliente cliente = gestionCliente.devolverIndividual(individual.getId());
			
			assertEquals(cliente.getCodigoPostal(),individual.getCodigoPostal());
			
		}catch(ClienteNoEncontrado e) {
			fail("Cliente no encontrado");
		}catch(UsuarioNoEncontrado e) {
			fail("Usuario no encontrado");
		}catch(ContraseniaInvalida e) {
			fail("Constrasenia erroenea");
		}catch(EJBException e) {
			fail("Excepción no controlada");
		}	
    	
    	
    }
	
	@Requisitos({"RF3"})
	@Test
    public void testModificaClienteIndividualError() throws ClienteNoEncontrado, UsuarioNoEncontrado, ContraseniaInvalida, NoAdministradorException{
    	
		Usuario administrador = new Usuario();
		administrador.setNombreUsuario("Alvaro");
		administrador.setPassword("perro");
		administrador.setTipo("ADMIN");
		
		Individual individual = new Individual();
		individual.setId("454987");
		individual.setIdentificacion("5555");
		individual.setTipoCliente("FISICA");
		individual.setEstado("ACTIVO");
		individual.setFechaAlta(Date.valueOf("2021-03-14"));
		individual.setFechaBaja(null);
		individual.setDireccion("Avenida Correcaminos");
		individual.setCiudad("Barcelona");
		individual.setCodigoPostal("29001");
		individual.setPais("España");
		individual.setNombre("Jammal");
		individual.setApellido("Hasbullah");
		individual.setFecha_nacimiento(null);
		
		try {
			
			gestionCliente.modificaCliente(individual, administrador);
			Cliente cliente = gestionCliente.devolverIndividual(individual.getId());
			
			assertEquals(cliente.getCiudad(),individual.getCiudad());
			
		}catch(ClienteNoEncontrado e) {
			//OK
		}catch(UsuarioNoEncontrado e) {
			fail("Usuario no encontrado");
		}catch(ContraseniaInvalida e) {
			fail("Constrasenia erroenea");
		}catch(EJBException e) {
			fail("Excepción no controlada");
		}	
    	
    	
    }
	
}
