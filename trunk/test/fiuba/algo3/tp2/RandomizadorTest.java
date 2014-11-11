package fiuba.algo3.tp2;
import junit.framework.Assert;

import org.junit.Test;


public class RandomizadorTest {
	
	@Test
	public void RandomizadorMockDebeFuncionarCorrectamenteParaCatastrofes(){
		RandomizadorInterface rand = new RandomizadorMock();
		rand.setNumeroMockCat(2);
		int res = rand.obtenerNumeroRandomCat(100);
		Assert.assertEquals(2,res);
	}
	
	@Test
	public void RandomizadorMockDebeFuncionarCorrectamenteParaCoordX(){
		RandomizadorInterface rand = new RandomizadorMock();
		rand.setNumeroMockX(2);
		int res = rand.obtenerNumeroRandomX(100);
		Assert.assertEquals(2,res);
	}
	
	@Test
	public void RandomizadorMockDebeFuncionarCorrectamenteParaCoordY(){
		RandomizadorInterface rand = new RandomizadorMock();
		rand.setNumeroMockY(2);
		int res = rand.obtenerNumeroRandomY(100);
		Assert.assertEquals(2,res);
	}
}
