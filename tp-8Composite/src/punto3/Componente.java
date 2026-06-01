package punto3;

public abstract class Componente {
	
	public abstract void caminar(int x, int y);
	
	public void anadir(Componente c){
        throw new UnsupportedOperationException("Este componente no soporta añadir tropas");
	}
	
	public void eliminar(Componente c) {
        throw new UnsupportedOperationException("Este componente no soporta eliminar tropas");	
	}
}
