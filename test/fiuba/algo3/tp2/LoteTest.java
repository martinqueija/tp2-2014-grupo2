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

}
