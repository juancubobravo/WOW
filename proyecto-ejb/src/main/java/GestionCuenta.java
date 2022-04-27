import exceptions.*;
import uma.wow.proyecto.*;


public interface GestionCuenta {
	
    public void creaCuenta(CuentaFintech cuentaNueva, Cliente c) throws CuentaEncontrada, ClienteNoEncontrado;
    public void cierraCuenta(String IBAN) throws SaldoException, CuentaNoEncontrada;

}