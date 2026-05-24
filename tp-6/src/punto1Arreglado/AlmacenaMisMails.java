package punto1Arreglado;

import java.util.List;

public class AlmacenaMisMails implements AlmacenaMail{

	private List<Correo> inbox;
	private List<Correo> borrados;
	
	public void borrarCorreo(Correo correo){
		this.inbox.remove(correo);
		this.borrados.add(correo);
	}
	
	public int contarBorrados(){
		return this.borrados.size();
	}
	
	public int contarInbox(){
		return this.inbox.size();
	}
	
	public void eliminarBorrado(Correo correo){
		this.borrados.remove(correo);
	}
	
	public void almacenarMail(Correo correo) {
		this.inbox.add(correo);
	}
	
}
