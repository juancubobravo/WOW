package uma.wow.proyecto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Cuenta_Fintech extends Cuenta {

	private String estado;
	private  Date fecha_apertura;
	@Column (nullable = true)
	private Date fecha_cierre;
	@Column (nullable = true)
	private String clasificacion;
	
	public Cuenta_Fintech(String iBAN) {
		super(iBAN);
		fecha_cierre = null;
		clasificacion = null;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFecha_apertura() {
		return fecha_apertura;
	}

	public void setFecha_apertura(Date fecha_apertura) {
		this.fecha_apertura = fecha_apertura;
	}

	public Date getFecha_cierre() {
		return fecha_cierre;
	}

	public void setFecha_cierre(Date fecha_cierre) {
		this.fecha_cierre = fecha_cierre;
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
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cuenta_Fintech other = (Cuenta_Fintech) obj;
		if (clasificacion == null) {
			if (other.clasificacion != null)
				return false;
		} else if (!clasificacion.equals(other.clasificacion))
			return false;
		if (fecha_apertura == null) {
			if (other.fecha_apertura != null)
				return false;
		} else if (!fecha_apertura.equals(other.fecha_apertura))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return super.toString()+" Cuenta_Fintech [estado=" + estado + ", fecha_apertura=" + fecha_apertura + ", fecha_cierre="
				+ fecha_cierre + ", clasificacion=" + clasificacion + "]";
	}
	

}
