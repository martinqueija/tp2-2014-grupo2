package fiuba.algo3.tp2;

import junit.framework.Assert;

import org.junit.Test;

public class RedDeAguaTest {
	@Test
	public void TuberiaDeberiaTenerAguaCuandoSeLoConectaAUnPozo(){
		Mapa mapa = new Mapa();
		PozoDeAgua pozo = new PozoDeAgua(5,5);
		Agua agua = new Agua();
		mapa.setSuperficieLote(5, 5, agua);
		mapa.agregarALaRedDeAgua(pozo);
		
		Assert.assertEquals(mapa.getTieneAguaLote(5, 8), false);
	
		TuberiaDeAgua tuberia = new TuberiaDeAgua(5,5);
		mapa.agregarALaRedDeAgua(tuberia);
		tuberia = new TuberiaDeAgua(5,6);
		mapa.agregarALaRedDeAgua(tuberia);
		tuberia = new TuberiaDeAgua(5,7);
		mapa.agregarALaRedDeAgua(tuberia);
		tuberia = new TuberiaDeAgua(5,8);
		mapa.agregarALaRedDeAgua(tuberia);
		
		Assert.assertEquals(mapa.getTieneAguaLote(5, 8), true);				
		
	}


}
