package com.ee.firearms.red;

public class Cliente {

	private HiloCliente hs;
	
	public Cliente() {
		hs = new HiloCliente();
		hs.start();
	}
	
	public void enviarMensaje(String msg) {
		this.hs.enviarMensaje(msg);
	}
	
}
