package fiuba.algo3.tp2;

public class Lote {
	boolean hayConstruccion = false; //variable booleana que define si el lote tiene algo construido o no.
	int coordX; // ubicacion del lote en el mapa
	int coordY;
	Superficie superficieDelLote;
	private Construccion construccion;
	
	public Lote(int coordenadaX,int coordenadaY){
		coordX = coordenadaX;
		coordY = coordenadaY;
	}
	
	public boolean hayConstruccion(){
		return hayConstruccion;
	}
	
	public int obtenerCoordX(){
		return coordX;
	}
	
	public int obtenerCoordY(){
		return coordY;
	}
	
	public void daniarConstruccion(double factor){
		if (construccion!=null){
			construccion.decrementarVida(factor);
		}
	}
	
	public double obtenerVidaConstruccion(){
		if (construccion!=null){
			return (construccion.obtenerVida());
		} else return 0;
			
	}
	
	public void insertarConstruccion(Construccion unaConstruccion){
		if(unaConstruccion.puedeConstruirEnSuperficie(superficieDelLote)){
			construccion=unaConstruccion;
			hayConstruccion=true;	
		}
		else {
			//excepcion
		}
	}

	public void definirTerrerno(Superficie superficieRecibida) {
		superficieDelLote = superficieRecibida;
		
	}
}
