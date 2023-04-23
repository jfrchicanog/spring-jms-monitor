package es.uma.informatica.sii.jms.monitor.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import es.uma.informatica.sii.jms.monitor.websocket.ManejadorWebSocket;

@Component
public class Monitor {
	
	private ManejadorWebSocket manejador;
	
	public Monitor(ManejadorWebSocket manejador) {
		this.manejador = manejador;
	}
	
	@JmsListener(destination = "contactos")
	public void recibeMensaje(String mensaje) {
		manejador.notificaCambio();
		System.out.println("Mensaje recibido: "+mensaje);
	}

}
