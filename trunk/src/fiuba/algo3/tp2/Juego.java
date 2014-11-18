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
		laCaja.DecrementarSaldo(unaCasa.obtenerCostoConstruccion());
		elMapa.insertarConstruccionEn(x, y, unaCasa);
	}
	
	public void DevolverSaldoCompraCasa(){
		Casa unaCasa = new Casa();
		laCaja.IncrementarSaldo(unaCasa.obtenerCostoConstruccion());
	}
	
	public void ComprarComercioEnCoord(int x, int y){
		Comercio unComercio = new Comercio();
		laCaja.DecrementarSaldo(unComercio.obtenerCostoConstruccion());
		elMapa.insertarConstruccionEn(x, y, unComercio);
	}
	
	public void ComprarIndustriaEnCoord(int x, int y){
		Industria unaIndustria = new Industria();
		laCaja.DecrementarSaldo(unaIndustria.obtenerCostoConstruccion());
		elMapa.insertarConstruccionEn(x, y, unaIndustria);
	}
	
	public void ComprarEstacionDeBomberosEnCoord(int x, int y){
		EstacionBomberos unaEstacionBomberos = new EstacionBomberos();
		laCaja.DecrementarSaldo(unaEstacionBomberos.obtenerCostoConstruccion());
		elMapa.insertarConstruccionEn(x, y, unaEstacionBomberos);
	}
	
	public void ComprarCentralNuclearEnCoord(int x, int y){
		CentralNuclear unaCentralNuclear = new CentralNuclear(x,y);
		laCaja.DecrementarSaldo(unaCentralNuclear.obtenerCostoConstruccion());
		elMapa.agregarALaRedElectrica(unaCentralNuclear);
	}
	
	public void ComprarCentralMineralEnCoord(int x, int y){
		CentralMineral unaCentralMineral = new CentralMineral(x,y);
		laCaja.DecrementarSaldo(unaCentralMineral.obtenerCostoConstruccion());
		elMapa.agregarALaRedElectrica(unaCentralMineral);
	}
	
	public void ComprarLineaDeTensionEnCoord(int x, int  y){
		LineaDeTension linea = new LineaDeTension(x,y);
		laCaja.DecrementarSaldo(linea.obtenerCostoConstruccion());
		elMapa.insertarConstruccionEn(x, y, linea);
		elMapa.agregarALaRedElectrica(linea);
	}
	
	public void ComprarCentralEolicaEnCoord(int x, int y){
		CentralEolica unaCentralEolica = new CentralEolica(x,y);
		laCaja.DecrementarSaldo(unaCentralEolica.obtenerCostoConstruccion());
		elMapa.agregarALaRedElectrica(unaCentralEolica);
	}
	
	public void ComprarPozoDeAguaEnCoord(int x, int y){
		PozoDeAgua pozo = new PozoDeAgua(x,y);
		laCaja.DecrementarSaldo(pozo.obtenerCostoConstruccion());
		elMapa.agregarALaRedDeAgua(pozo);
	}
	
	public void ComprarTuberiaDeAguaEnCoord(int x, int y){
		TuberiaDeAgua tuberia = new TuberiaDeAgua(x,y);
		laCaja.DecrementarSaldo(tuberia.obtenerCostoConstruccion());
		elMapa.agregarALaRedDeAgua(tuberia);
	}

	public void ComprarUnaRutaEnCoord(int i, int j) {
		Ruta ruta = new Ruta ();
		laCaja.DecrementarSaldo(ruta.obtenerCostoConstruccion());
		elMapa.insertarConstruccionEn(i, j, ruta);
		
	}
}
