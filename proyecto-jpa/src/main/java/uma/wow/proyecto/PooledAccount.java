package uma.wow.proyecto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class PooledAccount extends CuentaFintech {

	
<<<<<<< HEAD
	@OneToOne
	private String iban1;
=======
>>>>>>> ca8b39432d27cee3a9b6f277d149be5477b06dde


	public PooledAccount(String iban) {
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

	@Override
	public String toString() {
		return "PooledAccount [iban1=" + iban1 + "]";
	}
	
}