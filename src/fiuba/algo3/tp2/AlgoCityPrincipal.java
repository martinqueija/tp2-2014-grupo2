package fiuba.algo3.tp2;
import java.awt.EventQueue;
import fiuba.algo3.tp2.Controlador.AlgoCityControlador;
import fiuba.algo3.tp2.Vista.AlgoCityVista;

public class AlgoCityPrincipal {

	static AlgoCityVista view;
	static Juego juego;
	static AlgoCityControlador controlador;


	public static void main(String[] args) {

		
		
		Runnable runner = new Runnable(){
			@Override
			public void run(){
				view = new AlgoCityVista(17, 17);
				view.setVisible(true);
			}
			};
			EventQueue.invokeLater(runner);
			juego = new Juego();
			controlador = new AlgoCityControlador(view, juego);
	}
		
		
		
		
	
	

}



