package punto2;

public class Playing implements EstadoEquipo {

	public void play(Equipo equipo) throws Exception {
		throw new Exception("No puede dar Play!"); 
	}
	
	public void pause(Equipo equipo) throws Exception {
		equipo.getSong().pause();
		equipo.setState(new Pause());
	}
	
	public void stop(Equipo equipo) {
		equipo.getSong().stop();
		equipo.setState(new Select());
	}
}
