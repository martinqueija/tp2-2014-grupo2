package fiuba.algo3.tp2;
public class Terremoto {
	
	static final int Factor = 20;

	public double[][] iniciarTerremotoEn(int coordX, int coordY,Mapa elMapa){
		int tamanioLadoMapa = elMapa.obtenerTamanioLado();
		double DaniosAlotes[][] = new double[tamanioLadoMapa][tamanioLadoMapa];
		int distancia=0;
		double factor;
		for (int i=0;i<tamanioLadoMapa;i++){
			for (int j=0;j<tamanioLadoMapa;j++){
				distancia = elMapa.calcularDistanciaEntreLotes(coordX, coordY, i, j);
				factor = ((100)-(distancia*Factor));
				if (factor<0) {factor=0;}
				elMapa.daniarConstruccionDelLote(i, j, factor);
				DaniosAlotes[i][j] = factor;
			}	
		}
		return DaniosAlotes;
	}
	
	public int obtenerFactor(){
		return Factor;
	}
}
