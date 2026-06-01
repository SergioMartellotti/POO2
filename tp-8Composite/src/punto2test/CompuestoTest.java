package punto2test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import punto2.*;

class CompuestoTest {

	private HojaTrigo hojaT;
	private HojaSoja hojaS;
	private Compuesto c1;
	private Compuesto c2;
	
	@BeforeEach
	void setUp() {
		hojaT = new HojaTrigo();
		hojaS = new HojaSoja();
		
		c1 = new Compuesto(hojaS,hojaS,hojaT,hojaT);
		c2 = new Compuesto(hojaS,hojaT, c1, hojaS);
	}
	
	@Test
	void sumarCompuesto1() {
		assertEquals(1600, c1.precio());
	}
	
	@Test
	void sumarCompuesto2() {
		assertEquals(1700, c2.precio());
	}
	
	@Test
	void reemplazar() {
		c1.reemplazar(hojaT, 0);
		c1.reemplazar(hojaT, 1);
		assertEquals(1200, c1.precio());
	}
}