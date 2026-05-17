package caja2;

import java.util.List;

public class Caja {

	protected List<Producto> productos;
	
	public Caja(List<Producto> productos) {
		this.productos = productos; 
	}
	
	public Double vender(List<Producto> productos){
		Double monto = 0d;
		for(Producto producto : productos) {
			if (producto.hayStock()) {
				producto.restarUno();
				monto += producto.getPrecio();
			}
		}
		return monto;
	}
}

