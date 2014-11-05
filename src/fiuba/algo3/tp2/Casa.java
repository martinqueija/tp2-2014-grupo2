package fiuba.algo3.tp2;

public class Casa extends Construccion { //Casa es una instancia construible
	
	public boolean puedeConstruirEnSuperficie(Superficie superficieDelLote) {
		if (superficieDelLote.esTerrenoLLano()) {
			return true;	
		} else return false;
	}	

}
