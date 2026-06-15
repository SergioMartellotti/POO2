package punto1;

public class InicioJuego implements EstadoJuego{

	public void actualizarCartel(){
		System.out.println("Ingresar fichas para comenzar...");
	}
	
	public void pulsarBoton(Juego juego){
		// No hace nada...
	}
	
	public void finDeJuego(Juego juego){
		// No hace nada...		
	}
	
	public void ingresaUnaFicha(Juego juego) {
		juego.setFichas(juego.getFichas()+1);
		juego.setEstado(new Juego1Ficha());
	}
	
}
