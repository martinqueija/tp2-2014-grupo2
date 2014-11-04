package fiuba.algo3.tp2;

public class Lote {
	boolean estado = false; //variable booleana que define si el lote tiene algo construido o no.
	int coordX; // ubicacion del lote en el mapa
	int coordY;
	
	private Construccion construccion;
	
	public Lote(int coordenadaX,int coordenadaY){
		coordX = coordenadaX;
		coordY = coordenadaY;
	}
	
	public boolean obtenerEstado(){
		return estado;
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
		construccion=unaConstruccion;
		estado=true;
	}
}
