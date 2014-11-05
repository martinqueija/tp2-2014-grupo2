package fiuba.algo3.tp2;
import java.util.ArrayList;


public class Mapa {
	int tamanioLadoMapa = 200; //define la cantidad de lotes en un lado de la cuadrilla
	ArrayList<Lote> lotes = new ArrayList<Lote>();

	public Mapa(){
		TerrenoLLano terreno = new TerrenoLLano();
		Lote temp;
		for (int i=0;i<tamanioLadoMapa;i++){
			for (int j=0;j<tamanioLadoMapa;j++){
				temp = new Lote(i,j);
				temp.definirTerrerno(terreno);  //provisorio implementar algoritmo mapa
				lotes.add(temp);
			}	
		}
	}
	
	public int obtenerTamanioLado(){
		return tamanioLadoMapa;
	}
	
	public boolean obtenerEstadoDelLoteEn(int coordX, int coordY){
		Lote temp;
		temp = lotes.get(((coordX)*tamanioLadoMapa)+coordY); //esa formula busca el lote determinado en el arreglo continuo de lotes. es facil de entender
		return (temp.hayConstruccion());
	}
	
	public void insertarConstruccionEn(int coordX, int coordY, Construccion unaConstruccion){
		Lote temp;
		temp = lotes.get(((coordX)*tamanioLadoMapa)+coordY);
		temp.insertarConstruccion(unaConstruccion);
	}
	
	public void daniarConstruccionDelLote(int coordX, int coordY, double factor){
		Lote unLote;
		unLote = lotes.get(((coordX)*tamanioLadoMapa)+coordY);
		unLote.daniarConstruccion(factor);
	}
	
	public double obtenerVidaDeConstruccionEnLote(int coordX, int coordY){
		Lote unLote;
		unLote = lotes.get(((coordX)*tamanioLadoMapa)+coordY);
		return (unLote.obtenerVidaConstruccion());
	}
	
	public int calcularDistanciaEntreLotes(int x1, int y1, int x2, int y2){
		int diferenciaX;
		int diferenciaY;
		if (x1>x2) { diferenciaX = x1-x2; } else { diferenciaX = x2-x1; };
		if (y1>y2) { diferenciaY = y1-y2; } else { diferenciaY = y2-y1; };
		
		int diferenciaX2 = (diferenciaX)*(diferenciaX);
		int diferenciaY2 = (diferenciaY)*(diferenciaY);
		
		double sumaCuadrados = diferenciaX2 + diferenciaY2;
		int distancia = (int) Math.sqrt(sumaCuadrados);
		
		return distancia;
	}
	
}
