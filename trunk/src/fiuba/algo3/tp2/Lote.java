package fiuba.algo3.tp2;

public class Lote {

	private Superficie superficieDelLote;//agua o tierra
	private Construccion construccion;
	private LineaDeTension lineaDeTension;
	private CentralElectrica centralElectrica;
	private TuberiaDeAgua tuberia;

	private int consumoElectrico=0;
	private boolean hayConstruccion = false; //variable booleana que define si el lote tiene algo construido o no.
	private int coordX; // ubicacion del lote en el mapa
	private int coordY;
	private boolean tieneElectridadLote=false;
	private boolean tieneAguaLote=false;

	
	public boolean getTieneAgua(){
			return tieneAguaLote;
	}
	
	public void setAgua(boolean valor){
		tieneAguaLote=valor;
	}
	
	public void agregarTuberiaDeAgua(TuberiaDeAgua nuevaTuberia){
		tuberia=nuevaTuberia;
	}
	
	public void agregarLineaDeTension(LineaDeTension nuevaLineaDeTension){
		lineaDeTension=nuevaLineaDeTension;
		setElectricidadLote(nuevaLineaDeTension.getTieneElectricidad());
	}
	
	public void setElectricidadLote(boolean valor){
		tieneElectridadLote=valor;	
		
	}
	
	public boolean getTieneElectricidad(){
		return tieneElectridadLote;
		
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
	
	public void reparacionBomberos(){
		if (construccion!=null){
			construccion.reparacionBomberos();
		}
	}
}
