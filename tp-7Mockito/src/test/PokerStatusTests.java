package test;
import model.PokerStatus;

import static org.junit.jupiter.api.Assertions.*;

import org.mockito.Mock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PokerStatusTests {

	private PokerStatus pokerStatus;
	
	@BeforeEach
	void setUp() {
		pokerStatus = new PokerStatus();
	}
	
	
	@Test
	void verificarConPokerTest() {
		assertTrue(pokerStatus.verificar("2P","3D", "2D", "2C", "2T"));
	}

	@Test
	void verificarSinPokerTest() {
		assertFalse(pokerStatus.verificar("2P","3D", "2D", "3C", "2T"));
	}
}
