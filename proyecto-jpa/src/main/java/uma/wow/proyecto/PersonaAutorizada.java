package uma.wow.proyecto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PersonaAutorizada implements Serializable{
	
	@Id @GeneratedValue (strategy = GenerationType.AUTO)
	private String id;
	@Column (unique = true)
	private String identificacion;
	private String nombre;
	private String apellidos;
	private String direccion;
	@Column (nullable = true)
	private Date fechaNacimiento;
	@Column (nullable = true)
	private String estado;
	@Column (nullable = true)
	private Date fechaInicio;
	@Column (nullable = true)
	private Date fechaFin;
	
	public PersonaAutorizada(String id, String identificacion, String nombre, String apellidos, String direccion) {
		super();
		this.id = id;
		this.identificacion = identificacion;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		estado = null;
		fechaInicio = null;
		fechaFin = null;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
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

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonaAutorizada other = (PersonaAutorizada) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "PersonaAutorizada [id=" + id + ", identificacion=" + identificacion + ", nombre=" + nombre
				+ ", apellidos=" + apellidos + ", direccion=" + direccion + ", fechaNacimiento=" + fechaNacimiento
				+ ", estado=" + estado + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + "]";
	}

	
	

}
