package fiuba.algo3.tp2;
import org.junit.Test;
import junit.framework.Assert;

public class EstacionBomberosTest {
	
	@Test
	public void EstacionBomberosDeberiaRepararCasasConDanios(){
		Mapa unMapa = new Mapa();
		Construccion unaCasa = new Casa();
		Construccion otraCasa = new Casa();

		unMapa.insertarConstruccionEn(5, 5, unaCasa);
		unMapa.insertarConstruccionEn(10, 10, otraCasa);

		Terremoto unTerremoto = new Terremoto();
		unTerremoto.iniciarTerremotoEn(7, 7, unMapa);
		
		Assert.assertEquals(3.0,unaCasa.obtenerVida());
		Assert.assertEquals(6.0,otraCasa.obtenerVida());

		
		EstacionBomberos unaEstacionBomberos = new EstacionBomberos();
		unMapa.insertarConstruccionEn(9, 9, unaEstacionBomberos);
		
		unaEstacionBomberos.repararMapa(unMapa);
		
		Assert.assertEquals(6.6, otraCasa.obtenerVida()); //repara el 10% de la casa que tenia 6 de vida
		Assert.assertEquals(3.3, unaCasa.obtenerVida()); //repara el 10% de la casa que tenia 3 de vida
	}

}
