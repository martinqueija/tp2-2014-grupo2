package fiuba.algo3.tp2;

import junit.framework.Assert;

import org.junit.Test;

public class RedDeBomberosTest {
	
	@Test
	public void EstacionDeBomberosSoloDeberiaRepararCuandoSeActualizaElMapa(){
		Mapa unMapa = new Mapa(200);
		Construccion unaCasa = new Casa();
		Construccion otraCasa = new Casa();

		unMapa.insertarConstruccionEn(5, 5, unaCasa);
		unMapa.insertarConstruccionEn(10, 10, otraCasa);

		Terremoto unTerremoto = new Terremoto();
		unTerremoto.iniciarTerremotoEn(7, 7, unMapa);
		
		double vidaPostTerremoto1 = 100.0 - (100.0 - ((unMapa.calcularDistanciaEntreLotes(5, 5, 7, 7))*(unTerremoto.obtenerFactor())));
		double vidaPostTerremoto2 = 100.0 - (100.0 - ((unMapa.calcularDistanciaEntreLotes(10, 10, 7, 7))*(unTerremoto.obtenerFactor())));

		
		Assert.assertEquals(vidaPostTerremoto1,unaCasa.obtenerVida());
		Assert.assertEquals(vidaPostTerremoto2,otraCasa.obtenerVida());

		
		EstacionBomberos unaEstacionBomberos = new EstacionBomberos();
		unMapa.agregarALaRedDeBomberos(unaEstacionBomberos, 7, 7);
		
		unMapa.actualizarMapa();
		

		double vidaPostBomberos1 = vidaPostTerremoto1 + (vidaPostTerremoto1*0.10);
		double vidaPostBomberos2 = vidaPostTerremoto2 + (vidaPostTerremoto2*0.10);
		
		Assert.assertEquals(vidaPostBomberos2, otraCasa.obtenerVida()); //repara el 10% de la casa que tenia 6 de vida
		Assert.assertEquals(vidaPostBomberos1, unaCasa.obtenerVida()); //repara el 10% de la casa que tenia 3 de vida
	}

}
