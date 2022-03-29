package com.ee.firearms.entidades;

import com.ee.firearms.GameAssetManager;
import com.ee.firearms.armas.Shotgun;
import com.ee.firearms.armas.Weapon;

public class Player_2 extends Character {

//	private Sound shoot = Gdx.audio.newSound(Gdx.files.internal(GameAssetManager.SHOOT));
	private Weapon equippedWeapon;
	
	public Player_2(float x, float y, int weaponNumber) {
		super(600, x, y, GameAssetManager.PLAYER_2);
		
		switch(weaponNumber) {
		case 1: 
			this.equippedWeapon = new Shotgun();
			break;
		default: 
			this.equippedWeapon = new Shotgun();
			break;
		}
	}
	
	@Override
	public void attack() {
		equippedWeapon.attack();
//		shoot.play(0.2f);
	}

	@Override
	public void update(float worldX, float worldY) {
		super.update(worldX, worldY);
		equippedWeapon.update(worldX, worldY, sight);
	}
	
	@Override
	public void draw() {
		super.draw();
		equippedWeapon.draw();
	}
	
}
