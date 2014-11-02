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
	
	@Test
	public void mapaResuelveCorrectamenteUnaEspecficiaUbicacionYConstruyeUnaCasa() {
		Mapa mapa = new Mapa();
		Construccion unaCasa = new Casa();
		mapa.insertarConstruccionEn(2, 3, unaCasa);
		Assert.assertEquals(mapa.obtenerEstadoEn(2, 3),true);
		Assert.assertEquals(mapa.obtenerEstadoEn(3, 3),false);//lugar vecino sin construir
	}
}
