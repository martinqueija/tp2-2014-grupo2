package fiuba.algo3.tp2;

import junit.framework.Assert;

import org.junit.Test;

public class JuegoTests {
	
	@Test
	public void JuegoDeberiaInicializarseConPoblacionCero(){
		Juego elJuego = new Juego();
		Assert.assertEquals(0,elJuego.elMapa.getCantidadPoblacion());
	}
	
	@Test
	public void JuegoDeberiaInicializarseConSaldo1000(){
		Juego elJuego = new Juego();
		Assert.assertEquals(1000, elJuego.laCaja.ObtenerSaldo());
	}
	
	@Test
	public void JuegoDeberiaInicializarseConMapaVacio(){
		Juego elJuego = new Juego();
		boolean vale = true;
		Lote loteTemp;
		for (int i=0;i<elJuego.elMapa.obtenerTamanioLado();i++){
			for (int j=0;j<elJuego.elMapa.obtenerTamanioLado();j++){
				loteTemp = elJuego.elMapa.obtenerLote(i, j);
				if(loteTemp.hayConstruccion()) { vale = false; }
			}
		}
		Assert.assertEquals(true,vale);
	}
}
