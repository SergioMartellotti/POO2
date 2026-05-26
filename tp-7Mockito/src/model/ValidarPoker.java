package model;

import java.util.List;

public class ValidarPoker extends ValidadorMano{
	
	private ObtenerValores valoresDeMano;

	public ValidarPoker() {
		valoresDeMano = new ValoresNumeros();
	}
	
	public String getNombre() {return "Poker";}
	
	public boolean validar(List<String> cartas) {
		List<String> valores = valoresDeMano.obtenerValores(cartas);
		return buscarNIguales(valores, 0, 4) || buscarNIguales(valores, 1, 4); 
	}
}
