package uma.wow.proyecto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


import javax.persistence.*;

@Entity
public class Individual extends Cliente implements Serializable  {
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String apellido;
	@Column (nullable=true)
	@Temporal(TemporalType.DATE)
	private java.util.Date fechaNacimiento;
	
	
	public Individual(String id, String identificacion, String tipoCliente, String estado, Date fechaAlta,
			String direccion, String ciudad, String codigoPostal, String pais, List<CuentaFintech> cuentas, String nombre, String apellido, Date fechaNacimiento) {
		super(id, identificacion, tipoCliente, estado, fechaAlta, direccion, ciudad, codigoPostal, pais, cuentas);
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
	}
	
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
	public java.util.Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFecha_nacimiento(java.util.Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
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
