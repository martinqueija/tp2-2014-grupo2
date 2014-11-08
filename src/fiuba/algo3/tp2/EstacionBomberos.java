package fiuba.algo3.tp2;

public class EstacionBomberos extends Construccion {
	
	public void repararMapa(Mapa unMapa){
		Lote LoteTemp;
		for (int i=0;i<unMapa.obtenerTamanioLado();i++){
			for (int j=0;j<unMapa.obtenerTamanioLado();j++){
				LoteTemp=unMapa.obtenerLote(i, j);
				LoteTemp.reparacionBomberos();
			}
		}
	}
	
	public void reparacionBomberos(){
		double vidaActual = this.obtenerVida();
		double factorReparacion = ((vidaActual/100)*20); //repara el 20% de una estacion de bomberos
		this.incrementarVida(factorReparacion);
	}

}
