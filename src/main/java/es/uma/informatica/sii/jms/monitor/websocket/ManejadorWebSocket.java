package es.uma.informatica.sii.jms.monitor.websocket;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class ManejadorWebSocket extends TextWebSocketHandler {
	
	private List<WebSocketSession> clientes = Collections.synchronizedList(new ArrayList<>());
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		clientes.add(session);
		System.out.println("Registrado websocket con session "+session+" en manejador "+this);
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		clientes.remove(session);
		System.out.println("Cerrado websocket con session "+session+" en manejador "+this);
	}
	
	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		System.out.println("Error en websocket con session "+session);
	}
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		System.out.println("Recibido mensaje por Websocket: "+message.getPayload());
	}
	
	public void notificaCambio() {
		clientes.forEach(s->{
			try {
				s.sendMessage(new TextMessage("Cambio en backend"));
			} catch (IOException e) {
				System.out.println("Problema al enviar");
				e.printStackTrace();
			}
		});
	}

}
