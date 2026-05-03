package punto9;
import punto8.Point;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RectanguloTest {
	
	private Rectangulo rectanguloH;
	private Rectangulo rectanguloV;
	private Cuadrado cuadrado;
	
	@Test
	void testRectanguloError() throws Exception {
		assertThrows(Exception.class, () -> {new Rectangulo(new Point(1,5), new Point(1,6));});
	}
	
	@Test
	void testRectanguloH() throws Exception{
		rectanguloH = new Rectangulo(new Point(1,5), new Point(5,6));
		assertEquals(true, rectanguloH.esHorizontal());
	}

	@Test
	void testRectanguloV() throws Exception{
		rectanguloV = new Rectangulo(new Point(1,5), new Point(5,60));
		assertEquals(false, rectanguloV.esHorizontal());
	}
	
	@Test
	void testCuadrado() throws Exception{
		cuadrado = new Cuadrado(new Point(1,5), 2);
		assertEquals(cuadrado.getAncho(), cuadrado.getAlto());
		assertEquals(8,cuadrado.getPerimetro());
	}
}
