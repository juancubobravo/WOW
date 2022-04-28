import static org.junit.Assert.fail;

import java.sql.Date;

import javax.naming.NamingException;

import org.junit.Before;
import org.junit.Test;

import exceptions.CuentasActivas;
import exceptions.EJBException;
import uma.wow.proyecto.Individual;
import uma.wow.proyecto.Usuario;

public class RF4Pr {
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
	public void testDarBajaIndividualCorrecto() {
		
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
			gestionCliente.bajaCliente(individual, administrador);
		}catch(CuentasActivas e) {
			fail("No debería saltar error, el cliente no tiene cuentas activas");
		}catch(EJBException e) {
			fail("Excepción no controlada");
		}
		
	}
	
}
