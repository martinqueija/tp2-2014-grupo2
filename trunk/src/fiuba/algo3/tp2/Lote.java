package fiuba.algo3.tp2;

public class Lote {
	int consumoElectrico=0;
	boolean hayConstruccion = false; //variable booleana que define si el lote tiene algo construido o no.
	int coordX; // ubicacion del lote en el mapa
	int coordY;
	Superficie superficieDelLote;//agua o tierra
	private Construccion construccion;
	private LineaDeTension lineaDeTension;
	boolean TieneElectridadLote=false;
	private CentralElectrica centralElectrica;
	
	public void agregarLineaDeTension(LineaDeTension nuevaLineaDeTension){
		lineaDeTension=nuevaLineaDeTension;
		setElectricidadLote(nuevaLineaDeTension.getTieneElectricidad());
	}
	
	public void setElectricidadLote(boolean valor){
		TieneElectridadLote=valor;	
		
	}
	
	public boolean getTieneElectricidad(){
		return TieneElectridadLote;
		
	}
	
	public int getConsumoElectrico(){
		
		return consumoElectrico;
	}
	
	public void setConsumoElectrico(int consumo){
		consumoElectrico=consumo;
	}
	
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
		if (lineaDeTension!=null){
			lineaDeTension.decrementarVida(factor);
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

	public LineaDeTension getLineaDeTension() {
		return lineaDeTension;
	}

	public void setCentralElectricaQueAlmentaLote(CentralElectrica centraltemporal) {
		centralElectrica=centraltemporal;
		
	}
	public CentralElectrica getCentralElectrica(){
		return centralElectrica;
	}
}
