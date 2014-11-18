package fiuba.algo3.tp2.Controlador;
import java.awt.Color;

import fiuba.algo3.tp2.*;
import fiuba.algo3.tp2.Excepciones.*;
import fiuba.algo3.tp2.Vista.AlgoCityVista;

public class AlgoCityControlador {
	
	public Juego juego;
	public AlgoCityVista vista;
	
	public AlgoCityControlador(AlgoCityVista LaVista, Juego ElJuego){
		juego = ElJuego;
		vista = LaVista;
	}
	
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
		
	}
	
	
	
	public void proximoTurno(){
		
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
				vista.msgbox("NO TIENE SALDO SUFICIENTE");
			}
		}
		if (ConstruyeComercio){
			try{
				juego.ComprarComercioEnCoord(x, y);
			} catch (ExcepcionSinSaldo e){
				vista.msgbox("NO TIENE SALDO SUFICIENTE");
			}		}
		if (ConstruyeIndustria){
			try{
				juego.ComprarIndustriaEnCoord(x, y);
			} catch (ExcepcionSinSaldo e){
				vista.msgbox("NO TIENE SALDO SUFICIENTE");
			}		}
		if (ConstruyeCentralEolica){
			try{
				juego.ComprarCentralEolicaEnCoord(x, y);
			} catch (ExcepcionSinSaldo e){
				vista.msgbox("NO TIENE SALDO SUFICIENTE");
			}		}
		if (ConstruyeCentralMineral){
			try{
				juego.ComprarCentralMineralEnCoord(x, y);
			} catch (ExcepcionSinSaldo e){
				vista.msgbox("NO TIENE SALDO SUFICIENTE");
			}		}
		if (ConstruyeCentralNuclear){
			try{
				juego.ComprarCentralNuclearEnCoord(x, y);
			} catch (ExcepcionSinSaldo e){
				vista.msgbox("NO TIENE SALDO SUFICIENTE");
			}		}
		if (ConstruyePozoDeAgua){
			try{
				juego.ComprarPozoDeAguaEnCoord(x, y);
			} catch (ExcepcionSinSaldo e){
				vista.msgbox("NO TIENE SALDO SUFICIENTE");
			}		}
		if (ConstruyeLineaDeTension){
			try{
				juego.ComprarLineaDeTensionEnCoord(x, y);
			} catch (ExcepcionSinSaldo e){
				vista.msgbox("NO TIENE SALDO SUFICIENTE");
			}		}
		if (ConstruyeTuberia){
			try{
				juego.ComprarTuberiaDeAguaEnCoord(x, y);
			} catch (ExcepcionSinSaldo e){
				vista.msgbox("NO TIENE SALDO SUFICIENTE");
			}}
		if (ConstruyeRuta) {
			try{
				juego.ComprarUnaRutaEnCoord(x, y);
			} catch (ExcepcionSinSaldo e){
				vista.msgbox("NO TIENE SALDO SUFICIENTE");
			}
		}
		if (ConstruyeBomberos){
			try {
				juego.ComprarEstacionDeBomberosEnCoord(x, y);
			} catch (ExcepcionSinSaldo e){
				vista.msgbox("NO TIENE SALDO SUFICIENTE");
			}
		}
	}
}
