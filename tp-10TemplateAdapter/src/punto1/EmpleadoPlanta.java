package punto1;

public class EmpleadoPlanta extends Empleado{
	
	public EmpleadoPlanta(int cantidadHijos, boolean estaEnMatrimonio) {
		super(cantidadHijos, estaEnMatrimonio);
	}
	
	
	public Double calcularSueldoBasico() {
		return 3000d;
	}
	public Double bonoPorFamilia() {
		return getCantidadHijos() * 150.0;
	}
}
