package supermercado;
import java.util.ArrayList;
import java.util.List;

public class Supermercado {
    public String nombre;
    public String direccion;
    private List<Producto> productos;

    public Supermercado(String nombre, String direccion) {
    	this.nombre = nombre;
    	this.direccion = direccion;
    	productos = new ArrayList<>();
    	
    }
    
    public void agregarProducto(Producto producto) {
    	productos.add(producto);
    }
    
    public int getCantidadDeProductos() {
    	return productos.size();
    }
    
    public Double getPrecioTotal() {
    	double suma = 0;
    	for (Producto producto:productos) {
    		suma += producto.getPrecio();
    	}
    	return suma;
    }
}
