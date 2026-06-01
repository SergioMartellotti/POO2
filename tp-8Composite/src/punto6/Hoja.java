package punto6;

import java.util.Arrays;
import java.util.List;

public class Hoja implements IShapeShifter{
	
	private Integer number;
	
	public Hoja(Integer n) {
		this.number = n;
	}
	
	public int getNumber(){
		return this.number;
	}
	
	public IShapeShifter compose(IShapeShifter iss) {
		return new Compuesto(this, iss);
	}
	
	public int deepest() {
		return 0;
	}
	
	public IShapeShifter flat() {
		return this;
	}
	
	public List<Integer> values(){
		List<Integer> values = Arrays.asList(this.getNumber());
		return values;
	}

}
