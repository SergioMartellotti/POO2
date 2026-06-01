package punto3;

import java.util.ArrayList;
import java.util.List;

public class Composicion extends Componente{

	private List<Componente> ejercito = new ArrayList<Componente>(); 
	
	public Composicion(Componente ejercito) {
		this.ejercito.add(ejercito);
	}
	
	public Composicion() {		
	}
	
	public void caminar(int x, int y) {
		for (Componente miembro : ejercito) {
            miembro.caminar(x, y);
        }
	}
}
