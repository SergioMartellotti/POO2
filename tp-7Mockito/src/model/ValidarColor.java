package model;

import java.util.List;

public class ValidarColor extends ValidadorMano{
	
	private ObtenerValores valoresDeMano;

	public ValidarColor() {
		valoresDeMano = new ValoresTipos();
	}
	
	public String getNombre() {return "Color";}
	
	public boolean validar(List<String> cartas) {
		List<String> valores = valoresDeMano.obtenerValores(cartas);
		return buscarNIguales(valores, 0, 5); 
	}
}
