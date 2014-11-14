package fiuba.algo3.tp2;

public class Caja {
	private int Saldo = 1000;
	
	public void DecrementarSaldo(int Factor){
		Saldo = Saldo - Factor;
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
	
}
