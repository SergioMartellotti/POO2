package punto6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Compuesto implements IShapeShifter{

	private List<IShapeShifter> shifters;
	
	public Compuesto() {
		shifters = new ArrayList<IShapeShifter>();
	}
	
	public Compuesto(IShapeShifter h1, IShapeShifter h2) {
		shifters = new ArrayList<IShapeShifter>(Arrays.asList(h1,h2));
	}
	
	public IShapeShifter compose(IShapeShifter h1){
		return new Compuesto(this, h1);
	}

	public int deepest() {
		return (shifters.stream()
						.mapToInt(c -> c.deepest())
						.max()
						.orElse(0))+1;
	}
	
	public IShapeShifter flat() {
		if (this.deepest() <= 1) return this;

	    List<IShapeShifter> hojas = this.values().stream()
	    								.map(Hoja::new)
	    								.collect(Collectors.toList());

	    Compuesto resultado = new Compuesto();
	    hojas.forEach(resultado::add);
	    
	    return resultado;
	}
	
	public void add(IShapeShifter s) {
		this.shifters.add(s);
	}
	public List<Integer> values(){
		return shifters.stream().flatMap(c->c.values().stream()).collect(Collectors.toList());
	}
}
