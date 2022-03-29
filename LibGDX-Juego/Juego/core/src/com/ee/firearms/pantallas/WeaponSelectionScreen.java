package com.ee.firearms.pantallas;

import com.badlogic.gdx.Gdx;
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
import com.ee.firearms.utiles.Utiles;

public class WeaponSelectionScreen extends AbstractScreen {
	
	Stage stage;
	Texture[] weapons;
	Image selection, background;
	int selectedWeapon;
	
	public WeaponSelectionScreen(FireArms game) {
		super(game);
		this.game = game;
//		FitViewport viewport = new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
//		stage = new Stage(viewport);
		stage = new Stage(new FitViewport(Config.ANCHO, Config.ALTO));
		Gdx.input.setInputProcessor(stage);
		selectedWeapon=0;
		
		prepareUi();
	}
	
	@Override
	public void render(float delta) {
		Utiles.limpiarPantalla();
		super.render(delta);
		stage.act(delta);
		stage.draw();
		
	}
	public void prepareUi() {
		
		background = new Image(new Texture(Gdx.files.internal(GameAssetManager.FONDO_MENU)));
		background.setSize(Config.ANCHO, Config.ALTO);
		stage.addActor(background);
		
//		TextButton.TextButtonStyle buttonStyle = new TextButton.TextButtonStyle();
//		   buttonStyle.font = new BitmapFont();
//		   buttonStyle.fontColor = Color.WHITE;
//		   TextButton startBtn = new TextButton("Listo", buttonStyle);
		TextButton startBtn = new TextButton("LISTO", SkinManager.skin);
		startBtn.setSize(240, 80);
		   startBtn.setPosition((stage.getWidth() - startBtn.getWidth()) / 2, stage.getHeight() / 6);
		   startBtn.addCaptureListener(new ClickListener() {
			   public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
				   super.touchUp(event, x, y, pointer, button);
				   dispose();
				   game.setScreen(new StandbyScreen(game, 0, selectedWeapon + 1));
		        }
		   });
		   stage.addActor(startBtn);
		   
		   weapons = new Texture[] { new Texture(GameAssetManager.RIFLE_EXT),
				   					 new Texture(GameAssetManager.SNIPER_EXT),
//				   				     new Texture(GameAssetManager.SHOTGUN_EXT)
				   				   };
		   
		   selection = new Image(weapons[selectedWeapon]);
		   selection.setPosition((stage.getWidth() - selection.getWidth()) / 2, (stage.getHeight() - selection.getHeight()) / 2);
		   
		   stage.addActor(selection);
		   
//		   TextButton nextBtn = new TextButton("=>", buttonStyle);
		   TextButton nextBtn = new TextButton(">", SkinManager.skin);
		   nextBtn.setSize(160, 80);
		   nextBtn.setPosition(stage.getWidth() * 5 / 6 - nextBtn.getWidth() / 2, stage.getHeight() / 2);
		   nextBtn.addCaptureListener(new ClickListener() {
			   @Override
			   public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
				   super.touchUp(event, x, y, pointer, button);
				   if(selectedWeapon == weapons.length - 1) { selectedWeapon = 0; }
				   else { selectedWeapon++; }
				   stage.clear();
				   prepareUi();
			   }
		   });
		   stage.addActor(nextBtn);
		     
//		   TextButton prevBtn = new TextButton("<=", buttonStyle);
		   TextButton prevBtn = new TextButton("<", SkinManager.skin);
		   prevBtn.setSize(160, 80);
		   prevBtn.setPosition(stage.getWidth() / 6 - prevBtn.getWidth() / 2, stage.getHeight() / 2);
		   prevBtn.addCaptureListener(new ClickListener() {
			   @Override
			   public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
				   super.touchUp(event, x, y, pointer, button);
				   if(selectedWeapon == 0) { selectedWeapon = weapons.length - 1; }
				   else { selectedWeapon--; }
				   
				   stage.clear();
				   prepareUi();
			   }
		   });
		   stage.addActor(prevBtn);
		    
		    
	}

	@Override
	public void dispose() {
		Gdx.input.setInputProcessor(null);
	    stage.dispose();
		
	}
	
	

}
