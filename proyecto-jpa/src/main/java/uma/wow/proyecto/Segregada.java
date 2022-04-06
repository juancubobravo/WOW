package uma.wow.proyecto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Segregada extends CuentaFintech {

	@Column (nullable = true)
	private String comision;
	
	@OneToOne
	private CuentaReferencia iban;
	

	public String getComision() {
		return comision;
	}


	public void setComision(String comision) {
		this.comision = comision;
	}


	public Segregada(String iban) {
		super(iban);
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
