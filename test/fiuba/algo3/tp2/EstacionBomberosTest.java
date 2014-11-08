package fiuba.algo3.tp2;
import org.junit.Test;

import junit.framework.Assert;

public class EstacionBomberosTest {
	
	@Test
	public void EstacionBomberosDeberiaRepararCasasConDanios(){
		Mapa unMapa = new Mapa();
		Construccion unaCasa = new Casa();
		Construccion otraCasa = new Casa();

		unMapa.insertarConstruccionEn(5, 5, unaCasa);
		unMapa.insertarConstruccionEn(10, 10, otraCasa);

		Terremoto unTerremoto = new Terremoto();
		unTerremoto.iniciarTerremotoEn(7, 7, unMapa);
		
		Assert.assertEquals(3.0,unaCasa.obtenerVida());
		Assert.assertEquals(6.0,otraCasa.obtenerVida());

		
		EstacionBomberos unaEstacionBomberos = new EstacionBomberos();
		unMapa.insertarConstruccionEn(9, 9, unaEstacionBomberos);
		
		unaEstacionBomberos.repararMapa(unMapa);
		
		Assert.assertEquals(6.6, otraCasa.obtenerVida()); //repara el 10% de la casa que tenia 6 de vida
		Assert.assertEquals(3.3, unaCasa.obtenerVida()); //repara el 10% de la casa que tenia 3 de vida
	}
	
	@Test
	public void EstacionBomberosDeberiaRepararIndustriasConDanios(){
		Mapa unMapa = new Mapa();
		Construccion unaIndustria = new Industria();
		Construccion otraIndustria = new Industria();

		unMapa.insertarConstruccionEn(5, 5, unaIndustria);
		unMapa.insertarConstruccionEn(10, 10, otraIndustria);

		Terremoto unTerremoto = new Terremoto();
		unTerremoto.iniciarTerremotoEn(7, 7, unMapa);
		
		Assert.assertEquals(3.0,unaIndustria.obtenerVida());
		Assert.assertEquals(6.0,otraIndustria.obtenerVida());

		
		EstacionBomberos unaEstacionBomberos = new EstacionBomberos();
		unMapa.insertarConstruccionEn(9, 9, unaEstacionBomberos);
		
		unaEstacionBomberos.repararMapa(unMapa);
		
		Assert.assertEquals(3.0+(3.0*0.03), unaIndustria.obtenerVida()); //para las industrias repara un 3%
		Assert.assertEquals(6.0+(6.0*0.03), otraIndustria.obtenerVida()); 
	}
	
	@Test
	public void EstacionBomberosDeberiaRepararComerciosConDanios(){
		Mapa unMapa = new Mapa();
		Construccion unComercio = new Comercio();
		Construccion otroComercio = new Comercio();

		unMapa.insertarConstruccionEn(5, 5, unComercio);
		unMapa.insertarConstruccionEn(10, 10, otroComercio);

		Terremoto unTerremoto = new Terremoto();
		unTerremoto.iniciarTerremotoEn(7, 7, unMapa);
		
		Assert.assertEquals(3.0,unComercio.obtenerVida());
		Assert.assertEquals(6.0,otroComercio.obtenerVida());

		
		EstacionBomberos unaEstacionBomberos = new EstacionBomberos();
		unMapa.insertarConstruccionEn(9, 9, unaEstacionBomberos);
		
		unaEstacionBomberos.repararMapa(unMapa);
		
		Assert.assertEquals(6.0+(6.0*0.07), otroComercio.obtenerVida());//para comercios repara el 7%
		Assert.assertEquals(3.0+(3.0*0.07), unComercio.obtenerVida());
	}
	
	@Test
	public void EstacionDeBomberosDeberiaRepararEstacionDeBomberosConDanios(){
		Mapa unMapa = new Mapa();
		EstacionBomberos unaEstacionBomberos = new EstacionBomberos();

		unMapa.insertarConstruccionEn(5, 5, unaEstacionBomberos);

		Terremoto unTerremoto = new Terremoto();
		unTerremoto.iniciarTerremotoEn(7, 7, unMapa);
		
		Assert.assertEquals(3.0,unaEstacionBomberos.obtenerVida());
		
		unaEstacionBomberos.repararMapa(unMapa);
		
		Assert.assertEquals(3.0+(3.0*0.20), unaEstacionBomberos.obtenerVida());//para estaciones de bomberos reparan 20%
	}
	
	@Test
	public void EstacionDeBomberosDeberiaRepararCentralEolicaConDanios(){
		Mapa unMapa = new Mapa();
		EstacionBomberos unaEstacionBomberos = new EstacionBomberos();
		unMapa.insertarConstruccionEn(4, 4, unaEstacionBomberos);
		CentralEolica nuevaCentral = new CentralEolica(5,5);
		
		unMapa.agregarALaRedElectrica(nuevaCentral);
					
		Terremoto unTerremoto = new Terremoto();
		unTerremoto.iniciarTerremotoEn(7, 7, unMapa);
		
		Assert.assertEquals(3.0,nuevaCentral.obtenerVida());
		
		unaEstacionBomberos.repararMapa(unMapa);
		
		Assert.assertEquals(3.0+(3.0*0.15), nuevaCentral.obtenerVida());
	}
	
	@Test
	public void EstacionDeBomberosDeberiaRepararCentralMineralConDanios(){
		Mapa unMapa = new Mapa();
		EstacionBomberos unaEstacionBomberos = new EstacionBomberos();
		unMapa.insertarConstruccionEn(4, 4, unaEstacionBomberos);
		CentralMineral nuevaCentral = new CentralMineral(5,5);
		
		unMapa.agregarALaRedElectrica(nuevaCentral);
					
		Terremoto unTerremoto = new Terremoto();
		unTerremoto.iniciarTerremotoEn(7, 7, unMapa);
		
		Assert.assertEquals(3.0,nuevaCentral.obtenerVida());
		
		unaEstacionBomberos.repararMapa(unMapa);
		
		Assert.assertEquals(3.0+(3.0*0.10), nuevaCentral.obtenerVida());
	}
	
	@Test
	public void EstacionDeBomberosDeberiaRepararCentralNuclearConDanios(){
		Mapa unMapa = new Mapa();
		EstacionBomberos unaEstacionBomberos = new EstacionBomberos();
		unMapa.insertarConstruccionEn(4, 4, unaEstacionBomberos);
		CentralNuclear nuevaCentral = new CentralNuclear(5,5);
		
		unMapa.agregarALaRedElectrica(nuevaCentral);
					
		Terremoto unTerremoto = new Terremoto();
		unTerremoto.iniciarTerremotoEn(7, 7, unMapa);
		
		Assert.assertEquals(3.0,nuevaCentral.obtenerVida());
		
		unaEstacionBomberos.repararMapa(unMapa);
		
		Assert.assertEquals(3.0+(3.0*0.03), nuevaCentral.obtenerVida());
	}
}
