package com.ee.firearms.pantallas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Cursor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.ee.firearms.FireArms;
import com.ee.firearms.GameAssetManager;
import com.ee.firearms.SkinManager;
import com.ee.firearms.utiles.Config;
import com.ee.firearms.utiles.Texto;
import com.ee.firearms.utiles.Utiles;

public class GameOverScreen extends AbstractScreen {

	private Stage stage;
	private Texto textoGana;
	private Image texto;
	private TextButton volveralMenu;

	public GameOverScreen(FireArms game, String winner) {
		
		super(game);
		
		if(winner.contains("Player_2")) {
			winner = "Jugador 2";
		}
		else {
			winner = "Jugador 1";
		}
		
		System.out.println("Ganador " + winner);
		
		texto = new Image(new Texture(Gdx.files.internal(GameAssetManager.GAMEOVER)));
		
		textoGana = new Texto(GameAssetManager.FUENTE_QUANTUM, 50, Color.WHITE, true);
		textoGana.setTexto(winner + " ha ganado!");
		textoGana.setPosition(Config.ANCHO / 2 - textoGana.getAncho() / 2, Config.ALTO / 2 + textoGana.getAlto());
		
		Gdx.graphics.setSystemCursor(Cursor.SystemCursor.Arrow);
		
//		stage = new Stage(new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()));
		stage = new Stage(new FitViewport(Config.ANCHO, Config.ALTO));
		Gdx.input.setInputProcessor(stage);
		
//		skin = new Skin(Gdx.files.internal("skin/glassy-ui.json")); TODO Quitar
		
		volveralMenu = new TextButton("Volver", SkinManager.skin);
		volveralMenu.setSize(200, 100);
		
		prepareUi();
		
		
	}
	
	private void prepareUi() {
		
		texto.setSize(Config.ANCHO, Config.ALTO);
		volveralMenu.setPosition(Gdx.graphics.getWidth() / 2 - volveralMenu.getWidth() / 2, 70);
		volveralMenu.addListener(new ClickListener() {
			@Override
			public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
				super.touchUp(event, x, y, pointer, button);
				dispose();
				game.setScreen(new MenuScreen(game));
				
			}
		});
		
		stage.addActor(texto);
		stage.addActor(volveralMenu);
		
	}
	
	@Override
	public void dispose() {
		super.dispose();
		stage.dispose();
	}
	
	@Override
	public void render(float delta) {
		Utiles.limpiarPantalla();
		super.render(delta);
		
		stage.act(delta);
		stage.draw();
		
		Utiles.sb.begin();
			textoGana.dibujar();
		Utiles.sb.end();
	
		
		
		
	}

}
