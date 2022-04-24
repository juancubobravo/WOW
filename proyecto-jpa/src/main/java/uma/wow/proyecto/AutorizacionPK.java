package uma.wow.proyecto;

import java.io.Serializable;
import javax.persistence.*;


@Embeddable
public class AutorizacionPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name="EMPRESA_ID", insertable=false, updatable=false)
	private String empresaId;

	@Column(name="PERSONA_AUTORIZADA_ID", insertable=false, updatable=false)
	private String personaAutorizadaId;

	public AutorizacionPK() {
	}
	public String getEmpresaId() {
		return this.empresaId;
	}
	public void setEmpresaId(String empresaId) {
		this.empresaId = empresaId;
	}
	public String getPersonaAutorizadaId() {
		return this.personaAutorizadaId;
	}
	public void setPersonaAutorizadaId(String personaAutorizadaId) {
		this.personaAutorizadaId = personaAutorizadaId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AutorizacionPK)) {
			return false;
		}
		AutorizacionPK castOther = (AutorizacionPK)other;
		return 
			this.empresaId.equals(castOther.empresaId)
			&& this.personaAutorizadaId.equals(castOther.personaAutorizadaId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.empresaId.hashCode();
		hash = hash * prime + this.personaAutorizadaId.hashCode();
		
		return hash;
	}
}
