package uma.wow.proyecto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

@Entity
public class Autorizacion implements Serializable{
	private String tipo;
	@Id 
	private String id;
	@Id
	private String id1;
	
<<<<<<< HEAD
=======
	@ManyToOne
	private Empresa id1;
	
	@ManyToOne
	private PersonaAutorizada id2;
	
	public Autorizacion(String tipo, String iD, String iD1) {
		super();
		this.tipo = tipo;
		ID = iD;
		ID1 = iD1;
	}
>>>>>>> ca8b39432d27cee3a9b6f277d149be5477b06dde
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getId1() {
		return id1;
	}
	public void setId1(String id1) {
		this.id1 = id1;
	}
	
	
	public Autorizacion(String tipo, String id, String id1) {
		super();
		this.tipo = tipo;
		this.id = id;
		this.id1 = id1;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(id, id1);
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
		return Objects.equals(id, other.id) && Objects.equals(id1, other.id1);
	}
	
	
	@Override
	public String toString() {
		return "Autorizacion [tipo=" + tipo + ", id=" + id + ", id1=" + id1 + "]";
	}
	
	
	
}