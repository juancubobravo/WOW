package uma.wow.proyecto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

@Entity

public class Cliente implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue (strategy = GenerationType.AUTO)
	private String id;
	@Column (unique=true)
	private String identificacion;
	private String tipoCliente;
	private String estado;
	@Temporal (TemporalType.DATE)
	private java.util.Date fechaAlta;
	@Column (nullable=true)
	@Temporal(TemporalType.DATE)
	private java.util.Date fechaBaja;
	private String direccion;
	private String ciudad;
	private String codigoPostal;
	private String pais;
	
	@OneToMany (fetch = FetchType.LAZY, orphanRemoval=true,cascade = CascadeType.PERSIST)
	private List<CuentaFintech> cuentas;

	public Cliente(String id, String identificacion, String tipoCliente, String estado, Date fechaAlta,
			String direccion, String ciudad, String codigoPostal, String pais, List<CuentaFintech> cuentas) {
		super();
		this.id = id;
		this.identificacion = identificacion;
		this.tipoCliente = tipoCliente;
		this.estado = estado;
		this.fechaAlta = fechaAlta;
		this.fechaBaja = null;
		this.direccion = direccion;
		this.ciudad = ciudad;
		this.codigoPostal = codigoPostal;
		this.pais = pais;
		this.cuentas = cuentas;
	}
	
	public Cliente() {
		
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

	public String getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public java.util.Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(java.util.Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public java.util.Date getFechaBaja() {
		return fechaBaja;
	}

	public void setFechaBaja(java.util.Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public List<CuentaFintech> getCuentas() {
		return cuentas;
	}

	public void setCuentas(List<CuentaFintech> cuentas) {
		this.cuentas = cuentas;
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
		Cliente other = (Cliente) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", identificacion=" + identificacion + ", tipoCliente=" + tipoCliente + ", estado="
				+ estado + ", fechaAlta=" + fechaAlta + ", fechaBaja=" + fechaBaja + ", direccion=" + direccion
				+ ", ciudad=" + ciudad + ", codigoPostal=" + codigoPostal + ", pais=" + pais + ", cuentas=" + cuentas
				+ "]";
	}
	
	
}