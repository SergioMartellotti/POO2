package trabajador;

import java.util.ArrayList;
import java.util.List;

public class Trabajador {
	
	private List<Ingreso> ingresos;
	
	public Trabajador() {
		ingresos = new ArrayList<>();
	}
	
	public void agregarIngreso(Ingreso ingreso){
		ingresos.add(ingreso);
	}
	
	public Double getTotalPercibido() {
		Double monto = 0d;
		for(Ingreso ingreso : this.ingresos) {
			monto += ingreso.getMonto();
		}
		return monto;
	}
	
	public Double getMontoImponible() {
		Double monto = 0d;
		for(Ingreso ingreso : this.ingresos) {
			monto += ingreso.getImponible();
		}
		return monto;
	}
	
	public Double getImpuestoAPagar() {
		return this.getMontoImponible() * 0.2;
	}
}
