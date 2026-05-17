package caja2;

abstract class Producto implements Pagable{
	
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
	
	public Double getPrecio() {
		if (this.hayStock()) {
			this.restarUno();
			return this.precioFinal();
		}
		return 0d;
	}
	
	abstract Double precioFinal();
}