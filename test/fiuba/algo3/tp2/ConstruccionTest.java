package fiuba.algo3.tp2;
import org.junit.Test;
import junit.framework.Assert;

public class ConstruccionTest {
	
	@Test
	public void ConstruccionDecrementaVidaCorrectamente(){
		Construccion unaConstruccion = new Construccion();
		unaConstruccion.decrementarVida(50.0);
		Assert.assertEquals(unaConstruccion.obtenerVida(),100.0-50.0);
	}
	
	@Test
	public void ConstruccionNoDeberiaSeguirEnPieSiVidaLlegaACero(){
		Construccion unaConstruccion = new Construccion();
		unaConstruccion.decrementarVida(100.0);
		Assert.assertEquals(unaConstruccion.obtenerVida(), 0.0);
		Assert.assertEquals(unaConstruccion.obtenerEstado(), false);
	}
	
	@Test 
	public void InstanciaDeConstruccionSeInicializaCorrectamente(){
		Construccion unaConstruccion = new Construccion();
		Assert.assertEquals(unaConstruccion.obtenerVida(),100.0);
		Assert.assertEquals(unaConstruccion.obtenerEstado(), true);
	}
}