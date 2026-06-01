package punto6test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import punto6.*;

class ShapeShifterTest {

    private IShapeShifter a, b, c, d, e, f;

    @BeforeEach
    void setUp() {
        // Hojas
        a = new Hoja(1);
        b = new Hoja(2);

        // c = [1, 2]
        c = a.compose(b);

        // d = [3, [1,2]]
        IShapeShifter tres = new Hoja(3);
        d = tres.compose(c);

        // e = [5,6]
        IShapeShifter cinco = new Hoja(5);
        IShapeShifter seis = new Hoja(6);
        e = cinco.compose(seis);

        // f = [ d , e ]
        f = d.compose(e);
    }

    // ------------------------
    // 🧪 DEEPEST
    // ------------------------

    @Test
    void testDeepest() {
        assertEquals(0, a.deepest()); // hoja
        assertEquals(1, c.deepest()); // [1,2]
        assertEquals(2, d.deepest()); // [3, [1,2]]
        assertEquals(3, f.deepest()); // estructura completa
    }

    // ------------------------
    // 🧪 VALUES
    // ------------------------

    @Test
    void testValues() {
        List<Integer> valoresA = a.values();
        assertTrue(valoresA.contains(1));
        assertEquals(1, valoresA.size());

        List<Integer> valoresD = d.values();
        assertTrue(valoresD.containsAll(List.of(3,1,2)));

        List<Integer> valoresF = f.values();
        assertTrue(valoresF.containsAll(List.of(3,1,2,5,6)));
    }

    // ------------------------
    // 🧪 FLAT
    // ------------------------

    @Test
    void testFlatSimple() {
        // hoja no cambia
        IShapeShifter flatA = a.flat();
        assertEquals(0, flatA.deepest());
        assertEquals(List.of(1), flatA.values());
    }

    @Test
    void testFlatNivel1() {
        // ya está plano
        IShapeShifter flatC = c.flat();
        assertEquals(1, flatC.deepest());
        assertTrue(flatC.values().containsAll(List.of(1,2)));
    }

    @Test
    void testFlatComplejo() {
        IShapeShifter flatF = f.flat();

        // profundidad debe ser 1
        assertEquals(1, flatF.deepest());

        // debe contener todos los valores
        List<Integer> valores = flatF.values();
        assertTrue(valores.containsAll(List.of(3,1,2,5,6)));
        assertEquals(5, valores.size());
    }

    // ------------------------
    // 🧪 COMPOSE
    // ------------------------

    @Test
    void testComposeBasico() {
        IShapeShifter resultado = a.compose(b);

        assertEquals(1, resultado.deepest());
        assertTrue(resultado.values().containsAll(List.of(1,2)));
    }

    @Test
    void testComposeComplejo() {
        IShapeShifter resultado = d.compose(e);

        assertEquals(3, resultado.deepest());
        assertTrue(resultado.values().containsAll(List.of(3,1,2,5,6)));
    }
}