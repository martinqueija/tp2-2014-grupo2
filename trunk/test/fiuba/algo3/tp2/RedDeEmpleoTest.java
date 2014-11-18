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
	
	@Test
	public void MapaDeneriaTener12EmpleosDisponiblesAlAgregarUnComercioConAguaElectricidadYAccesoAlTransito(){
		Mapa mapa = new Mapa(200);
		Comercio comercio = new Comercio ();
		CentralEolica centralNueva = new CentralEolica(1,1);
		Ruta ruta = new Ruta();
		
		mapa.insertarConstruccionEn(1, 2, ruta);
		mapa.insertarConstruccionEn(2, 2, comercio);
		mapa.agregarALaRedElectrica(centralNueva);
		
		//Seteo que tenga agua el lote (2,2)
		Lote lote = mapa.obtenerLote(2, 1);
		PozoDeAgua pozo = new PozoDeAgua(2,1);
		TuberiaDeAgua tuberia = new TuberiaDeAgua(2,1);
		TuberiaDeAgua otraTuberia = new TuberiaDeAgua(2,2);
		Agua agua = new Agua();
		lote.definirTerrerno(agua);
		mapa.agregarALaRedDeAgua(pozo);
		mapa.agregarALaRedDeAgua(tuberia);
		mapa.agregarALaRedDeAgua(otraTuberia);
		
		mapa.actualizarMapa();
		Assert.assertEquals(12, mapa.getCantidadEmpleosDisponibles());		
	}

}
