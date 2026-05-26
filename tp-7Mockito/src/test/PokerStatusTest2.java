package test;

import model.PokerStatus2;
import model.*;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PokerStatusTests2 {

	private PokerStatus2 pokerStatus;
    
	private List<ValidadorMano> validadores;

	
	@BeforeEach
	void setUp() {
		validadores = new ArrayList<>(Arrays.asList(new ValidarPoker(), new ValidarTrio(), new ValidarColor()));
		pokerStatus = new PokerStatus2(validadores);
	}
		
	@Test
	void verificarConPokerTest() {
		assertEquals("Poker", pokerStatus.verificar("2P","3D", "2D", "2C", "2T"));
	}

	@Test
	void verificarSinNadaTest() {
		assertEquals("Nada", pokerStatus.verificar("2P","3D", "8D", "3C", "2T"));
	}

	@Test
	void verificarTrio2Test() {
		assertEquals("Trio", pokerStatus.verificar("2P","3D", "2D", "3C", "2T"));
	}
	
	@Test
	void verificarColorTest() {
		assertEquals("Color", pokerStatus.verificar("2P","3P", "3P", "6P", "10P"));
	}
	
	@Test
	void verificarTrioTest() {
		assertEquals("Trio", pokerStatus.verificar("2P","3D", "2D", "3C", "2T"));
	}
}
