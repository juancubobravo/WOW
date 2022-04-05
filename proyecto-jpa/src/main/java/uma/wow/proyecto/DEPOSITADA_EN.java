package uma.wow.proyecto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

@Entity
public class DEPOSITADA_EN implements Serializable{
	private float Saldo;
	private String IBAN;
	private String IBAN1;
	
	@ManyToOne
	private Cuenta_Referencia id1;
	
	@ManyToOne
	private Pooled_Account id2;
	
	public DEPOSITADA_EN(float saldo, String iBAN, String iBAN1) {
		super();
		Saldo = saldo;
		IBAN = iBAN;
		IBAN1 = iBAN1;
	}
	
	public float getSaldo() {
		return Saldo;
	}
	public void setSaldo(float saldo) {
		Saldo = saldo;
	}
	public String getIBAN() {
		return IBAN;
	}
	public void setIBAN(String iBAN) {
		IBAN = iBAN;
	}
	public String getIBAN1() {
		return IBAN1;
	}
	public void setIBAN1(String iBAN1) {
		IBAN1 = iBAN1;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(IBAN, IBAN1);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DEPOSITADA_EN other = (DEPOSITADA_EN) obj;
		return Objects.equals(IBAN, other.IBAN) && Objects.equals(IBAN1, other.IBAN1);
	}
	
	@Override
	public String toString() {
		return "DEPOSITADA_EN [Saldo=" + Saldo + ", IBAN=" + IBAN + ", IBAN1=" + IBAN1 + "]";
	}
	
}
