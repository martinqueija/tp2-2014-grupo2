package fiuba.algo3.tp2;
import java.util.ArrayList;


public class Mapa {
	int tamanioLadoMapa = 200; //define la cantidad de lotes en un lado de la cuadrilla
	ArrayList<Lote> lotes = new ArrayList<Lote>();
	RedElectrica redElectrica = new RedElectrica();
	RedDeAgua redDeAgua = new RedDeAgua();
	
	public Mapa(){
		redElectrica.agregarMapa(this);
		redDeAgua.agregarMpa(this);
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
	
	public void actualizarMapa(){
		redElectrica.actualizarRed();
		redDeAgua.actualizarRed();
	}
	
	public void agregarALaRedElectrica(CentralElectrica nuevaCentral){
		redElectrica.agregarCentralElectrica(nuevaCentral);
		
		this.insertarConstruccionEn(nuevaCentral.getPosicionX(),nuevaCentral.getPosicionY(),nuevaCentral);
	}
	
	public void agregarALaRedElectrica(LineaDeTension lineaDeTension){
		redElectrica.agregarLineaDeTension(lineaDeTension);
		Lote unLote;
		unLote = lotes.get(((lineaDeTension.getPosicionX())*tamanioLadoMapa)+lineaDeTension.getPosicionY());
		unLote.agregarLineaDeTension(lineaDeTension);
	}
	
	public int obtenerTamanioLado(){
		return tamanioLadoMapa;
	}
	
	public Lote obtenerLote(int x, int y){
		return lotes.get(((x)*tamanioLadoMapa)+y);
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
	
	
	public int getConsumoElecticoDeLote(int x, int y){
		Lote unLote;
		unLote = lotes.get(((x)*tamanioLadoMapa)+y);
		return unLote.getConsumoElectrico();
				
	}
	public boolean getTieneElecticidadLote(int x, int y){
		Lote unLote;
		unLote = lotes.get(((x)*tamanioLadoMapa)+y);
		return unLote.getTieneElectricidad();
		
	}
	public void setElectricidadLote(int x,int y, boolean valor){
		Lote unLote;
		unLote = lotes.get(((x)*tamanioLadoMapa)+y);
		unLote.setElectricidadLote(valor);
		
	}

	public void setCentralQueAlimentaLote(int x,int y,CentralElectrica centraltemporal) {
		Lote unLote;
		unLote = lotes.get(((x)*tamanioLadoMapa)+y);
		unLote.setCentralElectricaQueAlmentaLote(centraltemporal);
		
	}

	public void agregarALaRedDeAgua(PozoDeAgua pozo) {
		redDeAgua.agregarPozo(pozo);	
		this.insertarConstruccionEn(pozo.getCoordenadaX(),pozo.getCoordenadaY(),pozo);
	}

	public void agregarALaRedDeAgua(TuberiaDeAgua tuberia) {
		redDeAgua.agregarTuberia(tuberia);
		Lote unLote;
		unLote = lotes.get(((tuberia.getCoordenadaX())*tamanioLadoMapa)+tuberia.getCoordenadaY());
		unLote.agregarTuberiaDeAgua(tuberia);

		
	}

	public boolean getTieneAguaLote(int x, int y) {
		Lote unLote;
		unLote = lotes.get(((x)*tamanioLadoMapa)+y);
		return 	unLote.getTieneAgua();
	}
	public void setTieneAguaLote(int x, int y,boolean valor) {
		Lote unLote;
		unLote = lotes.get(((x)*tamanioLadoMapa)+y);
		unLote.setAgua(valor);

	}
}
