package fiuba.algo3.tp2;

import fiuba.algo3.tp2.Excepciones.*;


public class Juego {
	public Mapa elMapa;
	public Caja laCaja = new Caja();
	AdministradorCatastrofes adminCatastrofes = new AdministradorCatastrofes();
	RandomizadorInterface randomizer = new RandomizadorPosta();

	public int contadorAImpuestos=0;
	public int totalTurnos=0;

	int CANT_TURNOS_IMPUESTO = 2;
	
	
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
	
	public boolean proximoTurno(){
		boolean huboCatastrofe = dispararCatastrofes();
		elMapa.reparacionBomberos();
		contadorAImpuestos = contadorAImpuestos + 1;
		totalTurnos = totalTurnos + 1;
		if (contadorAImpuestos == CANT_TURNOS_IMPUESTO){
			contadorAImpuestos = 0;
			laCaja.RecoleccionImpuestosPorPoblacion(elMapa.getCantidadPoblacion());
		}
		
		return huboCatastrofe;
	}
	
	public boolean dispararCatastrofes(){
		boolean huboCatastrofe = adminCatastrofes.actuar(elMapa, randomizer);
		return huboCatastrofe;
	}
	
	public int obtenerCantidadTurnos(){
		return totalTurnos;
	}

	public void ComprarCasaEnCoord(int x, int y){
		boolean lanzo = false;
		Casa unaCasa = new Casa();
		if (laCaja.verificarSaldoParaCompra(unaCasa.obtenerCostoConstruccion())){
			try {
				elMapa.insertarConstruccionEn(x, y, unaCasa);
			} catch (ExcepcionSuperficieInvalida e){
				lanzo = true;
			} catch (ExcepcionLoteYaContieneConstruccion ee){
				lanzo = true;
			}

			if (!lanzo) {
				laCaja.DecrementarSaldo(unaCasa.obtenerCostoConstruccion());
			}
		}
	}
	
	public void ComprarComercioEnCoord(int x, int y){
		boolean lanzo = false;
		Comercio unComercio = new Comercio();
		if (laCaja.verificarSaldoParaCompra(unComercio.obtenerCostoConstruccion())){
			try {
				elMapa.insertarConstruccionEn(x, y, unComercio);
			} catch (ExcepcionSuperficieInvalida e){
				lanzo = true;
			} catch (ExcepcionLoteYaContieneConstruccion ee){
				lanzo = true;
			}

			if (!lanzo) {
				laCaja.DecrementarSaldo(unComercio.obtenerCostoConstruccion());
			}
		}
	}
	
	public void ComprarIndustriaEnCoord(int x, int y){
		boolean lanzo = false;
		Industria unaIndustria = new Industria();
		if (laCaja.verificarSaldoParaCompra(unaIndustria.obtenerCostoConstruccion())){
			try {
				elMapa.insertarConstruccionEn(x, y, unaIndustria);
			} catch (ExcepcionSuperficieInvalida e){
				lanzo = true;
			} catch (ExcepcionLoteYaContieneConstruccion ee){
				lanzo = true;
			}

			if (!lanzo) {
				laCaja.DecrementarSaldo(unaIndustria.obtenerCostoConstruccion());
			}
		}
	}
	
	public void ComprarEstacionDeBomberosEnCoord(int x, int y){
		boolean lanzo = false;
		EstacionBomberos unaEstacionBomberos = new EstacionBomberos();
		if (laCaja.verificarSaldoParaCompra(unaEstacionBomberos.obtenerCostoConstruccion())){
			try {
				elMapa.agregarALaRedDeBomberos(unaEstacionBomberos, x, y);
			} catch (ExcepcionSuperficieInvalida e){
				lanzo = true;
			} catch (ExcepcionLoteYaContieneConstruccion ee){
				lanzo = true;
			}

			if (!lanzo) {
				laCaja.DecrementarSaldo(unaEstacionBomberos.obtenerCostoConstruccion());
			}
		}
	}
	
	public void ComprarCentralNuclearEnCoord(int x, int y){
		boolean lanzo = false;
		CentralNuclear unaCentralNuclear = new CentralNuclear(x,y);
		if (laCaja.verificarSaldoParaCompra(unaCentralNuclear.obtenerCostoConstruccion())){
			try {
				elMapa.agregarALaRedElectrica(unaCentralNuclear);
			} catch (ExcepcionSuperficieInvalida e){
				lanzo = true;
			} catch (ExcepcionLoteYaContieneConstruccion ee){
				lanzo = true;
			}

			if (!lanzo) {
				laCaja.DecrementarSaldo(unaCentralNuclear.obtenerCostoConstruccion());
			}
		}
	}
	
	public void ComprarCentralMineralEnCoord(int x, int y){
		boolean lanzo = false;
		CentralMineral unaCentralMineral = new CentralMineral(x,y);
		if (laCaja.verificarSaldoParaCompra(unaCentralMineral.obtenerCostoConstruccion())){
			try {
				elMapa.agregarALaRedElectrica(unaCentralMineral);
			} catch (ExcepcionSuperficieInvalida e){
				lanzo = true;
			} catch (ExcepcionLoteYaContieneConstruccion ee){
				lanzo = true;
			}

			if (!lanzo) {
				laCaja.DecrementarSaldo(unaCentralMineral.obtenerCostoConstruccion());
			}
		}
	}
	
	public void ComprarLineaDeTensionEnCoord(int x, int  y){
		boolean lanzo = false;
		LineaDeTension linea = new LineaDeTension(x,y);
		if (laCaja.verificarSaldoParaCompra(linea.obtenerCostoConstruccion())){
			try {
				elMapa.agregarALaRedElectrica(linea);
			} catch (ExcepcionSuperficieInvalida e){
				lanzo = true;
			} catch (ExcepcionLoteYaContieneConstruccion ee){
				lanzo = true;
			} catch (ExcepcionLoteYaContieneLineaDeTension eee){
				lanzo = true;
			}
			
			if (!lanzo) {
				laCaja.DecrementarSaldo(linea.obtenerCostoConstruccion());
			}
		}
	}
	
	public void ComprarCentralEolicaEnCoord(int x, int y){
		boolean lanzo = false;
		CentralEolica unaCentralEolica = new CentralEolica(x,y);
		if (laCaja.verificarSaldoParaCompra(unaCentralEolica.obtenerCostoConstruccion())){
			try {
				elMapa.agregarALaRedElectrica(unaCentralEolica);
			} catch (ExcepcionSuperficieInvalida e){
				lanzo = true;
			} catch (ExcepcionLoteYaContieneConstruccion ee){
				lanzo = true;
			}
			
			if (!lanzo) {
				laCaja.DecrementarSaldo(unaCentralEolica.obtenerCostoConstruccion());
			}
		}
	}
	
	public void ComprarPozoDeAguaEnCoord(int x, int y){
		boolean lanzo = false;
		PozoDeAgua pozo = new PozoDeAgua(x,y);
		if (laCaja.verificarSaldoParaCompra(pozo.obtenerCostoConstruccion())){
			try {
				elMapa.agregarALaRedDeAgua(pozo);
			} catch (ExcepcionSuperficieInvalida e){
				lanzo = true;
			} catch (ExcepcionLoteYaContieneConstruccion ee){
				lanzo = true;
			}
			
			if (!lanzo) {
				laCaja.DecrementarSaldo(pozo.obtenerCostoConstruccion());
			}
		}
	}
	
	public void ComprarTuberiaDeAguaEnCoord(int x, int y){
		TuberiaDeAgua tuberia = new TuberiaDeAgua(x,y);
		boolean lanzo = false;
		if (laCaja.verificarSaldoParaCompra(tuberia.obtenerCostoConstruccion())){
			try {
				elMapa.agregarALaRedDeAgua(tuberia);
			} catch (ExcepcionSuperficieInvalida e){
				lanzo = true;
			} catch (ExcepcionLoteYaContieneConstruccion ee){
				lanzo = true;
			} catch (ExcepcionLoteYaContieneTuberia eee){
				lanzo = true;
			}
			
			if (!lanzo){
				laCaja.DecrementarSaldo(tuberia.obtenerCostoConstruccion());
			}
		}
	}
	
	public void ComprarUnaRutaEnCoord(int i, int j) {
		Ruta ruta = new Ruta ();
		boolean lanzo = false;
		if (laCaja.verificarSaldoParaCompra(ruta.obtenerCostoConstruccion())){
			try {
				elMapa.insertarConstruccionEn(i, j, ruta);
			} catch (ExcepcionSuperficieInvalida e) {
				lanzo = true;
			} catch (ExcepcionLoteYaContieneConstruccion ee){
				lanzo = true;
			}
			
			if (!lanzo) {
				laCaja.DecrementarSaldo(ruta.obtenerCostoConstruccion());
			}
		}
	}
	
}
