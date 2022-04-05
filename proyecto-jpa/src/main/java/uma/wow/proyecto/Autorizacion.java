package uma.wow.proyecto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

@Entity
public class Autorizacion implements Serializable{
	private String tipo;
	private String ID;
	private String ID1;
	
	@ManyToOne
	private EMPRESA id1;
	
	@ManyToOne
	private Persona_autorizada id2;
	
	public Autorizacion(String tipo, String iD, String iD1) {
		super();
		this.tipo = tipo;
		ID = iD;
		ID1 = iD1;
	}
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getID1() {
		return ID1;
	}
	public void setID1(String iD1) {
		ID1 = iD1;
	}
	
	@Override
	public String toString() {
		return "Autorizacion [tipo=" + tipo + ", ID=" + ID + ", ID1=" + ID1 + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(ID, ID1);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Autorizacion other = (Autorizacion) obj;
		return Objects.equals(ID, other.ID) && Objects.equals(ID1, other.ID1);
	}
	
}