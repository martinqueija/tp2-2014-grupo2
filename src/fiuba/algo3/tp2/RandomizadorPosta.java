package fiuba.algo3.tp2;
import java.util.Random;

public class RandomizadorPosta implements RandomizadorInterface {

	public int obtenerNumeroRandomCat(int rango) {
		Random randomGen = new Random();
		int NumeroRandom = randomGen.nextInt(rango);
		return NumeroRandom;
	}


	public int obtenerNumeroRandomX(int rango) {
		Random randomGen = new Random();
		int NumeroRandom = randomGen.nextInt(rango);
		return NumeroRandom;
	}

	public int obtenerNumeroRandomY(int rango) {
		Random randomGen = new Random();
		int NumeroRandom = randomGen.nextInt(rango);
		return NumeroRandom;
	}

}
