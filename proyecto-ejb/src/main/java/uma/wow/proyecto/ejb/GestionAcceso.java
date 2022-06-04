package uma.wow.proyecto.ejb;
import uma.wow.proyecto.ejb.exceptions.*;

/*import java.util.List;

import uma.wow.proyecto.Individual;
import uma.wow.proyecto.PersonaAutorizada;*/
import uma.wow.proyecto.Usuario;
public interface GestionAcceso {
	
	public void loginAdministrador(Usuario usuario) throws UsuarioNoEncontrado, ContraseniaInvalida, NoAdministradorException;
	
	public void loginCliente(Usuario usuario) throws UsuarioNoEncontrado, ContraseniaInvalida, EsEmpresaException, CuentaBloqueada, CuentaDeBaja, ClienteNoEncontrado, EsAdministrador;

	/*public void creaUsuario(Usuario usuario) throws UsuarioException;
	
	Individual devuelveCliente(Usuario usuario);
	
	PersonaAutorizada devuelvePersAut(Usuario usuario);
	
	public List<Usuario> devuelveTodos();*/
	
}
