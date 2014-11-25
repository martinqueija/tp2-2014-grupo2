package fiuba.algo3.tp2;
import fiuba.algo3.tp2.Controlador.AlgoCityControlador;
import fiuba.algo3.tp2.Vista.AlgoCityVista;
import fiuba.algo3.tp2.Vista.AlgoCityVistaInicio;

public class AlgoCityPrincipal {

	static AlgoCityVista view;
	static Juego juego;
	static AlgoCityControlador controlador;
	static AlgoCityVistaInicio viewInicio;

	public static void main(String[] args) {
			viewInicio = new AlgoCityVistaInicio();
			viewInicio.setVisible(true);
			juego = new Juego(15);
			view = new AlgoCityVista(15);
			controlador = new AlgoCityControlador(view, juego);
			view.setControlador(controlador);
			viewInicio.setControlador(controlador);
	}
}



