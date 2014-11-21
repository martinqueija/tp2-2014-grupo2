package fiuba.algo3.tp2;

public class Comercio extends Construccion{
	
	public boolean puedeConstruirEnSuperficie(Superficie superficieDelLote) {
		if (superficieDelLote.esTerrenoLLano()) {
			return true;	
		} else return false;
	}	
	
	public void reparacionBomberos(){
		double vidaActual = this.obtenerVida();
		double factorReparacion = ((vidaActual)*0.07); //repara el 7% de un comercio
		this.incrementarVida(factorReparacion);
	}
	
	public int obtenerCostoConstruccion(){
		return 5;
	}
	
	public String getIdentificador(){
		return "C ";
	}
	public boolean esComercio() {
		return true;
	}
	public int danioPorGozilla(){
		return (int) (vidaTotal*0.75);
	}
}
