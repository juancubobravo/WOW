package uma.wow.proyecto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Segregada extends Cuenta_Fintech {

	@Column (nullable = true)
	private String comision;
	
	@OneToOne
	private Cuenta_Referencia IBAN;
	

	public String getComision() {
		return comision;
	}


	public void setComision(String comision) {
		this.comision = comision;
	}


	public Segregada(String iBAN) {
		super(iBAN);
		// TODO Auto-generated constructor stub
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
		Segregada other = (Segregada) obj;
		if (comision == null) {
			if (other.comision != null)
				return false;
		} else if (!comision.equals(other.comision))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return super.toString()+ "Segregada [comision=" + comision + "]";
	}
	
	

}
