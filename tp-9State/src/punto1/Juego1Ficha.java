package punto1;

public class Juego1Ficha implements EstadoJuego{

	public void actualizarCartel(){
		// Borra el cartel de Inicio
	}
	
	public void pulsarBoton(Juego juego){
		juego.gastarUnaFicha();
		juego.setEstado(new Jugando());
	}
	
	public void finDeJuego(Juego juego){
		// no hace nada
	}
	
	public void ingresaUnaFicha(Juego juego) {
		juego.setFichas(juego.getFichas()+1);
		juego.setEstado(new JuegoCon2Fichas());
	}
}
