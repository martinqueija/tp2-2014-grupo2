package fiuba.algo3.tp2;

public class Casa extends Construccion { //Casa es una instancia construible
	
	public boolean puedeConstruirEnSuperficie(Superficie superficieDelLote) {
		if (superficieDelLote.esTerrenoLLano()) {
			return true;	
		} else return false;
	}	
	
	public void reparacionBomberos(){
		double vidaActual = this.obtenerVida();
		double factorReparacion = ((vidaActual/100)*10); //repara el 10% de una casa
		this.incrementarVida(factorReparacion);
	}
	
	public boolean esCasa(){
		return true;
	}
	
	public int obtenerCostoConstruccion(){
		return 5;
	}
	
	public String getIdentificador(){
		return "V ";
	}

}
