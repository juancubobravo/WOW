package uma.wow.proyecto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


import javax.persistence.*;

@Entity
@DiscriminatorValue(value="Empresa")
public class Empresa extends Cliente implements Serializable{
	private static final long serialVersionUID = 1L;
	@Column(nullable = false)
	private String razonSocial;
	
	@OneToMany(mappedBy="empresa")
	private List<Autorizacion> autori;
	
	
	public Empresa() {
		super();
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
