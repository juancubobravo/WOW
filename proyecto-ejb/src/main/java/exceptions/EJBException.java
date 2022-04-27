package exceptions;

public class EJBException extends Exception {
    public EJBException() {
    }

    public EJBException(String mensaje) {
        super(mensaje);
    }
}
