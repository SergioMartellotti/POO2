package punto6;

import java.util.List;

public interface IShapeShifter {
	public IShapeShifter compose(IShapeShifter iss);
	public int deepest();
	public IShapeShifter flat();
	public List<Integer> values();
}
