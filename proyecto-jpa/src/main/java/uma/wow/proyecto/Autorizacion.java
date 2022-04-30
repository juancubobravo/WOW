package uma.wow.proyecto;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;

@Entity
public class Autorizacion implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private AutorizacionPK id;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	@MapsId("empresaId")
	private Empresa empresa;
	
	@ManyToOne
	@JoinColumn( nullable = false)
	@MapsId("personaAutorizadaId")
	private PersonaAutorizada idAutorizada;
	
	@Column(nullable = false)
	private String tipo;
	
	public Autorizacion() {
		
	}
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa id) {
		this.empresa = id;
	}
	public PersonaAutorizada getIdAutorizada() {
		return idAutorizada;
	}
	public void setIdAutorizada(PersonaAutorizada id_autorizada) {
		this.idAutorizada = id_autorizada;
	}
	
	public AutorizacionPK getId() {
		return id;
	}

	public void setId(AutorizacionPK id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Autorizacion [tipo=" + tipo + "]";
	}
	
	

	
	
	
}