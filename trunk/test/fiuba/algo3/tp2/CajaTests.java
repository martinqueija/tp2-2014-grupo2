package fiuba.algo3.tp2;

import junit.framework.Assert;

import org.junit.Test;

import fiuba.algo3.tp2.Excepciones.ExcepcionSinSaldo;

public class CajaTests {
	
	@Test
	public void CajaDeberiaInicializarseConSaldoInicial(){
		Caja unaCaja = new Caja();
		Assert.assertEquals(unaCaja.obtenerSaldoInicial(),unaCaja.ObtenerSaldo());
	}
	
	@Test
	public void CajaDeberiaRecolectarDinero(){
		Caja unaCaja = new Caja();
		Poblacion laPoblacion = new Poblacion();
		laPoblacion.agregarPoblacion(100);
		unaCaja.RecoleccionImpuestosPorPoblacion(laPoblacion.getCantidadPoblacion());
		Assert.assertEquals(unaCaja.obtenerSaldoInicial()+(100*10), unaCaja.ObtenerSaldo());
	}
	@Test
	public void CajaDeberiaLanzarExcepcionSiSeQuedaSinSaldo(){
		Caja unaCaja = new Caja();
		boolean lanzo = false;
		try {
			unaCaja.DecrementarSaldo(unaCaja.obtenerSaldoInicial()*2);
		} catch (ExcepcionSinSaldo e){
			lanzo = true;
		}
		Assert.assertEquals(true, lanzo);
	}
	

}
