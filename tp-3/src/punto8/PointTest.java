package punto8;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PointTest {

	Point puntoA;
	Point puntoB;
	
	@Test
	void testPuntoCero() {
		puntoA = new Point();
		assertEquals(0,puntoA.getEjeX());
		assertEquals(0,puntoA.getEjeY());
	}

	@Test
	void testPuntoCreado() {
		puntoA = new Point(3,5);
		assertEquals(3,puntoA.getEjeX());
		assertEquals(5,puntoA.getEjeY());
	}
	
	@Test
	void testPuntoCambiado() {
		puntoA = new Point(3,5);
		puntoA.moverPunto(6, 10);
		assertEquals(6,puntoA.getEjeX());
		assertEquals(10,puntoA.getEjeY());
	}
	
	@Test
	void testPuntosSumados() {
		puntoA = new Point(3,5);
		puntoB = new Point(2,4);
		
		Point suma = puntoA.sumarCon(puntoB);
		
		assertEquals(5,suma.getEjeX());
		assertEquals(9,suma.getEjeY());
	}
}
