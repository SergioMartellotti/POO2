package model;

import java.util.ArrayList;
import java.util.List;

public class PokerStatus2 {
    private final List<ValidadorMano> evaluators;
    
    public PokerStatus2(List<ValidadorMano> evaluators) {
        this.evaluators = evaluators;
    }
    
    public String verificar(String c1, String c2, String c3, String c4, String c5) {
        List<String> cartas = new ArrayList<String>();
        cartas.add(c1);
        cartas.add(c2);
        cartas.add(c3);
        cartas.add(c4);
        cartas.add(c5);
        
        
        return evaluators.stream()
            .filter(e -> e.validar(cartas))
            .findFirst()
            .map(ValidadorMano::getNombre)
            .orElse("Nada");
    }
}