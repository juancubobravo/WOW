package uma.wow.proyecto.backing;


import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import uma.wow.proyecto.Cliente;
import uma.wow.proyecto.DepositaEnPK;
import uma.wow.proyecto.DepositadaEn;
import uma.wow.proyecto.Individual;
import uma.wow.proyecto.PooledAccount;
import uma.wow.proyecto.Usuario;
import uma.wow.proyecto.ejb.GestionCliente;
import uma.wow.proyecto.ejb.GestionCuenta;
import uma.wow.proyecto.ejb.exceptions.ClienteNoEncontrado;
import uma.wow.proyecto.ejb.exceptions.ContraseniaInvalida;
import uma.wow.proyecto.ejb.exceptions.CuentaEncontrada;
import uma.wow.proyecto.ejb.exceptions.CuentaNoEncontrada;
import uma.wow.proyecto.ejb.exceptions.NoAdministradorException;
import uma.wow.proyecto.ejb.exceptions.UsuarioNoEncontrado;

@Named(value = "cuentaPooledAbrir")
@RequestScoped
public class CuentaPooledAbrir {
	
	@Inject
	private InfoSesion sesion;
	
	@Inject
	private GestionCuenta cuentaEJB;
	
	@Inject
	private GestionCliente clienteEJB;
	
	private PooledAccount poolA;
	
	private Usuario usuario;
	
	private String IBAN;
	
	private String SWIFT;
	
	private List<DepositadaEn> deposito;
	
	private String ID;
	
	private double saldo;
	
	private String IBAN_REF;

	public String getIBAN_REF() {
		return IBAN_REF;
	}

	public void setIBAN_REF(String iBAN_REF) {
		IBAN_REF = iBAN_REF;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getIBAN() {
		return IBAN;
	}

	public void setIBAN(String iBAN) {
		IBAN = iBAN;
	}

	public String getSWIFT() {
		return SWIFT;
	}

	public void setSWIFT(String sWIFT) {
		SWIFT = sWIFT;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public String abreSegregada() throws NoAdministradorException, CuentaEncontrada, ContraseniaInvalida {
		
		if(sesion.isAdmin()) {
			
			try {
				
				
				Cliente cliente = clienteEJB.devolverIndividual(getID());
				
				poolA = new PooledAccount();
				poolA.setIban(getIBAN());
				poolA.setEstado("ACTIVA");
				poolA.setFechaCierre(null);
				poolA.setSwift(getSWIFT());
				//Date fecha = new Date();
				/*fecha.setHours(LocalDateTime.now().getHour());
				fecha.setMinutes(LocalDateTime.now().getMinute());
				fecha.setMonth(LocalDateTime.now().getMonthValue());
				fecha.setYear(LocalDateTime.now().getYear());*/
				poolA.setFechaApertura(Date.valueOf(LocalDate.now()));
				poolA.setClasificacion("p");
				
				PooledAccount cuentaRef = cuentaEJB.devolverPooled(getIBAN());
				
				deposito = new ArrayList<>();
				
				DepositadaEn depositoEn = new DepositadaEn();
				
				DepositaEnPK depositoEnPK = new DepositaEnPK();
				
				depositoEnPK.setPooledAccountIban(getIBAN());
				depositoEnPK.setCuentaReferenciaIban(getIBAN_REF());
				
				depositoEn.setId(depositoEnPK);
				depositoEn.setSaldo(getSaldo());
				
				deposito.add(depositoEn);
				
				try {
					
					cuentaEJB.creaCuenta(poolA, (Individual) cliente, usuario);
					
				}catch (ClienteNoEncontrado e) {
					
				}
				return "mainAdmin.xhtml";
				
				//CuentaEncontrada, ClienteNoEncontrado, UsuarioNoEncontrado, ContraseniaInvalida
				
			}catch (ClienteNoEncontrado e) {
				FacesMessage fm = new FacesMessage("El cliente no existe");
				FacesContext.getCurrentInstance().addMessage("abrirSegregada:cliente", fm);
			} catch (CuentaNoEncontrada e) {
				FacesMessage fm = new FacesMessage("La cuenta de referencia no existe");
				FacesContext.getCurrentInstance().addMessage("abrirSegregada:ibanReferencia", fm);
			} catch (UsuarioNoEncontrado e) {
				FacesMessage fm = new FacesMessage("El usuario no es administrativo");
				FacesContext.getCurrentInstance().addMessage("abrirSegregada:boton", fm);
			}
			
			return null;
			
		}else {
			throw new NoAdministradorException();
		}
	}

}
