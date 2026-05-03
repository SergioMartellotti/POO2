package practico2;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public abstract class Empleado {
	
	private String nombre;
	private String direccion;
	private String estadoCivil;
	private LocalDate fechaNac;
	private Float sueldoBasico;
	
			
	
	public Empleado(String nombre, String direccion, String estadoCivil, LocalDate fechaNac, Float sueldoBasico) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.estadoCivil = estadoCivil;
		this.fechaNac = fechaNac;
		this.sueldoBasico = sueldoBasico;
	}
	
	public int getEdad() {
		return Period.between(fechaNac, LocalDate.now()).getYears();
	}
	
	public abstract float sueldoBruto();
	public abstract float retenciones();
	public abstract float aporteJubilatorio();
	public abstract List<Concepto> getConceptosSueldoBruto();
	public abstract List<Concepto> getConceptosRetenciones();
	
	public float aporteObraSocial() {
		return sueldoBruto()*0.1f;
	}
		
	public float sueldoNeto() {
		return sueldoBruto() - retenciones(); 
	}
	
	protected String getEstadoCivil() {
		return estadoCivil;
	}

	protected Float getSueldoBasico() {
		return sueldoBasico;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public LocalDate getFechaNac() {
		return fechaNac;
	}
	

}

