import exceptions.ClienteNoEncontrado;
import exceptions.ContraseniaInvalida;
import exceptions.CuentaBloqueada;
import exceptions.CuentaDeBaja;
import exceptions.EsEmpresaException;
import exceptions.NoAdministradorException;
import exceptions.UsuarioNoEncontrado;
import uma.wow.proyecto.Usuario;
public interface GestionAcceso {
	
	public void loginAdministrador(Usuario usuario) throws UsuarioNoEncontrado, ContraseniaInvalida, NoAdministradorException;
	
	public void loginCliente(Usuario usuario) throws UsuarioNoEncontrado, ContraseniaInvalida, EsEmpresaException, CuentaBloqueada, CuentaDeBaja, ClienteNoEncontrado;

}
