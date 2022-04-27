import exceptions.ContraseniaInvalida;
import exceptions.NoAdministradorException;
import exceptions.UsuarioNoEncontrado;
import uma.wow.proyecto.Usuario;
public interface GestionAcceso {
	
	public boolean loginAdministrador(Usuario usuario) throws UsuarioNoEncontrado, ContraseniaInvalida, NoAdministradorException;
	
	public boolean loginCliente(Usuario usuario);

}
