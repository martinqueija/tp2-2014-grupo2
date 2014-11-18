package fiuba.algo3.tp2.Vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import fiuba.algo3.tp2.Controlador.*;


public class miEscuchadorDeConstruccion implements ActionListener{
	
	 int x;
	 int y;
	AlgoCityControlador controlador;
	
	public miEscuchadorDeConstruccion(int X, int Y, AlgoCityControlador Controlador){
		x = X;
		y = Y;
		controlador = Controlador;
	}
	public void actionPerformed(ActionEvent e){
			controlador.construirEnCoordenadas(x, y);
			controlador.actualizarVista();
		}
}
