package fiuba.algo3.tp2;

import junit.framework.Assert;

import org.junit.Test;

public class CentralNuclearTest {
	@Test
	public void CentralNuclearaDeberiaDarTensionAUnLoteDentroDelRadioDeAlcance(){
		Mapa mapa =new Mapa(200);
		CentralNuclear nuevaCentral = new CentralNuclear(1,5);
		
		mapa.agregarALaRedElectrica(nuevaCentral);
			
		Assert.assertEquals(mapa.getTieneElecticidadLote(1,29), true);
		
	}
	
	@Test
	public void CentralNuclearNoDeberiaDarTensionAUnLoteFueraDelRadioDeAlcance(){
		Mapa mapa =new Mapa(200);
		CentralNuclear nuevaCentral = new CentralNuclear(1,5);
		
		mapa.agregarALaRedElectrica(nuevaCentral);
			
		Assert.assertEquals(mapa.getTieneElecticidadLote(1,30), false);
		
	}

}
