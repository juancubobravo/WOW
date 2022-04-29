import static org.junit.Assert.fail;

import java.sql.Date;

import javax.naming.NamingException;

import org.junit.Before;
import org.junit.Test;

import es.uma.informatica.sii.anotaciones.Requisitos;
import exceptions.ClienteNoEncontrado;
import exceptions.ContraseniaInvalida;
import exceptions.CuentaBloqueada;
import exceptions.CuentaDeBaja;
import exceptions.EJBException;
import exceptions.EsEmpresaException;
import exceptions.UsuarioNoEncontrado;
import uma.wow.proyecto.Empresa;
import uma.wow.proyecto.Individual;
import uma.wow.proyecto.Usuario;

public class RF10Pr {
	
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
	
	@Requisitos({"RF10"})
	@Test
	public void testAccesoUsuario() {
		
		Usuario usuarioIndividual = new Usuario ();
		usuarioIndividual.setNombreUsuario("Carlos");
		usuarioIndividual.setPassword("1234");
		usuarioIndividual.setTipo("NORMAL");
		
		Individual individualParaUsuario = new Individual();
		individualParaUsuario.setIdentificacion("654987");
		individualParaUsuario.setTipoCliente("FISICA");
		individualParaUsuario.setEstado("ACTIVO");
		individualParaUsuario.setFechaAlta(Date.valueOf("2021-03-14"));
		individualParaUsuario.setFechaBaja(null);
		individualParaUsuario.setDireccion("Avenida Correcaminos");
		individualParaUsuario.setCiudad("Malaga");
		individualParaUsuario.setCodigoPostal("29001");
		individualParaUsuario.setPais("España");
		individualParaUsuario.setNombre("Jammal");
		individualParaUsuario.setApellido("Hasbullah");
		individualParaUsuario.setFecha_nacimiento(null);
		
		usuarioIndividual.setCliente(individualParaUsuario);
		
		
		try {
			gestionAcceso.loginCliente(usuarioIndividual);
		}catch(UsuarioNoEncontrado e) {
			fail("El usuario está creado, debería encontrarse");
		}catch(ContraseniaInvalida e) {
			fail("La contraseña es correcta");
		}catch(EsEmpresaException e) {
			fail("Es un Invividual");
		}catch(CuentaBloqueada e) {
			fail("La cuenta no está bloqueada");
		}catch(CuentaDeBaja e) {
			fail("La cuenta está activa");
		}catch(ClienteNoEncontrado e) {
			fail("El cliente está creado");
		}catch(EJBException e) {
			fail("Excepción no controlada");
		}
		
	}
	
	@Requisitos({"RF10"})
	@Test
	public void testAccesoUsuarioContraseñaErronea() {
		
		Usuario usuarioIndividual = new Usuario ();
		usuarioIndividual.setNombreUsuario("Carlos");
		usuarioIndividual.setPassword("7412");
		usuarioIndividual.setTipo("NORMAL");
		
		Individual individualParaUsuario = new Individual();
		individualParaUsuario.setIdentificacion("654987");
		individualParaUsuario.setTipoCliente("FISICA");
		individualParaUsuario.setEstado("ACTIVO");
		individualParaUsuario.setFechaAlta(Date.valueOf("2021-03-14"));
		individualParaUsuario.setFechaBaja(null);
		individualParaUsuario.setDireccion("Avenida Correcaminos");
		individualParaUsuario.setCiudad("Malaga");
		individualParaUsuario.setCodigoPostal("29001");
		individualParaUsuario.setPais("España");
		individualParaUsuario.setNombre("Jammal");
		individualParaUsuario.setApellido("Hasbullah");
		individualParaUsuario.setFecha_nacimiento(null);
		
		usuarioIndividual.setCliente(individualParaUsuario);
		
		
		try {
			gestionAcceso.loginCliente(usuarioIndividual);
		}catch(UsuarioNoEncontrado e) {
			fail("El usuario está creado, debería encontrarse");
		}catch(ContraseniaInvalida e) {
			//OK
		}catch(EsEmpresaException e) {
			fail("Es un Invividual");
		}catch(CuentaBloqueada e) {
			fail("La cuenta no está bloqueada");
		}catch(CuentaDeBaja e) {
			fail("La cuenta está activa");
		}catch(ClienteNoEncontrado e) {
			fail("El cliente está creado");
		}catch(EJBException e) {
			fail("Excepción no controlada");
		}
		
	}
	
	@Requisitos({"RF10"})
	@Test
	public void testAccesoUsuarioEmpresa() {
		
		Usuario usuarioEmpresa = new Usuario ();
		usuarioEmpresa.setNombreUsuario("Carniceria Paco");
		usuarioEmpresa.setPassword("vivalacomida");
		usuarioEmpresa.setTipo("NORMAL");
		
		Empresa empresaParaUsuario = new Empresa();
		empresaParaUsuario.setIdentificacion("789544");
		empresaParaUsuario.setTipoCliente("JURIDICO");
		empresaParaUsuario.setEstado("ACTIVO");
		empresaParaUsuario.setFechaAlta(Date.valueOf("2021-07-16"));
		empresaParaUsuario.setFechaBaja(null);
		empresaParaUsuario.setDireccion("Calle Pamplona");
		empresaParaUsuario.setCiudad("Madrid");
		empresaParaUsuario.setCodigoPostal("27009");
		empresaParaUsuario.setPais("España");
		empresaParaUsuario.setRazon_Social("Comida");
		
		usuarioEmpresa.setCliente(empresaParaUsuario);
		
		
		try {
			gestionAcceso.loginCliente(usuarioEmpresa);
		}catch(UsuarioNoEncontrado e) {
			fail("El usuario está creado, debería encontrarse");
		}catch(ContraseniaInvalida e) {
			fail("La contraseña es correcta");
		}catch(EsEmpresaException e) {
			//OK
		}catch(CuentaBloqueada e) {
			fail("La cuenta no está bloqueada");
		}catch(CuentaDeBaja e) {
			fail("La cuenta está activa");
		}catch(ClienteNoEncontrado e) {
			fail("El cliente está creado");
		}catch(EJBException e) {
			fail("Excepción no controlada");
		}
		
	}
}
