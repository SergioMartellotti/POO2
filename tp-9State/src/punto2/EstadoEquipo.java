package punto2;

public interface EstadoEquipo {

	public void play(Equipo equipo) throws Exception;
	public void pause(Equipo equipo) throws Exception;
	public void stop(Equipo equipo);
	
}
