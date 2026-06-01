package punto2;

public abstract class Component {

	public abstract Double precio();
   
    public void reemplazar(Component componente, int indice) {
        throw new UnsupportedOperationException("Este componente no soporta reemplazar hijos");
    }
}
