package uma.wow.proyecto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value="Pooled")

public class PooledAccount extends CuentaFintech implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy="pooledAccount")
	private List<DepositadaEn> depositaEn;

	
	public PooledAccount() {
		
	}

	public List<DepositadaEn> getDepositaEn() {
		return depositaEn;
	}

	public void setDepositaEn(List<DepositadaEn> depositaEn) {
		this.depositaEn = depositaEn;
	}

	
	@Override
	public String toString() {
		return "PooledAccount []";
	}
	
}