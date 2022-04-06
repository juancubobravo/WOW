package uma.wow.proyecto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class PooledAccount extends CuentaFintech {

	


	public PooledAccount(String iBAN) {
		super(iBAN);
		// TODO Auto-generated constructor stub
	}






	@Override
	public int hashCode() {
		return super.hashCode();
	}



}