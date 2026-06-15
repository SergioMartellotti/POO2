package punto1Test;

import punto1.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JuegoTest {

    private Juego juego;

    @BeforeEach
    void setUp() {
        juego = new Juego();
    }

    //Estado inicial
    @Test
    void estadoInicialSinFichas() {
        assertEquals(0, juego.getFichas());
    }

    //Ingresar 1 ficha
    @Test
    void ingresarUnaFicha() {
        juego.ponerFicha();

        assertEquals(1, juego.getFichas());
    }

    //Juego con 1 jugador
    @Test
    void jugarConUnaFicha() {
        juego.ponerFicha();      // pasa a Juego1Ficha
        juego.presionarBoton();  // inicia juego

        assertEquals(0, juego.getFichas()); // gastó la ficha
    }

    //Juego con 2 jugadores
    @Test
    void jugarConDosFichas() {
        juego.ponerFicha();
        juego.ponerFicha();

        juego.presionarBoton();

        assertEquals(0, juego.getFichas()); // gastó 2 fichas
    }

    // ------------------------
    // 🧪 No permite más de 2 fichas
    // ------------------------

    @Test
    void noPermiteMasDeDosFichas() {
        juego.ponerFicha();
        juego.ponerFicha();
        juego.ponerFicha();

        assertEquals(2, juego.getFichas()); // siguen habiendo 2
    }

    // No ingresan fichas mientras está jugando
    @Test
    void noPermiteFichasDuranteJuego() {
        juego.ponerFicha();
        juego.presionarBoton();
        juego.ponerFicha();

        assertEquals(0, juego.getFichas()); // no ingresó
    }

    // Se bloquea Botón durante juego
    @Test
    void botonNoHaceNadaDuranteJuego() {
        juego.ponerFicha();
        juego.presionarBoton();
        juego.presionarBoton();
        assertEquals(0, juego.getFichas());
    }

}