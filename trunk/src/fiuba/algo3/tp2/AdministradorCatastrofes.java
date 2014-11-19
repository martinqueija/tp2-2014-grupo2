package fiuba.algo3.tp2;

public class AdministradorCatastrofes {
	
	
	public void actuar(Mapa elMapa, RandomizadorInterface randomizer){
		int numRandom = randomizer.obtenerNumeroRandomCat(3);
		if (numRandom == 2) {
			Terremoto unTerremoto = new Terremoto();
			int xRand = randomizer.obtenerNumeroRandomX(elMapa.obtenerTamanioLado());
			int yRand = randomizer.obtenerNumeroRandomY(elMapa.obtenerTamanioLado());
			unTerremoto.iniciarTerremotoEn(xRand, yRand, elMapa);
		}
	}
	
	public int obtenerFactorTerremotos(){
		Terremoto terr = new Terremoto();
		return terr.obtenerFactor();
	}
}
