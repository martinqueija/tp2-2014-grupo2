package fiuba.algo3.tp2;
import org.junit.Test;

import junit.framework.Assert;

public class RutaTest {

	@Test
	public void RutaDecrementaLaVidaCorrectamente(){
		Ruta unaRuta = new Ruta();
		((Construccion)unaRuta).decrementarVida(10);
		Assert.assertEquals(((Construccion)unaRuta).obtenerVida(), 90.0);
	}
}
