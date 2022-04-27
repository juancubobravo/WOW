import exceptions.*;
import uma.wow.proyecto.*;

public interface GestionPersonaAutorizada {
	
    public void anyadirPersonaAutorizada(String IBAN, PersonaAutorizada pers) throws ClienteNoEncontrado, CuentaNoEncontrada;
    public void modificaPersonaAutorizada(PersonaAutorizada nuevosDatos) throws PersonaAutorizadaNoEncontrada;
    public void borraPersonaAutorizada(String IBAN, PersonaAutorizada pers) throws ClienteNoEncontrado, CuentaNoEncontrada;

}