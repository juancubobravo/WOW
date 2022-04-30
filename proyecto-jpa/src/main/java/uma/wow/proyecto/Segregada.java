package uma.wow.proyecto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue(value="Segregada")
public class Segregada extends CuentaFintech implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Column (nullable = true)
	private String comision;
	
	@OneToOne
	private CuentaReferencia cuentaReferencia;
	

	public String getComision() {
		return comision;
	}


	public void setComision(String comision) {
		this.comision = comision;
	}



	public CuentaReferencia getCuentaReferencia() {
		return cuentaReferencia;
	}


	public void setCuentaReferencia(CuentaReferencia cuentaReferencia) {
		this.cuentaReferencia = cuentaReferencia;
	}


	@Override
	public String toString() {
		return "Segregada [comision=" + comision + "]";
	}


	
	public Segregada() {
		
	}
	
	
}
