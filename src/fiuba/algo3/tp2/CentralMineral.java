package fiuba.algo3.tp2;

public class CentralMineral extends CentralElectrica { //Casa es una instancia construible
	int capacidadAbastecimiento=400;
	int posicionX;
	int posicionY;
	int radioAlcance=10;

	public CentralMineral(int x, int y) {
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

}
