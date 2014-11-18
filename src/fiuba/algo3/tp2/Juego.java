package fiuba.algo3.tp2;

public class Juego {
	public Mapa elMapa;
	public Caja laCaja = new Caja();
	AdministradorCatastrofes adminCatastrofes = new AdministradorCatastrofes();
	RandomizadorInterface randomizer = new RandomizadorPosta();
	
	
	public Juego(int tamLadoMapa){
		elMapa = new Mapa(tamLadoMapa);
	}
	
	/*
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
	}*/
	
	public void turnoJugador(Mapa elMapa, Caja laCaja){
		
	}

	public void ComprarCasaEnCoord(int x, int y){
		Casa unaCasa = new Casa();
		elMapa.insertarConstruccionEn(x, y, unaCasa);
		laCaja.DecrementarSaldo(unaCasa.obtenerCostoConstruccion());
	}
	
	public void ComprarComercioEnCoord(int x, int y){
		Comercio unComercio = new Comercio();
		elMapa.insertarConstruccionEn(x, y, unComercio);
		laCaja.DecrementarSaldo(unComercio.obtenerCostoConstruccion());
	}
	
	public void ComprarIndustriaEnCoord(int x, int y){
		Industria unaIndustria = new Industria();
		elMapa.insertarConstruccionEn(x, y, unaIndustria);
		laCaja.DecrementarSaldo(unaIndustria.obtenerCostoConstruccion());
	}
	
	public void ComprarEstacionDeBomberosEnCoord(int x, int y){
		EstacionBomberos unaEstacionBomberos = new EstacionBomberos();
		elMapa.insertarConstruccionEn(x, y, unaEstacionBomberos);
		laCaja.DecrementarSaldo(unaEstacionBomberos.obtenerCostoConstruccion());
	}
	
	public void ComprarCentralNuclearEnCoord(int x, int y){
		CentralNuclear unaCentralNuclear = new CentralNuclear(x,y);
		elMapa.agregarALaRedElectrica(unaCentralNuclear);
		laCaja.DecrementarSaldo(unaCentralNuclear.obtenerCostoConstruccion());
	}
	
	public void ComprarCentralMineralEnCoord(int x, int y){
		CentralMineral unaCentralMineral = new CentralMineral(x,y);
		elMapa.agregarALaRedElectrica(unaCentralMineral);
		laCaja.DecrementarSaldo(unaCentralMineral.obtenerCostoConstruccion());
	}
	
	public void ComprarLineaDeTensionEnCoord(int x, int  y){
		LineaDeTension linea = new LineaDeTension(x,y);
		elMapa.insertarConstruccionEn(x, y, linea);
		elMapa.agregarALaRedElectrica(linea);
		laCaja.DecrementarSaldo(linea.obtenerCostoConstruccion());
	}
	
	public void ComprarCentralEolicaEnCoord(int x, int y){
		CentralEolica unaCentralEolica = new CentralEolica(x,y);
		elMapa.agregarALaRedElectrica(unaCentralEolica);
		laCaja.DecrementarSaldo(unaCentralEolica.obtenerCostoConstruccion());
	}
	
	public void ComprarPozoDeAguaEnCoord(int x, int y){
		PozoDeAgua pozo = new PozoDeAgua(x,y);
		elMapa.agregarALaRedDeAgua(pozo);
		laCaja.DecrementarSaldo(pozo.obtenerCostoConstruccion());
	}
	
	public void ComprarTuberiaDeAguaEnCoord(int x, int y){
		TuberiaDeAgua tuberia = new TuberiaDeAgua(x,y);
		elMapa.agregarALaRedDeAgua(tuberia);
		laCaja.DecrementarSaldo(tuberia.obtenerCostoConstruccion());
	}

	public void ComprarUnaRutaEnCoord(int i, int j) {
		Ruta ruta = new Ruta ();
		elMapa.insertarConstruccionEn(i, j, ruta);
		laCaja.DecrementarSaldo(ruta.obtenerCostoConstruccion());
		
	}
}
