package practico2;
import java.util.ArrayList;
import java.util.List;


public class Empresa {
	
	public String nombre;
	public String cuit;
	public List<Empleado> empleados;
	public ReciboSueldo impresora; 
	
	public Empresa(String nombre, String cuit) {
		this.nombre = nombre;
		this.cuit = cuit;
		empleados = new ArrayList<>();
		impresora = new ReciboSueldo();
	}
	
	public void agregarEmpleado(Empleado e){
		empleados.add(e);
	}
	
	
	public void liquidarSueldos() {
		
		for (Empleado empleado : empleados) {
			impresora.armarRecibo(empleado);
		}		

	}
	
	public float sumaDeNetos() {
		float total = 0;
		
		for (Empleado empleado : empleados) {
			total = total + empleado.sueldoNeto(); 
		}
		return total;
	}
	
	public float sumaDeBrutos() {
		float total = 0;
		
		for (Empleado empleado : empleados) {
			total = total + empleado.sueldoBruto(); 
		}
		return total;
	}
	
	public float sumaDeRetenciones() {
		float total = 0;
		
		for (Empleado empleado : empleados) {
			total = total + empleado.retenciones(); 
		}
		return total;
	}
	

	
}
