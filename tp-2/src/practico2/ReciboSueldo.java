package practico2;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;


public class ReciboSueldo {
	
	public void armarRecibo(Empleado empleado){
		try {
			FileWriter writer = new FileWriter(empleado.getNombre()+".txt");
	            writer.write("Nombre: " + empleado.getNombre() + "\n");
	            writer.write("Dirección: " + empleado.getDireccion() + "\n");
	            writer.write("Fecha de emisión: " + LocalDate.now() + "\n");
	            writer.write("\n");
	            writer.write("Conceptos para sueldo Bruto: \n");
	            for(Concepto concepto:empleado.getConceptosSueldoBruto()) {
	            	writer.write(concepto.getNombre()+": " + concepto.getMonto() + "\n");
	            }
	            writer.write("\n");
	            writer.write("Sueldo Bruto = Sueldo Básico + Conceptos: \n");
	            writer.write("Sueldo Bruto: " + empleado.sueldoBruto() + "\n");
	            writer.write("\n");
	            writer.write("Conceptos de retenciones: \n");
	            for(Concepto concepto:empleado.getConceptosRetenciones()) {
	            	writer.write(concepto.getNombre()+": -" + concepto.getMonto() + "\n");
	            }
	            writer.write("\n");
	            writer.write("Retenciones: " + empleado.retenciones() + "\n");
	            writer.write("\n");
	            writer.write("Sueldo Neto = Sueldo Bruto - Retenciones. \n");
	            writer.write("Sueldo Neto: " + empleado.sueldoNeto() + "\n");
	            writer.close();
	        } catch (IOException e) {
	            System.out.println("Error al escribir el archivo");
	            e.printStackTrace();
	        }		
	}
}
