package fiuba.algo3.tp2;

public class CentralEolica extends CentralElectrica{
	
	int capacidadAbastecimiento=100;
	int posicionX;
	int posicionY;
	int radioAlcance=4;

	public CentralEolica(int x, int y) {
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
		double factorReparacion = ((vidaActual/100)*15); //repara el 15% de una Eolica
		this.incrementarVida(factorReparacion);
	}

	public int obtenerCostoConstruccion(){
		return 1000;
	}
	
	public String getIdentificador(){
		return "EO ";
	}
}
