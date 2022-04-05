package uma.wow.proyecto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

@Entity
public class Cliente implements Serializable{
	@Id @GeneratedValue (strategy = GenerationType.AUTO)
	private String ID;
	@Column (unique=true)
	private String Identificacion;
	private String tipo_cliente;
	private String estado;
	@Temporal (TemporalType.DATE)
	private java.util.Date Fecha_Alta;
	@Column (nullable=true)
	@Temporal(TemporalType.DATE)
	private java.util.Date Fecha_Baja;
	private String Direccion;
	private String Ciudad;
	private String CodigoPostal;
	private String Pais;
	
	@OneToMany (fetch = FetchType.LAZY, orphanRemoval=true,cascade = CascadeType.PERSIST)
	private List<Cuenta_Fintech> cuentas;
	
	
	
	
	public Cliente(String iD, String identificacion, String tipo_cliente, String estado, Date fecha_Alta,
			String direccion, String ciudad, String codigoPostal, String pais) {
		super();
		ID = iD;
		Identificacion = identificacion;
		this.tipo_cliente = tipo_cliente;
		this.estado = estado;
		Fecha_Alta = fecha_Alta;
		Fecha_Baja = null;
		Direccion = direccion;
		Ciudad = ciudad;
		CodigoPostal = codigoPostal;
		Pais = pais;
	}

	public Cliente() {
		// TODO Auto-generated constructor stub
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

	public String getTipo_cliente() {
		return tipo_cliente;
	}

	public void setTipo_cliente(String tipo_cliente) {
		this.tipo_cliente = tipo_cliente;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public java.util.Date getFecha_Alta() {
		return Fecha_Alta;
	}

	public void setFecha_Alta(java.util.Date fecha_Alta) {
		Fecha_Alta = fecha_Alta;
	}

	public java.util.Date getFecha_Baja() {
		return Fecha_Baja;
	}

	public void setFecha_Baja(java.util.Date fecha_Baja) {
		Fecha_Baja = fecha_Baja;
	}

	public String getDireccion() {
		return Direccion;
	}

	public void setDireccion(String direccion) {
		Direccion = direccion;
	}

	public String getCiudad() {
		return Ciudad;
	}

	public void setCiudad(String ciudad) {
		Ciudad = ciudad;
	}

	public String getCodigoPostal() {
		return CodigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		CodigoPostal = codigoPostal;
	}

	public String getPais() {
		return Pais;
	}

	public void setPais(String pais) {
		Pais = pais;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Identificacion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(Identificacion, other.Identificacion);
	}

	@Override
	public String toString() {
		return "Cliente [ID=" + ID + ", Identificacion=" + Identificacion + ", tipo_cliente=" + tipo_cliente
				+ ", estado=" + estado + ", Fecha_Alta=" + Fecha_Alta + ", Fecha_Baja=" + Fecha_Baja + ", Direccion="
				+ Direccion + ", Ciudad=" + Ciudad + ", CodigoPostal=" + CodigoPostal + ", Pais=" + Pais + "]";
	}
	
}