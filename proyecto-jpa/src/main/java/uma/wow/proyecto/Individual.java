package uma.wow.proyecto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

@Entity
public class Individual extends Cliente implements Serializable  {
	private String nombre;
	private String apellido;
	@Column (nullable=true)
	@Temporal(TemporalType.DATE)
	private java.util.Date fecha_nacimiento;
	
	@OneToOne
	private Cliente id1;
	
	public Individual(String nombre, String apellido, Date fecha_nacimiento) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.fecha_nacimiento = fecha_nacimiento;
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
	public java.util.Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	public void setFecha_nacimiento(java.util.Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
	
}
