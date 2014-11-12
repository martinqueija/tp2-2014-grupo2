package fiuba.algo3.tp2;
import junit.framework.Assert;
import org.junit.Test;

public class IntegracionTests {
	
	@Test
	public void TestIntegracion1(){
		Mapa unMapa = new Mapa();
		CentralNuclear central = new CentralNuclear(4,4);
		unMapa.insertarConstruccionEn(4, 4, central);
		Casa casa = new Casa();
		unMapa.insertarConstruccionEn(4, 6, casa);
		LineaDeTension linea = new LineaDeTension(4,5);
		unMapa.insertarConstruccionEn(4, 5, linea);
		unMapa.agregarALaRedElectrica(linea);
		unMapa.agregarALaRedElectrica(central);
		unMapa.actualizarMapa();
		Assert.assertEquals(true,unMapa.getTieneElecticidadLote(4, 6));
		
	}
	
	@Test
	public void TestIntegracion2(){
		Mapa unMapa = new Mapa();
		CentralNuclear central = new CentralNuclear(4,4);
		unMapa.insertarConstruccionEn(4, 4, central);
		Casa casa = new Casa();
		unMapa.insertarConstruccionEn(4, 8, casa);
		LineaDeTension linea1 = new LineaDeTension(4,5);
		LineaDeTension linea2 = new LineaDeTension(4,6);
		LineaDeTension linea3 = new LineaDeTension(4,7);
		
		unMapa.insertarConstruccionEn(4, 5, linea1);
		unMapa.insertarConstruccionEn(4, 6, linea2);
		unMapa.insertarConstruccionEn(4, 7, linea3);
		
		unMapa.agregarALaRedElectrica(linea1);
		unMapa.agregarALaRedElectrica(linea2);
		unMapa.agregarALaRedElectrica(linea3);
		
		unMapa.agregarALaRedElectrica(central);
		
		unMapa.actualizarMapa();
		
		Assert.assertEquals(true,unMapa.getTieneElecticidadLote(4, 6));
		
	}
	
	@Test
	public void TestIntegracion3(){
		Mapa unMapa = new Mapa();
		CentralEolica central = new CentralEolica(4,4);
		unMapa.insertarConstruccionEn(4, 4, central);
		Casa casa = new Casa();
		unMapa.insertarConstruccionEn(4, 8, casa);
		LineaDeTension linea1 = new LineaDeTension(4,5);
		LineaDeTension linea2 = new LineaDeTension(4,6);
		LineaDeTension linea3 = new LineaDeTension(4,7);
		
		unMapa.insertarConstruccionEn(4, 5, linea1);
		unMapa.insertarConstruccionEn(4, 6, linea2);
		unMapa.insertarConstruccionEn(4, 7, linea3);
		
		unMapa.agregarALaRedElectrica(linea1);
		unMapa.agregarALaRedElectrica(linea2);
		unMapa.agregarALaRedElectrica(linea3);
		
		unMapa.agregarALaRedElectrica(central);
		
		unMapa.actualizarMapa();
		
		Assert.assertEquals(true,unMapa.getTieneElecticidadLote(4, 6));
		
	}
	
	@Test
	public void TestIntegracion4(){
		Mapa unMapa = new Mapa();
		CentralMineral central = new CentralMineral(4,4);
		unMapa.insertarConstruccionEn(4, 4, central);
		Casa casa = new Casa();
		unMapa.insertarConstruccionEn(4, 8, casa);
		LineaDeTension linea1 = new LineaDeTension(4,5);
		LineaDeTension linea2 = new LineaDeTension(4,6);
		LineaDeTension linea3 = new LineaDeTension(4,7);
		
		unMapa.insertarConstruccionEn(4, 5, linea1);
		unMapa.insertarConstruccionEn(4, 6, linea2);
		unMapa.insertarConstruccionEn(4, 7, linea3);
		
		unMapa.agregarALaRedElectrica(linea1);
		unMapa.agregarALaRedElectrica(linea2);
		unMapa.agregarALaRedElectrica(linea3);
		
		unMapa.agregarALaRedElectrica(central);
		
		unMapa.actualizarMapa();
		
		Assert.assertEquals(true,unMapa.getTieneElecticidadLote(4, 6));
		
	}



}
