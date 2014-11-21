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
		if (numRandom == 1) {
			Godzilla nuevoGodzilla = new Godzilla();
			int ladoDeInicio = randomizer.obtenerNumeroRandomCat(4);
			int ladoDeFinalizacion = randomizer.obtenerNumeroRandomCat(4);
			int alturaDeInicio = randomizer.obtenerNumeroRandomCat(elMapa.obtenerTamanioLado());
			int alturaDeFinalizacion = randomizer.obtenerNumeroRandomCat(elMapa.obtenerTamanioLado());
			nuevoGodzilla.iniciarGodzilla(ladoDeInicio,ladoDeFinalizacion,alturaDeInicio,alturaDeFinalizacion,elMapa);
			}


	}
	
	
	public int obtenerFactorTerremotos(){
		Terremoto terr = new Terremoto();
		return terr.obtenerFactor();
	}
}
