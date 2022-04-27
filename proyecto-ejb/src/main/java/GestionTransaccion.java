import exceptions.*;
import uma.wow.proyecto.*;


public interface GestionTransaccion {
	
    public void transaccionClienteAutorizado(Individual ind, PersonaAutorizada persAut, String ibanDes, String ibanOr, double saldo)
            throws ClienteNoEncontrado, PersonaAutorizadaNoEncontrada;

}