package fiuba.algo3.tp2;

import junit.framework.Assert;

import org.junit.Test;

public class AdministradorCatastrofesTests {
	
	@Test
	public void AdministradorCatastrofesDeberiaIniciarUnTerremotoSiElRandomizerDevuelveNumeroCorrecto(){
		AdministradorCatastrofes adminCat = new AdministradorCatastrofes();
		RandomizadorMock randomizer = new RandomizadorMock();
		Mapa elMapa = new Mapa();
		Casa unaCasita = new Casa();
		elMapa.insertarConstruccionEn(8, 9, unaCasita);
		
		Assert.assertEquals(100.0, elMapa.obtenerVidaDeConstruccionEnLote(8, 9)); // casa deberia tener toda la vida
		
		randomizer.setNumeroMockCat(17);
		randomizer.setNumeroMockX(5);
		randomizer.setNumeroMockY(5);
		adminCat.actuar(elMapa, randomizer); //Deberia iniciar un terremoto en la coord 5.
		
		Assert.assertEquals(100.0-(100-(5*1.5)), elMapa.obtenerVidaDeConstruccionEnLote(8, 9)); // la raiz de la suma de los cuadrados de las diferencias en X y en Y da 5
		
	}
	
}
