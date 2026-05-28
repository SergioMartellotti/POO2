package test;

import model.*;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

class PokerStatusTestMockito {
	
	private PokerStatus2 pokerStatus;
	private List<ValidadorMano<?>> validadores;

    private Carta carta2p;
    private Carta carta3d;
    private Carta carta2d;
    private Carta carta2c;
    private Carta carta2t;
    private Carta carta8d;
    private Carta carta3c;
    private Carta carta3p;
    private Carta carta6p;
    private Carta carta10p;
    
	
	@BeforeEach
	void setUp() {
        carta2p = mock(Carta.class);
        carta3d = mock(Carta.class);
        carta2d = mock(Carta.class);
        carta2c = mock(Carta.class);
        carta2t = mock(Carta.class);
        carta8d = mock(Carta.class);
        carta3c = mock(Carta.class);
        carta3p = mock(Carta.class);
        carta6p = mock(Carta.class);
        carta10p = mock(Carta.class);        

        // 2 de Picas
        when(carta2p.getValor()).thenReturn(Valor.DOS);
        when(carta2p.getPalo()).thenReturn("P");
        
        // 3 de Diamantes
        when(carta3d.getValor()).thenReturn(Valor.TRES);
        when(carta3d.getPalo()).thenReturn("D");
        
        // 2 de Diamantes
        when(carta2d.getValor()).thenReturn(Valor.DOS);
        when(carta2d.getPalo()).thenReturn("D");
        
        // 2 de Corazones
        when(carta2c.getValor()).thenReturn(Valor.DOS);
        when(carta2c.getPalo()).thenReturn("C");
        
        // 2 de Tréboles
        when(carta2t.getValor()).thenReturn(Valor.DOS);
        when(carta2t.getPalo()).thenReturn("T");      

        // 8 de Diamantes
        when(carta8d.getValor()).thenReturn(Valor.OCHO);
        when(carta8d.getPalo()).thenReturn("D");
        
        // 3 de Corazones
        when(carta3c.getValor()).thenReturn(Valor.TRES);
        when(carta3c.getPalo()).thenReturn("C");
        
        // 3 de Picas
        when(carta3p.getValor()).thenReturn(Valor.TRES);
        when(carta3p.getPalo()).thenReturn("P");
        
        // 6 de Picas
        when(carta6p.getValor()).thenReturn(Valor.SEIS);
        when(carta6p.getPalo()).thenReturn("P");
        
        // 10 de Picas
        when(carta10p.getValor()).thenReturn(Valor.DIEZ);
        when(carta10p.getPalo()).thenReturn("P");
        
        // Validadores
        validadores = new ArrayList<ValidadorMano<?>>(Arrays.asList(new ValidarPoker(), new ValidarTrio(), new ValidarColor()));
        pokerStatus = new PokerStatus2(validadores);
	}

	
	@Test
	void verificarConPokerTest() {
		assertEquals("Poker", pokerStatus.verificar(carta2p, carta3d, carta2d, carta2c, carta2t));
	}

	@Test
	void verificarSinNadaTest() {
		assertEquals("Nada", pokerStatus.verificar(carta2p, carta3d, carta8d, carta3c, carta2t));
	}

	@Test
	void verificarTrioTest() {
		assertEquals("Trio", pokerStatus.verificar(carta2p, carta3d, carta2d, carta3c, carta2t));
	}
	
	@Test
	void verificarColorTest() {
		assertEquals("Color", pokerStatus.verificar(carta2p, carta3p, carta6p, carta10p, carta2p));
	}
}



