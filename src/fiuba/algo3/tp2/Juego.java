package fiuba.algo3.tp2;

public class Juego {
	Mapa elMapa = new Mapa();
	Caja laCaja = new Caja();
	AdministradorCatastrofes adminCatastrofes = new AdministradorCatastrofes();
	RandomizadorInterface randomizer = new RandomizadorPosta();
	
	public void iniciarJuego() {
		int turnos = 0;
		
		while (laCaja.ObtenerSaldo()>0) {
			if (turnos>=30) {
				laCaja.RecoleccionImpuestosPorPoblacion(elMapa.getCantidadPoblacion());
				turnos=0;
			}
			this.turnoJugador(elMapa, laCaja);
			adminCatastrofes.actuar(elMapa, randomizer);
			elMapa.actualizarMapa();
			turnos++;
		}
	}
	
	public void turnoJugador(Mapa elMapa, Caja laCaja){
		
	}

}
