package uma.wow.proyecto.ejb;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import uma.wow.proyecto.Autorizacion;
import uma.wow.proyecto.AutorizacionPK;
import uma.wow.proyecto.CuentaFintech;
import uma.wow.proyecto.CuentaReferencia;
import uma.wow.proyecto.DepositaEnPK;
import uma.wow.proyecto.DepositadaEn;
import uma.wow.proyecto.Divisa;
import uma.wow.proyecto.Empresa;
import uma.wow.proyecto.Individual;
import uma.wow.proyecto.PersonaAutorizada;
import uma.wow.proyecto.PooledAccount;
import uma.wow.proyecto.Segregada;
import uma.wow.proyecto.Transaccion;
import uma.wow.proyecto.Usuario;

@Singleton
@Startup
public class InicializaBBD {
	
	@PersistenceContext(unitName="WOWEJB")
	private EntityManager em;
	
	@PostConstruct
	public void inicializar() {
		
		/*
		//Comprobamos que la BBDD no esté inicializada de antes
		Usuario comprobar = em.find(Usuario.class, "Alvaro");
		if(comprobar != null) {
			return;
		}
		
		Usuario administrador = new Usuario();
		administrador.setNombreUsuario("Alvaro");
		administrador.setPassword("perro");
		administrador.setTipo("ADMIN");
		
		em.persist(administrador);
		
		Usuario usuario = new Usuario ();
		usuario.setNombreUsuario("Carlos");
		usuario.setPassword("gato");
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
	
		
		CuentaReferencia cuentaLlena = new CuentaReferencia();
		cuentaLlena.setNombreBanco("Unicaja");
		cuentaLlena.setIban("9999");
		cuentaLlena.setSwift("4812");
		cuentaLlena.setSaldo(1000000);
		
		CuentaReferencia cuentaVacia = new CuentaReferencia();
		cuentaVacia.setIban("538888");
		cuentaVacia.setNombreBanco("Caixa");
		cuentaVacia.setEstado(null);
		cuentaVacia.setSucursal(null);
		cuentaVacia.setFechaApertura(null);
		cuentaVacia.setPais(null);
		cuentaVacia.setSwift("482");
		cuentaVacia.setSaldo(0);
		
		Segregada segregadaVacia = new Segregada();
		segregadaVacia.setIban("88888");
		segregadaVacia.setSwift("4582");
		segregadaVacia.setClasificacion("SEGREGADA");
		segregadaVacia.setCliente(individual);
		segregadaVacia.setEstado("ABIERTA");
		segregadaVacia.setFechaApertura(Date.valueOf("2020-05-27"));
		segregadaVacia.setFechaCierre(null);
		segregadaVacia.setCuentaReferencia(cuentaVacia);
		
		em.persist(cuentaVacia);
		em.persist(segregadaVacia);
		
		
		em.persist(cuentaLlena);
		
		CuentaReferencia cuentaVacia2 = new CuentaReferencia();
		cuentaVacia2.setIban("723888");
		cuentaVacia2.setNombreBanco("Capo");
		cuentaVacia2.setEstado(null);
		cuentaVacia2.setSucursal(null);
		cuentaVacia2.setFechaApertura(null);
		cuentaVacia2.setPais(null);
		cuentaVacia2.setSwift("482");
		cuentaVacia2.setSaldo(0);
		
		PooledAccount pooledVacia = new PooledAccount();
		pooledVacia.setIban("1453134534528");
		pooledVacia.setSwift("4512");
		pooledVacia.setClasificacion("POOLED");
		pooledVacia.setCliente(individual);
		pooledVacia.setDepositaEn(null);
		pooledVacia.setEstado("ABIERTA");
		pooledVacia.setFechaApertura(Date.valueOf("2020-09-12"));
		pooledVacia.setFechaCierre(null);
		
		
		DepositaEnPK pk = new DepositaEnPK();
		pk.setCuentaReferenciaIban(cuentaVacia2.getIban());
		pk.setPooledAccountIban(pooledVacia.getIban());
		
		DepositadaEn dep = new DepositadaEn();
		dep.setId(pk);
		dep.setId2(pooledVacia);
		dep.setId1(cuentaVacia2);
		dep.setSaldo(cuentaVacia2.getSaldo());
		
		List<DepositadaEn> listado = new ArrayList<DepositadaEn>();
		listado.add(dep);
		pooledVacia.setDepositaEn(listado);
		
		em.persist(cuentaVacia2);
		em.persist(dep);
		em.persist(pooledVacia);
		
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
		
		Usuario usuarioIndividual = new Usuario ();
		usuarioIndividual.setNombreUsuario("Peter");
		usuarioIndividual.setPassword("1234");
		usuarioIndividual.setTipo("NORMAL");
		
		Individual individualParaUsuario = new Individual();
		individualParaUsuario.setId("9999999");
		individualParaUsuario.setIdentificacion("654987");
		individualParaUsuario.setTipoCliente("FISICA");
		individualParaUsuario.setEstado("ACTIVO");
		individualParaUsuario.setFechaAlta(Date.valueOf("2021-03-14"));
		individualParaUsuario.setFechaBaja(null);
		individualParaUsuario.setDireccion("Avenida Cos");
		individualParaUsuario.setCiudad("Malaga");
		individualParaUsuario.setCodigoPostal("2901");
		individualParaUsuario.setPais("España");
		individualParaUsuario.setNombre("Jamal");
		individualParaUsuario.setApellido("Peterh");
		individualParaUsuario.setFecha_nacimiento(null);
		
		usuarioIndividual.setCliente(individualParaUsuario);
		em.persist(usuarioIndividual);
		em.persist(individualParaUsuario);
		
		Usuario usuarioEmpresa = new Usuario ();
		usuarioEmpresa.setNombreUsuario("Carniceria Paco");
		usuarioEmpresa.setPassword("vivalacomida");
		usuarioEmpresa.setTipo("NORMAL");
		
		Empresa empresaParaUsuario = new Empresa();
		empresaParaUsuario.setId("55555555");
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
		
		
		PooledAccount pooled = new PooledAccount();
		pooled.setIban("16554");
		pooled.setSwift("4512");
		pooled.setClasificacion("POOLED");
		pooled.setCliente(empresaParaUsuario);
		pooled.setDepositaEn(null);
		pooled.setEstado("ABIERTA");
		pooled.setFechaApertura(Date.valueOf("2020-09-12"));
		pooled.setFechaCierre(null);
		
		
		DepositadaEn dep1 = new DepositadaEn();
		dep1.setId(pk);
		dep1.setId2(pooled);
		dep1.setId1(cuentaLlena);
		dep1.setSaldo(cuentaLlena.getSaldo());
		
		List<DepositadaEn> listaa = new ArrayList<DepositadaEn>();
		listaa.add(dep1);
		pooled.setDepositaEn(listaa);
		
		em.persist(pooled);
		em.persist(dep1);
		
		//************************************************
		Usuario userTrans = new Usuario ();
		userTrans.setNombreUsuario("Leopoldo");
		userTrans.setPassword("1124");
		userTrans.setTipo("NORMAL");
		
		PersonaAutorizada personaAutorizadaTrans = new PersonaAutorizada();
		personaAutorizadaTrans.setId("2216521981155");
		personaAutorizadaTrans.setIdentificacion("0771");
		personaAutorizadaTrans.setNombre("Pepe");
		personaAutorizadaTrans.setApellidos("Pelaez");
		personaAutorizadaTrans.setFechaNacimiento(null);
		personaAutorizadaTrans.setEstado("ACTIVO");
		personaAutorizadaTrans.setDireccion("Avda S");		
		personaAutorizadaTrans.setFechaInicio(null);
		personaAutorizadaTrans.setFechaFin(null);
		personaAutorizadaTrans.setAutori(null);
		
		Individual individualTrans = new Individual();
		individualTrans.setId("981841");
		individualTrans.setIdentificacion("654987");
		individualTrans.setTipoCliente("FISICA");
		individualTrans.setEstado("ACTIVO");
		individualTrans.setFechaAlta(Date.valueOf("2021-03-14"));
		individualTrans.setFechaBaja(null);
		individualTrans.setDireccion("Avenida Cos");
		individualTrans.setCiudad("Malaga");
		individualTrans.setCodigoPostal("2901");
		individualTrans.setPais("España");
		individualTrans.setNombre("Jamal");
		individualTrans.setApellido("Peterh");
		individualTrans.setFecha_nacimiento(null);
		
		List<CuentaFintech> listaTrans = new ArrayList<CuentaFintech>();
		CuentaFintech cuentaTrans = new CuentaFintech();
		cuentaTrans.setIban("795588");
		cuentaTrans.setEstado(null);
		cuentaTrans.setSwift("482");
		cuentaTrans.setFechaApertura(Date.valueOf("2021-03-14"));
		cuentaTrans.setFechaCierre(null);
		cuentaTrans.setClasificacion(null);
		
		listaTrans.add(cuentaTrans);
		individualTrans.setCuentas(listaTrans);
		*/
		
		Usuario comprobar = em.find(Usuario.class, "juan");
		if(comprobar != null) {
			return;
		}
		
		
		Empresa empresa = new Empresa();
		empresa.setId("P3310693A");
		empresa.setRazon_Social("Andamios Antonio");
		empresa.setTipoCliente("JURIDICO");
		empresa.setEstado("ACTIVO");
		empresa.setFechaAlta("2021-07-16");
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
		individual.setFechaAlta("2021-03-14");
		individual.setDireccion("Avenida Correcaminos");
		individual.setCiudad("Malaga");
		individual.setCodigoPostal("29001");
		individual.setPais("España");
		individual.setFechaNacimiento(null);
		
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
		
		
		em.merge(individual);
		em.merge(empresa);
		em.merge(autorizada);
		
		
		
	}

}
