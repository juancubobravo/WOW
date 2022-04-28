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

	    public void altaCliente(Empresa cliente, Usuario usuario) throws UsuarioException, UsuarioNoEncontrado, ContraseniaInvalida, NoAdministradorException;
	    public void altaCliente(Individual cliente, Usuario usuario) throws UsuarioException, UsuarioNoEncontrado, ContraseniaInvalida, NoAdministradorException;
	    public void modificaCliente(Cliente cliente) throws ClienteNoEncontrado, DatosException;
	    public void bajaCliente(Cliente c) throws ClienteNoEncontrado, CuentasActivas;

	

}