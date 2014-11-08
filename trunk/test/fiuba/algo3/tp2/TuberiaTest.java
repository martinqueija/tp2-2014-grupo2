package fiuba.algo3.tp2;

import junit.framework.Assert;

import org.junit.Test;

public class TuberiaTest {
	@Test
	public void TuberiaDeberiaCrearseSinAgua(){
		TuberiaDeAgua tuberia = new TuberiaDeAgua();

		Assert.assertEquals(tuberia.tieneAgua(), false);
	}
	@Test
	public void TuberiaDeberiaTenerAguaCuandoSeLoConectaAUnPozo(){
		Mapa mapa = new Mapa();
		Lote lote = mapa.obtenerLote(5, 5);
		PozoDeAgua pozo = new PozoDeAgua(5,5);
		TuberiaDeAgua tuberia = new TuberiaDeAgua(5,5);
		Agua agua = new Agua();
		

		Assert.assertEquals(tuberia.tieneAgua(), false);
		
		lote.definirTerrerno(agua);
		mapa.agregarALaRedDeAgua(pozo);
		mapa.agregarALaRedDeAgua(tuberia);
		
		Assert.assertEquals(tuberia.tieneAgua(), true);				
		
	}

}
