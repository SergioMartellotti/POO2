package model;

import java.util.ArrayList;
import java.util.List;

public class PokerStatus {
	
	public boolean verificar(String c1, String c2, String c3, String c4, String c5) {
		
		List<String> valoresDeCartas = valoresDeCartas(c1,c2,c3,c4,c5);
				
		return hayCuatroValoresIguales(valoresDeCartas);
	}
	
	private List<String> valoresDeCartas(String c1, String c2, String c3, String c4, String c5){
		List<String> valoresDeCartas = new ArrayList<String>();
		valoresDeCartas.add(valor(c1));
		valoresDeCartas.add(valor(c2));
		valoresDeCartas.add(valor(c3));
		valoresDeCartas.add(valor(c4));
		valoresDeCartas.add(valor(c5));
		return valoresDeCartas;
	}
	
	private String valor(String c) {
		return (c.length() == 2 ? c.substring(0,1) : c.substring(0,2));
	}
	
	private boolean hayCuatroValoresIguales(List<String> valores) {
		return valores.stream().filter(valor -> valor.equals(valores.get(0))).count() == 4 ||
			   valores.stream().filter(valor -> valor.equals(valores.get(1))).count() == 4;
	}
}