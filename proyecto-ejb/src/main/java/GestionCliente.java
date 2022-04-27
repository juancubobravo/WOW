import exceptions.ClienteNoEncontrado;
import exceptions.UsuarioException;
import uma.wow.proyecto.Empresa;
import uma.wow.proyecto.Individual;

public interface GestionCliente {
	
	//Dar de alta un cliente de tipo persona jurídica
	public void altaCliente(Empresa cliente) throws UsuarioException;
	
	//Dar de alta un cliente de tipo persona física
	public void altaCliente(Individual cliente)throws UsuarioException;
	
	public void modificarCliente(Empresa cliente) throws ClienteNoEncontrado;
	
	public void modificarCliente(Individual cliente) throws ClienteNoEncontrado;
	
	

}
