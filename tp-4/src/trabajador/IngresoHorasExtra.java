package trabajador;

public class IngresoHorasExtra extends Ingreso{

	private int cantidadHorasExtra;
	
	public IngresoHorasExtra(int mes, String concepto, Double monto, int cantidadHorasExtra) {
		super(mes, concepto, monto);
		this.cantidadHorasExtra = cantidadHorasExtra;
	}

	public int getCantidadHorasExtra() {
		return cantidadHorasExtra;
	}
	
	@Override
	public Double getImponible() {
		return 0d;
	}
	
}
