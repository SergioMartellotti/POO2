package punto1Arreglado;

public interface AlmacenaMail {
	
	public void borrarCorreo(Correo correo);
	public int contarBorrados();
	public int contarInbox();
	public void eliminarBorrado(Correo correo);
	public void almacenarMail(Correo correo);
}
