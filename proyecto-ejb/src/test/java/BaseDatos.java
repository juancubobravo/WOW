
//package es.uma.informatica.sii.ejb.practica;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import uma.wow.proyecto.*;


public class BaseDatos {
	public static void inicializaBaseDatos(String nombreUnidadPersistencia) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(nombreUnidadPersistencia);
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Usuario usuario = new Usuario ();
		usuario.setNombreUsuario("Carlos");
		usuario.setPassword("1234");
		usuario.setTipo("NORMAL");
		
		em.persist(usuario);
		
		Usuario administrador = new Usuario();
		administrador.setNombreUsuario("Alvaro");
		administrador.setPassword("perro");
		administrador.setTipo("ADMIN");
		
		em.persist(administrador);
		
		Individual individual = new Individual();
		individual.setIdentificacion("654987");
		individual.setTipoCliente("FISICA");
		individual.setEstado("ACTIVO");
		individual.setFechaAlta(Date.valueOf("2021-03-14"));
		individual.setFechaBaja(null);
		individual.setDireccion("Avenida Correcaminos");
		individual.setCiudad("Malaga");
		individual.setCodigoPostal("29001");
		individual.setPais("España");
		individual.setNombre("Jammal");
		individual.setApellido("Hasbullah");
		individual.setFecha_nacimiento(null);
		
		em.persist(individual);
				
		Empresa empresa = new Empresa();
		empresa.setIdentificacion("98756");
		empresa.setTipoCliente("JURIDICO");
		empresa.setEstado("ACTIVO");
		empresa.setFechaAlta(Date.valueOf("2021-07-16"));
		empresa.setFechaBaja(null);
		empresa.setDireccion("Calle España");
		empresa.setCiudad("Malaga");
		empresa.setCodigoPostal("29009");
		empresa.setPais("España");
		empresa.setRazon_Social("Ayudas");

		em.persist(empresa);

		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
}
