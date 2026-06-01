package punto4;

import java.util.Date;

public class Archivo implements FyleSystem {
	
	private String nombre;
	private Date ultimaModificacion;
	private int peso;
	
	public Archivo(String nombre, int peso, Date fecha) {
		this.nombre = nombre;
		this.peso = peso;
		this.ultimaModificacion = fecha;
	}
	
	public void printStructure(int nivel){
	    System.out.println(" ".repeat(nivel) + this.getNombre());
	}

	public String getNombre() {
		return nombre;
	}

	public int totalSize(){
		return peso;
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
