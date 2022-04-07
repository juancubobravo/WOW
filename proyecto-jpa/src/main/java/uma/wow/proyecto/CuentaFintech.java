package uma.wow.proyecto;

import java.io.Serializable;
import java.util.Date;


import javax.persistence.*;


@Entity
@DiscriminatorValue(value="CuentaReferencia")

public class CuentaFintech extends Cuenta implements Serializable {

	private static final long serialVersionUID = 1L;
	private String estado;
	
	
	@Temporal(TemporalType.DATE)
	private  Date fechaApertura;
	
	@Column (nullable = true)
	@Temporal(TemporalType.DATE)
	private Date fechaCierre;
	@Column (nullable = true)
	private String clasificacion;
	
	@ManyToOne
	@JoinColumn(name = "CUENTA_FINTECH_CLIENTE", nullable = false)
	private Cliente cliente;
	
	
	public CuentaFintech(String iban) {
		super(iban);
		fechaCierre = null;
		clasificacion = null;
	}
	
	public CuentaFintech() {
		
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public Date getFechaApertura() {
		return fechaApertura;
	}


	public void setFechaApertura(Date fechaApertura) {
		this.fechaApertura = fechaApertura;
	}


	public Date getFechaCierre() {
		return fechaCierre;
	}


	public void setFechaCierre(Date fechaCierre) {
		this.fechaCierre = fechaCierre;
	}


	public String getClasificacion() {
		return clasificacion;
	}


	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}


	@Override
	public int hashCode() {
		return super.hashCode();
	}


	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	

}
