package fiuba.algo3.tp2;

public class EnumeradoDeLote {
	enum TipoDeConstruccion { CASA, INDUSTRIA, COMERCIO, EOLICA, NUCLEAR, MINERAL, POZO, BOMBEROS, RUTA, SINCONSTRUCCION };
	
	TipoDeConstruccion construccionLote;
	
	public void setCasa() {
		construccionLote = TipoDeConstruccion.CASA;
	}
	
	public void setIndustria() {
		construccionLote = TipoDeConstruccion.INDUSTRIA;
	}
	
	public void setComercio() {
		construccionLote = TipoDeConstruccion.COMERCIO;
	}
	
	public void setEolica() {
		construccionLote = TipoDeConstruccion.EOLICA;
	}
	
	public void setNuclear() {
		construccionLote = TipoDeConstruccion.NUCLEAR;
	}
	
	public void setMineral() {
		construccionLote = TipoDeConstruccion.MINERAL;
	}
	
	public void setPozo() {
		construccionLote = TipoDeConstruccion.POZO;
	}
	
	public void setBomberos() {
		construccionLote = TipoDeConstruccion.BOMBEROS;
	}
	
	public void setRuta() {
		construccionLote = TipoDeConstruccion.RUTA;
	}
	
	public boolean esCasa(){
		if (construccionLote == TipoDeConstruccion.CASA){
			return true;
		} else return false;
	}
	
	public boolean esComercio(){
		if (construccionLote == TipoDeConstruccion.COMERCIO){
			return true;
		} else return false;
	}
	
	public boolean esIndustria(){
		if (construccionLote == TipoDeConstruccion.INDUSTRIA){
			return true;
		} else return false;
	}
	
	public boolean esEolica(){
		if (construccionLote == TipoDeConstruccion.EOLICA){
			return true;
		} else return false;
	}
	
	public boolean esMineral(){
		if (construccionLote == TipoDeConstruccion.MINERAL){
			return true;
		} else return false;
	}
	
	public boolean esNuclear(){
		if (construccionLote == TipoDeConstruccion.NUCLEAR){
			return true;
		} else return false;
	}
	
	public boolean esBomberos(){
		if (construccionLote == TipoDeConstruccion.BOMBEROS){
			return true;
		} else return false;
	}
	
	public boolean esRuta(){
		if (construccionLote == TipoDeConstruccion.RUTA){
			return true;
		} else return false;
	}
	
	public boolean esPozo(){
		if (construccionLote == TipoDeConstruccion.POZO){
			return true;
		} else return false;
	}

	public void setSinConstruccion() {
		construccionLote = TipoDeConstruccion.SINCONSTRUCCION;
	}
	
	
	
	
}
