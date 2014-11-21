package fiuba.algo3.tp2;

import junit.framework.Assert;

import org.junit.Test;

public class GodzillaTest {
	@Test
	public void GodzillaDeberiaDestruirPorCompletoUnaLineaDeTension(){
		Mapa unMapa = new Mapa(200);
		Godzilla godzilla = new Godzilla();
		LineaDeTension lineaDeTension = new LineaDeTension(0,0);
		
		unMapa.agregarALaRedElectrica(lineaDeTension);
		godzilla.iniciarGodzilla(0, 0, 0, 0, unMapa);
		
		Assert.assertEquals(0.0, lineaDeTension.obtenerVida());
	}
	
	@Test
	public void GodzillaDeberiaDestruirPorCompletoLaUnaCasa(){
		Mapa unMapa = new Mapa(200);
		Godzilla godzilla = new Godzilla();
		Construccion casa = new Casa();
		
		unMapa.insertarConstruccionEn(0, 0, casa);
		godzilla.iniciarGodzilla(0, 0, 0, 0, unMapa);
		
		Assert.assertEquals(0.0, unMapa.obtenerVidaDeConstruccionEnLote(0,0));
	}

	@Test
	public void GodzillaDeberiaDaniarEnUn75PorcientoALosComercios(){
		Mapa unMapa = new Mapa(200);
		Godzilla godzilla = new Godzilla();
		Construccion comercio = new Comercio();
		
		unMapa.insertarConstruccionEn(0, 0, comercio);
		godzilla.iniciarGodzilla(0, 0, 0, 0, unMapa);
		
		Assert.assertEquals(25.0, unMapa.obtenerVidaDeConstruccionEnLote(0,0));
	}
	
	@Test
	public void GodzillaDeberiaDaniarEnUn40PorcientoALasIndustrias(){
		Mapa unMapa = new Mapa(200);
		Godzilla godzilla = new Godzilla();
		Construccion industria = new Industria();
		
		unMapa.insertarConstruccionEn(0, 0, industria);
		godzilla.iniciarGodzilla(0, 0, 0, 0, unMapa);
		
		Assert.assertEquals(60.0, unMapa.obtenerVidaDeConstruccionEnLote(0,0));
	}
	
	@Test
	public void GodzillaDeberiaDaniarEnUn80PorcientoALasRuta(){
		Mapa unMapa = new Mapa(200);
		Godzilla godzilla = new Godzilla();
		Construccion ruta = new Ruta();
		
		unMapa.insertarConstruccionEn(0, 0, ruta);
		godzilla.iniciarGodzilla(0, 0, 0, 0, unMapa);
		
		Assert.assertEquals(20.0, unMapa.obtenerVidaDeConstruccionEnLote(0,0));
	}
	
	@Test
	public void GodzillaDeberiaDaniarEnUn35PorcientoALasCentralesElectricas(){
		Mapa unMapa = new Mapa(200);
		Godzilla godzilla = new Godzilla();
		Construccion central = new CentralElectrica(0,0);
		
		unMapa.insertarConstruccionEn(0, 0, central);
		godzilla.iniciarGodzilla(0, 0, 0, 0, unMapa);
		
		Assert.assertEquals(65.0, unMapa.obtenerVidaDeConstruccionEnLote(0,0));
	}
	
	@Test
	public void GodzillaDeberiaDestruirPorCompletoLaUnaEstacionDeBomberos(){
		Mapa unMapa = new Mapa(200);
		Godzilla godzilla = new Godzilla();
		Construccion bomberos = new EstacionBomberos();
		
		unMapa.insertarConstruccionEn(0, 0, bomberos);
		godzilla.iniciarGodzilla(0, 0, 0, 0, unMapa);
		
		Assert.assertEquals(0.0, unMapa.obtenerVidaDeConstruccionEnLote(0,0));
	}
	
	@Test
	public void GodzillaDeberiaDestruirPorCompletoUnPozoDeAgua(){
		Mapa unMapa = new Mapa(200);
		Godzilla godzilla = new Godzilla();
		Construccion pozo = new PozoDeAgua();
		Agua agua = new Agua();
		
		unMapa.setSuperficieLote(0, 0, agua);
		unMapa.insertarConstruccionEn(0, 0, pozo);
		godzilla.iniciarGodzilla(0, 0, 0, 0, unMapa);
		
		Assert.assertEquals(0.0, unMapa.obtenerVidaDeConstruccionEnLote(0,0));
	}
}
