import java.util.logging.Logger;

import javax.naming.NamingException;

import org.junit.Before;
import org.junit.Test;

import es.uma.informatica.sii.anotaciones.Requisitos;
import exceptions.ClienteNoEncontrado;
import exceptions.ContraseniaInvalida;
import exceptions.NoAdministradorException;
import exceptions.UsuarioNoEncontrado;
import uma.wow.proyecto.Empresa;
import uma.wow.proyecto.Individual;
import uma.wow.proyecto.Usuario;

@Requisitos({"RF3"})
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
	
	@Test
	public void testModificaClienteEmpresa(Empresa cliente, Usuario usuario) throws ClienteNoEncontrado, UsuarioNoEncontrado, ContraseniaInvalida, NoAdministradorException{
		
		try {
			
			gestionCliente.modificaCliente(cliente, usuario);
			

			cliente.setCiudad("MALAGA");
			cliente.setCodigoPostal("29007");
			cliente.setDireccion("C/MALAGA");
			cliente.setEstado("INACTIVO");
			cliente.setFechaAlta(cliente.getFechaAlta());
			cliente.setFechaBaja(cliente.getFechaBaja());
			cliente.setId("1111");
			cliente.setIdentificacion("1111");
			cliente.setPais("ESPANYA");
			cliente.setRazon_Social("x");
			cliente.setTipoCliente("INDIVIDUAL");
			cliente.setUsuario(usuario);
			
			usuario.setCliente(cliente);
			usuario.setNombreUsuario("Pepe");
			usuario.setPassword("1234");
			usuario.setTipo("INDIVIDUAL");
			
		}catch(ClienteNoEncontrado e) {
			
		}catch(UsuarioNoEncontrado e) {
			
		}catch(ContraseniaInvalida e) {
			
		}catch(NoAdministradorException e) {
			
		}
		
	}
	
	@Test
    public void testModificaClienteIndividual(Individual cliente, Usuario usuario) throws ClienteNoEncontrado, UsuarioNoEncontrado, ContraseniaInvalida, NoAdministradorException{
    	
		try {
			
			gestionCliente.modificaCliente(cliente, usuario);
			
			cliente.setCiudad("MALAGA");
			cliente.setCodigoPostal("29007");
			cliente.setDireccion("C/MALAGA");
			cliente.setEstado("INACTIVO");
			cliente.setFechaAlta(cliente.getFechaAlta());
			cliente.setFechaBaja(cliente.getFechaBaja());
			cliente.setId("1111");
			cliente.setIdentificacion("1111");
			cliente.setPais("ESPANYA");
			cliente.setTipoCliente("EMPRESA");
			cliente.setUsuario(usuario);
			
			usuario.setCliente(cliente);
			usuario.setNombreUsuario("Pepe");
			usuario.setPassword("1234");
			usuario.setTipo("INDIVIDUAL");
			
		}catch(ClienteNoEncontrado e) {
			
		}catch(UsuarioNoEncontrado e) {
			
		}catch(ContraseniaInvalida e) {
			
		}catch(NoAdministradorException e) {
			
		}
    	
    	
    }
	
}
