package punto2;

abstract class Solicitud {
	
	private Cliente cliente;
	private Double suma;
	private int cuotas;
	private boolean estaAprobada;
	
	public Solicitud(Cliente cliente, Double suma, int cuotas) {
		this.cliente = cliente;
		this.suma = suma;
		this.cuotas = cuotas;
		this.estaAprobada = false;
	}
	
	public Double cuotaMensual() {
		return suma/cuotas;
	}
	
	abstract void chequearSolicitud();

	public Cliente getCliente() {
		return cliente;
	}
	
	public boolean getEstaAprobada() {
		return estaAprobada;
	}

	public void setEstaAprobada(boolean estaAprobada) {
		this.estaAprobada = estaAprobada;
	}

	public Double getSuma() {
		return suma;
	}

	public int getCuotas() {
		return cuotas;
	}
	
	
}
