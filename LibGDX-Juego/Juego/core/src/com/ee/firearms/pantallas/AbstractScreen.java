package com.ee.firearms.pantallas;

import com.badlogic.gdx.Screen;
import com.ee.firearms.FireArms;
import com.ee.firearms.GameEventListener;
import com.ee.firearms.utiles.Utiles;

public abstract class AbstractScreen implements Screen, GameEventListener {
    
	protected FireArms game;
	
	public AbstractScreen(FireArms game) {
		this.game = game;
	}
	
	@Override
	public void show() {
		
	}

	@Override
	public void render(float delta) {
		Utiles.limpiarPantalla();
	}
		
	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void hide() {

	}

	@Override
	public void dispose() {
		
	}
	@Override
	public void permitirPick(boolean firstPick) {}

	@Override
	public void forzarPick(int nPersonaje) {}

	@Override
	public void iniciar() {}
	
	@Override
	public void updatePersonaje(int nPersonaje, float posX, float posY, float mouseX, float mouseY) {}

	@Override
	public void ataquePersonaje(int nPersonaje) {}
	
	@Override
	public void dañarPersonaje(int nPersonaje, int daño) {}

	@Override
	public void updateEntidadDaño(int nEnt, float posX, float posY, float deg) {}

	@Override
	public void destruirEntidadDaño(int nEnt) {}
	
	@Override
	public void asignarNumero(int nJugador) {}
	
	@Override
	public void asignarPersonaje(int nJugador, int nPersonaje, int nArma) {}
	
	@Override
	public void fin(int ganador) {}
	
}