package fiuba.algo3.tp2;

public class LineaDeTension extends Construccion { //Casa es una instancia construible
	
	boolean tieneElectricidad=false;
	CentralElectrica centralElectricaQueLeDaEnergia;
	
	int posicionX;
	int posicionY;
	
	public CentralElectrica getCentralElectrica(){
		return centralElectricaQueLeDaEnergia;
		
	}
	
	public LineaDeTension(int x, int y){
		posicionX=x;
		posicionY=y;
		tieneElectricidad=false;	
	}
	
	public void setTieneElectricidad(CentralElectrica centralElectrica){
		tieneElectricidad=true;
		centralElectricaQueLeDaEnergia=centralElectrica;
	}
	
	public void setNoTieneElectricidad( ){
		tieneElectricidad=false;
		centralElectricaQueLeDaEnergia=null;
	}
	
	public boolean getTieneElectricidad(){
		return tieneElectricidad;
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

}
