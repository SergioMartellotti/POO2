package model;

import java.util.List;
import java.util.stream.Collectors;

public class ValoresTipos implements ObtenerValores{
	
	public List<String> obtenerValores(List<String> cartas)  {
	    return cartas.stream()
	        .map(c -> extraerValor(c))
	        .collect(Collectors.toList());
	}
	
	public String extraerValor(String c) {
		return c.substring(c.length() - 1);
	}

}