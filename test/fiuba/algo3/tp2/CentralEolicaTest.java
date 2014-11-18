package fiuba.algo3.tp2;

import junit.framework.Assert;

import org.junit.Test;

public class CentralEolicaTest {
	
	@Test
	public void CentralEolicaDeberiaDarTensionAUnLoteDentroDelRadioDeAlcance(){
		Mapa mapa =new Mapa(200);
		CentralEolica nuevaCentral = new CentralEolica(1,5);
		
		mapa.agregarALaRedElectrica(nuevaCentral);
			
		Assert.assertEquals(mapa.getTieneElecticidadLote(1,8), true);
		
	}
	
	@Test
	public void CentralEolicaNoDeberiaDarTensionAUnLoteFueraDelRadioDeAlcance(){
		Mapa mapa =new Mapa(200);
		CentralEolica nuevaCentral = new CentralEolica(1,5);
		
		mapa.agregarALaRedElectrica(nuevaCentral);
			
		Assert.assertEquals(mapa.getTieneElecticidadLote(1,9), false);
		
	}
}
