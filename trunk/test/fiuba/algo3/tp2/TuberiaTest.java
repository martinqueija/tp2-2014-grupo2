package fiuba.algo3.tp2;

import junit.framework.Assert;

import org.junit.Test;

public class TuberiaTest {
	@Test
	public void TuberiaDeberiaCrearseSinAgua(){
		TuberiaDeAgua tuberia = new TuberiaDeAgua();

		Assert.assertEquals(tuberia.tieneAgua(), false);
	}

}