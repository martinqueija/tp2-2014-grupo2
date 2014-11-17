package fiuba.algo3.tp2;

public class Construccion {
	double vida = 100;
	
	public void decrementarVida(double factor){
		vida = vida - factor;
		if (vida <= 0) {
			vida = 0;
		}
	}
	
	public void incrementarVida(double factor){
		vida = vida + factor;
		if (vida > 100) { vida = 100; }
	}
	
	public double obtenerVida(){
		return vida;
	}


	public boolean puedeConstruirEnSuperficie(Superficie superficieDelLote) {
		//deberia estar implementada en una clase inferior
		return true;
	}
	
	public void reparacionBomberos(){
		//subclassResponsibility
	}
	
	public String getIdentificador(){
		return "";
	}
	
	public boolean esCasa(){
		return false;
	}
	
	public boolean esRuta(){
		return false;
	}
	
	public int obtenerCostoConstruccion(){
		return 0;
	}
}
