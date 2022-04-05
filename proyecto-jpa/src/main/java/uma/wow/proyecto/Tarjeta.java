package uma.wow.proyecto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.*;

@Entity
public class Tarjeta implements Serializable{

	
	
	@Id @GeneratedValue
	private String numero_tarjeta;

	private String nombre_propietario;
	@Column @Temporal(TemporalType.DATE)
	private Date fecha_caducidad;
	private int CVC;
	private String IBAN;
	private double Limite_mensual;
	private double limite_online;
	@Column @Temporal(TemporalType.DATE)
	private Date fechaActivacion;

	@ManyToOne
	private Cuenta iban;
	
	
	public Tarjeta() {
		super();
	}
	
	public Tarjeta(String numero_tarjeta, String nombre_propietario, Date fecha_caducidad, int cVC, String iBAN,
			double limite_mensual, double limite_online, Date fechaActivacion) {
		super();
		this.numero_tarjeta = numero_tarjeta;
		this.nombre_propietario = nombre_propietario;
		this.fecha_caducidad = fecha_caducidad;
		CVC = cVC;
		IBAN = iBAN;
		Limite_mensual = limite_mensual;
		this.limite_online = limite_online;
		this.fechaActivacion = fechaActivacion;
	}

	public String getNumero_tarjeta() {
		return numero_tarjeta;
	}

	public String getNombre_propietario() {
		return nombre_propietario;
	}

	public Date getFecha_caducidad() {
		return fecha_caducidad;
	}

	public int getCVC() {
		return CVC;
	}

	public String getIBAN() {
		return IBAN;
	}

	public double getLimite_mensual() {
		return Limite_mensual;
	}

	public double getLimite_online() {
		return limite_online;
	}

	public Date getFechaActivacion() {
		return fechaActivacion;
	}

	public void setNumero_tarjeta(String numero_tarjeta) {
		this.numero_tarjeta = numero_tarjeta;
	}

	public void setNombre_propietario(String nombre_propietario) {
		this.nombre_propietario = nombre_propietario;
	}

	public void setFecha_caducidad(Date fecha_caducidad) {
		this.fecha_caducidad = fecha_caducidad;
	}

	public void setCVC(int cVC) {
		CVC = cVC;
	}

	public void setIBAN(String iBAN) {
		IBAN = iBAN;
	}

	public void setLimite_mensual(double limite_mensual) {
		Limite_mensual = limite_mensual;
	}

	public void setLimite_online(double limite_online) {
		this.limite_online = limite_online;
	}

	public void setFechaActivacion(Date fechaActivacion) {
		this.fechaActivacion = fechaActivacion;
	}

	@Override
	public int hashCode() {
		return Objects.hash(numero_tarjeta);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tarjeta other = (Tarjeta) obj;
		if (numero_tarjeta == null) {
			if (other.numero_tarjeta != null)
				return false;
		} else if (!numero_tarjeta.equals(other.numero_tarjeta))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Tarjeta [numero_tarjeta=" + numero_tarjeta + ", nombre_propietario=" + nombre_propietario
				+ ", fecha_caducidad=" + fecha_caducidad + ", CVC=" + CVC + ", IBAN=" + IBAN + ", Limite_mensual="
				+ Limite_mensual + ", limite_online=" + limite_online + ", fechaActivacion=" + fechaActivacion + "]";
	}

	

}