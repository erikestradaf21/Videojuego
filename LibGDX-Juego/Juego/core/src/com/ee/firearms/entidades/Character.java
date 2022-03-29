package com.ee.firearms.entidades;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.ee.firearms.GameAssetManager;
import com.ee.firearms.utiles.Constantes;
import com.ee.firearms.utiles.Utiles;

public abstract class Character extends Entities {

	private int vida;
	private int vidaMax;
	private float worldX; // World
	private float worldY;
	private Sprite healthFrame;
	private Sprite healthBar;
	protected Vector2 sight;
	
	protected Character(int vida, float x, float y, String path) {
		super(path);
		this.vidaMax = vida;
		this.vida = vidaMax;
		s.setPosition(x, y);
		healthFrame = new Sprite(new Texture(GameAssetManager.HEALTH_FRAME));
		healthBar = new Sprite(new Texture(GameAssetManager.HEALTH_BAR));
		healthBar.setColor(Color.RED);
		sight = new Vector2(0, 0);
	}
	
	public abstract void attack();
	
	@Override
	public void update(float worldX, float worldY) { // World
 		super.update(worldX * Constantes.PPM, worldY * Constantes.PPM);
 		this.worldX = worldX;
 		this.worldY = worldY;
 		healthFrame.setPosition(s.getX(), s.getY() + s.getHeight() + 30);
 		healthBar.setPosition(healthFrame.getX(), healthFrame.getY());
	}
	
	public void calculateSight(Vector2 position) {
		sight.x = worldX * Constantes.PPM;
		sight.y = worldY * Constantes.PPM;
		sight = sight.sub(position).nor();
		sight.rotateDeg(180f);
		
		Utiles.cliente.enviarMensaje("mouse!" + Utiles.nJugador + "!" + sight.x + "!" + sight.y);
	}

	public void setSight(Vector2 position) {
		sight = position;
	}
	
	@Override
	public void draw() {
		super.draw();
		healthFrame.draw(Utiles.sb);
		healthBar.draw(Utiles.sb);
	}
	
	public Sprite getSprite() {
		return s;
	}
	
	public int getVida() {
		return vida;
	}
	
	public void cambiarVida(int valor) {
		vida += valor;
		vida = (vida < 0) ? 0: (vida > vidaMax) ? vidaMax : vida;
		healthBar.setSize(healthFrame.getWidth() * ((float)vida / vidaMax), healthBar.getHeight());
	}
}
