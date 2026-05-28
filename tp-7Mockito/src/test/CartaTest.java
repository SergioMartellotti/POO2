package test;

import model.Carta;
import model.Valor;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CartaTest {

	
	private Valor valor4;
	private Valor valor5;
	private Valor valorA;
	private Valor valorQ;
	
	
	private Carta carta4t;
	private Carta carta5t;
	private Carta cartaAc;
	private Carta cartakp;
	
	
	@BeforeEach
	void setUp() {
	valor4 = Valor.CUATRO;
	valor5 = Valor.CINCO;
	valorA = Valor.A;
	valorQ = Valor.Q;

	carta4t = new Carta(valor4, "T");
	carta5t = new Carta(valor5, "T");
	cartaAc = new Carta(valorA, "C");
	cartakp = new Carta(valorQ, "P");
	}
	
	@Test
	void sonMismoPaloTest() {
		assertEquals(true, carta4t.esMismoPalo(carta5t));
	}
	
	@Test
	void noSonMismoPaloTest() {
		assertEquals(false, carta4t.esMismoPalo(cartaAc));
	}

	@Test
	void laPrimeraEsMasGrandeTest() {
		assertTrue(cartaAc.esMayorQue(carta4t));
	}
}
