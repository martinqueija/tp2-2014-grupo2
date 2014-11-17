package fiuba.algo3.tp2;

import java.util.ArrayList;

public class RedDeAgua {
	
	ArrayList <PozoDeAgua> pozosDeAgua = new ArrayList<PozoDeAgua>();
	ArrayList <TuberiaDeAgua> tuberiasDeAgua = new ArrayList <TuberiaDeAgua>();

	private Mapa mapa;

	public void agregarPozo(PozoDeAgua pozo) {
		pozosDeAgua.add(pozo);
		this.actualizarRed();
		
	}

	private void actualizarPozos(){
		PozoDeAgua pozo;
		for(int i=0;i<pozosDeAgua.size();i++){
			pozo=pozosDeAgua.get(i);
			if(pozo.vida<=0){
				pozosDeAgua.remove(pozo);

			}
		}
		
	}
	public void actualizarRed() {
	
		PozoDeAgua pozoTem;
		TuberiaDeAgua tuberiaTem;
		this.actualizarPozos();
		if(pozosDeAgua.isEmpty()==false){
			for(int i=0; i<pozosDeAgua.size(); i++){
				pozoTem=pozosDeAgua.get(i);
				for(int j=0; j < tuberiasDeAgua.size(); j++){
					tuberiaTem=tuberiasDeAgua.get(j);
					if(pozoTem.getCoordenadaX()==tuberiaTem.getCoordenadaX()){
						if(pozoTem.getCoordenadaY()==tuberiaTem.getCoordenadaY()){
							tuberiaTem.setAgua(true);
						}
					}
				}
			}
		this.actualizarTuberiasDeAgua();
		}
		else{
			for(int j=0; j < tuberiasDeAgua.size(); j++){
				tuberiaTem=tuberiasDeAgua.get(j);
				tuberiaTem.setAgua(false);
			}
		}
		
	}

	private void actualizarTuberiasDeAgua() {
		TuberiaDeAgua tuberiaTem;
		for(int i=0; i< tuberiasDeAgua.size();i++){
			tuberiaTem=tuberiasDeAgua.get(i);
			if(tuberiaTem.tieneAgua()==false){
				if(existeTuberiaAdyacenteConAgua(tuberiaTem)){
					tuberiaTem.setAgua(true);	
					actualizarTuberiasDeAgua();
				}
			}
		}		
	}

	private boolean existeTuberiaAdyacenteConAgua(TuberiaDeAgua tuberiaTem) {
		TuberiaDeAgua tuberia;
		int distancia;
		for(int i=0; i< tuberiasDeAgua.size();i++){
			tuberia=tuberiasDeAgua.get(i);
			distancia=mapa.calcularDistanciaEntreLotes(tuberiaTem.getCoordenadaX(), tuberiaTem.getCoordenadaY(), tuberia.getCoordenadaX(),tuberia.getCoordenadaY());
			if(distancia<2){
				if(tuberia.tieneAgua){
				return true;
				}
			}
		}
		return false;
	}



	public void agregarMapa(Mapa nuevoMapa) {
		mapa = nuevoMapa;
		
	}

	public void agregarTuberia(TuberiaDeAgua tuberia) {
		tuberiasDeAgua.add(tuberia);
		this.actualizarRed();
		
	}

}
