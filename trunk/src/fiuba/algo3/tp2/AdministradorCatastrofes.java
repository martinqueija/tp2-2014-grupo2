package fiuba.algo3.tp2;

public class AdministradorCatastrofes {
	
	public void actuar(Mapa elMapa, RandomizadorInterface randomizer){
		int numRandom = randomizer.obtenerNumeroRandom(100);
		if ((numRandom == 17)||(numRandom == 78)) {
			Terremoto unTerremoto = new Terremoto();
			int xRand = randomizer.obtenerNumeroRandom(elMapa.obtenerTamanioLado());
			int yRand = randomizer.obtenerNumeroRandom(elMapa.obtenerTamanioLado());
			unTerremoto.iniciarTerremotoEn(xRand, yRand, elMapa);
		}
	}
}
