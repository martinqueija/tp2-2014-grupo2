package fiuba.algo3.tp2;

public class RandomizadorMock implements RandomizadorInterface {
	
	int numeroMockCat=0;
	int numeroMockX=0;
	int numeroMockY=0;
	

	public int obtenerNumeroRandomCat(int rango) {
		return numeroMockCat;
	}

	public void setNumeroMockCat(int numeroEntrada) {
		numeroMockCat = numeroEntrada;
	}

	public int obtenerNumeroRandomX(int rango) {
		return numeroMockX;
	}

	public void setNumeroMockX(int numeroEntrada) {
		numeroMockX = numeroEntrada;
	}

	public int obtenerNumeroRandomY(int rango) {
		return numeroMockY;
	}

	public void setNumeroMockY(int numeroEntrada) {
		numeroMockY = numeroEntrada;
	}

	
}
