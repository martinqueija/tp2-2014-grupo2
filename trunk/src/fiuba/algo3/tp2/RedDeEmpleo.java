package fiuba.algo3.tp2;

public class RedDeEmpleo {
	
	int empleos;
	
	Mapa mapa;

	public int getCantidadDeEmpleos() {
		return empleos;
	}
	
	public void actualizar(){
		this.setEmpelosCero();
		for(int i=0; i < mapa.obtenerTamanioLado(); i++){
			for(int j=0; j < mapa.obtenerTamanioLado(); j++){
				if(mapa.getTieneComercioLote(i,j)){
					if(mapa.getTieneAguaLote(i, j)){
						if(mapa.getTieneElecticidadLote(i, j)){
							if(this.tieneRutaAdyacente(i,j)){
								this.agregarEmpelos(12);
							}
						}
					}
				}
				if(mapa.getTieneIndustriaLote(i,j)){
					if(mapa.getTieneElecticidadLote(i, j)){
						if(this.tieneRutaAdyacente(i,j)){
							this.agregarEmpelos(25);
						}
					}
				}
			}
		}
		
	}

	private void agregarEmpelos(int i) {
		empleos=empleos+i;	
	}
	private void setEmpelosCero() {
		empleos=0;
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
	public void agregarMapa(Mapa nuevoMapa) {
		mapa=nuevoMapa;
	}

}
