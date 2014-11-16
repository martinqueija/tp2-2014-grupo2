package fiuba.algo3.tp2;
import fiuba.algo3.tp2.Excepciones.*;

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

	
	public boolean getTieneAgua(){
		if(tuberia==null)
			return false;
		return tuberia.tieneAgua;
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
		construccion = null;
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
		if (construccion != null) { throw new ExcepcionLoteYaContieneConstruccion(); }
		else {
			if(unaConstruccion.puedeConstruirEnSuperficie(superficieDelLote)){
				construccion=unaConstruccion;
				hayConstruccion=true;	
			}
			else {
				throw new ExcepcionSuperficieInvalida();
			}
		}
	}
	
	public Superficie obtenerSuperficieDelLote(){
		return (superficieDelLote);
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


	public boolean getTieneTuberiaDeAgua() {
		if(tuberia!=null){
		return true;
		}
		return false;
	}


	public boolean getEsLaConstruccionUnaCasa() {
		if (construccion!=null){
			return construccion.esCasa();
		}
		return false;
	}


	public boolean getEsLaConstruccionUnaRuta() {
		if (construccion!=null){
			return construccion.esRuta();
		}
		return false;
	}
}
