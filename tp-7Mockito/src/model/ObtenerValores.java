	package model;
	
	import java.util.List;
	
	public interface ObtenerValores {
		public List<String> obtenerValores(List<Carta> cartas);
		public String extraerValor(String c);
	}
