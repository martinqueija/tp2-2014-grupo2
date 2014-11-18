package fiuba.algo3.tp2;

import junit.framework.Assert;

import org.junit.Test;

public class RedDeEmpleoTest {
	
	@Test
	public void MapaDeberiaInicializarseConEmpleosDisponiblesEnCero(){
		Mapa mapa = new Mapa(200);
		
		Assert.assertEquals(0, mapa.getCantidadEmpleosDisponibles());

	}
	
	@Test
	public void AlAgregarUnaIndustriaAlMapaNoDeberianCrearseEmpleosSiNoTieneElectricidad(){
		Mapa mapa = new Mapa(200);
		Industria industrica = new Industria ();
		
		mapa.insertarConstruccionEn(1, 1, industrica);
		
		Assert.assertEquals(0, mapa.getCantidadEmpleosDisponibles());

	}
	
	@Test
	public void AlAgregarUnComerciolMapaNoDeberianCrearseEmpleosSiNoTieneElectricidad(){
		Mapa mapa = new Mapa(200);
		Comercio comercio = new Comercio ();
		
		mapa.insertarConstruccionEn(1, 1, comercio);
		
		Assert.assertEquals(0, mapa.getCantidadEmpleosDisponibles());
	}
	
	@Test
	public void MapaDeberiaTener25EmpleosDisponiblesAlAgregarUnaIndustriaConElectridadYAccesoAlTransito(){
		Mapa mapa = new Mapa(200);
		Industria industrica = new Industria ();
		CentralEolica centralNueva = new CentralEolica(1,2);
		Ruta ruta = new Ruta();
		mapa.insertarConstruccionEn(2, 1, ruta);
		mapa.insertarConstruccionEn(1, 1, industrica);
		mapa.agregarALaRedElectrica(centralNueva);
		
		mapa.actualizarMapa();
		Assert.assertEquals(25, mapa.getCantidadEmpleosDisponibles());
		
		
	}

}
