package fiuba.algo3.tp2;
import java.awt.EventQueue;

import fiuba.algo3.tp2.Vista.AlgoCityVista;

public class AlgoCity {
	
	public static void main(String[] args) {
		
		Runnable runner = new Runnable(){
			@Override
			public void run(){
				AlgoCityVista view = new AlgoCityVista();
				view.setVisible(true);
			}
		};
		
		
		
		EventQueue.invokeLater(runner);
	}

}
