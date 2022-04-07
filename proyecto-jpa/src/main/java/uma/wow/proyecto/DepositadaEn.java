package uma.wow.proyecto;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;

@Entity
public class DepositadaEn implements Serializable{
	private static final long serialVersionUID = 1L;
	private float saldo;
	private String iban;
	private String iban1;
	
	@ManyToOne
	private CuentaReferencia id1;
	
	@ManyToOne
	private PooledAccount id2;
	
	public DepositadaEn(float saldo, String iban, String iban1) {
		super();
		this.saldo = saldo;
		this.iban = iban;
		this.iban1 = iban1;
	}
	
	public DepositadaEn() {
		
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public String getIban1() {
		return iban1;
	}

	public void setIban1(String iban1) {
		this.iban1 = iban1;
	}

	public CuentaReferencia getId1() {
		return id1;
	}

	public void setId1(CuentaReferencia id1) {
		this.id1 = id1;
	}

	public PooledAccount getId2() {
		return id2;
	}

	public void setId2(PooledAccount id2) {
		this.id2 = id2;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id1, id2);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DepositadaEn other = (DepositadaEn) obj;
		return Objects.equals(id1, other.id1) && Objects.equals(id2, other.id2);
	}

	@Override
	public String toString() {
		return "DepositadaEn [saldo=" + saldo + ", iban=" + iban + ", iban1=" + iban1 + ", id1=" + id1 + ", id2=" + id2
				+ "]";
	}
	
	
	
}
