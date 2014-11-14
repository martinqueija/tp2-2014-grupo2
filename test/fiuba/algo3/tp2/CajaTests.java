package fiuba.algo3.tp2;

import junit.framework.Assert;

import org.junit.Test;

public class CajaTests {
	
	@Test
	public void CajaDeberiaInicializarseConSaldo1000(){
		Caja unaCaja = new Caja();
		Assert.assertEquals(1000,unaCaja.ObtenerSaldo());
	}
	
	@Test
	public void CajaDeberiaRecolectarDinero(){
		Caja unaCaja = new Caja();
		Poblacion laPoblacion = new Poblacion();
		laPoblacion.agregarPoblacion(100);
		unaCaja.RecoleccionImpuestosPorPoblacion(laPoblacion.getCantidadPoblacion());
		Assert.assertEquals(1000+(100*10), unaCaja.ObtenerSaldo());
	}
	
	

}
