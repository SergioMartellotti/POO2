package model;

import java.util.List;

public abstract class ValidadorMano {
	
	List<String> cartas;
	
	abstract String getNombre();
	abstract boolean validar(List<Carta> cartas);
	
	public boolean buscarNIguales(List<String> cartas, int posicion, int cantidad) {
		return cartas.stream().filter(valor -> valor.equals(cartas.get(posicion))).count() == cantidad;
	}
}
