package fiuba.algo3.tp2;
import junit.framework.Assert;
import org.junit.Test;

public class CasaTest {
	@Test
	public void FooShouldDoFoo(){
		Casa foo = new Casa();
		String result = foo.doFoo();
		Assert.assertEquals("Foo", result);
	}

}
