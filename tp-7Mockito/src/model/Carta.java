package model;

public class Carta {
    private Valor valor;
    private String palo;

    public Carta(Valor valor, String palo) {
        this.valor = valor;
        this.palo = palo;
    }

    public boolean esMayorQue(Carta otra) {
        return this.valor.getNumero() > otra.valor.getNumero();
    }
    
    public boolean esMismoPalo(Carta otra) {
    	return this.palo == otra.palo;
    }
    
    public Valor getValor() {
    	return valor;
    }
    public String getPalo() {
    	return palo;
    }
}