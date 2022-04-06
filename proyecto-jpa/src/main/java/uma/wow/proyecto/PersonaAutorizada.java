package uma.wow.proyecto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PersonaAutorizada implements Serializable{
	
	@Id @GeneratedValue (strategy = GenerationType.AUTO)
	private String ID;
	@Column (unique = true)
	private String Identificacion;
	private String nombre;
	private String apellidos;
	private String direccion;
	@Column (nullable = true)
	private Date fecha_nacimiento;
	@Column (nullable = true)
	private String Estado;
	@Column (nullable = true)
	private Date FechaInicio;
	@Column (nullable = true)
	private Date FechaFin;
	
	public PersonaAutorizada(String iD, String identificacion, String nombre, String apellidos, String direccion) {
		super();
		ID = iD;
		Identificacion = identificacion;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		Estado = null;
		FechaInicio = null;
		FechaFin = null;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getIdentificacion() {
		return Identificacion;
	}

	public void setIdentificacion(String identificacion) {
		Identificacion = identificacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public String getEstado() {
		return Estado;
	}

	public void setEstado(String estado) {
		Estado = estado;
	}

	public Date getFechaInicio() {
		return FechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		FechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return FechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		FechaFin = fechaFin;
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
		Persona_autorizada other = (Persona_autorizada) obj;
		if (ID == null) {
			if (other.ID != null)
				return false;
		} else if (!ID.equals(other.ID))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Persona_autorizada [ID=" + ID + ", Identificacion=" + Identificacion + ", nombre=" + nombre
				+ ", apellidos=" + apellidos + ", direccion=" + direccion + ", fecha_nacimiento=" + fecha_nacimiento
				+ ", Estado=" + Estado + ", FechaInicio=" + FechaInicio + ", FechaFin=" + FechaFin + "]";
	}
	
	

}
