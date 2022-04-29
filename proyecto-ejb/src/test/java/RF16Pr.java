import static org.junit.Assert.fail;

import java.sql.Date;
import java.util.logging.Logger;

import javax.naming.NamingException;

import org.junit.Before;
import org.junit.Test;

import exceptions.*;
import uma.wow.proyecto.Cliente;
import uma.wow.proyecto.CuentaReferencia;
import uma.wow.proyecto.Usuario;

/*	La aplicación permitirá a un usuario administrativo bloquear a un cliente o 
 * autorizado de manera temporal (no es lo mismo que una baja). En el caso de que 
 * el cliente bloqueado sea una persona jurídica, sus autorizados no podrán operar 
 * con al cuenta de dicho cliente. Si esa cuenta es la única a la que tienen acceso, 
 * la persona autorizada tampoco podrá acceder a la aplicación. Si el cliente es 
 * una persona física, esta no podrá acceder a la aplicación. La aplicación también 
 * permitirá a los usuarios administrativos desbloquear a los usuarios.
*/

public class RF16Pr {
	
private static final Logger LOG = Logger.getLogger(RF16Pr.class.getCanonicalName());
	
	private static final String CLIENTE_EJB = "java:global/classes/ClienteEJB";
	private static final String UNIDAD_PERSITENCIA_PRUEBAS = "WOWEJBTest";
	
	private GestionCliente gestionCliente;
	
	@Before
	public void setup() throws NamingException{
		gestionCliente = (GestionCliente) SuiteTest.ctx.lookup(CLIENTE_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
		
	}
	
	@Test
	public void testBloqueaClienteCorrecto(){
		
		Usuario usuario = new Usuario ();
		usuario.setNombreUsuario("Andres");
		usuario.setPassword("12324");
		usuario.setTipo("NORMAL");
		
		Cliente cliente = new Cliente();
		cliente.setCiudad("Alora");
		cliente.setCodigoPostal("5234");
		cliente.setCuentas(null);
		cliente.setDireccion("Calle Calle");
		cliente.setEstado(null);
		cliente.setFechaAlta(Date.valueOf("2020-08-14"));
		cliente.setFechaBaja(null);
		cliente.setId("23525");
		cliente.setIdentificacion("2562666");
		cliente.setPais("Mali");
		cliente.setTipoCliente("FISICO");
		cliente.setUsuario(usuario);
		
		try {			
			gestionCliente.bloqueaCliente(cliente);		
			
			
			//FALTA CREAR EN GestionCliente bloqueaCliente.java
			
			
		}catch(ClienteBloqueado e) {
			
			
			//FALTA CREAR LA EXCEPCION ClienteBloqueado.java
			
			
			fail("No debería saltar error, el cliente se bloquea");
			
		}catch(EJBException e) {
			fail("Excepción no controlada");
		}
		
	}	
	
	@Test
	public void testBloqueaClienteIncorrecto(){
		
		Usuario usuario = new Usuario ();
		usuario.setNombreUsuario("Maria");
		usuario.setPassword("1222324");
		usuario.setTipo("NORMAL");
		
		Cliente cliente = new Cliente();
		cliente.setCiudad("Alora");
		cliente.setCodigoPostal("5234");
		cliente.setCuentas(null);
		cliente.setDireccion("Calle Calle");
		cliente.setEstado(null);
		cliente.setFechaAlta(Date.valueOf("2020-08-14"));
		cliente.setFechaBaja(null);
		cliente.setId("2352225");
		cliente.setIdentificacion("22666");
		cliente.setPais("Mali");
		cliente.setTipoCliente("FISICO");
		cliente.setUsuario(usuario);
		
		
		//HAY QUE PONER ESTE CLIENTE COMO BLOQUEADO (NO SE COMO VAIS A IMPLEMENTARLO AUN)
		
		
		try {			
			gestionCliente.bloqueaCliente(cliente);		
			
		}catch(ClienteBloqueado e) {
			//OK
			
		}catch(EJBException e) {
			fail("Excepción no controlada");
		}
		
	}	
}
