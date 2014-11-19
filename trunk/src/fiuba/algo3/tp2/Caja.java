package fiuba.algo3.tp2;

import fiuba.algo3.tp2.Excepciones.ExcepcionSinSaldo;


public class Caja {
	private static final int SALDO_INICIAL = 1000000;
	private int Saldo = SALDO_INICIAL;
	
	
	public void DecrementarSaldo(int Factor){
		Saldo = Saldo - Factor;
		if (Saldo<0){
			Saldo = Saldo + Factor;
			throw new ExcepcionSinSaldo();
		}
	}
	
	public void IncrementarSaldo(int Factor){
		Saldo = Saldo + Factor;
	}
	
	public int obtenerSaldoInicial(){
		return SALDO_INICIAL;
	}
	
	public int ObtenerSaldo(){
		return Saldo;
	}
	
	public void RecoleccionImpuestosPorPoblacion(int Poblacion){
		int ganancia = Poblacion*10;
		this.IncrementarSaldo(ganancia);
	}
	
}
