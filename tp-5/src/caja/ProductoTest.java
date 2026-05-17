package caja;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProductoTest {

	private Producto arroz;
	private Producto leche;
	private Producto pan;
	
	@BeforeEach
	public void setUp() {
		arroz = new ProductoCooperativa(100d,10);
		leche = new ProductoCooperativa(50d,10);
		pan = new ProductoTradicional(80d,1);
	}
	
	@Test
	void testHayStock() {
		assertEquals(pan.hayStock(),true);
		pan.restarUno();
		assertEquals(pan.hayStock(),false);
	}
	
	@Test
	void testPrecio() {
		assertEquals(arroz.getPrecio(),90);
		assertEquals(pan.getPrecio(),80);
	}	

}
