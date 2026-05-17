package caja2;

public class Impuesto implements Pagable, Agencia{
	
	private Double precio;
	
	public Impuesto(Double precio) {
		this.precio = precio;
	}
	
	public Double getPrecio() {
		return pagarYRegistrar();
	}
	
	private Double pagarYRegistrar() {
		registrarPago(this);
		return precio;
	}
	
	public void registrarPago(Pagable servicio) {
		
	}
}
