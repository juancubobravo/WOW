
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
		
		Usuario usuarioEmpresa = new Usuario ();
		usuarioEmpresa.setNombreUsuario("Carniceria Paco");
		usuarioEmpresa.setPassword("vivalacomida");
		usuarioEmpresa.setTipo("NORMAL");
		
		Empresa empresaParaUsuario = new Empresa();
		empresaParaUsuario.setIdentificacion("789544");
		empresaParaUsuario.setTipoCliente("JURIDICO");
		empresaParaUsuario.setEstado("ACTIVO");
		empresaParaUsuario.setFechaAlta(Date.valueOf("2021-07-16"));
		empresaParaUsuario.setFechaBaja(null);
		empresaParaUsuario.setDireccion("Calle Pamplona");
		empresaParaUsuario.setCiudad("Madrid");
		empresaParaUsuario.setCodigoPostal("27009");
		empresaParaUsuario.setPais("España");
		empresaParaUsuario.setRazon_Social("Comida");
		
		usuarioEmpresa.setCliente(empresaParaUsuario);
		
		em.persist(usuarioEmpresa);
		
		Usuario usuarioIndividual = new Usuario ();
		usuarioIndividual.setNombreUsuario("Carlos");
		usuarioIndividual.setPassword("1234");
		usuarioIndividual.setTipo("NORMAL");
		
		Individual individualParaUsuario = new Individual();
		individualParaUsuario.setIdentificacion("654987");
		individualParaUsuario.setTipoCliente("FISICA");
		individualParaUsuario.setEstado("ACTIVO");
		individualParaUsuario.setFechaAlta(Date.valueOf("2021-03-14"));
		individualParaUsuario.setFechaBaja(null);
		individualParaUsuario.setDireccion("Avenida Correcaminos");
		individualParaUsuario.setCiudad("Malaga");
		individualParaUsuario.setCodigoPostal("29001");
		individualParaUsuario.setPais("España");
		individualParaUsuario.setNombre("Jammal");
		individualParaUsuario.setApellido("Hasbullah");
		individualParaUsuario.setFecha_nacimiento(null);
		
		usuarioIndividual.setCliente(individualParaUsuario);
		
		em.persist(usuarioIndividual);
		
		PooledAccount pooled = new PooledAccount();
		pooled.setIban("1453134534528");
		pooled.setSwift("4512");
		pooled.setClasificacion("POOLED");
		pooled.setCliente(individual);
		pooled.setDepositaEn(null);
		pooled.setEstado("ABIERTA");
		pooled.setFechaApertura(Date.valueOf("2020-09-12"));
		pooled.setFechaCierre(null);
		
		em.persist(pooled);
		
		Segregada segregada = new Segregada();
		segregada.setIban("1888134538888");
		segregada.setSwift("4582");
		segregada.setClasificacion("SEGREGADA");
		segregada.setCliente(individual);
		segregada.setEstado("ABIERTA");
		segregada.setFechaApertura(Date.valueOf("2020-05-27"));
		segregada.setFechaCierre(null);
		
		em.persist(segregada);
		
		CuentaReferencia cuentaVacia = new CuentaReferencia();
		cuentaVacia.setIban("538888");
		cuentaVacia.setSwift("482");
		cuentaVacia.setSaldo(0);
		
		em.persist(cuentaVacia);
		
		CuentaReferencia cuentaLlena = new CuentaReferencia();
		cuentaVacia.setIban("9999");
		cuentaVacia.setSwift("4812");
		cuentaVacia.setSaldo(1000000);
		
		em.persist(cuentaLlena);
		
		PersonaAutorizada personaAutorizadaBaja = new PersonaAutorizada();
		personaAutorizadaBaja.setApellidos("Pelaez");
		personaAutorizadaBaja.setAutori(null);
		personaAutorizadaBaja.setDireccion("Avda S");
		personaAutorizadaBaja.setEstado(null);
		personaAutorizadaBaja.setFechaInicio(Date.valueOf("2020-03-24"));
		personaAutorizadaBaja.setFechaFin(null);
		personaAutorizadaBaja.setId("511155");
		personaAutorizadaBaja.setIdentificacion("0771");
		personaAutorizadaBaja.setNombre(usuario.getNombreUsuario());
		personaAutorizadaBaja.setUsuario(usuario);
		
		em.persist(personaAutorizadaBaja);

		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
}
