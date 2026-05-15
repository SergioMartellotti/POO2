package trabajador;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IngresoTest {

	private Ingreso ingreso;
	
	@BeforeEach
	public void setUp(){
		ingreso = new Ingreso(1,"Pago Enero", 1000d);
	}
	
	@Test
	void testGetMonto() {
		assertEquals(1000, ingreso.getMonto());
	}

	@Test
	void testGetMes() {
		assertEquals(1, ingreso.getMes());
	}
	
	@Test
	void getConcepto() {
		assertEquals("Pago Enero", ingreso.getConcepto());
	}
	
	@Test
	void testGetImponible() {
		assertEquals(1000, ingreso.getImponible());
	}
}
