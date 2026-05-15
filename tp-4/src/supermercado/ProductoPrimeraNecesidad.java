package supermercado;

public class ProductoPrimeraNecesidad extends Producto{

    // private final Double DESCUENTO_APLICADO = 0.9;
	private Double descuento_aplicado;
	
    @Override
    public Double getPrecio(){
        return super.getPrecio() - super.getPrecio() * descuento_aplicado / 100;
    }

    public ProductoPrimeraNecesidad(String nombre, Double precio, Double descuento) {
        super(nombre, precio);
        this.descuento_aplicado = descuento;
    }
    
    public ProductoPrimeraNecesidad(String nombre, Double precio,  Double descuento, Boolean esPrecioCuidado) {
        super(nombre, precio);
        this.esPrecioCuidado = esPrecioCuidado;
        this.descuento_aplicado= descuento;
    }
}
