package supermercado;

public class Producto {
    public String nombre;
    public Double precio;


	public Boolean esPrecioCuidado;

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
		this.precio = precio;
	}
    
    public Producto(String nombre, Double precio) {
        this.nombre = nombre;
        this.precio = precio;
        this.esPrecioCuidado = false;
    }
    
    public Producto(String nombre, Double precio, boolean esPrecioCuidado) {
        this.nombre = nombre;
        this.precio = precio;
        this.esPrecioCuidado = esPrecioCuidado;
    }    

	public String getNombre() {
		return nombre;
	}
	
	public boolean esPrecioCuidado() {
		return this.esPrecioCuidado;
	}
	
	public void aumentarPrecio(Double aumento) {
		this.setPrecio(this.getPrecio()+aumento);
	}
    
}