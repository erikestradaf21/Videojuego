package com.ee.firearms.armas;

import com.ee.firearms.GameAssetManager;
import com.ee.firearms.utiles.Utiles;

public class Shotgun extends Weapon {
	
	public Shotgun() {
		super("Shotgun", 15, GameAssetManager.SHOTGUN);
	}

	@Override
	public void attack() {
		Utiles.globalDamageEntities.add(new ShotgunDamage(this));
	}
}
