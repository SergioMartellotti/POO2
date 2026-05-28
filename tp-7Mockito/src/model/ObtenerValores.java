	package model;
	
	import java.util.List;
	
	public interface ObtenerValores<T> {
		public List<T> obtenerValores(List<Carta> cartas);
	}
