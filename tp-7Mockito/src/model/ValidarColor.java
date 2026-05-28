package model;

import java.util.List;

public class ValidarColor extends ValidadorMano<String>{
	
	private ObtenerValores<String> valoresDeMano;

	public ValidarColor() {
		valoresDeMano = new ValoresTipos();
	}
	
	public String getNombre() {return "Color";}
	
	public boolean validar(List<Carta> cartas) {
		List<String> valores = valoresDeMano.obtenerValores(cartas);
		return buscarNIguales(valores, 0, 5); 
	}
}
