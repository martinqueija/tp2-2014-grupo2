package fiuba.algo3.tp2;

import junit.framework.Assert;

import org.junit.Test;

public class PoblacionTest {
	
	@Test
	public void MapaDeberiaInicializarseConPoblacionCero(){
		Mapa mapa = new Mapa(200);

		Assert.assertEquals(mapa.getCantidadPoblacion(), 0);
	}
	
	@Test
	public void PoblacionNoDeberiaAgregarPoblacionSolamentePorAgregarUnaCasa(){
		Mapa mapa = new Mapa(200);
		
		Assert.assertEquals(mapa.getCantidadPoblacion(), 0);
		
		Construccion casa = new Casa();
		mapa.insertarConstruccionEn(5, 5, casa);

		Assert.assertEquals(mapa.getCantidadPoblacion(), 0);
	}
	
	@Test
	public void PoblacionDeberiaAumentarSiSeCumplenTodasLasCondciones(){
		Mapa mapa = new Mapa(200);
		
		Industria ind = new Industria();
		Comercio com = new Comercio();
		
		Assert.assertEquals(mapa.getCantidadPoblacion(), 0);
		
		Construccion casa = new Casa();
		mapa.insertarConstruccionEn(5, 6, casa);
		mapa.insertarConstruccionEn(4, 4, ind);
		mapa.insertarConstruccionEn(4, 5, com);

		Assert.assertEquals(mapa.getCantidadPoblacion(), 0);
		
		//Seteo que tenga agua el lote (5,6)
		Lote lote = mapa.obtenerLote(5, 5);
		PozoDeAgua pozo = new PozoDeAgua(5,5);
		TuberiaDeAgua tuberia = new TuberiaDeAgua(5,5);
		TuberiaDeAgua otraTuberia = new TuberiaDeAgua(5,6);
		Agua agua = new Agua();
		lote.definirTerrerno(agua);
		mapa.agregarALaRedDeAgua(pozo);
		mapa.agregarALaRedDeAgua(tuberia);
		mapa.agregarALaRedDeAgua(otraTuberia);
		
		Assert.assertEquals(mapa.getTieneAguaLote(5, 6), true);
		
		//Seteo que tenga luz el lote (5,6)
		CentralEolica nuevaCentral = new CentralEolica(3,5);
		mapa.agregarALaRedElectrica(nuevaCentral);

		Assert.assertEquals(mapa.getTieneElecticidadLote(5, 6), true);
		
		//Seteo que este conectado a una ruta
		Ruta ruta = new Ruta();
		mapa.insertarConstruccionEn(5, 7, ruta);
		
		mapa.actualizarMapa();
		
		Assert.assertEquals(mapa.getCantidadPoblacion(), 100);
	}

}
