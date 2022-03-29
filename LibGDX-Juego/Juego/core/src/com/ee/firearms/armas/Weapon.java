package com.ee.firearms.armas;

import com.badlogic.gdx.math.Vector2;
import com.ee.firearms.entidades.Damage;
import com.ee.firearms.utiles.Constantes;

public abstract class Weapon extends Damage {

	public Weapon(String nombre, int da�o, String path) {
		super(nombre, da�o, path);
	}

	@Override
	public void update(float x, float y, Vector2 mira) {
		super.update(x * Constantes.PPM, y * Constantes.PPM, mira);
	}
}
