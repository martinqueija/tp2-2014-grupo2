package fiuba.algo3.tp2;

public class Caja {
	private int Saldo = 1000;
	
	public void DecrementarSaldo(int Factor){
		Saldo = Saldo - Factor;
	}
	
	public void IncrementarSaldo(int Factor){
		Saldo = Saldo + Factor;
	}
	
	public int ObtenerSaldo(){
		return Saldo;
	}
	
	public void RecoleccionImpuestosPorPoblacion(int Poblacion){
		int ganancia = Poblacion*10;
		this.IncrementarSaldo(ganancia);
	}
	
	public void ComprarCasaEnCoord(int x, int y, Mapa elMapa){
		Casa unaCasa = new Casa();
		elMapa.insertarConstruccionEn(x, y, unaCasa);
		this.DecrementarSaldo(5);
	}
	
	public void ComprarComercioEnCoord(int x, int y, Mapa elMapa){
		Comercio unComercio = new Comercio();
		elMapa.insertarConstruccionEn(x, y, unComercio);
		this.DecrementarSaldo(5);
	}
	
	public void ComprarIndustriaEnCoord(int x, int y, Mapa elMapa){
		Industria unaIndustria = new Industria();
		elMapa.insertarConstruccionEn(x, y, unaIndustria);
		this.DecrementarSaldo(10);
	}
	
	public void ComprarEstacionDeBomberosEnCoord(int x, int y, Mapa elMapa){
		EstacionBomberos unaEstacionBomberos = new EstacionBomberos();
		elMapa.insertarConstruccionEn(x, y, unaEstacionBomberos);
		this.DecrementarSaldo(1500);
	}
	
	public void ComprarCentralNuclearEnCoord(int x, int y, Mapa elMapa){
		CentralNuclear unaCentralNuclear = new CentralNuclear(x,y);
		elMapa.insertarConstruccionEn(x, y, unaCentralNuclear);
		elMapa.agregarALaRedElectrica(unaCentralNuclear);
		this.DecrementarSaldo(10000);
	}
	
	public void ComprarCentralMineralEnCoord(int x, int y, Mapa elMapa){
		CentralMineral unaCentralMineral = new CentralMineral(x,y);
		elMapa.insertarConstruccionEn(x, y, unaCentralMineral);
		elMapa.agregarALaRedElectrica(unaCentralMineral);
		this.DecrementarSaldo(3000);
	}
	
	public void ComprarLineaDeTensionEnCoord(int x, int  y, Mapa elMapa){
		LineaDeTension linea = new LineaDeTension(x,y);
		elMapa.insertarConstruccionEn(x, y, linea);
		elMapa.agregarALaRedElectrica(linea);
		this.DecrementarSaldo(200);
	}
	
	public void ComprarCentralEolicaEnCoord(int x, int y, Mapa elMapa){
		CentralEolica unaCentralEolica = new CentralEolica(x,y);
		elMapa.insertarConstruccionEn(x, y, unaCentralEolica);
		elMapa.agregarALaRedElectrica(unaCentralEolica);
		this.DecrementarSaldo(1000);
	}
	
	public void ComprarPozoDeAguaEnCoord(int x, int y, Mapa elMapa){
		PozoDeAgua pozo = new PozoDeAgua(x,y);
		elMapa.agregarALaRedDeAgua(pozo);
		this.DecrementarSaldo(250);
	}
	
	public void ComprarTuberiaDeAguaEnCoord(int x, int y, Mapa elMapa){
		TuberiaDeAgua tuberia = new TuberiaDeAgua(x,y);
		elMapa.agregarALaRedDeAgua(tuberia);
		this.DecrementarSaldo(5);
	}

	public void ComprarUnaRutaEnCoord(int i, int j, Mapa elMapa) {
		Ruta ruta = new Ruta ();
		elMapa.insertarConstruccionEn(i, j, ruta);
		this.DecrementarSaldo(10);
		
	}
	
}
