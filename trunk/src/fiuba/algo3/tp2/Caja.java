package fiuba.algo3.tp2;

import fiuba.algo3.tp2.Excepciones.ExcepcionSinSaldo;


public class Caja {
	private int Saldo = 0;
	
	public Caja(){
		Saldo = 1000;
	}
	
	public void DecrementarSaldo(int Factor){
		Saldo = Saldo - Factor;
		if (Saldo<0){
			Saldo = Saldo + Factor;
			throw new ExcepcionSinSaldo();
		}
	}
	
	public void setSaldo(int saldo){
		Saldo = saldo;
	}
	
	public void IncrementarSaldo(int Factor){
		Saldo = Saldo + Factor;
	}
	
	
	public int ObtenerSaldo(){
		return Saldo;
	}
	
	public void RecoleccionImpuestosPorPoblacion(int Poblacion){
		int ganancia = Poblacion*10;
		this.IncrementarSaldo(ganancia);
	}

	public boolean verificarSaldoParaCompra(int CostoConstruccion) {
		if (Saldo >= CostoConstruccion) {
			return true;
		}
		return false;
	}

	public int obtenerSaldoInicial() {
		return 1000;
	}
	
}
