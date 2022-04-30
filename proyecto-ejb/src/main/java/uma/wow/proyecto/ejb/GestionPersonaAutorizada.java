package uma.wow.proyecto.ejb;
import uma.wow.proyecto.ejb.exceptions.*;
import uma.wow.proyecto.*;
public interface GestionPersonaAutorizada {
	
	public void anyadirPersonaAutorizada(PooledAccount c, PersonaAutorizada pers, Usuario user, String tipo) throws ClienteNoEncontrado, CuentaNoEncontrada, NoEsEmpresaException, UsuarioNoEncontrado, ContraseniaInvalida, NoAdministradorException;
	public void anyadirPersonaAutorizada(Segregada c, PersonaAutorizada pers, Usuario user, String tipo) throws ClienteNoEncontrado, CuentaNoEncontrada, NoEsEmpresaException, UsuarioNoEncontrado, ContraseniaInvalida, NoAdministradorException;
	public void modificaPersonaAutorizada(PersonaAutorizada nuevosDatos, Usuario user) throws PersonaAutorizadaNoEncontrada, UsuarioNoEncontrado, ContraseniaInvalida, NoAdministradorException;
	public void borraPersonaAutorizada(PersonaAutorizada pers, Usuario user) throws PersonaAutorizadaNoEncontrada,UsuarioNoEncontrado, ContraseniaInvalida, NoAdministradorException;
	public PersonaAutorizada devolver(String identificacion) throws PersonaAutorizadaNoEncontrada;
}