package uma.wow.proyecto;

import java.io.Serializable;
import javax.persistence.*;


@Embeddable
public class DepositaEnPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name="POOLED_ACCOUNT_IBAN", insertable=false, updatable=false)
	private String pooledAccountIban;

	@Column(name="CUENTA_REFERENCIA_IBAN", insertable=false, updatable=false)
	private String cuentaReferenciaIban;

	public DepositaEnPK() {
	}
	public String getPooledAccountIban() {
		return this.pooledAccountIban;
	}
	public void setPooledAccountIban(String pooledAccountIban) {
		this.pooledAccountIban = pooledAccountIban;
	}
	public String getCuentaReferenciaIban() {
		return this.cuentaReferenciaIban;
	}
	public void setCuentaReferenciaIban(String cuentaReferenciaIban) {
		this.cuentaReferenciaIban = cuentaReferenciaIban;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DepositaEnPK)) {
			return false;
		}
		DepositaEnPK castOther = (DepositaEnPK)other;
		return 
			this.pooledAccountIban.equals(castOther.pooledAccountIban)
			&& this.cuentaReferenciaIban.equals(castOther.cuentaReferenciaIban);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.pooledAccountIban.hashCode();
		hash = hash * prime + this.cuentaReferenciaIban.hashCode();
		
		return hash;
	}
}
