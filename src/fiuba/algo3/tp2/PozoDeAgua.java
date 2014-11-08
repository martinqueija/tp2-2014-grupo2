package fiuba.algo3.tp2;

public class PozoDeAgua extends Construccion {
	
	private int coordenadaX;
	private int coordenadaY;
	
	public PozoDeAgua() {

	}

	public PozoDeAgua(int i, int j) {
		setCoordenadaX(i);
		setCoordenadaY(j);
	}

	public boolean puedeConstruirEnSuperficie(Superficie superficieDelLote) {
		if (superficieDelLote.esAgua()) {
			return true;	
		} else return false;
	}

	public int getCoordenadaX() {
		return coordenadaX;
	}

	public void setCoordenadaX(int coordenadaX) {
		this.coordenadaX = coordenadaX;
	}

	public int getCoordenadaY() {
		return coordenadaY;
	}

	public void setCoordenadaY(int coordenadaY) {
		this.coordenadaY = coordenadaY;
	}	

}
