package fiuba.algo3.tp2;

public class Construccion {
	int vida = 100;
	boolean enPie = true;
	
	public void decrementarVida(int factor){
		vida = vida - factor;
		if (vida <= 0) {
			vida = 0;
			enPie = false;
		}
	}
	
	public int obtenerVida(){
		return vida;
	}
	
	public boolean obtenerEstado(){
		return enPie;
	}
}
