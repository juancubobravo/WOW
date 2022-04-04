package uma.wow.proyecto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cuenta implements Serializable{
	

	@Id 
	private String IBAN;
	@Column (unique = true)
	private String SWIFT;
	
	
	public Cuenta(String iBAN) {
		super();
		IBAN = iBAN;
		SWIFT = null;
	}

	public String getIBAN() {
		return IBAN;
	}
	public void setIBAN(String iBAN) {
		IBAN = iBAN;
	}
	public String getSWIFT() {
		return SWIFT;
	}
	public void setSWIFT(String sWIFT) {
		SWIFT = sWIFT;
	}
	
	@Override
	public int hashCode() {
		return IBAN.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cuenta other = (Cuenta) obj;
		if (IBAN == null) {
			if (other.IBAN != null)
				return false;
		} else if (!IBAN.equals(other.IBAN))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cuenta [IBAN=" + IBAN + ", SWIFT=" + SWIFT + "]";
	}
	
	
	
}
