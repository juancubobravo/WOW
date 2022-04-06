package uma.wow.proyecto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

@Entity
public class Empresa extends Cliente implements Serializable{
	private String razonSocial;

	@OneToOne
	private Cliente id1;
	
	public Empresa(String id, String identificacion, String tipoCliente, String estado, Date fechaAlta,
			String direccion, String ciudad, String codigoPostal, String pais, List<CuentaFintech> cuentas, String razonSocial) {
		super(id, identificacion, tipoCliente, estado, fechaAlta, direccion, ciudad, codigoPostal, pais, cuentas);
		this.razonSocial = razonSocial;
	}

	public String getRazon_Social() {
		return razonSocial;
	}

	public void setRazon_Social(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	@Override
	public String toString() {
		return "Empresa [razonSocial=" + razonSocial + "]";
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
