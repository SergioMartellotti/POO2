package punto1;

public class Juego {

	int fichas;
	EstadoJuego estado;
	
	public Juego() {
		fichas=0;
		estado = new InicioJuego();
		estado.actualizarCartel();
	}
	
	public void presionarBoton() {
		estado.pulsarBoton(this);
		estado.actualizarCartel();
	}
	
	public int getFichas() {
		return this.fichas;
	}
	
	public void setFichas(int cantidad){
		this.fichas = cantidad;
	}
	
	public void gastarUnaFicha() {
		fichas = fichas - 1;
	}
	
	public void ponerFicha(){
		estado.ingresaUnaFicha(this);
	}
	
	public void setEstado(EstadoJuego estado) {
		this.estado = estado;
	}
}
