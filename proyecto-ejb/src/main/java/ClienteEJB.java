import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import exceptions.ClienteNoEncontrado;
import exceptions.UsuarioException;
import uma.wow.proyecto.Empresa;
import uma.wow.proyecto.Individual;

public class ClienteEJB implements GestionCliente{

    @PersistenceContext(name="WOWEJB")
    private EntityManager em;
	
	@Override
	public void altaCliente(Empresa cliente) throws UsuarioException{
		
		Empresa e = em.find(Empresa.class, cliente.getId());
		
		if(e!=null) {
			throw new UsuarioException();
		}
		
		em.persist(cliente);
		
	}

	@Override
	public void altaCliente(Individual cliente) throws UsuarioException {
		
		Individual e = em.find(Individual.class, cliente.getId());
		
		if(e!=null) {
			throw new UsuarioException();
		}
		
		em.persist(cliente);
		
	}

	@Override
	public void modificarCliente(Empresa cliente) throws ClienteNoEncontrado {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarCliente(Individual cliente) throws ClienteNoEncontrado {
		// TODO Auto-generated method stub
		
	}

}
