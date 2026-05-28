package model;

import java.util.List;
import java.util.stream.Collectors;

public class ValoresNumeros implements ObtenerValores<Valor>{
	
	public List<Valor> obtenerValores(List<Carta> cartas) {
	    return cartas.stream()
	        .map(c -> c.getValor())
	        .collect(Collectors.toList());
	}
}
