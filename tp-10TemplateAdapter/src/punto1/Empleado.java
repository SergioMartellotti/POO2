package punto1;

public abstract class Empleado {
	
	private int cantidadHijos;
	private boolean estaEnMatrimonio;
	
	
	public Empleado(int cantidadHijos, boolean estaEnMatrimonio) {
		this.cantidadHijos = cantidadHijos;
		this.estaEnMatrimonio = estaEnMatrimonio;
	}


	public int getCantidadHijos() {
		return cantidadHijos;
	}


	public void setCantidadHijos(int cantidadHijos) {
		this.cantidadHijos = cantidadHijos;
	}


	public boolean isEstaEnMatrimonio() {
		return estaEnMatrimonio;
	}


	public void setEstaEnMatrimonio(boolean estaEnMatrimonio) {
		this.estaEnMatrimonio = estaEnMatrimonio;
	}
	
	public Double calcularSueldo(){
		return calcularSueldoBasico() + bonoPorFamilia();
	}
	
	//faltan otros conceptos pero no están aclarados en la consigna.
	public Double calcularSueldoConAportes(){
		Double sueldo = this.calcularSueldo(); 
		return  sueldo - (sueldo * 0.13); 
	}
	
	
	public abstract Double calcularSueldoBasico();
	public abstract Double bonoPorFamilia();
}
