package uma.wow.proyecto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Pooled_Account extends Cuenta_Fintech {

	
	@OneToOne
	private Cuenta_Referencia IBAN;
	


	public Pooled_Account(String iBAN) {
		super(iBAN);
		// TODO Auto-generated constructor stub
	}






	@Override
	public int hashCode() {
		return super.hashCode();
	}



}