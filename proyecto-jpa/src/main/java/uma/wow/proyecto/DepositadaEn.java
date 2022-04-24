package uma.wow.proyecto;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;

@Entity
public class DepositadaEn implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Column(nullable = false)
	private float saldo;
	
	@MapsId
	@EmbeddedId
	private DepositaEnPK id;
	

	@ManyToOne
	@JoinColumn(name="CUENTA_REFERENCIA_IBAN", nullable = false)
	@MapsId("cuentaReferenciaIban")
	private CuentaReferencia id1;
	
	@ManyToOne
	@JoinColumn(name="POOLED_ACCOUNT_IBAN", nullable = false)
	@MapsId("pooledAccountIban")
	private PooledAccount id2;
	
	public DepositadaEn(float saldo) {
		super();
		this.saldo = saldo;
	}
	
	public DepositadaEn() {
		
	}
	
	public DepositaEnPK getId() {
		return id;
	}

	public void setId(DepositaEnPK id) {
		this.id = id;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
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
		return "DepositadaEn [saldo=" + saldo + ", id1=" + id1 + ", id2=" + id2 + "]";
	}


	
	
	
}
