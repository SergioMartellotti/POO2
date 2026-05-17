package caja2;

public class ProductoTradicional extends Producto{
	
	public ProductoTradicional(Double precio, int cantidad) {
		super(precio,cantidad);
	}
	
	public Double precioFinal() {
		return super.precio;
	}
	
}
