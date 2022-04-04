package uma.wow.proyecto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Cuenta_Referencia extends Cuenta {

	private String NombreBanco;
	@Column (nullable = true)
	private String Sucursal;
	@Column (nullable = true)
	private String Pais;
	private double Saldo;
	@Column (nullable = true)
	private Date fecha_apertura;
	@Column (nullable = true)
	private String Estado;
	
	@ManyToOne
	private Divisa abreviatura;
	
	public Cuenta_Referencia(String iBAN,String nombreBanco, double saldo) {
		super(iBAN);
		NombreBanco = nombreBanco;
		Saldo = saldo;
		Sucursal = null;
		Pais = null;
		fecha_apertura = null;
		Estado = null;
		
	}

	public String getNombreBanco() {
		return NombreBanco;
	}

	public void setNombreBanco(String nombreBanco) {
		NombreBanco = nombreBanco;
	}

	public String getSucursal() {
		return Sucursal;
	}

	public void setSucursal(String sucursal) {
		Sucursal = sucursal;
	}

	public String getPais() {
		return Pais;
	}

	public void setPais(String pais) {
		Pais = pais;
	}

	public double getSaldo() {
		return Saldo;
	}

	public void setSaldo(double saldo) {
		Saldo = saldo;
	}

	public Date getFecha_apertura() {
		return fecha_apertura;
	}

	public void setFecha_apertura(Date fecha_apertura) {
		this.fecha_apertura = fecha_apertura;
	}

	public String getEstado() {
		return Estado;
	}

	public void setEstado(String estado) {
		Estado = estado;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cuenta_Referencia other = (Cuenta_Referencia) obj;
		if (NombreBanco == null) {
			if (other.NombreBanco != null)
				return false;
		} else if (!NombreBanco.equals(other.NombreBanco))
			return false;
		if (Double.doubleToLongBits(Saldo) != Double.doubleToLongBits(other.Saldo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return super.toString()+" Cuenta_Referencia [NombreBanco=" + NombreBanco + ", Sucursal=" + Sucursal + ", Pais=" + Pais
				+ ", Saldo=" + Saldo + ", fecha_apertura=" + fecha_apertura + ", Estado=" + Estado + "]";
	}
	
	
	
	

}
