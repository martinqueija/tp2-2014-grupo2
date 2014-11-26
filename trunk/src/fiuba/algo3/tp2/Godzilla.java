package fiuba.algo3.tp2;

public class Godzilla {
	Mapa mapa;
	
	private int xInicio;
	private int yInicio;
	private int xFinal;
	private int yFinal;
	

	public double[][] iniciarGodzilla(int ladoDeInicio, int ladoDeFinalizacion, int alturaDeInicio, int alturaDeFinalizacion, Mapa elMapa) {
		//Si el lado es 0 es la izquierda, si es 1 es la derecha
		//si es 2 es arriba, y si es 3 es abajo
		mapa=elMapa;
		this.setCoordenadasInicio(ladoDeInicio,alturaDeInicio);
		this.setCoordenadasFinal(ladoDeFinalizacion,alturaDeFinalizacion);
		
		double danios[][] = this.daniarMapa();////// las lineas marcadas con // las agregue yo,
		return danios;////// devuelven que lotes tuvieron danio y eso lo uso despues para mostrar en el mapa por adonde paso godzilla
		
	}

	private double[][] daniarMapa() {
		
		int xPosicionActual=xInicio;
		int yPosicionActual=yInicio;
		
		double danios[][] = new double[mapa.obtenerTamanioLado()][mapa.obtenerTamanioLado()];///////
		
		for (int i = 0; i<mapa.obtenerTamanioLado(); i++){//////
			for (int j = 0; j<mapa.obtenerTamanioLado(); j++){//////
				danios[i][j] = 0;//////
			}//////
		}///////
		
		this.daniarMapaEnCoordenadas(xPosicionActual,yPosicionActual);
		danios[xPosicionActual][yPosicionActual] = 100;
				
		
		while(xPosicionActual!=xFinal || yPosicionActual!=yFinal){
			if(xPosicionActual!=xFinal){
				if((xPosicionActual+1)<=xFinal){
					xPosicionActual=xPosicionActual+1;}
				else{
					xPosicionActual=xPosicionActual-1;
				}
			}

			this.daniarMapaEnCoordenadas(xPosicionActual,yPosicionActual);
			danios[xPosicionActual][yPosicionActual] = 100;

			
			
			if(yPosicionActual!=yFinal){
				if((yPosicionActual+1)<=yFinal){
					yPosicionActual=yPosicionActual+1;}
				else{
					yPosicionActual=yPosicionActual-1;
				}
			}

			this.daniarMapaEnCoordenadas(xPosicionActual,yPosicionActual);
			danios[xPosicionActual][yPosicionActual] = 100;
			
			
		}
		return danios;//////
	}

	private void daniarMapaEnCoordenadas(int xPosicionActual,int yPosicionActual) {
		mapa.daniarConstruccioPorGodzilla(xPosicionActual, yPosicionActual);
	}

	private void setCoordenadasFinal(int ladoDeFinalizacion,int alturaDeFinalizacion) {
		if(ladoDeFinalizacion==0){
			xFinal=0;
			yFinal=alturaDeFinalizacion;
		}
		if(ladoDeFinalizacion==1){
			xFinal=mapa.obtenerTamanioLado()-1;
			yFinal=alturaDeFinalizacion;
		}
		if(ladoDeFinalizacion==2){
			xFinal=alturaDeFinalizacion;
			yFinal=0;
		}
		if(ladoDeFinalizacion==3){
			xFinal=alturaDeFinalizacion;
			yFinal=mapa.obtenerTamanioLado()-1;
		}
		
	}

	private void setCoordenadasInicio(int ladoDeInicio, int alturaDeInicio) {
		if(ladoDeInicio==0){
			xInicio=0;
			yInicio=alturaDeInicio;
		}
		if(ladoDeInicio==1){
			xInicio=mapa.obtenerTamanioLado()-1;
			yInicio=alturaDeInicio;
		}
		if(ladoDeInicio==2){
			xInicio=alturaDeInicio;
			yInicio=0;
		}
		if(ladoDeInicio==3){
			xInicio=alturaDeInicio;
			yInicio=mapa.obtenerTamanioLado()-1;
		}
	}


}
