package uma.wow.proyecto;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;

@Entity
public class Divisa implements Serializable {

	@Id
	@GeneratedValue
	private String abreviatura;
	private String nombre;
	@Column (nullable = true)
	private String simbolo;
	private double cambioEuro;

	public Divisa() {
		super();
	}

	@Override
	public String toString() {
		return "Divisa [abreviatura=" + abreviatura + ", nombre=" + nombre + ", simbolo=" + simbolo + ", cambioEuro="
				+ cambioEuro + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(abreviatura);
	}

	public Divisa(String abreviatura, String nombre, double cambioEuro) {
		super();
		this.abreviatura = abreviatura;
		this.nombre = nombre;
		this.cambioEuro = cambioEuro;
		this.simbolo = null;

	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Divisa other = (Divisa) obj;
		if (abreviatura == null) {
			if (other.abreviatura != null)
				return false;
		} else if (!abreviatura.equals(other.abreviatura))
			return false;
		return true;
	}

	public String getAbreviatura() {
		return abreviatura;
	}

	public String getNombre() {
		return nombre;
	}

	public String getSimbolo() {
		return simbolo;
	}

	public double getCambioEuro() {
		return cambioEuro;
	}

	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}

	public void setCambioEuro(double cambioEuro) {
		this.cambioEuro = cambioEuro;
	}

	

}