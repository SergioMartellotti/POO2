package caja2;

public class Servicio implements Pagable, Agencia{
	
	private Double precio;
	private int cantidad;
	
	public Servicio(Double precio, int cantidad) {
		this.precio = precio;
		this.cantidad = cantidad;
	}

	public Double getPrecio() {
		return pagarYRegistrar();
	}
	
	private Double pagarYRegistrar() {
		registrarPago(this);
		return precio * cantidad;
	}
	
	public void registrarPago(Pagable servicio) {
		
	}
}
