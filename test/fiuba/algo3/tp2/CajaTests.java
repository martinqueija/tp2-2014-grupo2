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
	
	@Test
	public void CajaDeberiaDecrementarSaldoCorrectamente(){
		Caja unaCaja = new Caja();
		int saldoPre = unaCaja.ObtenerSaldo();
		int saldoPost = saldoPre - 100;
		unaCaja.DecrementarSaldo(100);
		Assert.assertEquals(saldoPost, unaCaja.ObtenerSaldo());
	}
	
	@Test
	public void CajaDeberiaIncrementarSaldoCorrectamente(){
		Caja unaCaja = new Caja();
		int saldoPre = unaCaja.ObtenerSaldo();
		int saldoPost = saldoPre + 100;
		unaCaja.IncrementarSaldo(100);
		Assert.assertEquals(saldoPost, unaCaja.ObtenerSaldo());
	}
	
	@Test
	public void CajaDeberiaCalcularCorrectamenteSiPuedeComprar(){
		Caja unaCaja = new Caja();
		int saldoPre = unaCaja.obtenerSaldoInicial();
		unaCaja.DecrementarSaldo(saldoPre);
		unaCaja.IncrementarSaldo(10);
		Assert.assertEquals(10, unaCaja.ObtenerSaldo());
		Assert.assertEquals(false, unaCaja.verificarSaldoParaCompra(15));
		Assert.assertEquals(true, unaCaja.verificarSaldoParaCompra(5));
	}
	
	@Test
	public void RecoleccionDeImpuestosDeberiaFuncionarCorrectamente(){
		Caja unaCaja = new Caja();
		int saldoPre = unaCaja.obtenerSaldoInicial();
		unaCaja.DecrementarSaldo(saldoPre);
		unaCaja.IncrementarSaldo(10);
		Assert.assertEquals(10, unaCaja.ObtenerSaldo());
		
		
		unaCaja.RecoleccionImpuestosPorPoblacion(10); ///10*10=100
		
		Assert.assertEquals(10+100, unaCaja.ObtenerSaldo());
	}

}
