package fiuba.algo3.tp2;
import org.junit.Test;

import junit.framework.Assert;

public class LoteTest {
	
	@Test
	public void LoteDeberiaCrearseVacioYenCoordenadasSolicitadas(){
		Lote lote = new Lote(2,3);
		Assert.assertEquals(lote.hayConstruccion(), false);
		Assert.assertEquals(2, lote.obtenerCoordX());
		Assert.assertEquals(3, lote.obtenerCoordY());
	}
	
	@Test
	public void LoteDeberiaDaniarCorrectamenteUnaConstruccion(){
		Lote lote = new Lote(2,3);
		Construccion unaCasa = new Casa();
		TerrenoLLano terreno = new TerrenoLLano();
		lote.definirTerrerno(terreno);
		
		lote.insertarConstruccion(unaCasa);
		lote.daniarConstruccion(15.0);
		
		Assert.assertEquals(unaCasa.obtenerVida(), 85.0);
	}
	
	@Test
	public void LoteConConstruccionSeCreaCorrectamente(){
		Lote lote = new Lote(2,3);
		TerrenoLLano terreno = new TerrenoLLano();
		lote.definirTerrerno(terreno);
		Construccion unaCasa = new Casa();
		
		lote.insertarConstruccion(unaCasa);
	
		Assert.assertEquals(lote.obtenerVidaConstruccion(), 100.0);
		Assert.assertEquals(lote.hayConstruccion(),true);
		
	}
	
	@Test
	public void LoteNoDeberiaPoderConstruirseCasaSobreAgua(){
		Casa unaCasa = new Casa();
		Lote lote = new Lote(1,1);
		Agua agua = new Agua();
		lote.definirTerrerno(agua);
		
		lote.insertarConstruccion((Construccion)unaCasa);
		
		Assert.assertEquals(lote.hayConstruccion(), false);
		
	}
	
	@Test
	public void LoteDeberiaPoderConstruirseCasaSobreTerrenoLlano(){
		Casa unaCasa = new Casa();
		Lote lote = new Lote(1,1);
		TerrenoLLano tierra = new TerrenoLLano();
		lote.definirTerrerno(tierra);
		
		lote.insertarConstruccion((Construccion)unaCasa);
		
		Assert.assertEquals(lote.hayConstruccion(), true);
		
	}
	
	@Test
	public void LoteDeberiaPoderConstruirsePosoDeAguaSobreAgua(){
		Construccion posoDeAgua = new PosoDeAgua();
		Lote lote = new Lote(1,1);
		Agua agua = new Agua();
		lote.definirTerrerno(agua);
		
		lote.insertarConstruccion((Construccion)posoDeAgua);
		
		Assert.assertEquals(lote.hayConstruccion(), true);
		
	}

}
