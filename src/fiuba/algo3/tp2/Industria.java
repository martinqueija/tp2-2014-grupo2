package fiuba.algo3.tp2;

public class Industria extends Construccion{
	
	public boolean puedeConstruirEnSuperficie(Superficie superficieDelLote) {
		if (superficieDelLote.esTerrenoLLano()) {
			return true;	
		} else return false;
	}	
	
	public void reparacionBomberos(){
		double vidaActual = this.obtenerVida();
		double factorReparacion = ((vidaActual/100)*3); //repara el 3% de una industria
		this.incrementarVida(factorReparacion);
	}
	
	public int obtenerCostoConstruccion(){
		return 10;
	}
	
	public String getIdentificador(){
		return "I ";
	}
	public boolean esIndustria() {
		return true;
	}
	public int danioPorGozilla(){
		return (int) (vidaTotal*0.40);
	}
}
