package fiuba.algo3.tp2;
import junit.framework.Assert;
import org.junit.Test;

public class CasaTest {

	@Test
	public void CasaDecrementaLaVidaCorrectamente(){
		Casa unaCasa = new Casa();
		((Construccion)unaCasa).decrementarVida(10);
		Assert.assertEquals(((Construccion)unaCasa).obtenerVida(), 90);
	}
}
