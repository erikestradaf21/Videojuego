package com.ee.firearms.entidades;

import com.ee.firearms.utiles.Constantes;

public abstract class DamageEntity extends Entities {

	protected Damage origin;
	
	public DamageEntity(String path) {
		super(path);
	}
	
	public void update(float x, float y, float deg) { // World
		super.update(x * Constantes.PPM, y * Constantes.PPM);
		s.setRotation(deg);
	}
}