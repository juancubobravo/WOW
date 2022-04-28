

import exceptions.*;
import uma.wow.proyecto.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

public class BloqueoCliente implements GestionBloqueoCliente{

    @PersistenceContext(name="WOWEJB")
    private EntityManager em;


    // R16 
    @Override
    public void bloqueoUsuario(Usuario user, String estado) throws UsuarioException, DatosException, EmpresaNoEncontrada {
        Usuario usuario = em.find(Usuario.class, user.getNombreUsuario());
        if(usuario == null){
            throw new UsuarioException();
        }

        if(usuario.getPersonaAutorizada() != null){
            usuario.getPersonaAutorizada().setEstado(estado);
        } else if(usuario.getCliente() != null){
            bloqueoCliente(usuario.getCliente(), estado);
        } else {
            throw new DatosException();
        }

    }

    @Override
    public void bloqueoCliente(Cliente cliente, String estado) throws DatosException, EmpresaNoEncontrada {
        if(cliente.getTipoCliente().equals("PERSONA_JURIDICA")){
            cliente.setEstado(estado);
            comprobarBloqueoClienteAutorizado(cliente, estado);
        } else if(cliente.getTipoCliente().equals("PERSONA_FISICA")){
            cliente.setEstado(estado);
        } else {
            throw new DatosException();
        }
    }

    @Override
    public void comprobarBloqueoClienteAutorizado(Cliente cliente, String estado) throws EmpresaNoEncontrada {
        Empresa empresa = em.find(Empresa.class, cliente.getId());
        if(empresa == null){
            throw new EmpresaNoEncontrada();
        }
        List<Autorizacion> autorizacionList = empresa.getAutori();
        List<PersonaAutorizada> listaPersonasAutorizadas = new ArrayList<>();

        for (Autorizacion auto: autorizacionList) {
            listaPersonasAutorizadas.add(auto.getIdAutorizada());
        }

        for(PersonaAutorizada pers : listaPersonasAutorizadas){
            if(pers.getAutori().size() == 1){
                pers.setEstado(estado);
            }
        }
    }



}
