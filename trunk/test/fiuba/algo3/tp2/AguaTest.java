package fiuba.algo3.tp2;
import junit.framework.Assert;

import org.junit.Test;

public class AguaTest {

	@Test
	public void AguaDeberiaDebolverVerdaderoAlPreguntarleSiEsAgua(){
		Superficie superficieAgua = new Agua();

		Assert.assertEquals(((Agua) superficieAgua).esAgua(), true);
	}
	
	@Test
	public void AguaDeberiaDebolverFalsoAlPreguntarleSiEsTerrenoLLano(){
		Superficie superficieAgua = new Agua();

		Assert.assertEquals(((Agua)superficieAgua).esTerrenoLLano(), false);
	}
}
