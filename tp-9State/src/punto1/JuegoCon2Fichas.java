package punto1;

public class JuegoCon2Fichas implements EstadoJuego{

	public void actualizarCartel(){
		// no hace nada
	}
	
	public void pulsarBoton(Juego juego){
		juego.gastarUnaFicha();
		juego.gastarUnaFicha();	
		juego.setEstado(new Jugando());		
	}
	
	public void finDeJuego(Juego juego){
		// no hace nada
	}
	
	public void ingresaUnaFicha(Juego juego) {
		// no hace nada
	}
}
