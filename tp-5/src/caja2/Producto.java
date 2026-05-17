package caja2;

abstract class Producto {
	
	protected Double precio;
	private int cantidad;
	
	public Producto(Double precio, int cantidad) {
		this.precio = precio;
		this.cantidad = cantidad;
	}
	
	public boolean hayStock() {
		return this.cantidad > 0;
	}
	
	public void restarUno() {
		cantidad--;
	}
		
	public abstract Double getPrecio();
}
