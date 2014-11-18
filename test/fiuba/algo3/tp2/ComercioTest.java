package fiuba.algo3.tp2;
import junit.framework.Assert;
import org.junit.Test;

public class ComercioTest {
	
	@Test
	public void ComercioSeCreaCorrectamente(){
		Mapa unMapa = new Mapa(200);
		Comercio unComercio = new Comercio();
		unMapa.insertarConstruccionEn(3, 3, unComercio);
		
		Assert.assertEquals(100.0, unMapa.obtenerVidaDeConstruccionEnLote(3, 3));
	}
	@Test
	public void ComercioDeberiaDevolverTrueCuandoSeLePreguntaSiEsComercio(){

		Comercio unComercio = new Comercio();

		Assert.assertEquals(true, unComercio.esComercio());
	}
	
}
