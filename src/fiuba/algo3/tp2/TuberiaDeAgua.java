package fiuba.algo3.tp2;

public class TuberiaDeAgua {
	
	boolean tieneAgua = false;
	private int coordenadaX;
	private int coordenadaY;
	
	public TuberiaDeAgua() {

	}
	
	public void setAgua(boolean valor){
		tieneAgua=valor;
	}

	public TuberiaDeAgua(int i, int j) {
		setCoordenadaX(i);
		setCoordenadaY(j);
	}

	public boolean tieneAgua() {
		return tieneAgua;
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
