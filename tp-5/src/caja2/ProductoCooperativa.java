package caja2;

public class ProductoCooperativa extends Producto{
	
	public ProductoCooperativa(Double precio, int cantidad) {
		super(precio,cantidad);
	}
	
	public Double precioFinal() {
		return this.precio - (this.precio * 0.1);
	}
}
