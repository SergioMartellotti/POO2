package practico2;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmpTemporario extends Empleado{
	
	private LocalDate finDeDesignacion;
	private int cantHorasExtra;
	
	public EmpTemporario(String nombre, String direccion, String estadoCivil, LocalDate fechaNac, Float sueldoBasico, LocalDate finDeDesignacion, int cantHorasExtra) {
		super(nombre, direccion,estadoCivil,fechaNac,sueldoBasico);
		this.finDeDesignacion = finDeDesignacion;
		this.cantHorasExtra = cantHorasExtra;
	}
	
	
	public float sueldoBruto() {
		return this.getSueldoBasico() + sumaPorHorasExtra();
	}
	
	private int sumaPorHorasExtra() {
		return cantHorasExtra * 40;
	}
	
	public float retenciones() {
		return aporteObraSocial() + aportePorEdad() + aporteJubilatorio() + aportePorHorasExtra();
	}
	
	public float aporteJubilatorio() {
		return 0.10f * sueldoBruto();
	}
	
	private int aportePorEdad() {
		if (getEdad() > 50){
			return 25;
		} else {
			return 0;
		}
	}
	
	private float aportePorHorasExtra() {
		return 5 * cantHorasExtra;
	}


	public LocalDate getFinDeDesignacion() {
		return finDeDesignacion;
	}
	
	public List<Concepto> getConceptosSueldoBruto(){
		List<Concepto> conceptos = new ArrayList<>();
		conceptos.add(new Concepto("Sueldo Basico", this.getSueldoBasico()));	
		conceptos.add(new Concepto("Horas Extras", this.sumaPorHorasExtra()));

		return conceptos;
		
	}
	
	public List<Concepto> getConceptosRetenciones(){
		List<Concepto> retenciones = new ArrayList<>();
		retenciones.add(new Concepto("Obra Social", aporteObraSocial()));
		
		if (getEdad() > 50) {retenciones.add(new Concepto("Aporte por Edad", aportePorEdad() ));}

		retenciones.add(new Concepto("Aporte Jubilatorio", aporteJubilatorio()));
		
		if (cantHorasExtra>0) {retenciones.add(new Concepto("Retención por horas Extras", this.aportePorHorasExtra()));}

		return retenciones;
	}
	
	
}
