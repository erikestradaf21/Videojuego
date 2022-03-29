package com.ee.firearms.armas;

import com.ee.firearms.GameAssetManager;
import com.ee.firearms.entidades.DamageEntity;

public class ShotgunDamage extends DamageEntity {
	
//private Sound shoot = Gdx.audio.newSound(Gdx.files.internal(GameAssetManager.SHOOT));
	
	public ShotgunDamage(Weapon origin) {
		super(GameAssetManager.BULLET);
		this.origin = origin;
//		shoot.play(0.1f);
	}
}
