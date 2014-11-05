package fiuba.algo3.tp2;
public class Terremoto {
	

	public void iniciarTerremotoEn(int coordX, int coordY,Mapa elMapa){
		int tamanioLadoMapa = elMapa.obtenerTamanioLado();
		int distancia=0;
		double factor;
		for (int i=0;i<tamanioLadoMapa;i++){
			for (int j=0;j<tamanioLadoMapa;j++){
				distancia = elMapa.calcularDistanciaEntreLotes(coordX, coordY, i, j);
				factor = ((100)-(distancia*1.5));
				if (factor<0) {factor=0;}
				elMapa.daniarConstruccionDelLote(i, j, factor);
			}	
		}
	}
}
