package fiuba.algo3.tp2;
import java.util.ArrayList;


public class Mapa {
	int tamanioLadoMapa = 200; //define la cantidad de lotes en un lado de la cuadrilla
	ArrayList<Lote> lotes = new ArrayList<Lote>();
	
	public Mapa(){
		Lote temp;
		for (int i=0;i<tamanioLadoMapa;i++){
			for (int j=0;j<tamanioLadoMapa;j++){
				temp = new Lote(i,j);
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
		return (temp.obtenerEstado());
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
}
