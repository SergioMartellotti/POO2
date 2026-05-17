package caja;

public class ProductoCooperativa extends Producto{
	
	public ProductoCooperativa(Double precio, int cantidad) {
		super(precio,cantidad);
	}
	
	

	
	public Double getPrecio() {
		return this.precio - (this.precio * 0.1);
	}
}
