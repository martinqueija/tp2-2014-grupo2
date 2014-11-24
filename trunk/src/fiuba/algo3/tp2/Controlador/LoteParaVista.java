package fiuba.algo3.tp2.Controlador;
import fiuba.algo3.tp2.EnumeradoDeLote;

public class LoteParaVista {
	
	public boolean tieneLineaDeTension = false;
	public boolean tieneTuberia = false;
	public boolean tieneElectricidad = false;
	public boolean tieneConstruccion = false;
	public double vidaconstruccion = 0.0;
	public boolean esDeAgua = false;
	public boolean esDeTierra = false;
	public EnumeradoDeLote construccionEnum;
	
	
	public String representarseComoString(){
		String identpre = "";
		if (tieneConstruccion) {
			identpre = identpre + this.getIdentificadorConstruccionComoString();
		}
		
		if (tieneTuberia) {
			identpre = identpre + "() ";
		}
		
		if (tieneLineaDeTension){
			identpre = identpre + "! ";
		}
		
		if (tieneElectricidad){
			identpre = identpre + "* ";
		}
		
		String identpost = "";
		
		if (tieneConstruccion) {
			identpost = String.valueOf((int)vidaconstruccion);
		} else {
			identpost = "";
		}
		
		String ident = "<html>" + identpre + "<br/>" + identpost + "</html>";
		
		return ident;
	}
	
	public void setEnumeradoLote(EnumeradoDeLote enu){
		construccionEnum = enu;
	}

	public void setTieneTuberia(){
		tieneTuberia = true;
	}
	
	public void setTieneLineaDeTension(){
		tieneLineaDeTension = true;
	}
	
	public void setTieneElectricidad(){
		tieneElectricidad = true;
	}
	
	public void setTieneConstruccion(){
		tieneConstruccion = true;
	}
	
	public void setVidaConstruccion(double vida){
		vidaconstruccion = vida;
	}
	
	public void setEsDeTierra(){
		esDeTierra = true;
	}
	
	public void setEsDeAgua(){
		esDeAgua = true;
	}

	public String getIdentificadorConstruccionComoString(){
		if (construccionEnum.esCasa()) {
			return "V ";
		}
		
		if (construccionEnum.esComercio()) {
			return "C ";
		}
		
		if (construccionEnum.esIndustria()) {
			return "I ";
		}
		
		if (construccionEnum.esPozo()) {
			return "PA ";
		}
		
		if (construccionEnum.esEolica()) {
			return "CE ";
		}
		
		if (construccionEnum.esMineral()) {
			return "CM ";
		}
		
		if (construccionEnum.esNuclear()) {
			return "CN ";
		}
		
		if (construccionEnum.esRuta()) {
			return "R ";
		}
		
		if (construccionEnum.esBomberos()) {
			return "B ";
		}
		
		return "";
		
	}
	
	public boolean getTieneLienaDeTension(){
		return tieneLineaDeTension;
	}

	public void setNoTieneConstruccion() {
		tieneConstruccion = false;
	}

	public void setNoTieneElectricidad() {
		tieneElectricidad = false;
	}

	public void setNoTieneLineaDeTension() {
		tieneLineaDeTension = false;
	}

	public void setNoTieneTuberia() {
		tieneTuberia = false;
	}

	
	public boolean esRuta() {
		if (construccionEnum.esRuta()){
			return true;
		}
		return false;
	}
}
