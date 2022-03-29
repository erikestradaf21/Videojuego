package com.ee.firearms.pantallas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.ee.firearms.FireArms;
import com.ee.firearms.GameAssetManager;
import com.ee.firearms.GameEventListener;
import com.ee.firearms.SkinManager;
import com.ee.firearms.red.Cliente;
import com.ee.firearms.utiles.Config;
import com.ee.firearms.utiles.Texto;
import com.ee.firearms.utiles.Utiles;

public class SelectionScreen extends AbstractScreen implements GameEventListener {

	private Stage stage;
	private FireArms game;
	private Texture[] characters;
	private Image selection, background;
	private int selectedCharacter;
	private Texto espera;
	
	private boolean pick;
	private float pickTimer;
	
	public SelectionScreen(FireArms game) {
		
		super(game);
		
		espera = new Texto(GameAssetManager.FUENTE_QUANTUM, 20, Color.WHITE, true);
		
		FitViewport viewport = new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		stage = new Stage(viewport);
		Gdx.input.setInputProcessor(stage);
		this.game = game;
		selectedCharacter=0;
		prepareUi();
		
		Utiles.listener = this;
		Utiles.cliente = new Cliente();
		Utiles.cliente.enviarMensaje("conexion");
		Utiles.cliente.enviarMensaje("solicitarPick");
		
	}
	public void prepareUi() {

		background = new Image(new Texture(Gdx.files.internal(GameAssetManager.FONDO_MENU)));
		background.setSize(Config.ANCHO, Config.ALTO);
		stage.addActor(background);
		   
		TextButton startBtn = new TextButton("SIGUIENTE", SkinManager.skin);
		startBtn.setSize(320, 80);
		   startBtn.setPosition((stage.getWidth() - startBtn.getWidth()) / 2, stage.getHeight() / 6);
		   startBtn.addCaptureListener(new ClickListener() {
			   public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
				   super.touchUp(event, x, y, pointer, button);
				   continuar();
		        }
		   });
		   stage.addActor(startBtn);
		   
		   characters = new Texture[] { 
				   						new Texture(GameAssetManager.PLAYER_1_EXT),
				     					new Texture(GameAssetManager.PLAYER_2_EXT) 
				     				  };
		   
		   selection = new Image(characters[selectedCharacter]);
		   selection.setPosition((stage.getWidth() - selection.getWidth()) / 2, (stage.getHeight() - selection.getHeight()) / 2);
		   stage.addActor(selection);
		   
		   TextButton nextBtn = new TextButton(">", SkinManager.skin);
		   nextBtn.setSize(160, 80);
		   nextBtn.setPosition(stage.getWidth() * 5 / 6 - nextBtn.getWidth() / 2, stage.getHeight() / 2);
		   nextBtn.addCaptureListener(new ClickListener() {
			   @Override
			   public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
				   super.touchUp(event, x, y, pointer, button);
				   if(selectedCharacter == characters.length - 1) { selectedCharacter = 0; }
				   else { selectedCharacter++; }
				   
				   stage.clear();
				   prepareUi();
			   }
		   });
		   stage.addActor(nextBtn);
		     
		   TextButton prevBtn = new TextButton("<", SkinManager.skin);
		   prevBtn.setSize(160, 80);
		   prevBtn.setPosition(stage.getWidth() / 6 - prevBtn.getWidth() / 2, stage.getHeight() / 2);
		   prevBtn.addCaptureListener(new ClickListener() {
			   @Override
			   public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
				   super.touchUp(event, x, y, pointer, button);
				   if(selectedCharacter == 0) { selectedCharacter = characters.length - 1; }
				   else { selectedCharacter--; }
				   
				   stage.clear();
				   prepareUi();
			   }
		   });
		   stage.addActor(prevBtn);
		    
		    
		}


	@Override
	public void render(float delta) {
//		Utiles.limpiarPantalla();
		super.render(delta);
		
		if(pick) {
			stage.act(delta);
			stage.draw();
		} else {
			
			pickTimer += delta;
			if(pickTimer >= 5) {
				pickTimer = 0;
				Utiles.cliente.enviarMensaje("solicitarFPick");
			}
			
			Utiles.sb.begin();
			espera.dibujar(Utiles.sb, "Esperando...", (Gdx.graphics.getWidth() / 2) - 150, Gdx.graphics.getHeight() / 2);
			Utiles.sb.end();
		}
		
	}

	@Override
	public void dispose() {
		Gdx.input.setInputProcessor(null);
	    stage.dispose();
//	    espera.dispose();
		
	}
	
	@Override
	public void asignarNumero(int nJugador) {
		Utiles.nJugador = nJugador;
	}
	
	@Override
	public void permitirPick(boolean pick) {
		this.pick = pick;
		
	}
	
	@Override
	public void forzarPick(int nPersonaje) {
		if(nPersonaje == 0) {
			selectedCharacter = 1;
		}
		if(nPersonaje == 1) {
			selectedCharacter = 0;
		}
		continuar();
	}
	
	public void continuar() {
		dispose();
		if(selectedCharacter == 1) {
			   game.setScreen(new StandbyScreen(game, 1, 0));
		   }
		   else {
			   game.setScreen(new WeaponSelectionScreen(game));
		   }
		
	}

}
