package punto1;

public class Jugando implements EstadoJuego{

	public void actualizarCartel(){
		// no hace nada
	}
	
	public void pulsarBoton(Juego juego){
		// no hace nada
	}
	
	public void finDeJuego(Juego juego){
		juego.setEstado(new InicioJuego());
	}
	
	public void ingresaUnaFicha(Juego juego) {
		// no hace nada
	}
}
