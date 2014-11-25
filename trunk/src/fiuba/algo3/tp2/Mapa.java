package fiuba.algo3.tp2;
import java.util.ArrayList;
import fiuba.algo3.tp2.Excepciones.*;


public class Mapa {
	int tamanioLadoMapa;; //define la cantidad de lotes en un lado del mapa
	ArrayList<Lote> lotes = new ArrayList<Lote>();
	RedElectrica redElectrica = new RedElectrica();
	RedDeAgua redDeAgua = new RedDeAgua();
	Poblacion poblacion = new Poblacion();
	RedDeEmpleo redDeEmpleo = new RedDeEmpleo();
	RedDeBomberos redDeBomberos = new RedDeBomberos();
	
	
	public Mapa(int tamLadoMapa){
		tamanioLadoMapa = tamLadoMapa;
		redElectrica.agregarMapa(this);
		redDeAgua.agregarMapa(this);
		poblacion.agregarMapa(this);
		redDeEmpleo.agregarMapa(this);
		redDeBomberos.agregarMapa(this);
		TerrenoLLano terrenoLlano = new TerrenoLLano();
		Agua agua = new Agua();
		Lote loteTemp;
		int var = (int)tamanioLadoMapa*3/5;
		
		for (int i=0;i<tamanioLadoMapa;i++){
			for (int j=0;j<tamanioLadoMapa;j++){
				loteTemp = new Lote(i,j);
				
				if (j<var) {
					loteTemp.definirTerrerno(terrenoLlano);
				} else {
					if ((i+j)>2*var){
						loteTemp.definirTerrerno(agua);
					} else {
						loteTemp.definirTerrerno(terrenoLlano);
					}
				}				
				lotes.add(loteTemp);
			}	
		}
	}
	
	public void actualizarMapa(){
		this.removerConstruccionesSinVida();
		redElectrica.actualizarRed();
		redDeAgua.actualizarRed();
		poblacion.actualizar();
		redDeEmpleo.actualizar();
	}
	
	public void removerConstruccionesSinVida(){
		Lote loteTemp;
		for (int i=0;i<tamanioLadoMapa;i++){
			for (int j=0;j<tamanioLadoMapa;j++){
				loteTemp = this.obtenerLote(i, j);
				if (loteTemp.hayConstruccion()){
					if ((loteTemp.obtenerVidaConstruccion())<=0) {
						loteTemp.eliminarConstruccion();
					}
				}
				if(loteTemp.getTieneLineaDeTension()){
					if(loteTemp.obtenerVidaLineaDeTension()<=0){
						loteTemp.eliminarLineaDeTension();
					}
				}
			}
		}
	}
		
	public void agregarALaRedDeBomberos(EstacionBomberos bomberos, int x, int y){
		if (!(this.sonCoordendadasValidas(x, y))) {throw new ExcepcionCoordenadasInvalidas();}
		else {	
				boolean lanzo = false;
				try {
					this.insertarConstruccionEn(x, y, bomberos);
				} catch (ExcepcionLoteYaContieneConstruccion e){
					lanzo = true;
					throw new ExcepcionLoteYaContieneConstruccion();
				}
				if (!lanzo){
					redDeBomberos.agregarEstacionBomberos(bomberos);
				}
			}
	}
	
	public void agregarALaRedElectrica(CentralElectrica nuevaCentral){
		if (!(this.sonCoordendadasValidas(nuevaCentral.getPosicionX(), nuevaCentral.getPosicionY()))) {throw new ExcepcionCoordenadasInvalidas();}
		else {
				boolean lanzo = false;
				try {
					this.insertarConstruccionEn(nuevaCentral.getPosicionX(),nuevaCentral.getPosicionY(),nuevaCentral);
				} catch (ExcepcionLoteYaContieneConstruccion e){
					lanzo = true;
					throw new ExcepcionLoteYaContieneConstruccion();
				}
				if (!lanzo) {
					redElectrica.agregarCentralElectrica(nuevaCentral);
				}
			}
	}
	
	public void agregarALaRedElectrica(LineaDeTension lineaDeTension){
		if (!(this.sonCoordendadasValidas(lineaDeTension.getPosicionX(), lineaDeTension.getPosicionY()))) {throw new ExcepcionCoordenadasInvalidas();}
		else {
				boolean lanzo = false;
				Lote unLote;
				unLote = lotes.get(((lineaDeTension.getPosicionX())*tamanioLadoMapa)+lineaDeTension.getPosicionY());
				try {
					unLote.agregarLineaDeTension(lineaDeTension);
				} catch (ExcepcionLoteYaContieneLineaDeTension e){
					lanzo = true;
					throw new ExcepcionLoteYaContieneConstruccion();
				}
				if (!lanzo){
					redElectrica.agregarLineaDeTension(lineaDeTension);
				}
			}
	}
	
	public int obtenerTamanioLado(){
		return tamanioLadoMapa;
	}
	
	public void reparacionBomberos(){
		redDeBomberos.repararMapa();
	}
	
	public Lote obtenerLote(int x, int y){
		if (!(this.sonCoordendadasValidas(x, y))) {throw new ExcepcionCoordenadasInvalidas();}
		else {
				return lotes.get(((x)*tamanioLadoMapa)+y);
		}
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
		if (!(this.sonCoordendadasValidas(coordX, coordY))) {throw new ExcepcionCoordenadasInvalidas();}
		else {
				Lote temp;
				temp = lotes.get(((coordX)*tamanioLadoMapa)+coordY); //esa formula busca el lote determinado en el arreglo continuo de lotes. es facil de entender
				return (temp.hayConstruccion());
			}
	}
	
	public void insertarConstruccionEn(int coordX, int coordY, Construccion unaConstruccion){
		Lote temp;
		if (!(this.sonCoordendadasValidas(coordX, coordY))) {throw new ExcepcionCoordenadasInvalidas();}
		else {
				temp = lotes.get(((coordX)*tamanioLadoMapa)+coordY);
				temp.insertarConstruccion(unaConstruccion);
			}
	}
	
	public void daniarConstruccionDelLote(int coordX, int coordY, double factor){
		if (!(this.sonCoordendadasValidas(coordX, coordY))) {throw new ExcepcionCoordenadasInvalidas();}
		else {
				Lote unLote;
				unLote = lotes.get(((coordX)*tamanioLadoMapa)+coordY);
				unLote.daniarConstruccion(factor);
			}
	}
		
	public double obtenerVidaDeConstruccionEnLote(int coordX, int coordY){
		if (!(this.sonCoordendadasValidas(coordX, coordY))) {throw new ExcepcionCoordenadasInvalidas();}
		else {
				Lote unLote;
				unLote = lotes.get(((coordX)*tamanioLadoMapa)+coordY);
				return (unLote.obtenerVidaConstruccion());
			}
	}
		
	public int getConsumoElecticoDeLote(int x, int y){
		if (!(this.sonCoordendadasValidas(x, y))) {throw new ExcepcionCoordenadasInvalidas();}
		else {
				Lote unLote;
				unLote = lotes.get(((x)*tamanioLadoMapa)+y);
				return unLote.getConsumoElectrico();
			}
				
	}
	
	public boolean getTieneElecticidadLote(int x, int y){
		if (!(this.sonCoordendadasValidas(x, y))) {throw new ExcepcionCoordenadasInvalidas();}
		else {
				Lote unLote;
				unLote = lotes.get(((x)*tamanioLadoMapa)+y);
				return unLote.getTieneElectricidad();
			}
		
	}
	
	public void setElectricidadLote(int x,int y, boolean valor){
		if (!(this.sonCoordendadasValidas(x, y))) {throw new ExcepcionCoordenadasInvalidas();}
		else {
				Lote unLote;
				unLote = lotes.get(((x)*tamanioLadoMapa)+y);
				unLote.setElectricidadLote(valor);
			}
		
	}

	public void setCentralQueAlimentaLote(int x,int y,CentralElectrica centraltemporal) {
		if (!(this.sonCoordendadasValidas(x, y))) {throw new ExcepcionCoordenadasInvalidas();}
		else {
				Lote unLote;
				unLote = lotes.get(((x)*tamanioLadoMapa)+y);
				unLote.setCentralElectricaQueAlmentaLote(centraltemporal);
		}
		
	}

	public void agregarALaRedDeAgua(PozoDeAgua pozo) {
		if (!(this.sonCoordendadasValidas(pozo.getCoordenadaX(), pozo.getCoordenadaY()))) {throw new ExcepcionCoordenadasInvalidas();}
		else {
				redDeAgua.agregarPozo(pozo);	
				this.insertarConstruccionEn(pozo.getCoordenadaX(),pozo.getCoordenadaY(),pozo);
		}
	}

	public void agregarALaRedDeAgua(TuberiaDeAgua tuberia) {
		if (!(this.sonCoordendadasValidas(tuberia.getCoordenadaX(), tuberia.getCoordenadaY()))) {throw new ExcepcionCoordenadasInvalidas();}
		else {
				Lote unLote;
				boolean lanzo = false;
				unLote = lotes.get(((tuberia.getCoordenadaX())*tamanioLadoMapa)+tuberia.getCoordenadaY());
				try {
					unLote.agregarTuberiaDeAgua(tuberia);
				} catch (ExcepcionLoteYaContieneTuberia e){
					lanzo = true;
					throw new ExcepcionLoteYaContieneTuberia();
				}
				if (!lanzo) {
					redDeAgua.agregarTuberia(tuberia);
				}
		}
	}

	public boolean getTieneAguaLote(int x, int y) {
		if (!(this.sonCoordendadasValidas(x, y))) {throw new ExcepcionCoordenadasInvalidas();}
		else {
				Lote unLote;
				unLote = lotes.get(((x)*tamanioLadoMapa)+y);
				return 	unLote.getTieneAgua();
			}
	}
	
	public void setSuperficieLote(int x, int y,Superficie terrerno){
		if (!(this.sonCoordendadasValidas(x, y))) {throw new ExcepcionCoordenadasInvalidas();}
		else {
				Lote unLote;
				unLote = lotes.get(((x)*tamanioLadoMapa)+y);
				unLote.definirTerrerno(terrerno);
			}
	}

	public boolean getTieneLoteTuberiaDeAgua(int x, int y) {
		if (!(this.sonCoordendadasValidas(x, y))) {throw new ExcepcionCoordenadasInvalidas();}
		else {
				Lote unLote;
				unLote = lotes.get(((x)*tamanioLadoMapa)+y);
				return unLote.getTieneTuberiaDeAgua();
			}
	}

	public boolean getTieneCasaElLote(int i, int j) {
		if (!(this.sonCoordendadasValidas(i, j))) {throw new ExcepcionCoordenadasInvalidas();}
		else {
				Lote unLote;
				unLote = lotes.get(((i)*tamanioLadoMapa)+j);
				return unLote.getEsLaConstruccionUnaCasa();
			}
	}

	public boolean getTieneRutaElLote(int i, int j) {
		if (!(this.sonCoordendadasValidas(i, j))) {throw new ExcepcionCoordenadasInvalidas();}
		else {
				Lote unLote;
				unLote = lotes.get(((i)*tamanioLadoMapa)+j);
				return unLote.getEsLaConstruccionUnaRuta();
			}

	}

	private boolean sonCoordendadasValidas(int i, int j) {
		if(i<0){
			return false;
		}
		if(j<0){
			return false;
		}
		
		if(i>=this.tamanioLadoMapa){
			return false;
		}
		if(i>=this.tamanioLadoMapa){
			return false;
		}
		return true;
	}

	public int getCantidadPoblacion() {
		return poblacion.getCantidadPoblacion();
	}

	public int getCantidadEmpleosDisponibles() {

		return redDeEmpleo.getCantidadDeEmpleos();
	}

	public boolean getTieneComercioLote(int i, int j) {
		if (!(this.sonCoordendadasValidas(i, j))) {throw new ExcepcionCoordenadasInvalidas();}
		else {
				Lote unLote;
				unLote = lotes.get(((i)*tamanioLadoMapa)+j);
				return unLote.getEsLaConstruccionUnComercio();
			}
	}

	public boolean getTieneIndustriaLote(int i, int j) {
		if (!(this.sonCoordendadasValidas(i, j))) {throw new ExcepcionCoordenadasInvalidas();}
		else {
				Lote unLote;
				unLote = lotes.get(((i)*tamanioLadoMapa)+j);
				return unLote.getEsLaConstruccionUnaIndustria();
			}
	}

	public double obtenerVidaLineaDeTensionDelLote(int i, int j) {
		if (!(this.sonCoordendadasValidas(i, j))) {throw new ExcepcionCoordenadasInvalidas();}
		else {
				Lote unLote;
				unLote = lotes.get(((i)*tamanioLadoMapa)+j);
				return unLote.getVidaLineaDeTension();
			}
	}

	public void daniarConstruccioPorGodzilla(int i,int j) {
		if (!(this.sonCoordendadasValidas(i, j))) {throw new ExcepcionCoordenadasInvalidas();}
		else {
				Lote unLote;
				unLote = lotes.get(((i)*tamanioLadoMapa)+j);
				unLote.daniarConstruccionPorGodzilla();
			}
		
	}
	
	public boolean LoteEsDeAgua(int i, int j){
		if (!(this.sonCoordendadasValidas(i, j))) {throw new ExcepcionCoordenadasInvalidas();}
		else {
				Lote unLote;
				unLote = this.obtenerLote(i, j);
				if (unLote.esLoteDeAgua()) return true;
			}
		return false;
	}
	
	public boolean LoteEsDeTierra(int i, int j){
		if (!(this.sonCoordendadasValidas(i, j))) {throw new ExcepcionCoordenadasInvalidas();}
		else {
				Lote unLote;
				unLote = this.obtenerLote(i, j);
				if (unLote.esLoteDeTierra()) return true;
			}
		return false;
	}
	
	public EnumeradoDeLote DameEnumeradoDelLote(int i, int j){
		if (!(this.sonCoordendadasValidas(i, j))) {throw new ExcepcionCoordenadasInvalidas();}
		else {
				Lote loteTemp = this.obtenerLote(i, j);
				return (loteTemp.obtenerEnumerado());
		}
	}

	
	public boolean LoteTieneConstruccion(int i, int j) {
		Lote loteTemp = this.obtenerLote(i, j);
		if (loteTemp.hayConstruccion()) {
			return true;
		}
		return false;
	}

	
	public boolean getTieneLineaDeTensionLote(int i, int j) {
		Lote loteTemp = this.obtenerLote(i, j);
		if (loteTemp.getTieneLineaDeTension()) {
			return true;
		}
		return false;
	}

	public boolean getTieneTuberiaLote(int i, int j) {		
		Lote loteTemp = this.obtenerLote(i, j);
		if (loteTemp.getTieneTuberiaDeAgua()) {
			return true;
		}
		return false;
	}
	
	public boolean loteTieneComercioCercano(int distanciaMax, int x, int y){
		int distanciaTemp=0;
		for (int i=0;i<tamanioLadoMapa;i++){
			for (int j=0;j<tamanioLadoMapa;j++){
				distanciaTemp = calcularDistanciaEntreLotes(x, y, i, j);
				if (distanciaTemp<=distanciaMax){
					if (getTieneComercioLote(i,j)){
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public boolean loteTieneIndustriaCercano(int distanciaMax, int x, int y){
		int distanciaTemp=0;
		for (int i=0;i<tamanioLadoMapa;i++){
			for (int j=0;j<tamanioLadoMapa;j++){
				distanciaTemp = calcularDistanciaEntreLotes(x, y, i, j);
				if (distanciaTemp<=distanciaMax){
					if (getTieneIndustriaLote(i,j)){
						return true;
					}
				}
			}
		}
		return false;
	}
}



