package model;

import java.util.ArrayList;
import java.util.List;

public class PokerStatus2 {
    private final List<ValidadorMano<?>> validadores;
    
    public PokerStatus2(List<ValidadorMano<?>> validadores) {
        this.validadores = validadores;
    }
    


	public String verificar(Carta c1, Carta c2, Carta c3, Carta c4, Carta c5) {
        List<Carta> cartas = new ArrayList<Carta>();
        cartas.add(c1);
        cartas.add(c2);
        cartas.add(c3);
        cartas.add(c4);
        cartas.add(c5);
        
        
        return validadores.stream()
            .filter(e -> e.validar(cartas))
            .findFirst()
            .map(ValidadorMano::getNombre)
            .orElse("Nada");
    }
}