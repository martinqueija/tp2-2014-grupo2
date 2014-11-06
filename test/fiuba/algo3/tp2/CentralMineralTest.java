package fiuba.algo3.tp2;

import junit.framework.Assert;

import org.junit.Test;

public class CentralMineralTest {
	@Test
	public void CentralMineralDeberiaDarTensionAUnLoteDentroDelRadioDeAlcance(){
		Mapa mapa =new Mapa();
		CentralMineral nuevaCentral = new CentralMineral(1,5);
		
		mapa.agregarALaRedElectrica(nuevaCentral);
			
		Assert.assertEquals(mapa.getTieneElecticidadLote(1,14), true);
		
	}
	
	@Test
	public void CentralMineralNoDeberiaDarTensionAUnLoteFueraDelRadioDeAlcance(){
		Mapa mapa =new Mapa();
		CentralMineral nuevaCentral = new CentralMineral(1,5);
		
		mapa.agregarALaRedElectrica(nuevaCentral);
			
		Assert.assertEquals(mapa.getTieneElecticidadLote(1,15), false);
		
	}

}
