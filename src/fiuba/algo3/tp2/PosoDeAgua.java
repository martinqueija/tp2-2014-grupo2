package fiuba.algo3.tp2;

public class PosoDeAgua extends Construccion {
	
	public boolean puedeConstruirEnSuperficie(Superficie superficieDelLote) {
		if (superficieDelLote.esAgua()) {
			return true;	
		} else return false;
	}	

}
