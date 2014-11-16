package fiuba.algo3.tp2;
import junit.framework.Assert;
import org.junit.Test;
import fiuba.algo3.tp2.Excepciones.*;



public class MapaTest {
	
	@Test
	public void mapaDeberiaCrearseVacio() {
		Mapa mapa = new Mapa();
		for (int i=0;i<12;i++){
			for (int j=0;j<12;j++){
				Assert.assertEquals(mapa.obtenerEstadoDelLoteEn(i,j), false);
			}	
		}
	}
	
	@Test
	public void mapaResuelveCorrectamenteUnaEspecficaUbicacionYConstruyeUnaCasa() {
		Mapa mapa = new Mapa();
		Construccion unaCasa = new Casa();
		mapa.insertarConstruccionEn(2, 3, unaCasa);
		Assert.assertEquals(mapa.obtenerEstadoDelLoteEn(2, 3),true);
		Assert.assertEquals(mapa.obtenerEstadoDelLoteEn(3, 3),false);//lugar vecino sin construir
	}
	
	@Test
	public void MapaPuedeDaniarCorrectamenteCualquierLoteEnElMapa(){
		Mapa mapa = new Mapa();
		double vidaRestante;
		Construccion unaCasa = new Casa();
		mapa.insertarConstruccionEn(5, 5, unaCasa);
		mapa.daniarConstruccionDelLote(5, 5, 15);
		vidaRestante = mapa.obtenerVidaDeConstruccionEnLote(5, 5);
		Assert.assertEquals(vidaRestante, 85.0);
	}

	@Test
	public void MapaDebeDevolverLaVidaCorrectaDeCualquierCostruccionEnElMapa(){
		Mapa mapa = new Mapa();
		Construccion unaCasa = new Casa();
		mapa.insertarConstruccionEn(2, 3, unaCasa);
		Assert.assertEquals(mapa.obtenerVidaDeConstruccionEnLote(2, 3),100.0);
	}
	
	@Test
	public void MapaDeberiaLanzarExcepcionConstryuendoFueraDelMapa(){
		Mapa mapa = new Mapa();
		Construccion unaCasa = new Casa();
		boolean lanzo = false;
		try {
				mapa.insertarConstruccionEn(-2, 3, unaCasa);
		} catch (ExcepcionCoordenadasInvalidas excepcion) {
			lanzo = true;
		}
		Assert.assertEquals(lanzo,true);
	}
	
	@Test
	public void MapaACtualizarDeberiaEliminarLasCOnstruccionesSinVida(){
		Mapa mapa = new Mapa();
		Construccion unaCasa = new Casa();
		mapa.insertarConstruccionEn(1, 1, unaCasa);
		
		Lote loteTemp = mapa.obtenerLote(1, 1);
		
		Assert.assertEquals(true, loteTemp.hayConstruccion());
		
		mapa.daniarConstruccionDelLote(1, 1, 100);
		mapa.actualizarMapa();
		
		
		Assert.assertEquals(false, loteTemp.hayConstruccion());
	}
	
}
