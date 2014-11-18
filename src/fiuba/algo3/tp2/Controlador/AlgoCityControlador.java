package fiuba.algo3.tp2.Controlador;
import java.awt.Color;

import fiuba.algo3.tp2.*;
import fiuba.algo3.tp2.Vista.AlgoCityVista;

public class AlgoCityControlador {
	
	Juego juego;
	AlgoCityVista vista;
	
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
	
	
	
	public void actualizarSuperficie(){
		Lote loteTemp;
		String stringTemp;
		Color colorMarron = new Color(130,50,0);
		Color colorAzul = new Color(0,153,255);
		for (int i = 0; i<juego.elMapa.obtenerTamanioLado();){
			for (int j = 0; j<juego.elMapa.obtenerTamanioLado();){
				loteTemp = juego.elMapa.obtenerLote(i, j);
				if (loteTemp.getTieneAgua()) {
					vista.setBotonColorBackground(colorAzul, i+2, j+2);
				} else {
					vista.setBotonColorBackground(colorMarron, i+2, j+2);
				};
				stringTemp = loteTemp.obtenerIdentificadorLote();
				vista.setBotonTexto(stringTemp, i+2, j+2);
			}
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
		ConstruyeCasa = true;
	}
	
	public void SetProximoAConstruirComercio(){
		ConstruyeComercio = true;
	}
	
	public void SetProximoAConstruirIndustria(){
		ConstruyeIndustria = true;
	}
	
	public void SetProximoAConstruirCentralNuclear(){
		ConstruyeCentralNuclear = true;
	}
	
	public void SetProximoAConstruirCentralEolica(){
		ConstruyeCentralEolica = true;
	}
	
	public void SetProximoAConstruirCentralMineral(){
		ConstruyeCentralMineral = true;
	}
	
	public void SetProximoAConstruirTuberia(){
		ConstruyeTuberia = true;
	}
	
	public void SetProximoAConstruirLineaDeTension(){
		ConstruyeLineaDeTension = true;
	}
	
	public void SetProximoAConstruirPozoDeAgua(){
		ConstruyePozoDeAgua = true;
	}
	
	public void SetProximoAConstruirBomberos(){
		ConstruyeBomberos = true;
	}
	
	public void SetProximoAConstruirRuta(){
		ConstruyeRuta = true;
	}
	
	public void construirEnCoordenadas(int x, int y){
		if (ConstruyeRuta) {
			juego.ComprarUnaRutaEnCoord(x, y);
		}
		if (ConstruyeRuta) {
			juego.ComprarUnaRutaEnCoord(x, y);
		}
	}
}
