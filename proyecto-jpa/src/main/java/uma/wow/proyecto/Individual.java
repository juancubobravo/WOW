package uma.wow.proyecto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


import javax.persistence.*;

@Entity
@DiscriminatorValue(value="Individual")
public class Individual extends Cliente implements Serializable  {
	private static final long serialVersionUID = 1L;
	@Column(nullable = false)
	private String nombre;
	@Column(nullable = false)
	private String apellido;
	@Column (nullable=true)
	@Temporal(TemporalType.DATE)
	private Date fechaNacimiento;
	
		
	public Individual() {
		
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFecha_nacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	
	@Override
	public String toString() {
		return "Individual [nombre=" + nombre + ", apellido=" + apellido + ", fechaNacimiento=" + fechaNacimiento + "]";
	}
	
}
