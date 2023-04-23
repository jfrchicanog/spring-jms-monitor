package es.uma.informatica.sii.jms.monitor.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Monitor {
	
	@JmsListener(destination = "contactos")
	public void recibeMensaje(String mensaje) {
		System.out.println("Mensjae recibido: "+mensaje);
	}

}
