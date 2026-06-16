package punto1;

public class EmpleadoTemporario extends Empleado{
	
	private int cantidadHorasExtra;
	
	public EmpleadoTemporario(int cantidadHijos, boolean estaEnMatrimonio, int cantidadHorasExtra) {
		super(cantidadHijos, estaEnMatrimonio);
		this.cantidadHorasExtra = cantidadHorasExtra;
	}
	
	
	public Double calcularSueldoBasico() {
		return (5 * this.cantidadHorasExtra) + 1000d;
	}
	public Double bonoPorFamilia() {
		return (isEstaEnMatrimonio() || getCantidadHijos() > 0) ? 100.0 : 0.0;
	}
}
