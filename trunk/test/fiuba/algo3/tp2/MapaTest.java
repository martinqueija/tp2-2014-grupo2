package fiuba.algo3.tp2;
import junit.framework.Assert;
import org.junit.Test;

public class MapaTest {
	
	@Test
	public void mapaDeberiaCrearseVacio() {
		Mapa mapa = new Mapa();
		for (int i=0;i<12;i++){
			for (int j=0;j<12;j++){
				Assert.assertEquals(mapa.obtenerEstadoEn(i,j), false);
			}	
		}
	}
}
