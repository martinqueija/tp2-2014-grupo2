package fiuba.algo3.tp2;
import junit.framework.Assert;
import org.junit.Test;

public class IndustriaTest {
	
	@Test
	public void IndustriaSeCreaCorrectamente(){
		Mapa unMapa = new Mapa(200);
		Industria unaIndustria = new Industria();
		unMapa.insertarConstruccionEn(3, 3, unaIndustria);
		
		Assert.assertEquals(100.0, unMapa.obtenerVidaDeConstruccionEnLote(3, 3));
	}
	@Test
	public void IndustriaDeveriaDevolverVerdaderoSiSeLePreguntaSiEsIndustria(){

		Industria unaIndustria = new Industria();

		
		Assert.assertEquals(true, unaIndustria.esIndustria());
	}
}
