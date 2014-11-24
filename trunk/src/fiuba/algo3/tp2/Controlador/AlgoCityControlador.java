package fiuba.algo3.tp2.Controlador;
import java.awt.Color;

import fiuba.algo3.tp2.*;
import fiuba.algo3.tp2.Excepciones.*;
import fiuba.algo3.tp2.Vista.AlgoCityVista;

public class AlgoCityControlador {
	
	String FIN_JUEGO = "Usted ha entrado en bancarrota. Game over...";
	
	public Juego juego;
	public AlgoCityVista vista;
	
	public AlgoCityControlador(AlgoCityVista LaVista, Juego ElJuego){
		juego = ElJuego;
		vista = LaVista;
	}
	
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
	
	
	
	public void actualizarVista(){
		Lote loteTemp;
		String stringTemp;
		Color colorMarron = new Color(130,50,0);
		Color colorAzul = new Color(0,153,255);
		Color colorBlanco = new Color(255,255,255);
		Color colorGris = new Color(100,100,100);
		
		juego.elMapa.actualizarMapa();
		
		for (int i = 0; i<juego.elMapa.obtenerTamanioLado(); i++){
			for (int j = 0; j<juego.elMapa.obtenerTamanioLado(); j++){
				loteTemp = juego.elMapa.obtenerLote(i, j);
				if (loteTemp.esLoteDeAgua()) {
					vista.setBotonColorBackground(colorAzul, i+2, j);
				} else if (loteTemp.esLoteDeTierra()){
					vista.setBotonColorBackground(colorMarron, i+2, j);
				};
				
				if (loteTemp.esLoteDeRuta()){
					vista.setBotonColorBackground(colorGris, i+2, j);
				}
				stringTemp = loteTemp.obtenerIdentificadorLote();
				vista.setBotonTexto(stringTemp, i+2, j);
				vista.setBotonColorTexto(colorBlanco, i+2, j);
			}
		}
		
		vista.setSaldo(juego.laCaja.ObtenerSaldo());
		vista.setNumeroTurnos(juego.obtenerCantidadTurnos());
		vista.setCantidadPoblacion(juego.elMapa.getCantidadPoblacion());
		
	}
	
	
	
	public void proximoTurno(){
		juego.proximoTurno();
		actualizarVista();
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
			try{
				juego.ComprarCasaEnCoord(x, y);
			} catch (ExcepcionSinSaldo e) {
				vista.msgbox(SALDO_INS);
			} catch (ExcepcionSuperficieInvalida ee){
				vista.msgbox(SUP_INV);
				juego.DevolverSaldoCompraCasa();
			}
		}
		if (ConstruyeComercio){
			try{
				juego.ComprarComercioEnCoord(x, y);
			} catch (ExcepcionSinSaldo e){
				vista.msgbox(SALDO_INS);
			} catch (ExcepcionSuperficieInvalida ee){
				vista.msgbox(SUP_INV);
				juego.DevolverSaldoCompraComercio();
			}
		}
		if (ConstruyeIndustria){
			try{
				juego.ComprarIndustriaEnCoord(x, y);
			} catch (ExcepcionSinSaldo e){
				vista.msgbox(SALDO_INS);
			} catch (ExcepcionSuperficieInvalida ee){
				vista.msgbox(SUP_INV);
				juego.DevolverSaldoCompraIndustria();
			}
		}
		if (ConstruyeCentralEolica){
			try{
				juego.ComprarCentralEolicaEnCoord(x, y);
			} catch (ExcepcionSinSaldo e){
				vista.msgbox(SALDO_INS);
			} catch (ExcepcionSuperficieInvalida ee){
				vista.msgbox(SUP_INV);
				juego.DevolerSaldoCompraCentralEolica();
			}
		}
		
		if (ConstruyeCentralMineral){
			try{
				juego.ComprarCentralMineralEnCoord(x, y);
			} catch (ExcepcionSinSaldo e){
				vista.msgbox(SALDO_INS);
			} catch (ExcepcionSuperficieInvalida ee){
				vista.msgbox(SUP_INV);
				juego.DevolverSaldoCompraCentralMineral();
		}
			}
		
		if (ConstruyeCentralNuclear){
			try{
				juego.ComprarCentralNuclearEnCoord(x, y);
			} catch (ExcepcionSinSaldo e){
				vista.msgbox(SALDO_INS);
			} catch (ExcepcionSuperficieInvalida ee){
				vista.msgbox(SUP_INV);
				juego.DevolverSaldoCompraCentralNuclear();
			}
		}
		
		if (ConstruyePozoDeAgua){
			try{
				juego.ComprarPozoDeAguaEnCoord(x, y);
			} catch (ExcepcionSinSaldo e){
				vista.msgbox(SALDO_INS);
			} catch (ExcepcionSuperficieInvalida ee){
				vista.msgbox(SUP_INV);
				juego.DevolverSaldoCompraPozoDeAgua();
			}
		}
		
		if (ConstruyeLineaDeTension){
			try{
				juego.ComprarLineaDeTensionEnCoord(x, y);
			} catch (ExcepcionSinSaldo e){
				vista.msgbox(SALDO_INS);
			} catch (ExcepcionSuperficieInvalida ee){
				vista.msgbox(SUP_INV);
				juego.DevolverSaldoCompraLineaDeTension();
			}
		}
		
		if (ConstruyeTuberia){
			try{
				juego.ComprarTuberiaDeAguaEnCoord(x, y);
			} catch (ExcepcionSinSaldo e){
				vista.msgbox(SALDO_INS);
			} catch (ExcepcionSuperficieInvalida ee){
				vista.msgbox(SUP_INV);
				juego.DevolverSaldoCompraTuberia();
			}
		}
		
		if (ConstruyeRuta) {
			try{
				juego.ComprarUnaRutaEnCoord(x, y);
			} catch (ExcepcionSinSaldo e){
				vista.msgbox(SALDO_INS);
			} catch (ExcepcionSuperficieInvalida ee){
				vista.msgbox(SUP_INV);
				juego.DevolverSaldoCompraRuta();
			}
		}
		if (ConstruyeBomberos){
			try {
				juego.ComprarEstacionDeBomberosEnCoord(x, y);
			} catch (ExcepcionSinSaldo e){
				vista.msgbox(SALDO_INS);
			} catch (ExcepcionSuperficieInvalida ee){
				vista.msgbox(SUP_INV);
				juego.DevolverSaldoCompraBomberos();
			}
		}
	}
}
