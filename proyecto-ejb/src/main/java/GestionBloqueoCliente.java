import exceptions.*;
import uma.wow.proyecto.*;

public interface GestionBloqueoCliente {
	
    public void bloqueoUsuario(Usuario user, String estado) throws UsuarioException, DatosException, EmpresaNoEncontrada;
    public void bloqueoCliente(Cliente cliente, String estado) throws DatosException, EmpresaNoEncontrada;
    public void comprobarBloqueoClienteAutorizado(Cliente cliente, String estado) throws EmpresaNoEncontrada;

}
