import uma.wow.proyecto.Cliente;
import uma.wow.proyecto.Empresa;
import uma.wow.proyecto.Individual;
import uma.wow.proyecto.PersonaAutorizada;
import uma.wow.proyecto.Usuario;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import exceptions.ClienteNoEncontrado;
import exceptions.ContraseniaInvalida;
import exceptions.CuentaBloqueada;
import exceptions.CuentaDeBaja;
import exceptions.EsEmpresaException;
import exceptions.NoAdministradorException;
import exceptions.UsuarioNoEncontrado;

@Stateless
public class AccesoEJB implements GestionAcceso{

	@PersistenceContext(unitName="WOWEJB")
	private EntityManager em;
	
	@Override
	public void loginAdministrador(Usuario usuario) throws UsuarioNoEncontrado, ContraseniaInvalida, NoAdministradorException {
		
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
		
	
	}

	@Override
	public void loginCliente(Usuario usuario) throws UsuarioNoEncontrado, ContraseniaInvalida, EsEmpresaException, CuentaBloqueada, CuentaDeBaja, ClienteNoEncontrado{
		
		Usuario u = em.find(Usuario.class, usuario.getNombreUsuario());
		
		//Comprobamos si existe el usuario
		
		if(u == null) {
			throw new UsuarioNoEncontrado();
		}
		
		//El usuario existe, comprobamos su contraseña
		
		if(!u.getPassword().equals(usuario.getPassword())) {
			throw new ContraseniaInvalida();
		}
		
		//Comprobamos que no sea una persona jurídica
		
		Empresa empresa = em.find(Empresa.class,u.getCliente().getId());
		Individual fisica = em.find(Individual.class, u.getCliente().getId());
		PersonaAutorizada autorizado = em.find(PersonaAutorizada.class, u.getPersonaAutorizada().getId());
		
		if(empresa != null) {
			throw new EsEmpresaException();
			
		} else if(fisica != null) {
			
			if(fisica.getEstado() == "BLOQUEADO") {
				throw new CuentaBloqueada();
			} else if(fisica.getEstado()=="BAJA") {
				throw new CuentaDeBaja();
			}
			
		} else if(autorizado != null){
			if(autorizado.getEstado() == "BLOQUEADO") {
				throw new CuentaBloqueada();
			} else if(autorizado.getEstado()=="BAJA") {
				throw new CuentaDeBaja();
			}
			
		} else {
			throw new ClienteNoEncontrado();
		}
		
		
	}
	
	
	

}
