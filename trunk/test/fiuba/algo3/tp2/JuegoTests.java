package fiuba.algo3.tp2;

import junit.framework.Assert;
import fiuba.algo3.tp2.Excepciones.*;
import org.junit.Test;

public class JuegoTests {
	
	@Test
	public void JuegoDeberiaInicializarseConPoblacionCero(){
		Juego elJuego = new Juego();
		Assert.assertEquals(0,elJuego.elMapa.getCantidadPoblacion());
	}
	
	@Test
	public void JuegoDeberiaInicializarseConSaldo1000(){
		Juego elJuego = new Juego();
		Assert.assertEquals(1000, elJuego.laCaja.ObtenerSaldo());
	}
	
	@Test
	public void JuegoDeberiaInicializarseConMapaVacio(){
		Juego elJuego = new Juego();
		boolean vale = true;
		Lote loteTemp;
		for (int i=0;i<elJuego.elMapa.obtenerTamanioLado();i++){
			for (int j=0;j<elJuego.elMapa.obtenerTamanioLado();j++){
				loteTemp = elJuego.elMapa.obtenerLote(i, j);
				if(loteTemp.hayConstruccion()) { vale = false; }
			}
		}
		Assert.assertEquals(true,vale);
	}
	
	

	@Test
	public void DeberiaConstruirUnaRutaYdecrementarLaCantidadDeDinero(){
		Juego juego = new Juego();
		

		juego.ComprarUnaRutaEnCoord(5,5);
		
		Assert.assertEquals(1000-10, juego.laCaja.ObtenerSaldo());
		Assert.assertEquals(100.0, juego.elMapa.obtenerVidaDeConstruccionEnLote(5, 5));
	}
	
	@Test
	public void DeberiaConstruirUnaTuberiaDeAguaYdecrementarLaCantidadDeDinero(){
		Juego juego = new Juego();
		

		juego.ComprarTuberiaDeAguaEnCoord(5,5);
		
		Assert.assertEquals(1000-5, juego.laCaja.ObtenerSaldo());
		Assert.assertEquals(true, juego.elMapa.getTieneLoteTuberiaDeAgua(5, 5));
	}
	
	@Test
	public void DeberiaConstruirUnPozoDeAguaYdecrementarLaCantidadDeDinero(){
		Juego juego = new Juego();
		Agua agua = new Agua();
		
		juego.elMapa.setSuperficieLote(5, 5, agua);
		juego.ComprarPozoDeAguaEnCoord(5,5);
		
		Assert.assertEquals(1000-250, juego.laCaja.ObtenerSaldo());
		Assert.assertEquals(100.0, juego.elMapa.obtenerVidaDeConstruccionEnLote(5, 5));
	}

	@Test
	public void DeberiaConstruirCasaYdecrementarLaCantidadDeDinero(){
		Juego juego = new Juego();
		
		juego.ComprarCasaEnCoord(5,5);
		
		Assert.assertEquals(1000-5, juego.laCaja.ObtenerSaldo());
		Assert.assertEquals(100.0, juego.elMapa.obtenerVidaDeConstruccionEnLote(5, 5));
	}
	
	@Test
	public void CajaDeberiaConstruirComercioYdecrementarLaCantidadDeDinero(){
		Juego juego = new Juego();
		
		juego.ComprarComercioEnCoord(5,5);
		
		Assert.assertEquals(1000-5, juego.laCaja.ObtenerSaldo());
		Assert.assertEquals(100.0, juego.elMapa.obtenerVidaDeConstruccionEnLote(5, 5));
	}
	
	@Test
	public void DeberiaConstruirLineaDeTensionYdecrementarLaCantidadDeDinero(){
		Juego juego = new Juego();
		
		juego.ComprarLineaDeTensionEnCoord(5, 5);
		
		Assert.assertEquals(1000-5, juego.laCaja.ObtenerSaldo());
		Assert.assertEquals(100.0, juego.elMapa.obtenerVidaDeConstruccionEnLote(5, 5));
	}
	
	@Test
	public void DeberiaConstruirIndustriaYdecrementarLaCantidadDeDinero(){
		Juego juego = new Juego();
		
		juego.ComprarIndustriaEnCoord(5,5);
		
		Assert.assertEquals(1000-10, juego.laCaja.ObtenerSaldo());
		Assert.assertEquals(100.0, juego.elMapa.obtenerVidaDeConstruccionEnLote(5, 5));
	}
	
	@Test
	public void DeberiaConstruirEstacionBomberosYdecrementarLaCantidadDeDinero(){
		Juego juego = new Juego();
		
		juego.laCaja.IncrementarSaldo(1500);
		juego.ComprarEstacionDeBomberosEnCoord(5,5);

		
		Assert.assertEquals(1000, juego.laCaja.ObtenerSaldo()); // 1000+1500-1500=1000
		Assert.assertEquals(100.0, juego.elMapa.obtenerVidaDeConstruccionEnLote(5, 5));
	}
	
	@Test
	public void DeberiaConstruirCentralNuclearYdecrementarLaCantidadDeDinero(){
		Juego juego = new Juego();
		
		juego.laCaja.IncrementarSaldo(10000);	
		juego.ComprarCentralNuclearEnCoord(5,5);

		Assert.assertEquals(1000+10000-10000, juego.laCaja.ObtenerSaldo());
		Assert.assertEquals(100.0, juego.elMapa.obtenerVidaDeConstruccionEnLote(5, 5));
	}
	
	@Test
	public void DeberiaConstruirCentralMineralYdecrementarLaCantidadDeDinero(){
		Juego juego = new Juego();

		juego.laCaja.IncrementarSaldo(3000);	
		juego.ComprarCentralMineralEnCoord(5,5);
		
		Assert.assertEquals(1000+3000-3000, juego.laCaja.ObtenerSaldo());
		Assert.assertEquals(100.0, juego.elMapa.obtenerVidaDeConstruccionEnLote(5, 5));
	}
	
	@Test
	public void DeberiaConstruirCentralEolicaYdecrementarLaCantidadDeDinero(){
		Juego juego = new Juego();
		
		juego.laCaja.IncrementarSaldo(1000);
		juego.ComprarCentralEolicaEnCoord(5,5);
		
		Assert.assertEquals(1000+1000-1000, juego.laCaja.ObtenerSaldo());
		Assert.assertEquals(100.0, juego.elMapa.obtenerVidaDeConstruccionEnLote(5, 5));
	}
	
	@Test
	public void DeberiaLanzarExcpecionConstruyendoFueraDelMapa(){
		Juego juego = new Juego();
		boolean lanzo = false;
		juego.laCaja.IncrementarSaldo(1000);
		try {
				juego.ComprarCentralEolicaEnCoord(-5,5);
		} catch (ExcepcionCoordenadasInvalidas excepcion) {
			lanzo = true;
		}
		
		Assert.assertEquals(true, lanzo);
	}
	
	@Test
	public void DeberiaLanzarExcepcionAlConstruirCasaSobreAgua(){
		Juego juego = new Juego();
		Agua agua = new Agua();
		boolean lanzo = false;
		
		juego.elMapa.setSuperficieLote(5, 5, agua);
		
		try{
			juego.ComprarCasaEnCoord(5,5);
		
			} catch (ExcepcionSuperficieInvalida excepcion) {
				lanzo = true;
			}
		Assert.assertEquals(lanzo,true);
	}
}
