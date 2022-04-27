import uma.wow.proyecto.Usuario;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import exceptions.ContraseniaInvalida;
import exceptions.NoAdministradorException;
import exceptions.UsuarioNoEncontrado;

@Stateless
public class AccesoEJB implements GestionAcceso{

	@PersistenceContext(name="WOWEJB")
	private EntityManager em;
	
	@Override
	public boolean loginAdministrador(Usuario usuario) throws UsuarioNoEncontrado, ContraseniaInvalida, NoAdministradorException {
		
		Usuario u = em.find(Usuario.class, usuario.getNombreUsuario());
		
		//Comprobamos si existe el usuario
		
		if(u == null) {
			throw new UsuarioNoEncontrado();
		}
		
		//El usuario existe, comprobamos su contraseña
		
		if(!u.getPassword().equals(usuario.getPassword())) {
			throw new ContraseniaInvalida();
		}
		
		//Comprobamos si el usuario autenticado es administrador
		if(!u.getTipo().equals("ADMIN")) {
			throw new NoAdministradorException();
		}
		
		return true;
	}

	@Override
	public boolean loginCliente(Usuario usuario) {
		// TODO Auto-generated method stub
		
		return true;
		
	}
	
	
	

}
