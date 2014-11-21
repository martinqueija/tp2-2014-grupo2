package fiuba.algo3.tp2;

import java.util.ArrayList;

public class RedDeBomberos {
	Mapa mapa;
	ArrayList <EstacionBomberos> estacionesDeBomberos = new ArrayList<EstacionBomberos>();

	public void agregarMapa(Mapa newMapa) {
		mapa=newMapa;
		
	}

	public void actualizar() {
		EstacionBomberos bomberosTem;
		for(int i=0; i<estacionesDeBomberos.size(); i++){
			bomberosTem=estacionesDeBomberos.get(i);
			if(bomberosTem.obtenerVida()<=0){
				estacionesDeBomberos.remove(bomberosTem);
			}
		}	
	}

	public void agregarEstacionBomberos(EstacionBomberos bomberos) {
		estacionesDeBomberos.add(bomberos);
		
	}

	public void repararMapa() {
		this.actualizar();
		EstacionBomberos bomberosTem;
		for(int i=0; i<estacionesDeBomberos.size(); i++){
			bomberosTem=estacionesDeBomberos.get(i);
			bomberosTem.repararMapa(mapa);
		}
		
	}

}
