package model;

import java.util.List;
import java.util.stream.Collectors;

public class ValoresTipos implements ObtenerValores<String>{
	
	public List<String> obtenerValores(List<Carta> cartas)  {
	    return cartas.stream()
	        .map(c -> c.getPalo())
	        .collect(Collectors.toList());
	}


}