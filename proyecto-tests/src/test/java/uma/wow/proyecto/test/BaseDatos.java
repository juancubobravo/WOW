package uma.wow.proyecto.test;

//package es.uma.informatica.sii.ejb.practica;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import uma.wow.proyecto.*;


public class BaseDatos {
	public static void inicializaBaseDatos(String nombreUnidadPersistencia, Map<String, String> properties) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(nombreUnidadPersistencia, properties);
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Usuario juan = new Usuario();
		juan.setNombreUsuario("juan");
		juan.setPassword("juan");
		juan.setTipo("NORMAL");
		
		Usuario ponciano = new Usuario();
		ponciano.setNombreUsuario("ponciano");
		ponciano.setPassword("ponciano");
		ponciano.setTipo("ADMIN");
		em.persist(ponciano);
		
		em.persist(juan);
		/*
		Empresa empresa = new Empresa();
		empresa.setId("P3310693A");
		empresa.setRazon_Social("Andamios Antonio");
		empresa.setTipoCliente("JURIDICO");
		empresa.setEstado("ACTIVO");
		empresa.setFechaAlta(Date.valueOf("2021-07-16"));
		empresa.setDireccion("Alameda de Colón");
		empresa.setCiudad("Malaga");
		empresa.setCodigoPostal("25300");
		empresa.setPais("España");
		
		Individual individual = new Individual();
		individual.setId("63937528N");
		individual.setNombre("Paco");
		individual.setApellido("Gómez");
		individual.setTipoCliente("FISICA");
		individual.setEstado("ACTIVO");
		individual.setFechaAlta(Date.valueOf("2021-03-14"));
		individual.setDireccion("Avenida Correcaminos");
		individual.setCiudad("Malaga");
		individual.setCodigoPostal("29001");
		individual.setPais("España");
		individual.setFecha_nacimiento(null);
		
		PersonaAutorizada autorizada = new PersonaAutorizada();
		autorizada.setId("Y4001267V");
		autorizada.setNombre("Pepe");
		autorizada.setApellidos("Pelaez");
		autorizada.setFechaNacimiento(null);
		autorizada.setEstado("ACTIVO");
		autorizada.setDireccion("Avda S");		
		autorizada.setFechaInicio(null);
		autorizada.setFechaFin(null);
		
		
		Autorizacion aut = new Autorizacion();
		AutorizacionPK id = new AutorizacionPK();
		id.setPersonaAutorizadaId("Y4001267V");
		id.setEmpresaId("P3310693A");
		aut.setId(id);
		aut.setEmpresa(empresa);
		aut.setIdAutorizada(autorizada);
		aut.setTipo("OPERAR");
		
		List<Autorizacion> lista = new ArrayList<>();
		lista.add(aut);
		
		autorizada.setAutori(lista);
				
		Divisa euro = new Divisa();
		euro.setAbreviatura("euro");
		euro.setNombre("euro");
		euro.setCambioEuro(1);
		euro.setSimbolo("€");
		em.merge(euro);

		Divisa dolar = new Divisa();
		dolar.setAbreviatura("dolar");
		dolar.setNombre("dolares");
		dolar.setCambioEuro(0.95);
		dolar.setSimbolo("$");
		em.merge(dolar);
		
		Divisa libra = new Divisa();
		libra.setAbreviatura("libra");
		libra.setNombre("libra");
		libra.setCambioEuro(1.17);
		libra.setSimbolo("£");
		em.merge(libra);
		
		Usuario juan = new Usuario();
		juan.setNombreUsuario("juan");
		juan.setPassword("juan");
		juan.setTipo("NORMAL");
		juan.setCliente(individual);
		individual.setUsuario(juan);
		em.merge(juan);
		
		Usuario ana = new Usuario();
		ana.setNombreUsuario("ana");
		ana.setPassword("ana");
		ana.setTipo("NORMAL");
		ana.setPersonaAutorizada(autorizada);
		autorizada.setUsuario(ana);
		em.merge(ana);
		
		Usuario ponciano = new Usuario();
		ponciano.setNombreUsuario("ponciano");
		ponciano.setPassword("ponciano");
		ponciano.setTipo("ADMIN");
		em.merge(ponciano);
		
		
		CuentaReferencia cuentaref2 = new CuentaReferencia();
		cuentaref2.setIban("VG57DDVS5173214964983931");
		cuentaref2.setSwift("2345");
		cuentaref2.setNombreBanco("Santander");
		cuentaref2.setSucursal("Plaza mayor");
		cuentaref2.setSaldo(45.0);
		cuentaref2.setFechaApertura(Date.valueOf("2022-04-25"));
		cuentaref2.setEstado("ABIERTA");
		cuentaref2.setAbreviatura(dolar);
		
		em.merge(cuentaref2);
		
		CuentaReferencia cuentaref3 = new CuentaReferencia();
		cuentaref3.setIban("HN47QUXH11325678769785549996");
		cuentaref3.setSwift("2345");
		cuentaref3.setNombreBanco("Santander");
		cuentaref3.setSucursal("Plaza mayor");
		cuentaref3.setSaldo(45.0);
		cuentaref3.setFechaApertura(Date.valueOf("2022-04-25"));
		cuentaref3.setEstado("ABIERTA");
		cuentaref3.setAbreviatura(dolar);
		
		em.merge(cuentaref3);
		
		CuentaReferencia cuentaref4 = new CuentaReferencia();
		cuentaref4.setIban("ES7121007487367264321882");
		cuentaref4.setSwift("2345");
		cuentaref4.setNombreBanco("Santander");
		cuentaref4.setSucursal("Plaza mayor");
		cuentaref4.setSaldo(100.0);
		cuentaref4.setFechaApertura(Date.valueOf("2022-04-25"));
		cuentaref4.setEstado("ABIERTA");
		cuentaref4.setAbreviatura(euro);
		
		em.merge(cuentaref4);
		
		
		CuentaReferencia cuentaref5 = new CuentaReferencia();
		cuentaref5.setIban("VG88HBIJ4257959912673134");
		cuentaref5.setSwift("2345");
		cuentaref5.setNombreBanco("Santander");
		cuentaref5.setSucursal("Plaza mayor");
		cuentaref5.setSaldo(200.0);
		cuentaref5.setFechaApertura(Date.valueOf("2022-04-25"));
		cuentaref5.setEstado("ABIERTA");
		cuentaref5.setAbreviatura(dolar);
		
		em.merge(cuentaref5);
		
		
		CuentaReferencia cuentaref6 = new CuentaReferencia();
		cuentaref6.setIban("GB79BARC20040134265953");
		cuentaref6.setSwift("2345");
		cuentaref6.setNombreBanco("Santander");
		cuentaref6.setSucursal("Plaza mayor");
		cuentaref6.setSaldo(134.0);
		cuentaref6.setFechaApertura(Date.valueOf("2022-04-25"));
		cuentaref6.setEstado("ABIERTA");
		cuentaref6.setAbreviatura(libra);
		
		em.merge(cuentaref6);
		
		PooledAccount pooled = new PooledAccount();
		pooled.setIban("ES8400817251647192321264");
		pooled.setCliente(individual);
		pooled.setClasificacion("POOLED");
		pooled.setEstado("ABIERTA");
		pooled.setSwift("2346");
		pooled.setFechaApertura(Date.valueOf("2021-05-22"));
		
		DepositadaEn depositaEn1 = new DepositadaEn();

		depositaEn1.setSaldo(100.0);
		depositaEn1.setId1(cuentaref4);
		depositaEn1.setId2(pooled);
		DepositaEnPK dep1_pk = new DepositaEnPK();
		dep1_pk.setCuentaReferenciaIban("ES7121007487367264321882");
		dep1_pk.setPooledAccountIban("ES8400817251647192321264");
		depositaEn1.setId(dep1_pk);
		em.merge(depositaEn1);  
		
		
		DepositadaEn depositaEn2 = new DepositadaEn();

		depositaEn2.setSaldo(200.0);
		depositaEn2.setId1(cuentaref5);
		depositaEn2.setId2(pooled);
		DepositaEnPK dep2_pk = new DepositaEnPK();
		dep2_pk.setCuentaReferenciaIban("VG88HBIJ4257959912673134");
		dep2_pk.setPooledAccountIban("ES8400817251647192321264");
		depositaEn2.setId(dep2_pk);
		
		em.merge(depositaEn2);
		
		
		DepositadaEn depositaEn3 = new DepositadaEn();

		depositaEn3.setSaldo(134.0);
		depositaEn3.setId1(cuentaref6);
		depositaEn3.setId2(pooled);
		DepositaEnPK dep3_pk = new DepositaEnPK();
		dep3_pk.setCuentaReferenciaIban("GB79BARC20040134265953");
		dep3_pk.setPooledAccountIban("ES8400817251647192321264");
		depositaEn3.setId(dep3_pk);
		
		em.merge(depositaEn3);
		
		List<DepositadaEn> listaDepo = new ArrayList<>();
		listaDepo.add(depositaEn1);
		listaDepo.add(depositaEn2);
		listaDepo.add(depositaEn3);
		
		pooled.setDepositaEn(listaDepo);
		
		em.merge(pooled);
		
		Segregada segregada1 = new Segregada();
		segregada1.setIban("NL63ABNA6548268733");
		segregada1.setCliente(empresa);
		segregada1.setEstado("ABIERTA");
		segregada1.setCuentaReferencia(cuentaref2);
		segregada1.setClasificacion("SEGREGADA");
		segregada1.setSwift("2347");
		segregada1.setFechaApertura(Date.valueOf("2022-04-25"));
		
		em.merge(segregada1);
		
		Segregada segregada2 = new Segregada();
		segregada2.setIban("FR5514508000502273293129K55");
		segregada2.setCliente(empresa);
		segregada2.setEstado("ABIERTA");
		segregada2.setCuentaReferencia(cuentaref3);
		segregada2.setClasificacion("SEGREGADA");
		segregada2.setSwift("2347");
		segregada2.setFechaApertura(Date.valueOf("2022-04-25"));
		
		em.merge(segregada2);
		
		Segregada segregada3 = new Segregada();
		segregada3.setIban("DE31500105179261215675");
		segregada3.setCliente(empresa);
		segregada3.setEstado("BAJA");
		segregada3.setClasificacion("SEGREGADA");
		segregada3.setSwift("2347");
		segregada3.setFechaApertura(Date.valueOf("2021-04-25"));
		segregada3.setFechaCierre(Date.valueOf("2021-09-01"));
		
		em.merge(segregada3);
		
		Transaccion transaccion = new Transaccion();
		transaccion.setIDunico("553");
		transaccion.setCantidad(200.0);
		transaccion.setComision(null);
		transaccion.setIban(segregada1);
		transaccion.setIban1(pooled);
		transaccion.setDivisa(dolar);
		transaccion.setDivisa1(dolar);
		transaccion.setFechaEjecucion(Date.valueOf("2022-04-25"));
		transaccion.setFechaInstruccion(Date.valueOf("2022-04-25"));
		transaccion.setInternacional(null);
		transaccion.setTipo("CD");
		em.merge(transaccion);
		
		List<CuentaFintech> cuentasEmpresa = new ArrayList<>();
		cuentasEmpresa.add(segregada1);
		cuentasEmpresa.add(segregada2);
		cuentasEmpresa.add(segregada3);
		
		empresa.setCuentas(cuentasEmpresa);
		
		List<CuentaFintech> cuentasIndividual = new ArrayList<>();
		cuentasIndividual.add(pooled);
		
		individual.setCuentas(cuentasIndividual);
		
		em.merge(individual);
		em.merge(empresa);
		em.merge(autorizada);
		*/
		

		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
}
