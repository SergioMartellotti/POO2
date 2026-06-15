package punto2;

public class Pause implements EstadoEquipo {

	public void play(Equipo equipo) throws Exception {
		throw new Exception("No puede dar Play!"); 
	}
	
	public void pause(Equipo equipo) {
		equipo.getSong().play();
		equipo.setState(new Playing());
	}
	
	public void stop(Equipo equipo) {
		equipo.getSong().stop();
		equipo.setState(new Select());
	}
}
