package fiuba.algo3.tp2;
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
			view = new AlgoCityVista(15);
			view.setVisible(true);
			juego = new Juego(15);
			controlador = new AlgoCityControlador(view, juego);
			view.setControlador(controlador);
			controlador.actualizarVista();
	}
		
		
		
		
	
	

}



