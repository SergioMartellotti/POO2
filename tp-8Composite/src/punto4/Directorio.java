package punto4;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Directorio implements FyleSystem{
	
	private String nombre;
	private Date ultimaModificacion;
	private List<FyleSystem> fyleSystem = new ArrayList<FyleSystem>();
	
	public Directorio(String nombre, Date fecha) {
		this.nombre = nombre;
		this.ultimaModificacion = fecha;
	}
	
	public void printStructure(int nivel) {
	    System.out.println(" ".repeat(nivel) + this.getNombre());
	    
	    for (FyleSystem file : fyleSystem) {
	        file.printStructure(nivel + 2);
	    }
	}

	public void add(FyleSystem file) {
		fyleSystem.add(file);
	}
	
	public String getNombre() {
		return nombre;
	}
	public int totalSize() {
		int total = 0;
		for(FyleSystem file : fyleSystem) {
			 total += file.totalSize();
		}
		return total;
	}
	public FyleSystem lastModified() {
        throw new UnsupportedOperationException("No es un directorio!");
	}
	
	public FyleSystem oldestElement() {
        throw new UnsupportedOperationException("No es un directorio!");
	}

	public Date getUltimaModificacion() {
		return ultimaModificacion;
	}
	
}
