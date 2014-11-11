package fiuba.algo3.tp2;

public class RandomizadorMock implements RandomizadorInterface {
	
	int numeroMock=0;

	public int obtenerNumeroRandom(int rango) {
		return numeroMock;
	}

	public void setNumeroMock(int numeroEntrada) {
		numeroMock = numeroEntrada;
	}
	
	
}
