package supermercado;

public class ProductoPrimeraNecesidad extends Producto{

    private final Double DESCUENTO_APLICADO = 0.9;

    @Override
    public Double getPrecio(){
        return super.getPrecio() * DESCUENTO_APLICADO;
    }

    public ProductoPrimeraNecesidad(String nombre, Double precio) {
        super(nombre, precio);
    }
    
    public ProductoPrimeraNecesidad(String nombre, Double precio, Boolean esPrecioCuidado) {
        super(nombre, precio);
        this.esPrecioCuidado = esPrecioCuidado;
    }
}
