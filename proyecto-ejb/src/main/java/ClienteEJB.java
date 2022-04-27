import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import exceptions.ClienteNoEncontrado;
import exceptions.CuentasActivas;
import exceptions.DatosException;
import exceptions.UsuarioException;
import uma.wow.proyecto.*;

public class ClienteEJB implements GestionCliente{

    @PersistenceContext(name="WOWEJB")
    private EntityManager em;

    //R2
    @Override
    public void altaCliente(Cliente cliente, Usuario usuario) throws UsuarioException{

        Cliente busc = em.find(Cliente.class, cliente.getId());

        if(busc != null){
            throw new UsuarioException();
        }

        em.persist(cliente);
    }

    //R3
  
    @Override
    public void modificaCliente(Cliente cliente) throws ClienteNoEncontrado, DatosException{
        Cliente oldCliente = em.find(Cliente.class, cliente);

        if(oldCliente == null){
            throw new ClienteNoEncontrado();
        }

        if(cliente.getIdentificacion() != null && cliente.getTipoCliente() != null){ // MIRAR LAS COMPROBACIONES
            oldCliente.setIdentificacion(cliente.getIdentificacion());
            oldCliente.setTipoCliente(cliente.getTipoCliente()); // ACABAR (QUE PASA SI SE CAMBIA DE EMPRESA A INDIVIDUAL)
            oldCliente.setEstado(cliente.getEstado());
            oldCliente.setFechaAlta(cliente.getFechaAlta());
            oldCliente.setFechaBaja(cliente.getFechaBaja());
            oldCliente.setDireccion(cliente.getDireccion());
            oldCliente.setCiudad(cliente.getCiudad());
            oldCliente.setCodigoPostal(cliente.getCodigoPostal());
            oldCliente.setPais(cliente.getPais());
            oldCliente.setCuentas(cliente.getCuentas());
            oldCliente.setUsuario(cliente.getUsuario());
        } else {
            throw new DatosException();
        }
    }

    // R4
    @Override
    public void bajaCliente(Cliente c) throws ClienteNoEncontrado, CuentasActivas{
        Cliente cliente = em.find(Cliente.class, c.getId());
        if(cliente == null){
            throw new ClienteNoEncontrado();
        }

        List<CuentaFintech> listCuentas = cliente.getCuentas();

        int ok = 0;

        for (CuentaFintech cuenta: listCuentas) {
            if(cuenta.getEstado().equals("ACTIVO")){
                ok = 1;
            }
        }

        if(ok == 1){
            throw new CuentasActivas();
        }

        cliente.setEstado("BAJA");

    }




}
