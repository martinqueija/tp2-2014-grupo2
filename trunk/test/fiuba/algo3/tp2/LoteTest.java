package fiuba.algo3.tp2;
import org.junit.Test;
import fiuba.algo3.tp2.Excepciones.*;
import junit.framework.Assert;

public class LoteTest {
	
	@Test
	public void SiLaTuberiaTieneAguaElLoteDeberiaTenerAgua(){
		Mapa mapa = new Mapa(200);
		Lote lote = mapa.obtenerLote(5, 5);
		PozoDeAgua pozo = new PozoDeAgua(5,5);
		TuberiaDeAgua tuberia = new TuberiaDeAgua(5,5);
		Agua agua = new Agua();
		

		Assert.assertEquals(tuberia.tieneAgua(), false);
		
		lote.definirTerrerno(agua);
		mapa.agregarALaRedDeAgua(pozo);
		mapa.agregarALaRedDeAgua(tuberia);
		
		Assert.assertEquals(tuberia.tieneAgua(), true);		
		
		Assert.assertEquals(mapa.getTieneAguaLote(5,5), true);	
		
	}
	
	@Test
	public void LoteDeberiaCrearseVacioYenCoordenadasSolicitadas(){
		Lote lote = new Lote(2,3);
		Assert.assertEquals(lote.hayConstruccion(), false);
		Assert.assertEquals(2, lote.obtenerCoordX());
		Assert.assertEquals(3, lote.obtenerCoordY());
	}
	
	@Test
	public void LoteDeberiaDaniarCorrectamenteUnaConstruccion(){
		Lote lote = new Lote(2,3);
		Construccion unaCasa = new Casa();
		TerrenoLLano terreno = new TerrenoLLano();
		lote.definirTerrerno(terreno);
		
		lote.insertarConstruccion(unaCasa);
		lote.daniarConstruccion(15.0);
		
		Assert.assertEquals(unaCasa.obtenerVida(), 85.0);
	}
	
	@Test
	public void LoteConConstruccionSeCreaCorrectamente(){
		Lote lote = new Lote(2,3);
		TerrenoLLano terreno = new TerrenoLLano();
		lote.definirTerrerno(terreno);
		Construccion unaCasa = new Casa();
		
		lote.insertarConstruccion(unaCasa);
	
		Assert.assertEquals(lote.obtenerVidaConstruccion(), 100.0);
		Assert.assertEquals(lote.hayConstruccion(),true);
		
	}
	
	@Test
	public void LoteNoDeberiaPoderConstruirseCasaSobreAgua(){
		Casa unaCasa = new Casa();
		Lote lote = new Lote(1,1);
		Agua agua = new Agua();
		boolean lanzo = false;
		lote.definirTerrerno(agua);

		
		try {
			lote.insertarConstruccion((Construccion)unaCasa);
		} catch (ExcepcionSuperficieInvalida excepcion) {
			lanzo = true;
		}
		
		Assert.assertEquals(lanzo,true);
		Assert.assertEquals(lote.hayConstruccion(), false);
		
	}
	
	@Test
	public void LoteDeberiaPoderConstruirseCasaSobreTerrenoLlano(){
		Casa unaCasa = new Casa();
		Lote lote = new Lote(1,1);
		TerrenoLLano tierra = new TerrenoLLano();
		lote.definirTerrerno(tierra);
		
		lote.insertarConstruccion((Construccion)unaCasa);
		
		Assert.assertEquals(lote.hayConstruccion(), true);
		
	}
	
	@Test
	public void LoteDeberiaPoderConstruirsePosoDeAguaSobreAgua(){
		Construccion posoDeAgua = new PozoDeAgua();
		Lote lote = new Lote(1,1);
		Agua agua = new Agua();
		lote.definirTerrerno(agua);
		
		lote.insertarConstruccion((Construccion)posoDeAgua);
		
		Assert.assertEquals(lote.hayConstruccion(), true);
		
	}

	@Test
	public void LoteDebeDevolverCorrectamenteLaSuperficieQueSeLeAsignoAgua(){
		Lote unLote = new Lote(1,1);
		Superficie sup;
		Agua agua = new Agua();
		unLote.definirTerrerno(agua);
		sup = unLote.obtenerSuperficieDelLote();
		
		Assert.assertEquals(sup.esAgua(), true);
		Assert.assertEquals(sup.esTerrenoLLano(), false);
	}
	
	@Test
	public void LoteDebeDevolverCorrectamenteLaSuperficieQueSeLeAsignoTerrenoLlano(){
		Lote unLote = new Lote(1,1);
		Superficie sup;
		TerrenoLLano terreno = new TerrenoLLano();
		unLote.definirTerrerno(terreno);
		sup = unLote.obtenerSuperficieDelLote();
		
		Assert.assertEquals(sup.esAgua(), false);
		Assert.assertEquals(sup.esTerrenoLLano(), true);
	}
	
	@Test
	public void LoteDeberiaLanzarExcepcionSiSeIntentaConstruirDondeYaHayConstruccion(){
		Casa casa = new Casa();
		Casa otraCasa = new Casa();
		Lote lote = new Lote(1,1);
		TerrenoLLano terreno = new TerrenoLLano();
		lote.definirTerrerno(terreno);
		boolean lanzo = false;
		
		lote.insertarConstruccion(casa);
		try {
			lote.insertarConstruccion(otraCasa);
		} catch (ExcepcionLoteYaContieneConstruccion excepcion) {
			lanzo = true;
		}
		
		Assert.assertEquals(true,lanzo);
		
	}
	
	@Test
	public void EliminarConstruccionDeberiaSacarLaCOnstruccionDelLOte(){
		Casa casa = new Casa();
		Lote lote = new Lote(1,1);
		TerrenoLLano terr = new TerrenoLLano();
		lote.definirTerrerno(terr);
		lote.insertarConstruccion(casa);
		lote.eliminarConstruccion();
		
		Assert.assertEquals(false, lote.hayConstruccion());
	}	
	
	@Test
	public void IdentificadorDeberiaDevolverseCorrecamente(){
		Casa casa = new Casa();
		Lote lote = new Lote(1,1);
		TerrenoLLano terr = new TerrenoLLano();
		lote.definirTerrerno(terr);
		lote.insertarConstruccion(casa);
		
		Assert.assertEquals("<html>V <br/>100</html>", lote.obtenerIdentificadorLote());
	}
	
	@Test
	public void IdentificadorDeberiaDevolverseCorrecamente2(){
		Industria ind = new Industria();
		Lote lote = new Lote(1,1);
		TerrenoLLano terr = new TerrenoLLano();
		lote.definirTerrerno(terr);
		lote.insertarConstruccion(ind);
		
		Assert.assertEquals("<html>I <br/>100</html>", lote.obtenerIdentificadorLote());
	}
	
	@Test
	public void IdentificadorDeberiaDevolverseCorrecamente3(){
		CentralEolica eo = new CentralEolica(1,1);
		Lote lote = new Lote(1,1);
		TerrenoLLano terr = new TerrenoLLano();
		lote.definirTerrerno(terr);
		lote.insertarConstruccion(eo);
		
		Assert.assertEquals("<html>EO <br/>100</html>", lote.obtenerIdentificadorLote());
	}
	
	@Test
	public void IdentificadorDeberiaDevolverseCorrecamente4(){
		Lote lote = new Lote(1,1);
		TerrenoLLano terr = new TerrenoLLano();
		lote.definirTerrerno(terr);
		
		Assert.assertEquals("<html><br/>-</html>", lote.obtenerIdentificadorLote());
	}
	
	@Test
	public void DeberiaDevolverCorrectamenteSiEsAguaOtierra(){
		TerrenoLLano terr = new TerrenoLLano();
		Agua agua = new Agua();
		Mapa mapa = new Mapa(15);
		Lote lote1;
		Lote lote2;
		lote1 = mapa.obtenerLote(1, 1);
		lote1.definirTerrerno(terr);
		lote2 = mapa.obtenerLote(1, 2);
		lote2.definirTerrerno(agua);
		
		Assert.assertEquals(true, lote1.esLoteDeTierra());
		Assert.assertEquals(true, lote2.esLoteDeAgua());
	}
}
