import exceptions.*;
import uma.wow.proyecto.*;

public interface GestionPersonaAutorizada {
	
	public void anyadirPersonaAutorizada(PooledAccount c, PersonaAutorizada pers, Usuario user) throws ClienteNoEncontrado, CuentaNoEncontrada, NoEsEmpresaException, UsuarioNoEncontrado, ContraseniaInvalida, NoAdministradorException;
	public void anyadirPersonaAutorizada(Segregada c, PersonaAutorizada pers, Usuario user) throws ClienteNoEncontrado, CuentaNoEncontrada, NoEsEmpresaException, UsuarioNoEncontrado, ContraseniaInvalida, NoAdministradorException;
    public void modificaPersonaAutorizada(PersonaAutorizada nuevosDatos) throws PersonaAutorizadaNoEncontrada;
    public void borraPersonaAutorizada(String IBAN, PersonaAutorizada pers) throws ClienteNoEncontrado, CuentaNoEncontrada;

}