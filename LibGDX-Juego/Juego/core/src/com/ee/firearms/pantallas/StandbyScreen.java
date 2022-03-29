package com.ee.firearms.pantallas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.ee.firearms.FireArms;
import com.ee.firearms.GameAssetManager;
import com.ee.firearms.GameEventListener;
import com.ee.firearms.utiles.Config;
import com.ee.firearms.utiles.Texto;
import com.ee.firearms.utiles.Utiles;

public class StandbyScreen extends AbstractScreen implements GameEventListener {

	private Texto espera;
	private int selectedCharacter, weaponNumber;
	private Image background;
	private Stage stage;
	
	public StandbyScreen(FireArms game, int selectedCharacter, int weaponNumber) {
		super(game);
		this.game = game;
		stage = new Stage(new FitViewport(Config.ANCHO, Config.ALTO));
		
		espera = new Texto(GameAssetManager.FUENTE_QUANTUM, 20, Color.WHITE, true);
		this.selectedCharacter = selectedCharacter;
		this.weaponNumber = weaponNumber;
		
		
		
		Utiles.listener = this;
		Utiles.cliente.enviarMensaje("ready!" + selectedCharacter);
		
		Gdx.input.setInputProcessor(stage);
		
		background = new Image(new Texture(Gdx.files.internal(GameAssetManager.FONDO_MENU)));
		background.setSize(Config.ANCHO, Config.ALTO);
		stage.addActor(background);
		
	}
	
	@Override
	public void render(float delta) {
		Utiles.limpiarPantalla();
		super.render(delta);
		
		stage.act(delta);
		stage.draw();
		
		Utiles.sb.begin();
		espera.dibujar(Utiles.sb, "Esperando...", (Gdx.graphics.getWidth() / 2) - 150, Gdx.graphics.getHeight() / 2);
		Utiles.sb.end();
	}

	@Override
	public void iniciar() {
		game.setScreen(new MultiplayerScreen(game, selectedCharacter, weaponNumber));
		
	}

}