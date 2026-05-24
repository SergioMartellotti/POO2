package punto2;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class BancoTest {
    
    private Banco banco;
    private Cliente clienteAprobado;
    private Cliente clienteRechazado;
    private Inmueble inmueble;
    
    @Before
    public void setUp() {
        banco = new Banco();
        inmueble = new Inmueble("Av. Siempreviva 123", 200000.0);
        
        // Cliente con buen sueldo (aprueba créditos)
        clienteAprobado = new Cliente("Juan", "Perez", 35, 5000.0, banco);
        
        // Cliente con bajo sueldo (rechaza créditos)
        clienteRechazado = new Cliente("Pedro", "Gomez", 25, 800.0, banco);
        
        // Agregar clientes al banco
        banco.agregarCliente(clienteAprobado);
        banco.agregarCliente(clienteRechazado);
    }
    
    @Test
    public void testBancoInicialmenteVacio() {
        assertEquals(0, banco.getSolicitudes().size());
        assertEquals(0.0, banco.montoAEntregar(), 0.001);
    }
    
    @Test
    public void testRegistrarUnaSolicitud() {
        SolicitudPersonal solicitud = new SolicitudPersonal(clienteAprobado, 10000.0, 12);
        banco.registrarSolicitud(solicitud);
        
        assertEquals(1, banco.getSolicitudes().size());
        assertEquals(0.0, banco.montoAEntregar(), 0.001); // Aún no evaluada
    }
    
    @Test
    public void testEvaluarSolicitudPersonalAprobada() {
        // Cliente con sueldo neto: 12 * 5000 = 60000 (>= 15000)
        // Cuota mensual: 10000/12 = 833.33
        // Porcentaje de cuota: 833.33 * 100 / 5000 = 16.67% (<= 70%)
        SolicitudPersonal solicitud = new SolicitudPersonal(clienteAprobado, 10000.0, 12);
        banco.registrarSolicitud(solicitud);
        banco.evaluarSolicitud();
        
        assertTrue(solicitud.getEstaAprobada());
        assertEquals(10000.0, banco.montoAEntregar(), 0.001);
    }
    
    @Test
    public void testEvaluarSolicitudPersonalRechazada() {
        // Cliente con sueldo neto: 12 * 800 = 9600 (< 15000) 
        SolicitudPersonal solicitud = new SolicitudPersonal(clienteRechazado, 10000.0, 12);
        banco.registrarSolicitud(solicitud);
        banco.evaluarSolicitud();
        
        assertFalse(solicitud.getEstaAprobada());
        assertEquals(0.0, banco.montoAEntregar(), 0.001);
    }
    
    @Test
    public void testEvaluarSolicitudHipotecariaAprobada() {
        // Condiciones:
        // 1. Cuota: 50000/50 = 1000, porcentaje: 1000*100/5000 = 20% (<= 50%) 
        // 2. Inmueble: 200000 * 100 / 50000 = 400% (>= 70%) 
        // 3. Edad final: 35 + 50/12 = 35 + 4 = 39 (<= 65) 
        SolicitudHipotecario solicitud = new SolicitudHipotecario(clienteAprobado, 50000.0, 50, inmueble);
        banco.registrarSolicitud(solicitud);
        banco.evaluarSolicitud();
        
        assertTrue(solicitud.getEstaAprobada());
        assertEquals(50000.0, banco.montoAEntregar(), 0.001);
    }
    
    @Test
    public void testEvaluarSolicitudHipotecariaRechazadaPorCuota() {
        // Cuota mensual: 100000/12 = 8333.33
        // Porcentaje: 8333.33 * 100 / 5000 = 166.67% (> 50%) 
        SolicitudHipotecario solicitud = new SolicitudHipotecario(clienteAprobado, 100000.0, 12, inmueble);
        banco.registrarSolicitud(solicitud);
        banco.evaluarSolicitud();
        
        assertFalse(solicitud.getEstaAprobada());
        assertEquals(0.0, banco.montoAEntregar(), 0.001);
    }
    
    @Test
    public void testEvaluarSolicitudHipotecariaRechazadaPorInmueble() {
        // Inmueble de bajo valor: 50000 * 100 / 100000 = 50% (< 70%) 
        Inmueble inmuebleBarato = new Inmueble("Calle Falsa 123", 50000.0);
        SolicitudHipotecario solicitud = new SolicitudHipotecario(clienteAprobado, 100000.0, 120, inmuebleBarato);
        banco.registrarSolicitud(solicitud);
        banco.evaluarSolicitud();
        
        assertFalse(solicitud.getEstaAprobada());
        assertEquals(0.0, banco.montoAEntregar(), 0.001);
    }
    
    @Test
    public void testEvaluarSolicitudHipotecariaRechazadaPorEdad() {
        // Edad final: 60 + (240/12) = 60 + 20 = 80 (> 65) 
        Cliente clienteMayor = new Cliente("Jubilado", "Garcia", 60, 8000.0, banco);
        banco.agregarCliente(clienteMayor);
        
        SolicitudHipotecario solicitud = new SolicitudHipotecario(clienteMayor, 100000.0, 240, inmueble);
        banco.registrarSolicitud(solicitud);
        banco.evaluarSolicitud();
        
        assertFalse(solicitud.getEstaAprobada());
        assertEquals(0.0, banco.montoAEntregar(), 0.001);
    }
    
    @Test
    public void testMontoTotalMultiplesSolicitudes() {
        // Aprobada: 10000
        SolicitudPersonal solicitud1 = new SolicitudPersonal(clienteAprobado, 10000.0, 12);
        
        // Aprobada: 50000
        SolicitudHipotecario solicitud2 = new SolicitudHipotecario(clienteAprobado, 50000.0, 50, inmueble);
        
        // Rechazada: 20000
        SolicitudPersonal solicitud3 = new SolicitudPersonal(clienteRechazado, 20000.0, 24);
        
        banco.registrarSolicitud(solicitud1);
        banco.registrarSolicitud(solicitud2);
        banco.registrarSolicitud(solicitud3);
        
        // Evaluar cada una (tu método evaluarSolicitud() solo evalúa la primera)
        // Como tu método actual solo evalúa la primera, evaluamos manualmente
        solicitud1.chequearSolicitud();
        solicitud2.chequearSolicitud();
        solicitud3.chequearSolicitud();
        
        // Total esperado: 10000 + 50000 = 60000
        assertEquals(60000.0, banco.montoAEntregar(), 0.001);
    }
    
    @Test
    public void testMontoTotalCeroCuandoNoHayAprobadas() {
        SolicitudPersonal solicitud1 = new SolicitudPersonal(clienteRechazado, 10000.0, 12);
        SolicitudPersonal solicitud2 = new SolicitudPersonal(clienteRechazado, 20000.0, 24);
        
        banco.registrarSolicitud(solicitud1);
        banco.registrarSolicitud(solicitud2);
        
        solicitud1.chequearSolicitud();
        solicitud2.chequearSolicitud();
        
        assertEquals(0.0, banco.montoAEntregar(), 0.001);
    }
}
