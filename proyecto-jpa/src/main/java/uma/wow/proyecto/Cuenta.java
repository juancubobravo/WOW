package uma.wow.proyecto;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cuenta implements Serializable{
	

	@Id 
	private String iban;
	@Column (unique = true)
	private String swift;
	
	
	public Cuenta(String iban) {
		super();
		this.iban = iban;
		swift = null;
	}


	public String getIban() {
		return iban;
	}


	public void setIban(String iban) {
		this.iban = iban;
	}


	public String getSwift() {
		return swift;
	}


	public void setSwift(String swift) {
		this.swift = swift;
	}


	@Override
	public int hashCode() {
		return Objects.hash(iban);
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
		return Objects.equals(iban, other.iban);
	}


	@Override
	public String toString() {
		return "Cuenta [iban=" + iban + ", swift=" + swift + "]";
	}
	
	
}
