package fiuba.algo3.tp2;
import org.junit.Test;
import junit.framework.Assert;

public class ConstruccionTest {
	
	@Test
	public void ConstruccionDeberiaDevolverFalsoAlPreguntarleSiEsRuta(){
		Construccion unaConstruccion = new Construccion();

		Assert.assertEquals(unaConstruccion.esRuta(),false);
	}
	
	@Test
	public void ConstruccionDeberiaDevolverFalsoAlPreguntarleSiEsCasa(){
		Construccion unaConstruccion = new Construccion();

		Assert.assertEquals(unaConstruccion.esCasa(),false);
	}
	
	
	@Test
	public void ConstruccionDecrementaVidaCorrectamente(){
		Construccion unaConstruccion = new Construccion();
		unaConstruccion.decrementarVida(50.0);
		Assert.assertEquals(unaConstruccion.obtenerVida(),100.0-50.0);
	}
	

}
