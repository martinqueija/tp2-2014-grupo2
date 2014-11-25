package fiuba.algo3.tp2;

public class AdministradorCatastrofes {
	
	double DaniosAlotesDeUltimaCatastrofe[][];
	
	public boolean actuar(Mapa elMapa, RandomizadorInterface randomizer){
		boolean huboCatastrofe = false;
		int numRandom = randomizer.obtenerNumeroRandomCat(3);
		if (numRandom == -2) {
			huboCatastrofe = true;
			Terremoto unTerremoto = new Terremoto();
			int xRand = randomizer.obtenerNumeroRandomX(elMapa.obtenerTamanioLado());
			int yRand = randomizer.obtenerNumeroRandomY(elMapa.obtenerTamanioLado());
			DaniosAlotesDeUltimaCatastrofe = unTerremoto.iniciarTerremotoEn(xRand, yRand, elMapa);
		}
		if (numRandom == 1) {
			Godzilla nuevoGodzilla = new Godzilla();
			int ladoDeInicio = randomizer.obtenerNumeroRandomCat(4);
			int ladoDeFinalizacion = randomizer.obtenerNumeroRandomCat(4);
			int alturaDeInicio = randomizer.obtenerNumeroRandomCat(elMapa.obtenerTamanioLado());
			int alturaDeFinalizacion = randomizer.obtenerNumeroRandomCat(elMapa.obtenerTamanioLado());
			DaniosAlotesDeUltimaCatastrofe = nuevoGodzilla.iniciarGodzilla(ladoDeInicio,ladoDeFinalizacion,alturaDeInicio,alturaDeFinalizacion,elMapa);
			}

		return huboCatastrofe;
	}
	
	
	public int obtenerFactorTerremotos(){
		Terremoto terr = new Terremoto();
		return terr.obtenerFactor();
	}
	
	public double[][] getDaniosALotesDeUltimaCatastrofe(){
		return DaniosAlotesDeUltimaCatastrofe;
	}
}
