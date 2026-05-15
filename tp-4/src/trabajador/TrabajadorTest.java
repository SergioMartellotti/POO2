package trabajador;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TrabajadorTest {

	private Trabajador trabajador;
	
	
	@BeforeEach
	public void setUp(){
		trabajador = new Trabajador();
		trabajador.agregarIngreso(new Ingreso(1,"Pago Enero", 1000d));
		trabajador.agregarIngreso(new Ingreso(2,"Pago Febrero", 1500d));
		trabajador.agregarIngreso(new Ingreso(3,"Pago Marzo", 2000d));
		trabajador.agregarIngreso(new IngresoHorasExtra(3,"Horas Marzo", 90d, 5));
	}
	
	@Test
	void testTotalPercibido() {
		assertEquals(4590, trabajador.getTotalPercibido());
	}

	@Test
	void testMontoImponible() {
		assertEquals(4500, trabajador.getMontoImponible());
	}
	
	@Test
	void testImpuestoAPagar() {
		assertEquals(900, trabajador.getImpuestoAPagar());
	}	
}
