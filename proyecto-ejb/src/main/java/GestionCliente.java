import java.util.List;

import exceptions.*;
import uma.wow.proyecto.*;


public interface GestionCliente {
	
	/*//Dar de alta un cliente de tipo persona jurídica
	public void altaCliente(Empresa cliente) throws UsuarioException;
	
	//Dar de alta un cliente de tipo persona física
	public void altaCliente(Individual cliente)throws UsuarioException;
	
	public void modificaCliente(Empresa cliente) throws ClienteNoEncontrado;
	
	public void modificaCliente(Individual cliente) throws ClienteNoEncontrado,DatosException;
	*/

	    public void altaCliente(Empresa cliente, Usuario usuario) throws UsuarioException, UsuarioNoEncontrado, ContraseniaInvalida, NoAdministradorException, ClienteNoEncontrado, ClienteYaExistente;
	    public void altaCliente(Individual cliente, Usuario usuario) throws UsuarioException, UsuarioNoEncontrado, ContraseniaInvalida, NoAdministradorException, ClienteNoEncontrado, ClienteYaExistente;
	    public void modificaCliente(Empresa cliente, Usuario usuario) throws ClienteNoEncontrado, UsuarioNoEncontrado, ContraseniaInvalida, NoAdministradorException;
	    public void modificaCliente(Individual cliente, Usuario usuario) throws ClienteNoEncontrado, UsuarioNoEncontrado, ContraseniaInvalida, NoAdministradorException;
	    public void bajaCliente(Individual c, Usuario usuario) throws ClienteNoEncontrado, CuentasActivas, UsuarioNoEncontrado, ContraseniaInvalida, NoAdministradorException;
	    public void bajaCliente(Empresa c, Usuario usuario) throws ClienteNoEncontrado, CuentasActivas, UsuarioNoEncontrado, ContraseniaInvalida, NoAdministradorException;
	    public List<Cliente> devolverTodosClientes();
	    public Cliente devolver(String identificacion) throws ClienteNoEncontrado;

}