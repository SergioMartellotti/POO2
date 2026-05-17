package caja2;

import java.util.List;

public class CajaConFacturas extends Caja implements Agencia{
	
	public CajaConFacturas(List<Producto> productos) {
		super(productos);
	}
	
	
	public Double cobrarFactura(Factura factura) {
		registrarPago(factura);
		return factura.getPrecio();
	}
	
	public void registrarPago(Factura factura) {
		
	}
}
