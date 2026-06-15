package punto2;

public class Equipo {

	private EstadoEquipo estado;
	private Song song;
	
	
	public Equipo(Song song){
		this.song = song;
		this.estado = new Select();
	}
	
	public void play() throws Exception{
		estado.play(this);
	}
	
	public void pause() throws Exception{
		estado.pause(this);
	}
	
	public void stop(){
		estado.stop(this);
	}
	
	public Song getSong() {
		return this.song;
	}
	
	public void setState(EstadoEquipo estado) {
		this.estado = estado;
	}
}
