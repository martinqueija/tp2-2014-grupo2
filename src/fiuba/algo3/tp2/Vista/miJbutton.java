package fiuba.algo3.tp2.Vista;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class miJbutton extends JButton {
	int coordx;
	int coordy;
	
	public miJbutton(String string){
		super(string);
	}
	
	public void setCoordenadas(int x, int y){
		coordx = x;
		coordy = y;
	}
	
	public int getcoordX(){
		return coordx;
	}
	
	public int getcoordY(){
		return coordy;
	}
}
