package punto1Arreglado;

import java.util.List;

public interface ServicioMail {

	public List<Correo> recibirNuevos(String user, String pass);
	
	public void enviar(Correo correo);
	
	public void conectar(String nombreUsuario, String passusuario);
}
