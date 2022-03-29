package com.ee.firearms.armas;

import com.badlogic.gdx.math.Vector2;
import com.ee.firearms.entidades.Damage;
import com.ee.firearms.utiles.Constantes;

public abstract class Weapon extends Damage {

	public Weapon(String nombre, int daño, String path) {
		super(nombre, daño, path);
	}

	@Override
	public void update(float x, float y, Vector2 mira) {
		super.update(x * Constantes.PPM, y * Constantes.PPM, mira);
	}
}
