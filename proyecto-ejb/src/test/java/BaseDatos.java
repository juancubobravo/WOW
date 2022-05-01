
//package es.uma.informatica.sii.ejb.practica;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
		
		
		Usuario administrador = new Usuario();
		administrador.setNombreUsuario("Alvaro");
		administrador.setPassword("perro");
		administrador.setTipo("ADMIN");
		
		em.persist(administrador);
		
		Usuario usuario = new Usuario ();
		usuario.setNombreUsuario("Carlos");
		usuario.setPassword("1234");
		usuario.setTipo("NORMAL");
	
		Individual individual = new Individual();
		individual.setId("654987");
		individual.setIdentificacion("8933533");
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
		individual.setUsuario(usuario);
		List<CuentaFintech> lista = new ArrayList<CuentaFintech>();
		individual.setCuentas(lista);
		
		usuario.setCliente(individual);
		
		em.persist(usuario);
		em.persist(individual);
				
		Empresa empresa = new Empresa();
		empresa.setId("98756");
		empresa.setIdentificacion("45575233");
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
		
		empresaParaUsuario.setUsuario(usuarioEmpresa);
		usuarioEmpresa.setCliente(empresaParaUsuario);
		
		em.persist(usuarioEmpresa);
		em.persist(empresaParaUsuario);
		
		
		/*
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
		individualParaUsuario.setNombre("Paco");
		individualParaUsuario.setApellido("Uwu");
		individualParaUsuario.setFecha_nacimiento(null);
		
		usuario.setCliente(individualParaUsuario);
		individualParaUsuario.setUsuario(usuario);
		
		//em.persist(usuarioIndividual); // Clave primaria duplicada
		em.persist(individualParaUsuario);
		*/
		
		
		CuentaReferencia cuentaLlena = new CuentaReferencia();
		cuentaLlena.setNombreBanco("Unicaja");
		cuentaLlena.setIban("9999");
		cuentaLlena.setSwift("4812");
		cuentaLlena.setSaldo(1000000);
		
		CuentaReferencia cuentaVacia = new CuentaReferencia();
		cuentaVacia.setNombreBanco("Unicaja");
		cuentaVacia.setIban("538888");
		cuentaVacia.setSwift("482");
		cuentaVacia.setSaldo(0);
		
		em.persist(cuentaVacia);
		
		
		em.persist(cuentaLlena);
		
		PooledAccount pooled = new PooledAccount();
		pooled.setIban("1453134534528");
		pooled.setSwift("4512");
		pooled.setClasificacion("POOLED");
		pooled.setCliente(individual);
		pooled.setDepositaEn(null);
		pooled.setEstado("ABIERTA");
		pooled.setFechaApertura(Date.valueOf("2020-09-12"));
		pooled.setFechaCierre(null);
		
		DepositadaEn dep = new DepositadaEn();
		dep.setId2(pooled);
		dep.setId1(cuentaLlena);
		dep.setSaldo(cuentaLlena.getSaldo());
		
		List<DepositadaEn> listaa = new ArrayList<DepositadaEn>();
		listaa.add(dep);
		pooled.setDepositaEn(listaa);
		
		em.persist(dep);
		em.persist(pooled);
		
		Segregada segregada = new Segregada();
		segregada.setIban("1888134538888");
		segregada.setSwift("4582");
		segregada.setClasificacion("SEGREGADA");
		segregada.setCliente(individual);
		segregada.setEstado("ABIERTA");
		segregada.setFechaApertura(Date.valueOf("2020-05-27"));
		segregada.setFechaCierre(null);
		segregada.setCuentaReferencia(cuentaLlena);
		
		em.persist(segregada);
		
		Usuario usuarioPerAut = new Usuario ();
		usuarioPerAut.setNombreUsuario("JoseManuel");
		usuarioPerAut.setPassword("1234");
		usuarioPerAut.setTipo("NORMAL");
		
		PersonaAutorizada personaAutorizadaBaja = new PersonaAutorizada();
		personaAutorizadaBaja.setId("511155");
		personaAutorizadaBaja.setIdentificacion("0771");
		personaAutorizadaBaja.setNombre("Pepe");
		personaAutorizadaBaja.setApellidos("Pelaez");
		personaAutorizadaBaja.setFechaNacimiento(null);
		personaAutorizadaBaja.setEstado("ACTIVO");
		personaAutorizadaBaja.setDireccion("Avda S");		
		personaAutorizadaBaja.setFechaInicio(null);
		personaAutorizadaBaja.setFechaFin(null);
		personaAutorizadaBaja.setAutori(null);		
		personaAutorizadaBaja.setUsuario(usuarioPerAut);
		usuarioPerAut.setPersonaAutorizada(personaAutorizadaBaja);
		
		em.persist(usuarioPerAut);
		em.persist(personaAutorizadaBaja);
		
		
		
		
		

		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
}
