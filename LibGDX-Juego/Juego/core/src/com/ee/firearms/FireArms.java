package com.ee.firearms;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.ee.firearms.pantallas.MenuScreen;
import com.ee.firearms.utiles.ReproductorMusica;
import com.ee.firearms.utiles.ServerInputter;
import com.ee.firearms.utiles.Utiles;

public class FireArms extends Game {
	
    public GameAssetManager assets;
    public static ReproductorMusica repMusica;
	
	@Override
	public void create () {
		Utiles.sb = new SpriteBatch();
        this.assets = new GameAssetManager();
        repMusica = new ReproductorMusica();
        Utiles.entrada = new ServerInputter();
		Gdx.input.setInputProcessor(Utiles.entrada);

        new SkinManager();
        
        if(assets.isFinished()) {
        	this.setScreen(new MenuScreen(this));
        }
	}
	
	@Override
    public void render () {
        super.render();
//        screen.render(Gdx.graphics.getDeltaTime());
        if(repMusica != null) {
        	repMusica.update();
        }
        assets.update();
    }
    
    @Override
    public void dispose () {
    	super.dispose();
    }
    
}