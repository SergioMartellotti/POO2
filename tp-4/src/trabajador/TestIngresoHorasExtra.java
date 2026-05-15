package trabajador;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestIngresoHorasExtra {

	private IngresoHorasExtra ingreso;
	
	@BeforeEach
	public void setUp(){
		ingreso = new IngresoHorasExtra(1,"Pago Enero", 1000d, 10);
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
		assertEquals(0, ingreso.getImponible());
	}

	@Test
	void testGetCantidadHorasExtra() {
		assertEquals(10, ingreso.getCantidadHorasExtra());
	}
}

