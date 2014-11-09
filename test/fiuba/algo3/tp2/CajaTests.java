package fiuba.algo3.tp2;

import junit.framework.Assert;

import org.junit.Test;

public class CajaTests {
//ruta 10 lineaTen 5 tuboAgua 5 eloica 1000 minreal 3000 nucelar 10000
//pozo agua 250 bomberos 1500 resodemcoa 5 comercio 5 industria 10
	
	@Test
	public void CajaDeberiaConstruirCasaYdecrementarLaCantidadDeDinero(){
		Caja unaCaja = new Caja();
		Mapa unMapa = new Mapa();
		
		unaCaja.ComprarCasaEnCoord(5,5);
		
		Assert.assertEquals(1000-5, unaCaja.ObtenerSaldo());
	}
	
}
