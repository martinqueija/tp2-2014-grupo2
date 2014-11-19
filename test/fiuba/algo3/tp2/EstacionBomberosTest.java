package fiuba.algo3.tp2;
import org.junit.Test;

import junit.framework.Assert;

public class EstacionBomberosTest {
	
	@Test
	public void EstacionBomberosDeberiaRepararCasasConDanios(){
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
		unMapa.insertarConstruccionEn(9, 9, unaEstacionBomberos);
		
		unaEstacionBomberos.repararMapa(unMapa);
		

		double vidaPostBomberos1 = vidaPostTerremoto1 + (vidaPostTerremoto1*0.10);
		double vidaPostBomberos2 = vidaPostTerremoto2 + (vidaPostTerremoto2*0.10);
		
		Assert.assertEquals(vidaPostBomberos2, otraCasa.obtenerVida()); //repara el 10% de la casa que tenia 6 de vida
		Assert.assertEquals(vidaPostBomberos1, unaCasa.obtenerVida()); //repara el 10% de la casa que tenia 3 de vida
	}
	
	@Test
	public void EstacionBomberosDeberiaRepararIndustriasConDanios(){
		Mapa unMapa = new Mapa(200);
		Construccion unaIndustria = new Industria();
		Construccion otraIndustria = new Industria();

		unMapa.insertarConstruccionEn(5, 5, unaIndustria);
		unMapa.insertarConstruccionEn(10, 10, otraIndustria);

		Terremoto unTerremoto = new Terremoto();
		unTerremoto.iniciarTerremotoEn(7, 7, unMapa);

		double vidaPostTerremoto1=100.0-(100-(unMapa.calcularDistanciaEntreLotes(5, 5, 7, 7)*unTerremoto.obtenerFactor()));
		double vidaPostTerremoto2=100.0-(100-(unMapa.calcularDistanciaEntreLotes(10, 10, 7, 7)*unTerremoto.obtenerFactor()));
		
		Assert.assertEquals(vidaPostTerremoto1,unaIndustria.obtenerVida());
		Assert.assertEquals(vidaPostTerremoto2,otraIndustria.obtenerVida());

		
		EstacionBomberos unaEstacionBomberos = new EstacionBomberos();
		unMapa.insertarConstruccionEn(9, 9, unaEstacionBomberos);
		
		unaEstacionBomberos.repararMapa(unMapa);

		double vidaPostBomberos1 = vidaPostTerremoto1 + (vidaPostTerremoto1*0.03);
		double vidaPostBomberos2 = vidaPostTerremoto2 + (vidaPostTerremoto2*0.03);
		
		Assert.assertEquals(vidaPostBomberos1, unaIndustria.obtenerVida()); //para las industrias repara un 3%
		Assert.assertEquals(vidaPostBomberos2, otraIndustria.obtenerVida()); 
	}
	
	@Test
	public void EstacionBomberosDeberiaRepararComerciosConDanios(){
		Mapa unMapa = new Mapa(200);
		Construccion unComercio = new Comercio();
		Construccion otroComercio = new Comercio();

		unMapa.insertarConstruccionEn(5, 5, unComercio);
		unMapa.insertarConstruccionEn(10, 10, otroComercio);

		Terremoto unTerremoto = new Terremoto();
		unTerremoto.iniciarTerremotoEn(7, 7, unMapa);
		

		double vidaPostTerremoto1=100.0-(100-(unMapa.calcularDistanciaEntreLotes(5, 5, 7, 7)*unTerremoto.obtenerFactor()));
		double vidaPostTerremoto2=100.0-(100-(unMapa.calcularDistanciaEntreLotes(10, 10, 7, 7)*unTerremoto.obtenerFactor()));
		
		Assert.assertEquals(vidaPostTerremoto1,unComercio.obtenerVida());
		Assert.assertEquals(vidaPostTerremoto2,otroComercio.obtenerVida());

		
		EstacionBomberos unaEstacionBomberos = new EstacionBomberos();
		unMapa.insertarConstruccionEn(9, 9, unaEstacionBomberos);
		
		unaEstacionBomberos.repararMapa(unMapa);
		

		double vidaPostBomberos1 = vidaPostTerremoto1 + (vidaPostTerremoto1*0.07);
		double vidaPostBomberos2 = vidaPostTerremoto2 + (vidaPostTerremoto2*0.07);
		
		Assert.assertEquals(vidaPostBomberos2, otroComercio.obtenerVida());//para comercios repara el 7%
		Assert.assertEquals(vidaPostBomberos1, unComercio.obtenerVida());
	}
	
	@Test
	public void EstacionDeBomberosDeberiaRepararEstacionDeBomberosConDanios(){
		Mapa unMapa = new Mapa(200);
		EstacionBomberos unaEstacionBomberos = new EstacionBomberos();

		unMapa.insertarConstruccionEn(5, 5, unaEstacionBomberos);

		Terremoto unTerremoto = new Terremoto();
		unTerremoto.iniciarTerremotoEn(9, 8, unMapa);
		double vidaDespues = (100.0)-(100.0-((unMapa.calcularDistanciaEntreLotes(5, 5, 9, 8))*(unTerremoto.obtenerFactor()))); 
		Assert.assertEquals(vidaDespues ,unaEstacionBomberos.obtenerVida());
		
		unaEstacionBomberos.repararMapa(unMapa);
		
		if (vidaDespues+(vidaDespues*0.20)>100){
			vidaDespues=100;
		}
		
		Assert.assertEquals(vidaDespues, unaEstacionBomberos.obtenerVida());//para estaciones de bomberos reparan 20%
	}
	
	@Test
	public void EstacionDeBomberosDeberiaRepararCentralEolicaConDanios(){
		Mapa unMapa = new Mapa(200);
		EstacionBomberos unaEstacionBomberos = new EstacionBomberos();
		unMapa.insertarConstruccionEn(4, 4, unaEstacionBomberos);
		CentralEolica nuevaCentral = new CentralEolica(5,5);
		
		unMapa.agregarALaRedElectrica(nuevaCentral);
					
		Terremoto unTerremoto = new Terremoto();
		unTerremoto.iniciarTerremotoEn(7, 7, unMapa);
		
		double vidaPostTerremoto = 100.0 - (100.0 - ((unMapa.calcularDistanciaEntreLotes(5, 5, 7, 7))*(unTerremoto.obtenerFactor())));
		
		Assert.assertEquals(vidaPostTerremoto,nuevaCentral.obtenerVida());
		
		unaEstacionBomberos.repararMapa(unMapa);
		
		double vidaPostbomberos = vidaPostTerremoto + (vidaPostTerremoto*0.15);
		
		Assert.assertEquals(vidaPostbomberos, nuevaCentral.obtenerVida());
	}
	
	@Test
	public void EstacionDeBomberosDeberiaRepararCentralMineralConDanios(){
		Mapa unMapa = new Mapa(200);
		EstacionBomberos unaEstacionBomberos = new EstacionBomberos();
		unMapa.insertarConstruccionEn(4, 4, unaEstacionBomberos);
		CentralMineral nuevaCentral = new CentralMineral(5,5);
		
		unMapa.agregarALaRedElectrica(nuevaCentral);
					
		Terremoto unTerremoto = new Terremoto();
		unTerremoto.iniciarTerremotoEn(7, 7, unMapa);
		
		double vidaPostTerremoto1=100.0-(100-(unMapa.calcularDistanciaEntreLotes(5, 5, 7, 7)*unTerremoto.obtenerFactor()));

		
		Assert.assertEquals(vidaPostTerremoto1,nuevaCentral.obtenerVida());
		
		unaEstacionBomberos.repararMapa(unMapa);
		
		double vidaPostbomberos = vidaPostTerremoto1 + (vidaPostTerremoto1*0.10);

		
		Assert.assertEquals(vidaPostbomberos, nuevaCentral.obtenerVida());
	}
	
	@Test
	public void EstacionDeBomberosDeberiaRepararCentralNuclearConDanios(){
		Mapa unMapa = new Mapa(200);
		EstacionBomberos unaEstacionBomberos = new EstacionBomberos();
		unMapa.insertarConstruccionEn(4, 4, unaEstacionBomberos);
		CentralNuclear nuevaCentral = new CentralNuclear(5,5);
		
		unMapa.agregarALaRedElectrica(nuevaCentral);
					
		Terremoto unTerremoto = new Terremoto();
		unTerremoto.iniciarTerremotoEn(7, 7, unMapa);
		
		double vidaPostTerremoto1=100.0-(100-(unMapa.calcularDistanciaEntreLotes(5, 5, 7, 7)*unTerremoto.obtenerFactor()));

		
		Assert.assertEquals(vidaPostTerremoto1,nuevaCentral.obtenerVida());
		
		unaEstacionBomberos.repararMapa(unMapa);
		
		double vidaPostbomberos = vidaPostTerremoto1 + (vidaPostTerremoto1*0.03);

		
		Assert.assertEquals(vidaPostbomberos, nuevaCentral.obtenerVida());
	}
}
