package fiuba.algo3.tp2;
import junit.framework.Assert;

import org.junit.Test;


public class RandomizadorTest {
	
	@Test
	public void RandomizadorMockDebeFuncionarCorrectamente(){
		RandomizadorInterface rand = new RandomizadorMock();
		rand.setNumeroMock(2);
		int res = rand.obtenerNumeroRandom();
		Assert.assertEquals(2,res);
	}
}
