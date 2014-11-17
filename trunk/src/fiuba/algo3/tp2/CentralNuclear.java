package fiuba.algo3.tp2;

public class CentralNuclear extends CentralElectrica {
	int capacidadAbastecimiento=1000;
	int posicionX;
	int posicionY;
	int radioAlcance=25;

	public CentralNuclear(int x, int y) {
		super(x, y);
		posicionX=x;
		posicionY=y;


	}

	public int getUsoActual(){
		return usoActual;
	}
	
	public void setUsoActualACero(){
		usoActual=0;
	}
	public void agregarAConsumoDeEnergia(int consumoNuevo){
		usoActual=usoActual+consumoNuevo;
	}
	
	public int getRadioDeAlcance(){
		return radioAlcance;		
	}
	

	public boolean puedeConstruirEnSuperficie(Superficie superficieDelLote) {
		if (superficieDelLote.esTerrenoLLano()) {
			return true;	
		} else return false;
	}	
	
	void setPosicionX(int x){
		posicionX=x;
	}
	
	void setPosicionY(int y){
		posicionY=y;
	}
	
	int getPosicionX(){
		return posicionX;
	}
	
	int getPosicionY(){
		return posicionY;
	}
	public int getCapacidadAbastecimiento(){
		return capacidadAbastecimiento;
		
	}
	
	public void reparacionBomberos(){
		double vidaActual = this.obtenerVida();
		double factorReparacion = ((vidaActual/100)*3); //repara el 3% de una Nuclear
		this.incrementarVida(factorReparacion);
	}
	
	public int obtenerCostoConstruccion(){
		return 10000;
	}
	
	public String getIdentificador(){
		return "EN ";
	}
}
