package uma.wow.proyecto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

@Entity
public class EMPRESA extends Cliente implements Serializable{
	private String Razon_Social;

	@OneToOne
	private Cliente id1;
	
	public EMPRESA(String razon_Social) {
		super();
		Razon_Social = razon_Social;
	}

	public String getRazon_Social() {
		return Razon_Social;
	}

	public void setRazon_Social(String razon_Social) {
		Razon_Social = razon_Social;
	}

	@Override
	public String toString() {
		return "EMPRESA [Razon_Social=" + Razon_Social + "]";
	}
	
	
}
