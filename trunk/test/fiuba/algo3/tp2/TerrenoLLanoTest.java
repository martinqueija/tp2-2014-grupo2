package fiuba.algo3.tp2;
import junit.framework.Assert;

import org.junit.Test;

public class TerrenoLLanoTest {

	@Test
	public void TerreroLLanoDeberiaDebolverVerdaderoAlPreguntarleSiEsTerrenoLLano(){
		Superficie terrenoLLano = new TerrenoLLano();

		Assert.assertEquals(((TerrenoLLano)terrenoLLano).esTerrenoLLano(), true);
	}
	
	@Test
	public void TerrernoLLanoDeberiaDebolverFalsoAlPreguntarleSiEsAgua(){
		Superficie terrenoLLano = new TerrenoLLano();

		Assert.assertEquals(((TerrenoLLano)terrenoLLano).esAgua(), false);
	}
}
