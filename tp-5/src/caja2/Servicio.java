package caja2;

public class Servicio implements Factura{

	private int cantidad;
	private Double precio;
	
	public Servicio(int cantidad, Double precio) {
		this.cantidad=cantidad;
		this.precio=precio;
	}
	
	public Double getPrecio() {
		return cantidad * precio;
	}
	
}
