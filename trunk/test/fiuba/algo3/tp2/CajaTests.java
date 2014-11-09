package fiuba.algo3.tp2;

import junit.framework.Assert;

import org.junit.Test;

public class CajaTests {
//ruta 10 lineaTen 5 tuboAgua 5 pozo agua

	@Test
	public void CajaDeberiaConstruirCasaYdecrementarLaCantidadDeDinero(){
		Caja unaCaja = new Caja();
		Mapa unMapa = new Mapa();
		
		unaCaja.ComprarCasaEnCoord(5,5,unMapa);
		
		Assert.assertEquals(1000-5, unaCaja.ObtenerSaldo());
		Assert.assertEquals(100.0, unMapa.obtenerVidaDeConstruccionEnLote(5, 5));
	}
	
	@Test
	public void CajaDeberiaConstruirComercioYdecrementarLaCantidadDeDinero(){
		Caja unaCaja = new Caja();
		Mapa unMapa = new Mapa();
		
		unaCaja.ComprarComercioEnCoord(5,5,unMapa);
		
		Assert.assertEquals(1000-5, unaCaja.ObtenerSaldo());
		Assert.assertEquals(100.0, unMapa.obtenerVidaDeConstruccionEnLote(5, 5));
	}
	
	@Test
	public void CajaDeberiaConstruirIndustriaYdecrementarLaCantidadDeDinero(){
		Caja unaCaja = new Caja();
		Mapa unMapa = new Mapa();
		
		unaCaja.ComprarIndustriaEnCoord(5,5,unMapa);
		
		Assert.assertEquals(1000-10, unaCaja.ObtenerSaldo());
		Assert.assertEquals(100.0, unMapa.obtenerVidaDeConstruccionEnLote(5, 5));
	}
	
	@Test
	public void CajaDeberiaConstruirEstacionBomberosYdecrementarLaCantidadDeDinero(){
		Caja unaCaja = new Caja();
		Mapa unMapa = new Mapa();
		
		unaCaja.ComprarEstacionDeBomberosEnCoord(5,5,unMapa);
		unaCaja.IncrementarSaldo(1500);
		
		Assert.assertEquals(1000, unaCaja.ObtenerSaldo()); // 1000+1500-1500=1000
		Assert.assertEquals(100.0, unMapa.obtenerVidaDeConstruccionEnLote(5, 5));
	}
	
	@Test
	public void CajaDeberiaConstruirCentralNuclearYdecrementarLaCantidadDeDinero(){
		Caja unaCaja = new Caja();
		Mapa unMapa = new Mapa();
		
		unaCaja.ComprarCentralNuclearEnCoord(5,5,unMapa);
		unaCaja.IncrementarSaldo(10000);	
		
		Assert.assertEquals(1000+10000-10000, unaCaja.ObtenerSaldo());
		Assert.assertEquals(100.0, unMapa.obtenerVidaDeConstruccionEnLote(5, 5));
	}
	
	@Test
	public void CajaDeberiaConstruirCentralMineralYdecrementarLaCantidadDeDinero(){
		Caja unaCaja = new Caja();
		Mapa unMapa = new Mapa();
		
		unaCaja.ComprarCentralMineralEnCoord(5,5,unMapa);
		unaCaja.IncrementarSaldo(3000);	
		
		Assert.assertEquals(1000+3000-3000, unaCaja.ObtenerSaldo());
		Assert.assertEquals(100.0, unMapa.obtenerVidaDeConstruccionEnLote(5, 5));
	}
	
	@Test
	public void CajaDeberiaConstruirCentralEolicaYdecrementarLaCantidadDeDinero(){
		Caja unaCaja = new Caja();
		Mapa unMapa = new Mapa();
		
		unaCaja.ComprarCentralEolicaEnCoord(5,5,unMapa);
		unaCaja.IncrementarSaldo(1000);	
		
		Assert.assertEquals(1000+1000-1000, unaCaja.ObtenerSaldo());
		Assert.assertEquals(100.0, unMapa.obtenerVidaDeConstruccionEnLote(5, 5));
	}
	
}
