package fiuba.algo3.tp2;

import junit.framework.Assert;

import org.junit.Test;

import fiuba.algo3.tp2.Excepciones.ExcepcionSinSaldo;

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
	@Test
	public void CajaDeberiaLanzarExcepcionSiSeQuedaSinSaldo(){
		Caja unaCaja = new Caja();
		boolean lanzo = false;
		try {
			unaCaja.DecrementarSaldo(5000000);
		} catch (ExcepcionSinSaldo e){
			lanzo = true;
		}
		Assert.assertEquals(true, lanzo);
	}
	

}
