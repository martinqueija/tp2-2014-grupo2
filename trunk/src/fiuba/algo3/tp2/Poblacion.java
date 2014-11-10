package fiuba.algo3.tp2;

public class Poblacion {
	
	Mapa mapa;
	int poblacionTotal=0;
	
	public void agregarMapa(Mapa nuevoMapa) {
		mapa = nuevoMapa;	
	}

	public void agregarPoblacion(int valor){
		poblacionTotal = poblacionTotal + valor;
	}
	
	public int getCantidadPoblacion(){
		return poblacionTotal;
	}
	
	public void actualizar(){
		poblacionTotal = 0;
		for(int i=0; i < mapa.obtenerTamanioLado(); i++){
			for(int j=0; j < mapa.obtenerTamanioLado(); j++){
				if(mapa.getTieneCasaElLote(i,j)){
					if(mapa.getTieneAguaLote(i, j)){
						if(mapa.getTieneElecticidadLote(i, j)){
							if(this.tieneRutaAdyacente(i,j)){
								this.agregarPoblacion(100);
							}
						}
					}
				}
			}
		}
		
	}

	private boolean tieneRutaAdyacente(int i, int j) {
		if(mapa.getTieneRutaElLote(i-1,j)){
			return true;
		}
		if(mapa.getTieneRutaElLote(i+1,j)){
			return true;
		}
		if(mapa.getTieneRutaElLote(i,j-1)){
			return true;
		}
		if(mapa.getTieneRutaElLote(i,j+1)){
			return true;
		}
		return false;
	}
	
}
