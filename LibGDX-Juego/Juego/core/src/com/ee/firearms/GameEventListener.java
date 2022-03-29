package com.ee.firearms;

import java.util.EventListener;

public interface GameEventListener extends EventListener {

	public void permitirPick(boolean firstPick);
	public void forzarPick(int nPersonaje);
	public void iniciar();
	public void asignarNumero(int nJugador);
	public void asignarPersonaje(int nJugador, int nPersonaje, int nArma);
	public void updatePersonaje(int nPersonaje, float posX, float posY, float mouseX, float mouseY);
	public void ataquePersonaje(int nPersonaje); // crear sprite de bala o habilidad
	public void da�arPersonaje(int nPersonaje, int da�o);
	public void updateEntidadDa�o(int nEnt, float posX, float posY, float deg); //actualizar sprite
	public void destruirEntidadDa�o(int nEnt);
	public void fin(int ganador);
	
}
