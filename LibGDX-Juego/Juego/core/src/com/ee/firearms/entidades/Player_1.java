package com.ee.firearms.entidades;

import com.ee.firearms.GameAssetManager;
import com.ee.firearms.armas.Rifle;
import com.ee.firearms.armas.Sniper;
import com.ee.firearms.armas.Weapon;

public class Player_1 extends Character {

//	private Sound shoot = Gdx.audio.newSound(Gdx.files.internal(GameAssetManager.SHOOT));
	private Weapon equippedWeapon;
	
	public Player_1(float x, float y, int weaponNumber) {
		super(600, x, y, GameAssetManager.PLAYER_1);
		
		switch(weaponNumber) {
		case 2: 
			this.equippedWeapon = new Rifle();
			break;
		case 3: 
			this.equippedWeapon = new Sniper();
		default: 
			this.equippedWeapon = new Rifle();
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
