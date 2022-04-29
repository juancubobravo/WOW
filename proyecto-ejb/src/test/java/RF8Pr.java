import static org.junit.Assert.fail;

import java.sql.Date;
import java.util.logging.Logger;

import javax.naming.NamingException;

import org.junit.Before;
import org.junit.Test;

import exceptions.*;
import uma.wow.proyecto.CuentaReferencia;
import uma.wow.proyecto.Individual;
import uma.wow.proyecto.PersonaAutorizada;
import uma.wow.proyecto.PooledAccount;
import uma.wow.proyecto.Usuario;

/*	La aplicación permitirá a un administrativo dar de baja a personas autorizadas 
 * a operar con cuentas cuyos clientes sean personas jurídicas. Estas personas no 
 * se eliminan del sistema, ya que podría ser necesario que la información conste 
 * para alguna auditoría o informe. Una persona autorizada que esté de baja no 
 * puede acceder a la cuenta en la que se encontraba autorizada.
*/

public class RF8Pr {
	
private static final Logger LOG = Logger.getLogger(RF6Pr.class.getCanonicalName());
	
	private static final String PERSONA_AUTORIZADA_EJB = "java:global/classes/PersonaAutorizadaEJB";
	private static final String UNIDAD_PERSITENCIA_PRUEBAS = "WOWEJBTest";
	
	private GestionPersonaAutorizada gestionPersonaAutorizada;
	
	@Before
	public void setup() throws NamingException{
		gestionPersonaAutorizada = (GestionPersonaAutorizada) SuiteTest.ctx.lookup(PERSONA_AUTORIZADA_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
		
	}
	
	@Test
	public void testBajaPersonaAutorizadaCorrecto(){
		
		Usuario usuario = new Usuario ();
		usuario.setNombreUsuario("Antonio");
		usuario.setPassword("12rrr34");
		usuario.setTipo("NORMAL");
		
		PersonaAutorizada personaAutorizada = new PersonaAutorizada();
		personaAutorizada.setApellidos(PERSONA_AUTORIZADA_EJB);
		personaAutorizada.setAutori(null);
		personaAutorizada.setDireccion("Avda Grande");
		personaAutorizada.setEstado(null);
		personaAutorizada.setFechaInicio(Date.valueOf("2020-03-24"));
		personaAutorizada.setFechaFin(null);
		personaAutorizada.setId("5555");
		personaAutorizada.setIdentificacion("010101");
		personaAutorizada.setNombre(usuario.getNombreUsuario());
		personaAutorizada.setUsuario(usuario);
		
		try {			
			gestionPersonaAutorizada.borraPersonaAutorizada(personaAutorizada, usuario);		
			
		}catch(CuentaDeBaja e) {
			fail("No debería saltar error, la persona esta autorizada");
			
		}catch(EJBException e) {
			fail("Excepción no controlada");
		}
		
	}	
	

	@Test
	public void testBajaPersonaAutorizadaIncorrecto(){
		
		Usuario usuario = new Usuario ();
		usuario.setNombreUsuario("Manolo");
		usuario.setPassword("1200034");
		usuario.setTipo("NORMAL");
		
		PersonaAutorizada personaAutorizadaBaja = new PersonaAutorizada();
		personaAutorizadaBaja.setApellidos("Pelaez");
		personaAutorizadaBaja.setAutori(null);
		personaAutorizadaBaja.setDireccion("Avda S");
		personaAutorizadaBaja.setEstado(null);
		personaAutorizadaBaja.setFechaInicio(Date.valueOf("2020-03-24"));
		personaAutorizadaBaja.setFechaFin(null);
		personaAutorizadaBaja.setId("511155");
		personaAutorizadaBaja.setIdentificacion("0771");
		personaAutorizadaBaja.setNombre(usuario.getNombreUsuario());
		personaAutorizadaBaja.setUsuario(usuario);
		
		try {			
			gestionPersonaAutorizada.borraPersonaAutorizada(personaAutorizada, usuario);		
			
		}catch(CuentaDeBaja e) {
			//OK
			
		}catch(EJBException e) {
			fail("Excepción no controlada");
		}
		
	}	
	
}
