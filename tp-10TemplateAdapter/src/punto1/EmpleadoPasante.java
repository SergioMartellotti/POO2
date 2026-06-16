package punto1;

public class EmpleadoPasante extends Empleado {

	private int cantidadHorasExtra;

	public EmpleadoPasante(int cantidadHijos, boolean estaEnMatrimonio, int cantidadHorasExtra) {
		super(cantidadHijos, estaEnMatrimonio);
		this.cantidadHorasExtra = cantidadHorasExtra;
	}
	
	public Double calcularSueldoBasico() {
		return 40.0 * this.cantidadHorasExtra;
	}
	public Double bonoPorFamilia() {
		return 0.0;
	}
	
}
