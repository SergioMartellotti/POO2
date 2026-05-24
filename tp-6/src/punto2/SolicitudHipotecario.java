package punto2;

public class SolicitudHipotecario extends Solicitud{
	
	final int porcentajeParaAprobarCuota = 50;
	final int porcentajeParaAprobarInmueble = 70;
	private Inmueble inmueble;
	
	public SolicitudHipotecario(Cliente cliente, Double suma, int cuotas, Inmueble inmueble) {
		super(cliente, suma, cuotas);
		this.inmueble = inmueble;
	}
	
	public void chequearSolicitud() {
		this.setEstaAprobada(this.apruebaMontoDeCuota() && this.apruebaMontoPorInmueble() && this.apruebaEdad()); 
	}
	
	
	public boolean apruebaMontoDeCuota() {
		return this.porcentajeDeSueldoPorCuota() <= porcentajeParaAprobarCuota;
	}
	
	public Double porcentajeDeSueldoPorCuota() {
		return this.cuotaMensual() * 100 / this.getCliente().getSueldoMensual();
	}
	
	public boolean apruebaMontoPorInmueble() {
		return this.porcentajeDeValorInmueble() >= porcentajeParaAprobarInmueble;
	}
	
	public Double porcentajeDeValorInmueble() {
		return inmueble.getValorFiscal() * 100 / this.getSuma(); 
	}
	
	public boolean apruebaEdad() {
		return this.edadClienteAlFinalizar() <= 65;
	}
	
	public int edadClienteAlFinalizar() {
		return this.getCliente().getEdad() + (int) this.getCuotas()/12;
	}
}
