package uma.wow.proyecto.backing;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import uma.wow.proyecto.CuentaFintech;
import uma.wow.proyecto.PersonaAutorizada;
import uma.wow.proyecto.PooledAccount;
import uma.wow.proyecto.Usuario;
import uma.wow.proyecto.ejb.GestionCuenta;
import uma.wow.proyecto.ejb.GestionPersonaAutorizada;
import uma.wow.proyecto.ejb.exceptions.ClienteNoEncontrado;
import uma.wow.proyecto.ejb.exceptions.ContraseniaInvalida;
import uma.wow.proyecto.ejb.exceptions.CuentaNoEncontrada;
import uma.wow.proyecto.ejb.exceptions.NoAdministradorException;
import uma.wow.proyecto.ejb.exceptions.NoEsEmpresaException;
import uma.wow.proyecto.ejb.exceptions.PersonaAutorizadaEncontrada;
import uma.wow.proyecto.ejb.exceptions.UsuarioNoEncontrado;

@Named(value = "autorizadosAniadir")
@RequestScoped
public class AutorizadosAniadir {
	
	@Inject
	private GestionPersonaAutorizada autorizadaEJB;

	@Inject
	private InfoSesion sesion;

	private Usuario usuario;
	
	private PersonaAutorizada personaAut;
	
	private CuentaFintech cuentaF;
	
	private PooledAccount pol;
	
	public PooledAccount getPol() {
		return pol;
	}

	public void setPol(PooledAccount pol) {
		this.pol = pol;
	}

	public AutorizadosAniadir() {
		
		personaAut = new PersonaAutorizada();
		usuario = new Usuario();
		
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public PersonaAutorizada getPersonaAut() {
		return personaAut;
	}

	public void setPersonaAut(PersonaAutorizada personaAut) {
		this.personaAut = personaAut;
	}

	public CuentaFintech getCuentaF() {
		return cuentaF;
	}

	public void setCuentaF(CuentaFintech cuentaF) {
		this.cuentaF = cuentaF;
	}

	
	
	public String autorizadosAniadir() throws CuentaNoEncontrada, NoEsEmpresaException, UsuarioNoEncontrado, ContraseniaInvalida, PersonaAutorizadaEncontrada {
		
		try {
			
			usuario = sesion.getUsuario();
			autorizadaEJB.anyadirPersonaAutorizada(pol, personaAut, usuario, usuario.getTipo());
			return "mainAdmin.xhtml";
			
			//ClienteNoEncontrado, CuentaNoEncontrada, NoEsEmpresaException, UsuarioNoEncontrado, ContraseniaInvalida,PersonaAutorizadaEncontrada, NoAdministradorException;
			
		}catch(NoAdministradorException e) {
			
			FacesMessage fm = new FacesMessage("El usuario no es administrativo");
			FacesContext.getCurrentInstance().addMessage("añadirAutorizados", fm);
			
		}catch(ClienteNoEncontrado e) {
			
			FacesMessage fm = new FacesMessage("El cliente no es juridico");
			FacesContext.getCurrentInstance().addMessage("añadirAutorizados", fm);
			
		}
		return null;
	}
	
}
