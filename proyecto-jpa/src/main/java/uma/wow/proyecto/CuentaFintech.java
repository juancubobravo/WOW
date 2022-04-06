package uma.wow.proyecto;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class CuentaFintech extends Cuenta {

	private String estado;
	private  Date fechaApertura;
	@Column (nullable = true)
	private Date fechaCierre;
	@Column (nullable = true)
	private String clasificacion;
	
	
	public CuentaFintech(String iban) {
		super(iban);
		fechaCierre = null;
		clasificacion = null;
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
