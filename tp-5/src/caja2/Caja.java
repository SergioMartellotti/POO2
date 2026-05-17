package caja2;

import java.util.List;

public class Caja {

	private List<Pagable> productos;
	
	public Caja(List<Pagable> productos) {
		this.productos = productos; 
	}
	
	public Double vender(List<Pagable> productos){
		Double monto = 0d;
		for(Pagable producto : productos) {
				monto += producto.getPrecio();
		}
		return monto;
	}
}
