package caja2;

public class Impuesto implements Factura{
	
	private Double precio;
	
	public Impuesto(Double precio) {
		this.precio=precio;
	}
	
	public Double getPrecio() {
		return precio;
	}
}
