package fiuba.algo3.tp2;

public class Ruta extends Construccion { //Casa es una instancia construible
	
	public boolean esRuta(){
		return true;
	}

	public boolean puedeConstruirEnSuperficie(Superficie superficieDelLote) {
		if (superficieDelLote.esTerrenoLLano()) {
			return true;	
		} else return false;
	}	
	
	public int obtenerCostoConstruccion(){
		return 10;
	}
	
	public String getIdentificador(){
		return "R ";
	}
	public int danioPorGozilla(){
		return (int) (vidaTotal*0.80);
	}
}


