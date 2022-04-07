package uma.wow.proyecto;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class PooledAccount extends CuentaFintech implements Serializable {
	private static final long serialVersionUID = 1L;
	@OneToOne
	private String iban1;


	public PooledAccount(String iban) {
		super(iban);
	}
	
	public PooledAccount() {
		
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	@Override
	public String toString() {
		return "PooledAccount [iban1=" + iban1 + "]";
	}
	
}