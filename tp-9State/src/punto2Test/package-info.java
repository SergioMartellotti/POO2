package punto2Test;
import punto2.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EquipoTest {

    private Equipo equipo;
    private Song song;

    @BeforeEach
    void setUp() {
        song = new Song();
        equipo = new Equipo(song);
    }

    //Play desde selección

    @Test
    void playDesdeSeleccionFunciona() {
        assertDoesNotThrow(() -> equipo.play());
    }

    // Pause desde selección da error

    @Test
    void pauseDesdeSeleccionLanzaError() {
        assertThrows(Exception.class, () -> equipo.pause());
    }

    //Play dos veces da error

    @Test
    void playDesdePlayingLanzaError() throws Exception {
        equipo.play(); // pasa a Playing

        assertThrows(Exception.class, () -> equipo.play());
    }

    // Pause desde Playing

    @Test
    void pauseDesdePlayingFunciona() throws Exception {
        equipo.play();

        assertDoesNotThrow(() -> equipo.pause());
    }

    // Pause en pausa (reanuda)

    @Test
    void pauseEnPauseReanuda() throws Exception {
        equipo.play();   // Playing
        equipo.pause();  // Pause

        assertDoesNotThrow(() -> equipo.pause()); // debería reanudar
    }

    //Play desde Pause → error
    @Test
    void playDesdePauseLanzaError() throws Exception {
        equipo.play();
        equipo.pause();

        assertThrows(Exception.class, () -> equipo.play());
    }

    //Stop desde Playing
    @Test
    void stopDesdePlayingFunciona() throws Exception {
        equipo.play();

        assertDoesNotThrow(() -> equipo.stop());
    }

    //Stop desde Pause
    @Test
    void stopDesdePauseFunciona() throws Exception {
        equipo.play();
        equipo.pause();

        assertDoesNotThrow(() -> equipo.stop());
    }

    // Stop desde Select (no hace nada)
    @Test
    void stopDesdeSelectNoHaceNada() {
        assertDoesNotThrow(() -> equipo.stop());
    }
}