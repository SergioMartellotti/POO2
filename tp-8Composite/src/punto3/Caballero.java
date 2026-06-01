package punto3;

public class Caballero extends PersonajeConPosicion {
    private boolean subiendo = true;
    
    public Caballero(Posicion posicion) {
        super(posicion);
    }
    
    
    public void caminar(int x, int y) {        
        int direccionX = x - posicion.getPosicionX();
        
        // ve si el zigzag es hacia la izquierda o derecha
        int pasoX = direccionX == 0 ? 0 : (direccionX > 0 ? 1 : -1);
        

        while (posicion.getPosicionX() != x) {
            int nuevaX = posicion.getPosicionX() + pasoX;
            int nuevaY = posicion.getPosicionY();
            
            // movimiento en Y
            if (subiendo) {
                nuevaY += 1;  // Sube
            } else {
                nuevaY -= 1;  // Baja
            }
            
            // Para mantener el zigzag controlado
            if (Math.abs(nuevaY - y) > 2) {
                nuevaY = posicion.getPosicionY();
            }
            
            posicion.setPosicionX(nuevaX);
            posicion.setPosicionY(nuevaY);
            subiendo = !subiendo;
                    }
        
        // Una vez alcanzada la X
        while (posicion.getPosicionY() != y) {
            int pasoY = y > posicion.getPosicionY() ? 1 : -1;
            posicion.setPosicionY(posicion.getPosicionY() + pasoY);
        }
    }
}