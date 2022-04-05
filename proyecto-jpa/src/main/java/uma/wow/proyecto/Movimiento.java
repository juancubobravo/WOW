package uma.wow.proyecto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Movimiento implements Serializable{
	@Id @GeneratedValue (strategy = GenerationType.AUTO)
	private String ID;
	@Column @Temporal(TemporalType.DATE)
	private Date Fecha; 
	private String Concepto;
	private String Emisor;
	private double Cantidad;
	private String Modo_Operacion;
	
	@ManyToOne
	private Tarjeta numero_tarjeta;
	
	@ManyToOne
	private Divisa abreviatura;
	
	public Movimiento(String iD, Date fecha, String concepto, String emisor, double cantidad, String modo_Operación) {
		super();
		ID = iD;
		Fecha = fecha;
		Concepto = concepto;
		Emisor = emisor;
		Cantidad = cantidad;
		Modo_Operacion = modo_Operación;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public Date getFecha() {
		return Fecha;
	}
	public void setFecha(Date fecha) {
		Fecha = fecha;
	}
	public String getConcepto() {
		return Concepto;
	}
	public void setConcepto(String concepto) {
		Concepto = concepto;
	}
	public String getEmisor() {
		return Emisor;
	}
	public void setEmisor(String emisor) {
		Emisor = emisor;
	}
	public double getCantidad() {
		return Cantidad;
	}
	public void setCantidad(double cantidad) {
		Cantidad = cantidad;
	}
	public String getModo_Operación() {
		return Modo_Operacion;
	}
	public void setModo_Operación(String modo_Operación) {
		Modo_Operacion = modo_Operación;
	}
	
	
	@Override
	public int hashCode() {
		return ID.hashCode(); 
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movimiento other = (Movimiento) obj;
		if (ID == null) {
			if (other.ID != null)
				return false;
		} else if (!ID.equals(other.ID))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Movimiento [ID=" + ID + ", Fecha=" + Fecha + ", Concepto=" + Concepto + ", Emisor=" + Emisor
				+ ", Cantidad=" + Cantidad + ", Modo_Operacion=" + Modo_Operacion + "]";
	}
}
