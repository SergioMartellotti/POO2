package punto2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolicitudHipotecarioTest {

	private Cliente cliente;
	private Inmueble inmueble;
	private Inmueble inmueble2;
	private Banco banco;
	private SolicitudHipotecario solicitud;
	
	@BeforeEach
	public void setUp() {
		this.banco = new Banco();
		this.inmueble = new Inmueble("direccion", 100000d);
		this.inmueble2 = new Inmueble("direccion", 35000d);
		this.cliente = new Cliente("Sergio", "Martellotti", 37, 2000d, banco);
	}	
	
	@Test
	public void apruebaMontoDeCuotaTest() {
		this.solicitud = new SolicitudHipotecario(this.cliente, 50000d, 50, inmueble);
		banco.registrarSolicitud(solicitud);
		banco.evaluarSolicitud();
		assertEquals(true, solicitud.apruebaMontoDeCuota());
	}

	@Test
	public void noApruebaMontoDeCuotaTest() {
		this.solicitud = new SolicitudHipotecario(this.cliente, 50001d, 50, inmueble);
		banco.registrarSolicitud(solicitud);
		banco.evaluarSolicitud();
		assertEquals(false, solicitud.apruebaMontoDeCuota());
	}
	
	@Test
	public void porcentajeDeSueldoPorCuotaTest() {
		this.solicitud = new SolicitudHipotecario(this.cliente, 50000d, 50, inmueble);
		banco.registrarSolicitud(solicitud);
		banco.evaluarSolicitud();
		assertEquals(50, solicitud.porcentajeDeSueldoPorCuota());
	}	

	
	@Test
	public void noPorcentajeDeSueldoPorCuotaTest() {
		this.solicitud = new SolicitudHipotecario(this.cliente, 50001d, 50, inmueble);
		banco.registrarSolicitud(solicitud);
		banco.evaluarSolicitud();
		assertNotEquals(50, solicitud.porcentajeDeSueldoPorCuota());
	}

	
	
	@Test
	public void porcentajeDeValorInmuebleTest() {
		this.solicitud = new SolicitudHipotecario(this.cliente, 50000d, 50, inmueble);
		banco.registrarSolicitud(solicitud);
		banco.evaluarSolicitud();
		assertEquals(200, solicitud.porcentajeDeValorInmueble());
	}
	
	@Test
	public void apruebaMontoPorInmuebleTest() {
		this.solicitud = new SolicitudHipotecario(this.cliente, 50000d, 50, inmueble);
		banco.registrarSolicitud(solicitud);
		banco.evaluarSolicitud();
		assertEquals(true, solicitud.apruebaMontoPorInmueble());
	}
	
	@Test
	public void noApruebaMontoPorInmuebleTest() {
		this.solicitud = new SolicitudHipotecario(this.cliente, 710000d, 50, inmueble);
		banco.registrarSolicitud(solicitud);
		banco.evaluarSolicitud();
		assertEquals(false, solicitud.apruebaMontoPorInmueble());
	}	
	
	@Test
	public void noApruebaPorEdadTest() {
		this.solicitud = new SolicitudHipotecario(this.cliente, 50000d, 350, inmueble);
		banco.registrarSolicitud(solicitud);
		banco.evaluarSolicitud();
		assertEquals(false, solicitud.apruebaEdad());
	}
	
	
}
