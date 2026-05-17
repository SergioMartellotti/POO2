package caja2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CajaTest {

	private Caja caja;
	private List<Pagable> stockProductos;
	private Producto arroz;
	private Producto leche;
	private Producto pan;
	private Servicio servicio;
	private Impuesto impuesto;
	
	@BeforeEach
	public void setUp() {
		arroz = new ProductoCooperativa(100d,10);
		leche = new ProductoCooperativa(50d,10);
		pan = new ProductoTradicional(80d,1);
		servicio = new Servicio(50d, 2);
		impuesto = new Impuesto(20d);
		
		stockProductos = new ArrayList<Pagable>();
		stockProductos.add(arroz);
		stockProductos.add(leche);
		stockProductos.add(pan);
		caja = new Caja(stockProductos);
	}
		
	@Test
	void testVenderCooperativa() {
		List<Pagable> compra = new ArrayList<Pagable>();
		compra.add(arroz);
		compra.add(leche);
		compra.add(servicio);
		
		assertEquals(caja.vender(compra), 235);	
	}

	@Test
	void testVendeTradicional() {
		List<Pagable> compra = new ArrayList<Pagable>();
		compra.add(arroz);
		compra.add(pan);
		compra.add(impuesto);
		assertEquals(caja.vender(compra), 190);
	}
	
}


