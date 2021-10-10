package com.empresa.mygame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGame extends Game/*ApplicationAdapter*/ {
	//TODO "extends Game" (xq cambiar?) no paso nada aparentemente
	SpriteBatch batch;
	Texture img;
	int cont = 0;
	
	public MyGame() {
		System.out.println("constructor");//debugear
	}
	
	@Override
	public void create () {// se ejecuta una vez al abrir el juego, bueno para inicializar
		System.out.println("create");
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
	}

	@Override
	public void render () {// se ejecuta todo el tiempo, como en bucle y ejecutado paralelamente con el programa
		update();
		ScreenUtils.clear(1, 0, 0, 1);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
	}
	
	private void update() {
		// TODO Auto-generated method stub
		cont++;
		System.out.println("probando Sprites y Texturas");
		
	}

	@Override
	public void dispose () {
		// saca/limpia recursos q puse en memoria como img, sonidos, etc
		//(libera recursos en memoria q ya no se usen)
		batch.dispose();
		img.dispose();
	}
	//TODO investigar estructura basica de como funciona el libGDX
}
