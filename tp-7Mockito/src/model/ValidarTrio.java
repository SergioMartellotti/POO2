package model;

import java.util.List;

public class ValidarTrio extends ValidadorMano<Valor>{
	
	private ObtenerValores<Valor> valoresDeMano;

	public ValidarTrio() {
		valoresDeMano = new ValoresNumeros();
	}
	
	public String getNombre() {return "Trio";}
	
	public boolean validar(List<Carta> cartas) {
		List<Valor> valores = valoresDeMano.obtenerValores(cartas);
		return buscarNIguales(valores, 0, 3) || buscarNIguales(valores, 1, 3) || buscarNIguales(valores, 2, 3); 
	}
}