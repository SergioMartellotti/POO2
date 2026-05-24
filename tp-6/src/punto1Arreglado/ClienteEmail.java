package punto1Arreglado;

public class ClienteEmail {

	private ServicioMail servidor;
	private AlmacenaMail almacen;
	private String nombreUsuario;
	private String passusuario;
	
	 
	public ClienteEmail(AlmacenaMail almacen, ServicioMail servidor, String nombreUsuario, String pass) {
		this.servidor=servidor;
		this.almacen=almacen;
		this.nombreUsuario=nombreUsuario;
		this.passusuario=pass;			
		this.conectar();
	}
	
	public void conectar(){
		this.servidor.conectar(this.nombreUsuario,this.passusuario);
	}
	
	public void borrarCorreo(Correo correo){
		this.almacen.borrarCorreo(correo);
	}
	
	public int contarBorrados(){
		return almacen.contarBorrados();
	}
	
	public int contarInbox(){
		return almacen.contarInbox();
	}
	
	public void eliminarBorrado(Correo correo){
		this.almacen.eliminarBorrado(correo);
	}
	
	public void recibirNuevos(){
		this.servidor.recibirNuevos(this.nombreUsuario, this.passusuario);
		// debería tomar los mails y almacenarlos uno por uno en almacen.
	}
	
	public void enviarCorreo(String asunto, String destinatario, String cuerpo){
		Correo correo = new Correo(asunto, destinatario, cuerpo);
		this.servidor.enviar(correo);
	}

}
