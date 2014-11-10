package fiuba.algo3.tp2;

public class Juego {
	Mapa elMapa = new Mapa();
	Caja laCaja = new Caja();
	Poblacion laPoblacion = new Poblacion();
	
	public void iniciarJuego() {
		laPoblacion.agregarMapa(elMapa);
		int turnos = 0;
		
		while (laCaja.ObtenerSaldo()>0) {
			if (turnos>=30) {
				laCaja.RecoleccionImpuestosPorPoblacion(laPoblacion);
				turnos=0;
			}
			this.turnoJugador(elMapa, laCaja, laPoblacion);
			elMapa.actualizarMapa();
			turnos++;
		}
	}
	
	public void turnoJugador(Mapa elMapa, Caja laCaja, Poblacion laPoblacion){
		
	}

}
