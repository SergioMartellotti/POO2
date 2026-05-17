package caja2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CajaTest {

	private Caja caja;
	private List<Producto> stockProductos;
	private Producto arroz;
	private Producto leche;
	private Producto pan;
	
	@BeforeEach
	public void setUp() {
		arroz = new ProductoCooperativa(100d,10);
		leche = new ProductoCooperativa(50d,10);
		pan = new ProductoTradicional(80d,1);
		stockProductos = new ArrayList<Producto>();
		stockProductos.add(arroz);
		stockProductos.add(leche);
		stockProductos.add(pan);
		caja = new Caja(stockProductos);
	}
		
	@Test
	void testVenderCooperativa() {
		List<Producto> compra = new ArrayList<Producto>();
		compra.add(arroz);
		compra.add(leche);
		assertEquals(caja.vender(compra), 135);
		
	}

	@Test
	void testVendeTradicional() {
		List<Producto> compra = new ArrayList<Producto>();
		compra.add(arroz);
		compra.add(pan);
		assertEquals(caja.vender(compra), 170);
	}
}


