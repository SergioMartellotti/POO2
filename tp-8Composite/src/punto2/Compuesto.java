package punto2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Compuesto extends Component{
	
	private List<Component> componentes;
	
	public Compuesto(Component c1, Component c2, Component c3, Component c4){
		 componentes = new ArrayList<Component>(Arrays.asList(c1,c2,c3,c4));
	}
	
	public Double precio(){
		return componentes.stream().mapToDouble(c->c.precio()/4).sum();
	}
	
	public void reemplazar(Component componente, int indice){
        componentes.set(indice, componente);
    }
        
}
