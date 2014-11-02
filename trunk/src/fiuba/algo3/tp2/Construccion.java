package fiuba.algo3.tp2;

public class Construccion {
	int vida = 100;
	
	public void decrementarVida(int factor){
		vida = vida - factor;
	}
	
	public int obtenerVida(){
		return vida;
	}
}
