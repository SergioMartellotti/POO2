package punto3;

public class Ingeniero extends PersonajeConPosicion {
	
	private int lajas;
	
	public Ingeniero(Posicion posicion, int lajas) {
		super(posicion);
		this.lajas = lajas;
	}
	
	public void caminar(int x, int y) {
        int direccionX = x - posicion.getPosicionX();
        int direccionY = y - posicion.getPosicionY();
        
        // se determina si se va hacia arriba o abajo, izquierda o derecha...
        int pasoX = direccionX == 0 ? 0 : (direccionX > 0 ? 1 : -1);
        int pasoY = direccionY == 0 ? 0 : (direccionY > 0 ? 1 : -1);
        
        
        while (posicion.getPosicionX() != x || posicion.getPosicionY() != y) {
            int nuevaX = posicion.getPosicionX();
            int nuevaY = posicion.getPosicionY();
            
            if (nuevaX != x) nuevaX += pasoX;
            if (nuevaY != y) nuevaY += pasoY;
            
            if (lajas > 0) { // si quedan lajas...
                lajas--;
            }
            
            posicion.setPosicionX(nuevaX);
            posicion.setPosicionY(nuevaY);
            
        }
	}
}
