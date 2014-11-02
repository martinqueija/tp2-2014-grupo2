package fiuba.algo3.tp2;
import java.util.ArrayList;


public class Mapa {
	int tamanioLadoMapa = 12; //define la cantidad de lotes en un lado de la cuadrilla
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
	
	public boolean obtenerEstadoEn(int coordX, int coordY){
		Lote temp;
		temp = lotes.get(((coordX)*tamanioLadoMapa)+coordY);
		return (temp.obtenerEstado());
	}
	
	public void insertarConstruccionEn(int coordX, int coordY, Construccion unaConstruccion){
		Lote temp;
		temp = lotes.get(((coordX)*tamanioLadoMapa)+coordY);
		temp.insertarConstruccion(unaConstruccion);
	}
	
	public void daniarLote(int coordX, int coordY, int factor){
		Lote unLote;
		unLote = lotes.get(((coordX)*tamanioLadoMapa)+coordY);
		unLote.daniarConstruccion(factor);
	}
	
	public int obtenerVidaDeConstruccionEnLote(int coordX, int coordY){
		Lote unLote;
		unLote = lotes.get(((coordX)*tamanioLadoMapa)+coordY);
		return (unLote.obtenerVidaConstruccion());
	}
}
