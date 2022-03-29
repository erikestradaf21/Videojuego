package com.ee.firearms.utiles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.ee.firearms.GameEventListener;
import com.ee.firearms.entidades.DamageEntity;
import com.ee.firearms.red.Cliente;

public final class Utiles {

	public static SpriteBatch sb;
	public static Cliente cliente;
	public static GameEventListener listener;
	public static int nJugador;
	public static ServerInputter entrada;
	public static Array<DamageEntity> globalDamageEntities = new Array<DamageEntity>();
	
	public static void limpiarPantalla() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }
	
	
	public static void delay(long milis) {
		try {
			Thread.sleep(milis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
