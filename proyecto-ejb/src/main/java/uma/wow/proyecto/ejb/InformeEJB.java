package uma.wow.proyecto.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class InformeEJB implements GestionInforme{
	
	@PersistenceContext(unitName="WOWEJB")
	private EntityManager em;
	
	
}
