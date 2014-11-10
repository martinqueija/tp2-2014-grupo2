package fiuba.algo3.tp2;

public class Juego {
	Mapa elMapa = new Mapa();
	Caja laCaja = new Caja();
	Poblacion laPoblacion = new Poblacion();
	AdministradorCatastrofes adminCatastrofes = new AdministradorCatastrofes();
	
	public void iniciarJuego() {
		laPoblacion.agregarMapa(elMapa);
		int turnos = 0;
		
		while (laCaja.ObtenerSaldo()>0) {
			if (turnos>=30) {
				laCaja.RecoleccionImpuestosPorPoblacion(laPoblacion);
				turnos=0;
			}
			this.turnoJugador(elMapa, laCaja, laPoblacion);
			adminCatastrofes.actuar(elMapa);
			elMapa.actualizarMapa();
			turnos++;
		}
	}
	
	public void turnoJugador(Mapa elMapa, Caja laCaja, Poblacion laPoblacion){
		
	}

}
