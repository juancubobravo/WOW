package uma.wow.proyecto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.*;

@Entity
public class Transaccion implements Serializable {

	@Id
	@GeneratedValue
	private String IDunico;
	@Column @Temporal(TemporalType.DATE)
	private Date fechaInstruccion;
	private double cantidad;
	@Column (nullable = true) @Temporal(TemporalType.DATE) 
	private Date fechaEjecucion;
	private String tipo;
	private String comision;
	private String internacional;
	
	@ManyToOne
	private Cuenta IBAN;
	
	@ManyToOne
	private Cuenta IBAN2;
	

	public Transaccion() {
		super();
	}

	@Override
	public String toString() {
		return "Transaccion [IDunico=" + IDunico + ", fechaInstruccion=" + fechaInstruccion + ", cantidad=" + cantidad
				+ ", fechaEjecucion=" + fechaEjecucion + ", tipo=" + tipo + ", comision=" + comision
				+ ", internacional=" + internacional + "]";
	}

	public Transaccion(String iDunico, Date fechaInstruccion, double cantidad, String tipo, String comision,
			String internacional) {
		super();
		IDunico = iDunico;
		this.fechaInstruccion = fechaInstruccion;
		this.cantidad = cantidad;
		this.tipo = tipo;
		this.comision = comision;
		this.internacional = internacional;
		this.fechaEjecucion = null;
	}

	@Override
	public int hashCode() {
		return Objects.hash(IDunico);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaccion other = (Transaccion) obj;
		if (IDunico == null) {
			if (other.IDunico != null)
				return false;
		} else if (!IDunico.equals(other.IDunico))
			return false;
		return true;
	}

	public String getIDunico() {
		return IDunico;
	}

	public Date getFechaInstruccion() {
		return fechaInstruccion;
	}

	public double getCantidad() {
		return cantidad;
	}

	public Date getFechaEjecucion() {
		return fechaEjecucion;
	}

	public String getTipo() {
		return tipo;
	}

	public String getComision() {
		return comision;
	}

	public String getInternacional() {
		return internacional;
	}

	public void setIDunico(String iDunico) {
		IDunico = iDunico;
	}

	public void setFechaInstruccion(Date fechaInstruccion) {
		this.fechaInstruccion = fechaInstruccion;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	public void setFechaEjecucion(Date fechaEjecucion) {
		this.fechaEjecucion = fechaEjecucion;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setComision(String comision) {
		this.comision = comision;
	}

	public void setInternacional(String internacional) {
		this.internacional = internacional;
	}

	

	

}