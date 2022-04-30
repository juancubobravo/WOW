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
public class RF7Pr {
	
	
private static final Logger LOG = Logger.getLogger(RF2Pr.class.getCanonicalName());
	
	private static final String PERSONA_AUTORIZADA_EJB = "java:global/classes/PersonaAutorizadaEJB";
	private static final String UNIDAD_PERSITENCIA_PRUEBAS = "WOWEJBTest";
	
	private GestionPersonaAutorizada gestionAutorizada;
	
	
	@Before
	public void setup() throws NamingException{
		gestionAutorizada = (GestionPersonaAutorizada) SuiteTest.ctx.lookup(PERSONA_AUTORIZADA_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
		
	}
	
	@Requisitos({"RF7"})
	@Test
	public void testModificaAutorizado() throws PersonaAutorizadaNoEncontrada, ContraseniaInvalida, UsuarioNoEncontrado, NoAdministradorException{
		
		Usuario administrador = new Usuario();
		administrador.setNombreUsuario("Alvaro");
		administrador.setPassword("perro");
		administrador.setTipo("ADMIN");
		
		Usuario usuario = new Usuario ();
		usuario.setNombreUsuario("Carlos");
		usuario.setPassword("1234");
		usuario.setTipo("NORMAL");
		
		PersonaAutorizada personaAutorizada = new PersonaAutorizada();
		personaAutorizada.setApellidos("Paez");
		personaAutorizada.setAutori(null);
		personaAutorizada.setDireccion("Avda S");
		personaAutorizada.setEstado(null);
		personaAutorizada.setFechaInicio(Date.valueOf("2020-03-24"));
		personaAutorizada.setFechaFin(null);
		personaAutorizada.setId("511155");
		personaAutorizada.setIdentificacion("0771");
		personaAutorizada.setNombre(usuario.getNombreUsuario());
		personaAutorizada.setUsuario(usuario);
		
		try {
				
			gestionAutorizada.modificaPersonaAutorizada(personaAutorizada, administrador);
			PersonaAutorizada persA = gestionAutorizada.devolver(personaAutorizada.getId());
			
			assertEquals(personaAutorizada.getApellidos(),persA.getApellidos());
			
		}catch(PersonaAutorizadaNoEncontrada e) {
			fail("Persona Autorizada no encontrada");
		}
		
		
	}

}
