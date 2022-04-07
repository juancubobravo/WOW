package uma.wow.proyecto;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;

@Entity
public class Autorizacion implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@ManyToOne
	@JoinColumn
	private Empresa id;
	
	@Id
	@ManyToOne
	@JoinColumn
	private PersonaAutorizada idAutorizada;
	
	@Column(nullable = false)
	private String tipo;
	
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public Autorizacion() {
		
	}
	
	
	public Empresa getId() {
		return id;
	}
	public void setId(Empresa id) {
		this.id = id;
	}
	public PersonaAutorizada getIdAutorizada() {
		return idAutorizada;
	}
	public void setIdAutorizada(PersonaAutorizada id_autorizada) {
		this.idAutorizada = id_autorizada;
	}
	public Autorizacion(String tipo, Empresa id, PersonaAutorizada id1) {
		super();
		this.tipo = tipo;
		this.id = id;
		this.idAutorizada = id1;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(id, idAutorizada);
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
		return Objects.equals(id, other.id) && Objects.equals(idAutorizada, other.idAutorizada);
	}
	
	
	@Override
	public String toString() {
		return "Autorizacion [tipo=" + tipo + ", id=" + id + ", id1=" + idAutorizada + "]";
	}
	
	
	
}