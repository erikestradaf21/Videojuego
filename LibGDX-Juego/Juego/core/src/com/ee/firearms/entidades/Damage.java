package com.ee.firearms.entidades;

import com.badlogic.gdx.math.Vector2;

public abstract class Damage extends Entities {
	private String name;
	private int damage;
	
	public Damage(String name, int damage, String path) {
		super(path);
		this.name = name;
		this.damage = damage;
	}

	public String getName() {
		return name;
	}

	public int getDamage() {
		return damage;
	}

	public abstract void attack();
	
	public void update(float x, float y, Vector2 sight) {
		super.update(x, y);
		s.setRotation((sight.angleDeg()));
	}
}
