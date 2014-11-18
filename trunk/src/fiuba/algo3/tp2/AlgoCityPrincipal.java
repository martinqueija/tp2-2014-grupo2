package fiuba.algo3.tp2;
import java.awt.EventQueue;
import fiuba.algo3.tp2.Controlador.AlgoCityControlador;
import fiuba.algo3.tp2.Vista.AlgoCityVista;

public class AlgoCityPrincipal {

	static AlgoCityVista view;
	static Juego juego;
	static AlgoCityControlador controlador;

	public static void main(String[] args) {
		/*
		Runnable runner = new Runnable(){
			@Override
			public void run(){
				view = new AlgoCityVista(15, 15);
				view.setVisible(true);
			}
			};
			EventQueue.invokeLater(runner);*/
			view = new AlgoCityVista(15, 15);
			view.setVisible(true);
			juego = new Juego(15);
			controlador = new AlgoCityControlador(view, juego);
			juego.ComprarCasaEnCoord(1, 1);
			juego.ComprarEstacionDeBomberosEnCoord(3, 6);
			juego.ComprarPozoDeAguaEnCoord(13, 13);
			juego.ComprarTuberiaDeAguaEnCoord(13, 12);
			juego.ComprarUnaRutaEnCoord(4, 4);
			controlador.actualizarSuperficie();
	}
		
		
		
		
	
	

}



