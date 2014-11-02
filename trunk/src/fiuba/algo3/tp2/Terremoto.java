package fiuba.algo3.tp2;
import java.lang.Math;
public class Terremoto {
	
	private int calcularDistanciaEntreLotes(int x1, int y1, int x2, int y2){
		int diferenciaX;
		int diferenciaY;
		if (x1>x2) { diferenciaX = x1-x2; } else { diferenciaX = x2-x1; };
		if (y1>y2) { diferenciaY = y1-y2; } else { diferenciaY = y2-y1; };
		
		diferenciaX = (diferenciaX)*(diferenciaX);
		diferenciaY = (diferenciaY)*(diferenciaY);
		
		double sumaCuadrados = diferenciaX + diferenciaY;
		int distancia = (int) Math.sqrt(sumaCuadrados);
		
		return distancia;
	}
	
	public void iniciarTerremotoEn(int coordX, int coordY,Mapa elMapa){
		int tamanioLadoMapa = elMapa.obtenerTamanioLado();
		int distancia=0;
		double factor;
		for (int i=0;i<tamanioLadoMapa;i++){
			for (int j=0;j<tamanioLadoMapa;j++){
				distancia = calcularDistanciaEntreLotes(coordX, coordY, i, j);
				factor = ((100)-(distancia*1.5));
				elMapa.daniarConstruccionDelLote(i, j, factor);
			}	
		}
	}
}
