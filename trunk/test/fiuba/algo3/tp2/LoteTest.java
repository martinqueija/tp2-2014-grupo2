package fiuba.algo3.tp2;
import org.junit.Test;
import junit.framework.Assert;

public class LoteTest {
	
	@Test
	public void LoteDeberiaCrearseVacioYenCoordenadasSolicitadas(){
		Lote lote = new Lote(2,3);
		Assert.assertEquals(lote.obtenerEstado(), false);
		Assert.assertEquals(2, lote.obtenerCoordX());
		Assert.assertEquals(3, lote.obtenerCoordY());
	}
	
	@Test
	public void LoteDeberiaDaniarCorrectamenteUnaConstruccion(){
		Lote lote = new Lote(2,3);
		Construccion unaCasa = new Casa();
		
		lote.insertarConstruccion(unaCasa);
		lote.daniarConstruccion(15.0);
		
		Assert.assertEquals(unaCasa.obtenerVida(), 85.0);
	}
	
	@Test
	public void LoteConConstruccionSeCreaCorrectamente(){
		Lote lote = new Lote(2,3);
		Construccion unaCasa = new Casa();
		
		lote.insertarConstruccion(unaCasa);
	
		Assert.assertEquals(lote.obtenerVidaConstruccion(), 100.0);
		Assert.assertEquals(lote.obtenerEstado(),true);
		
	}


}
