package fiuba.algo3.tp2;

public class Construccion {
	double vida = 100;
	boolean enPie = true;
	
	public void decrementarVida(double factor){
		vida = vida - factor;
		if (vida <= 0) {
			vida = 0;
			enPie = false;
		}
	}
	
	public double obtenerVida(){
		return vida;
	}
	
	public boolean obtenerEstado(){
		return enPie;
	}

	public boolean puedeConstruirEnSuperficie(Superficie superficieDelLote) {
		//deberia estar implementada en una clase inferior
		return true;
	}
}
