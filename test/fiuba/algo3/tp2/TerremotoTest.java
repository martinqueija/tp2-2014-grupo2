package fiuba.algo3.tp2;
import junit.framework.Assert;

import org.junit.Test;

public class TerremotoTest {
	
	@Test
	public void TerrerotoDeberiaDestruirPorCompletoLaLineaDeTensionEnElEpicentro(){
		Mapa unMapa = new Mapa(200);
		Terremoto unTerremoto = new Terremoto();
		LineaDeTension lineaDeTension = new LineaDeTension(5,5);
		
		unMapa.agregarALaRedElectrica(lineaDeTension);
		unTerremoto.iniciarTerremotoEn(5, 5, unMapa);
		
		Assert.assertEquals(0.0, lineaDeTension.obtenerVida());
	}
	
	@Test
	public void TerremotoDeberiaDestruirPorCompletoLaConstruccionEnElEpicentro(){
		Mapa unMapa = new Mapa(200);
		Terremoto unTerremoto = new Terremoto();
		Construccion casa = new Casa();
		
		unMapa.insertarConstruccionEn(5, 5, casa);
		unTerremoto.iniciarTerremotoEn(5, 5, unMapa);
		
		Assert.assertEquals(0.0, unMapa.obtenerVidaDeConstruccionEnLote(5,5));
	}
	
	@Test
	public void TerremotoDeberiaDestruirParcialmenteConstruccionesVecinasPorUnFactorDeDistancia(){
		Mapa unMapa = new Mapa(200);
		Terremoto unTerremoto = new Terremoto();
		Construccion unaCasa = new Casa();
		Construccion ultimaCasa = new Casa();
		
		unMapa.insertarConstruccionEn(3, 5, unaCasa); //Distancia de 2 lotes entonces vida decrementa por 100-(20x2)=60
		unMapa.insertarConstruccionEn(4, 2, ultimaCasa); //sqrt(1+9)=3.16 entonces la vida decrementa por 100-(20x3)=40
		unTerremoto.iniciarTerremotoEn(5, 5, unMapa);
		
		Assert.assertEquals(100.0-60.0, unMapa.obtenerVidaDeConstruccionEnLote(3,5));
		Assert.assertEquals(100.0-40.0, unMapa.obtenerVidaDeConstruccionEnLote(4, 2));
	}
	
	@Test
	public void TerremotoNoDeberiaAfectarConstruccionesQueEstenAmasDe67unidadesDeDistancia(){
		Mapa unMapa = new Mapa(200);
		Terremoto unTerremoto = new Terremoto();
		Construccion unaCasa = new Casa();
		Construccion otraCasa = new Casa();
		
		unMapa.insertarConstruccionEn(1, 1, unaCasa);
		unMapa.insertarConstruccionEn(15, 15, otraCasa);
		unTerremoto.iniciarTerremotoEn(180, 180, unMapa);
		
		Assert.assertEquals(100.0, unMapa.obtenerVidaDeConstruccionEnLote(1,1));
		Assert.assertEquals(100.0, ((Construccion)otraCasa).obtenerVida());
	}

}
