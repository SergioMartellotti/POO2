package punto2;

public class Select implements EstadoEquipo{

	public void play(Equipo equipo) {
		equipo.getSong().play();
		equipo.setState(new Playing());
	}
	
	public void pause(Equipo equipo)throws Exception {
		throw new Exception("No puede dar Pause!"); 
	}
	
	public void stop(Equipo equipo) {
		
	}
}
