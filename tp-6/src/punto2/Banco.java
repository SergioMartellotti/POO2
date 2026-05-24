package punto2;

import java.util.ArrayList;
import java.util.List;

public class Banco {
	
	private List<Cliente> clientes;
	private List<Solicitud> solicitudes;
	
	public Banco() {
		clientes = new ArrayList<Cliente>();
		solicitudes = new ArrayList<Solicitud>();
	}
	
	public void agregarCliente(Cliente cliente){
		clientes.add(cliente);
	}
	
	public void registrarSolicitud(Solicitud solicitud) {
		solicitudes.add(solicitud);		
	}
	
	public void evaluarSolicitud() {
		solicitudes.get(0).chequearSolicitud();
	}

	public List<Solicitud> getSolicitudes() {
		return solicitudes;
	}
	
	public Double montoAEntregar() {
		Double montoTotal = 0d;
		
		for(Solicitud solicitud : this.solicitudes) {
			if (solicitud.getEstaAprobada()) {
				montoTotal += solicitud.getSuma();
			}
		}
		return montoTotal;
	}
}
