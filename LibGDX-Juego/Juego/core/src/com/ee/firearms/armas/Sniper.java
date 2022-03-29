package com.ee.firearms.armas;

import com.ee.firearms.GameAssetManager;
import com.ee.firearms.utiles.Utiles;

public class Sniper extends Weapon {
	
	public Sniper() {
		super("Sniper", 15, GameAssetManager.SNIPER);
	}

	@Override
	public void attack() {
		Utiles.globalDamageEntities.add(new SniperDamage(this));
	}
}
