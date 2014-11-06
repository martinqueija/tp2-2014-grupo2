package fiuba.algo3.tp2;

import junit.framework.Assert;

import org.junit.Test;

public class RedElectricaTest {
	
	@Test
	public void UnaNuevaLineaDeTensionDeberiaCrearseSinElectricidadTest(){
		LineaDeTension lineaNueva= new LineaDeTension(1,2);
		
		Assert.assertEquals(lineaNueva.getTieneElectricidad(),false);
		
	}
	@Test
	public void UnaLineaDeTensionDeberiaTenerTensionSiEstaLoSuficientementeCercaDeUnaCentralTest(){
		//el radio de alcance incluye la posicion, es decir si estoy en X=0, y tiene un 
		//radop de alcance de 4, llega hasta X=3
		Mapa mapa =new Mapa();
		CentralEolica nuevaCentral = new CentralEolica(1,5);
		LineaDeTension lineaNueva= new LineaDeTension(2,5);
		
		mapa.agregarALaRedElectrica(nuevaCentral);
		mapa.agregarALaRedElectrica(lineaNueva);
			
		Assert.assertEquals(lineaNueva.getTieneElectricidad(), true);
		
	}
	
	@Test
	public void UnLoteSuficientemteCercaDeUnaCentralDeberiaTenerTensionSinTenerUnaLineaTest(){
		Mapa mapa =new Mapa();
		CentralEolica nuevaCentral = new CentralEolica(1,5);
		
		mapa.agregarALaRedElectrica(nuevaCentral);
			
		Assert.assertEquals(mapa.getTieneElecticidadLote(1,4), true);
		
	}
	
	public void UnLoteSuficientemteLejosDeUnaCentralMpDeberiaTenerTensionSinTenerUnaLinea(){
		Mapa mapa =new Mapa();
		CentralEolica nuevaCentral = new CentralEolica(1,5);
		
		mapa.agregarALaRedElectrica(nuevaCentral);
			
		Assert.assertEquals(mapa.getTieneElecticidadLote(1,50), false);
		
	}
	
	@Test
	public void UnaLineaDeTensionNoDeberiaTenerTensionSiEstaLoSuficientementeLejosDeUnaCentralTest(){
		Mapa mapa =new Mapa();
		CentralEolica nuevaCentral = new CentralEolica(1,5);
		LineaDeTension lineaNueva= new LineaDeTension(1,50);
				
		mapa.agregarALaRedElectrica(nuevaCentral);
		mapa.agregarALaRedElectrica(lineaNueva);
		
		
		Assert.assertEquals(lineaNueva.getTieneElectricidad(), false);
		
	}
}
