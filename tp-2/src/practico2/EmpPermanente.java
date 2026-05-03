package practico2;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class EmpPermanente extends Empleado{
	
	private int cantHijos;
	private int antiguedad;
	
	public EmpPermanente(String nombre, String direccion, String estadoCivil, LocalDate fechaNac, Float sueldoBasico, int cantHijos, int antiguedad) {
		super(nombre, direccion, estadoCivil, fechaNac, sueldoBasico);
		this.cantHijos = cantHijos;
		this.antiguedad = antiguedad;
	}
	
	public float sueldoBruto() {
		return this.getSueldoBasico() + sueldoFamiliar() + sumaPorAntiguedad();
	}
	

	private float sueldoFamiliar() {
		return 150*cantHijos + cienSiEsCasado();
	} 

	private float sumaPorAntiguedad() {
		return 50 * antiguedad;
	}
	
	private int cienSiEsCasado() {
		if (this.getEstadoCivil() == "casado"){
				return 100;
		} else {
			return 0;
		}
	}
	
	public float retenciones() {
		return  aporteObraSocial() + aportePorHijos() + aporteJubilatorio();
	}
	


	private float aportePorHijos() {
		return cantHijos*20;
	}
	
	public float aporteJubilatorio() {
		return 0.10f * sueldoBruto();
	}
	
	public List<Concepto> getConceptosSueldoBruto(){
		List<Concepto> conceptos = new ArrayList<>();
		conceptos.add(new Concepto("Sueldo Basico", this.getSueldoBasico()));
		
		if (cantHijos>0) {conceptos.add(new Concepto("Concepto Hijos", 150*cantHijos ));}
		if (this.getEstadoCivil()=="casado") {conceptos.add(new Concepto("Concepto casado", 100));}
		
		conceptos.add(new Concepto("Antiguedad", this.sumaPorAntiguedad()));
		return conceptos;
		
	}
	
	public List<Concepto> getConceptosRetenciones(){
		List<Concepto> retenciones = new ArrayList<>();
		retenciones.add(new Concepto("Obra Social", aporteObraSocial()));
		
		if (cantHijos>0) {retenciones.add(new Concepto("Retención por Hijos", 20*cantHijos ));}
		
		retenciones.add(new Concepto("Aporte Jubilatorio", aporteJubilatorio()));
		return retenciones;
	}

}
