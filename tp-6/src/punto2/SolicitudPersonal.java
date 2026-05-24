package punto2;

public class SolicitudPersonal extends Solicitud {

	final int porcentajeParaAprobarCuota = 70;
	
	public SolicitudPersonal(Cliente cliente, Double suma, int cuotas) {
		super(cliente, suma, cuotas);
	}
	
	public void chequearSolicitud() {
		this.setEstaAprobada(this.apruebaSueldo() && this.apruebaMontoDeCuota()); 
	}
	
	private boolean apruebaSueldo(){
		return this.getCliente().sueldoNeto() >= 15000d;
	}
	
	private boolean apruebaMontoDeCuota() {
		return this.porcentajeDeSueldoPorCuota() <= porcentajeParaAprobarCuota;
	}
	
	private Double porcentajeDeSueldoPorCuota() {
		return this.cuotaMensual() * 100 / this.getCliente().getSueldoMensual();
	}
}
