package fiuba.algo3.tp2;
import junit.framework.Assert;
import org.junit.Test;

public class IndustriaTest {
	
	@Test
	public void IndustriaSeCreaCorrectamente(){
		Mapa unMapa = new Mapa();
		Industria unaIndustria = new Industria();
		unMapa.insertarConstruccionEn(3, 3, unaIndustria);
		
		Assert.assertEquals(100.0, unMapa.obtenerVidaDeConstruccionEnLote(3, 3));
	}
}
