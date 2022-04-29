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

/*	La aplicación permitirá a un administrativo añadir personas autorizadas a las 
 * cuentas que pertenezcan a cliente que son personas jurídicas. Las personas 
 * autorizadas serán las que podrán entrar en la aplicación para realizar operaciones
 * con la cuenta.
*/

public class RF6Pr {
	
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
	public void testAnyadirPersonaAutorizadaCorrecto(){
		
		Usuario usuario = new Usuario ();
		usuario.setNombreUsuario("Daniel");
		usuario.setPassword("1234");
		usuario.setTipo("NORMAL");
		
		PersonaAutorizada personaAutorizada = new PersonaAutorizada();
		personaAutorizada.setApellidos(PERSONA_AUTORIZADA_EJB);
		personaAutorizada.setAutori(null);
		personaAutorizada.setDireccion("Avda Grande");
		personaAutorizada.setEstado(null);
		personaAutorizada.setFechaInicio(Date.valueOf("2020-03-24"));
		personaAutorizada.setFechaFin(null);
		personaAutorizada.setId("456456");
		personaAutorizada.setIdentificacion("765987");
		personaAutorizada.setNombre(usuario.getNombreUsuario());
		personaAutorizada.setUsuario(usuario);

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
		
		try {			
			gestionPersonaAutorizada.anyadirPersonaAutorizada(pooled, personaAutorizada, usuario, "Autorizado");		
			
		}catch(PersonaAutorizadaEncontrada e) {
			fail("No debería saltar error, la persona aun no esta autorizada");
			
		}catch(EJBException e) {
			fail("Excepción no controlada");
		}
		
	}	
	
	
	@Test
	public void testAnyadirPersonaAutorizadaIncorrecto(){
		
		Usuario usuario = new Usuario ();
		usuario.setNombreUsuario("Daniel");
		usuario.setPassword("1234");
		usuario.setTipo("NORMAL");
		
		PersonaAutorizada personaAutorizada = new PersonaAutorizada();
		personaAutorizada.setApellidos(PERSONA_AUTORIZADA_EJB);
		personaAutorizada.setAutori(null);
		personaAutorizada.setDireccion("Avda Grande");
		personaAutorizada.setEstado(null);
		personaAutorizada.setFechaInicio(Date.valueOf("2020-03-24"));
		personaAutorizada.setFechaFin(null);
		personaAutorizada.setId("46");
		personaAutorizada.setIdentificacion("5987");
		personaAutorizada.setNombre(usuario.getNombreUsuario());
		personaAutorizada.setUsuario(usuario);

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
		
		try {			
			gestionPersonaAutorizada.anyadirPersonaAutorizada(pooled, personaAutorizada, usuario, "Autorizado");		
			
		}catch(PersonaAutorizadaEncontrada e) {
			//OK
			
		}catch(EJBException e) {
			fail("Excepción no controlada");
		}
		
	}	
	
}
