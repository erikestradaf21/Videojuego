package com.ee.firearms.entidades;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.ee.firearms.utiles.Utiles;

public abstract class Entities {

	private Texture t;
	protected Sprite s;
	
	public Entities(String path) {
		t = new Texture(path);
		s = new Sprite(t);
	}
	
	public void draw() {
		s.draw(Utiles.sb);
	}
	
	public void update(float posX, float posY) {
		s.setOriginBasedPosition(posX, posY);
	}
	
}
