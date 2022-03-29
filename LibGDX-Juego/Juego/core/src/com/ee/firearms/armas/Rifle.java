package com.ee.firearms.armas;

import com.ee.firearms.GameAssetManager;
import com.ee.firearms.utiles.Utiles;

public class Rifle extends Weapon {

	public Rifle() {
		super("Rifle", 15, GameAssetManager.RIFLE);
	}

	@Override
	public void attack() {
		Utiles.globalDamageEntities.add(new RifleDamage(this));
	}

}
