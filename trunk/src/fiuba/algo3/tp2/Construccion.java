package fiuba.algo3.tp2;

public class Construccion {
	double vida = 100;
	double vidaTotal = 100;
	
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
		return true;
	}
	
	public void reparacionBomberos(){
	}
	
	public int obtenerCostoConstruccion(){
		return 0;
	}

	public int danioPorGozilla(){
		return (int) vidaTotal;
	}
	
	
	public boolean esCasa(){
		return false;
	}
	
	public boolean esBomberos(){
		return false;
	}
	
	public boolean esPozo(){
		return false;
	}
	
	public boolean esEolica(){
		return false;
	}

	public boolean esComercio() {
		return false;
	}

	public boolean esIndustria() {
		return false;
	}
	
	public boolean esMineral(){
		return false;
	}
	
	public boolean esNuclear(){
		return false;
	}
	
	public boolean esRuta(){
		return false;
	}
}
