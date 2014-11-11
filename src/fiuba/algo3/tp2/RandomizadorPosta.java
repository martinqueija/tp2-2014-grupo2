package fiuba.algo3.tp2;
import java.util.Random;

public class RandomizadorPosta implements RandomizadorInterface {

	public int obtenerNumeroRandom(int rango) {
		Random randomGen = new Random();
		int NumeroRandom = randomGen.nextInt(rango);
		return NumeroRandom;
	}

	public void setNumeroMock(int numeroEntrada) {
	}

}
