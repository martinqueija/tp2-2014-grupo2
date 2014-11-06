package fiuba.algo3.tp2;

public class CentralElectrica extends Construccion { //Casa es una instancia construible
	
	int capacidadAbastecimiento;
	int posicionX;
	int posicionY;
	int radioAlcance;
	int usoActual=0;
	
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
	
	public CentralElectrica(int x, int y){

		posicionX=x;
		posicionY=y;



		
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