package punto2;

public class Cliente {

	private String nombre;
	private String apellido;
	private int edad;
	private Double sueldoMensual;
	private Banco banco;
	
	public Cliente(String nombre, String apellido, int edad, Double sueldoMensual, Banco banco) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.sueldoMensual = sueldoMensual;
		this.banco = banco;
	}
	
	public Double sueldoNeto() {
		return 12*sueldoMensual;
	}
	
	public Double getSueldoMensual() {
		return sueldoMensual;
	}

	public void solicitarCreditoBancario(Solicitud solicitud){
		this.banco.registrarSolicitud(solicitud);
	}

	public int getEdad() {
		return edad;
	}
	
	
}
