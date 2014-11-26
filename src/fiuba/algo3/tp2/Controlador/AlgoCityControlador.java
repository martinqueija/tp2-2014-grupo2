package fiuba.algo3.tp2.Controlador;
import java.awt.Color;
import fiuba.algo3.tp2.*;
import fiuba.algo3.tp2.Vista.AlgoCityVista;
import fiuba.algo3.tp2.Vista.LoteParaVista;

public class AlgoCityControlador {
	
	public Juego juego;
	public AlgoCityVista vista;

	String SALDO_INS = "Saldo insuficiente.";
	String SUP_INV = "Superficie invalida para la construccion";
	
	boolean ConstruyeCasa = false;
	boolean ConstruyeComercio = false;
	boolean ConstruyeIndustria = false;
	boolean ConstruyeCentralNuclear = false;
	boolean ConstruyeCentralEolica = false;
	boolean ConstruyeCentralMineral = false;
	boolean ConstruyePozoDeAgua = false;
	boolean ConstruyeTuberia = false;
	boolean ConstruyeLineaDeTension = false;
	boolean ConstruyeBomberos = false;
	boolean ConstruyeRuta = false;
	
	LoteParaVista[][] lotesDeVista;
	
	///
	
	public AlgoCityControlador(AlgoCityVista LaVista, Juego ElJuego){
		juego = ElJuego;
		vista = LaVista;
		lotesDeVista = new LoteParaVista[juego.elMapa.obtenerTamanioLado()][juego.elMapa.obtenerTamanioLado()];
		CrearLotesParaVista();
	}
	
	public void actualizarVista(){
		LoteParaVista loteParaVistaTemp;
		String stringTemp;
		Color colorMarron = new Color(130,50,0);
		Color colorAzul = new Color(0,153,255);
		Color colorBlanco = new Color(255,255,255);
		Color colorGris = new Color(100,100,100);
		
		actualizarLotesParaVista();
		juego.elMapa.actualizarMapa();
		
		for (int i = 0; i<juego.elMapa.obtenerTamanioLado(); i++){
			for (int j = 0; j<juego.elMapa.obtenerTamanioLado(); j++){
				loteParaVistaTemp = lotesDeVista[i][j];
				if (loteParaVistaTemp.esDeAgua) {
					vista.setBotonColorBackground(colorAzul, i+2, j);
				} else if (loteParaVistaTemp.esDeTierra){
					vista.setBotonColorBackground(colorMarron, i+2, j);
				};
				
				if (loteParaVistaTemp.esRuta()){
					vista.setBotonColorBackground(colorGris, i+2, j);
				}
				stringTemp = loteParaVistaTemp.representarseComoString();
				vista.setBotonTexto(stringTemp, i+2, j);
				vista.setBotonColorTexto(colorBlanco, i+2, j);
			}
		}
		
		vista.setSaldo(juego.laCaja.ObtenerSaldo());
		vista.setNumeroTurnos(juego.obtenerCantidadTurnos());
		vista.setCantidadPoblacion(juego.elMapa.getCantidadPoblacion());
		
	}
	
	public void CrearLotesParaVista(){
		for (int i = 0; i < juego.elMapa.obtenerTamanioLado(); i++){
			for (int j = 0; j < juego.elMapa.obtenerTamanioLado(); j++){
				LoteParaVista loteParaVistaTemp = new LoteParaVista();
				lotesDeVista[i][j] = loteParaVistaTemp;
			}
		}
	}
	
	public void actualizarLotesParaVista(){
		LoteParaVista loteParaVistaTemp;
		for (int i = 0; i < juego.elMapa.obtenerTamanioLado(); i++){
			for (int j = 0; j < juego.elMapa.obtenerTamanioLado(); j++){
				
				loteParaVistaTemp = lotesDeVista[i][j];
				
				loteParaVistaTemp.setEnumeradoLote(juego.elMapa.DameEnumeradoDelLote(i, j));
				
				if (juego.elMapa.LoteEsDeAgua(i, j)){
					loteParaVistaTemp.setEsDeAgua();
				}
				
				if (juego.elMapa.LoteEsDeTierra(i, j)){
					loteParaVistaTemp.setEsDeTierra();
				}
				
				if (juego.elMapa.LoteTieneConstruccion(i,j)) {
					loteParaVistaTemp.setTieneConstruccion();
				} else {
					loteParaVistaTemp.setNoTieneConstruccion();
				}
				
				if (juego.elMapa.getTieneElecticidadLote(i, j)){
					loteParaVistaTemp.setTieneElectricidad();
				} else {
					loteParaVistaTemp.setNoTieneElectricidad();
				}
				
				if (juego.elMapa.getTieneLineaDeTensionLote(i,j)) {
					loteParaVistaTemp.setTieneLineaDeTension();
				} else {
					loteParaVistaTemp.setNoTieneLineaDeTension();
				}
				
				if (juego.elMapa.getTieneTuberiaLote(i,j)){
					loteParaVistaTemp.setTieneTuberia();
				} else {
					loteParaVistaTemp.setNoTieneTuberia();
				}
				
				loteParaVistaTemp.setVidaConstruccion(juego.elMapa.obtenerVidaDeConstruccionEnLote(i, j));
				
				lotesDeVista[i][j] = loteParaVistaTemp;
			}
		}
	}
	
	public void proximoTurno(){
		boolean huboCatastrofe = juego.proximoTurno();
		actualizarVista();
		if (huboCatastrofe) {
			double[][] DaniosALotes = juego.obtenerDaniosUltimaCatastrofe();
			vista.mostrarDaniosDeUltimaCatastrofe(DaniosALotes);
		}
	}
	
	public void setTodosFalso(){
		ConstruyeCasa = false;
		ConstruyeComercio = false;
		ConstruyeIndustria = false;
		ConstruyeCentralNuclear = false;
		ConstruyeCentralEolica = false;
		ConstruyeCentralMineral = false;
		ConstruyePozoDeAgua = false;
		ConstruyeTuberia = false;
		ConstruyeLineaDeTension = false;
		ConstruyeBomberos = false;
		ConstruyeRuta = false;
	}
	
	public void SetProximoAConstruirCasa(){
		setTodosFalso();
		ConstruyeCasa = true;
	}
	
	public void SetProximoAConstruirComercio(){
		setTodosFalso();
		ConstruyeComercio = true;
	}
	
	public void SetProximoAConstruirIndustria(){
		setTodosFalso();
		ConstruyeIndustria = true;
	}
	
	public void SetProximoAConstruirCentralNuclear(){
		setTodosFalso();
		ConstruyeCentralNuclear = true;
	}
	
	public void SetProximoAConstruirCentralEolica(){
		setTodosFalso();
		ConstruyeCentralEolica = true;
	}
	
	public void SetProximoAConstruirCentralMineral(){
		setTodosFalso();
		ConstruyeCentralMineral = true;
	}
	
	public void SetProximoAConstruirTuberia(){
		setTodosFalso();
		ConstruyeTuberia = true;
	}
	
	public void SetProximoAConstruirLineaDeTension(){
		setTodosFalso();
		ConstruyeLineaDeTension = true;
	}
	
	public void SetProximoAConstruirPozoDeAgua(){
		setTodosFalso();
		ConstruyePozoDeAgua = true;
	}
	
	public void SetProximoAConstruirBomberos(){
		setTodosFalso();
		ConstruyeBomberos = true;
	}
	
	public void SetProximoAConstruirRuta(){
		setTodosFalso();
		ConstruyeRuta = true;
	}
	
	public void construirEnCoordenadas(int x, int y){
		if (ConstruyeCasa) {
			juego.ComprarCasaEnCoord(x, y);
		}
		
		if (ConstruyeComercio){
			juego.ComprarComercioEnCoord(x, y);
		}
		
		if (ConstruyeIndustria){
			juego.ComprarIndustriaEnCoord(x, y);
		}
		
		if (ConstruyeCentralEolica){
			juego.ComprarCentralEolicaEnCoord(x, y);
		}
		
		if (ConstruyeCentralMineral){
			juego.ComprarCentralMineralEnCoord(x, y);
		}
		
		if (ConstruyeCentralNuclear){
			juego.ComprarCentralNuclearEnCoord(x, y);
		}
		
		if (ConstruyePozoDeAgua){
			juego.ComprarPozoDeAguaEnCoord(x, y);
		}
		
		if (ConstruyeLineaDeTension){
			juego.ComprarLineaDeTensionEnCoord(x, y);
		}
		
		if (ConstruyeTuberia){
			juego.ComprarTuberiaDeAguaEnCoord(x, y);
		}
		
		if (ConstruyeRuta) {
			juego.ComprarUnaRutaEnCoord(x, y);
		}
		
		if (ConstruyeBomberos){
			juego.ComprarEstacionDeBomberosEnCoord(x, y);
		}
	}

	public void clickeoJugar(int valorSlider) {
		juego.laCaja.setSaldo(valorSlider);
		vista.setVisible(true);
		actualizarVista();
	}
		
}
