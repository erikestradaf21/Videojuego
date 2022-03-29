package com.ee.firearms;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class GameAssetManager extends AssetManager {

	// Fuentes
		 	public static final String FUENTE_QUANTUM = "fuentes/quantum-profit.ttf";
		 	public static final String FUENTE_SECRET = "fuentes/secret-power.otf";
		 	public static final String FUENTE_POSSUM = "fuentes/possum.otf";

		    // Imagenes
		 	public static final String LOGO = "imagenes/logo.png";
		 	public static final String FONDO_MENU = "imagenes/fondoMenu.png";
		 	public static final String TITULO_MENU = "imagenes/tituloMenu.png";
		 	public static final String TITULO_OPCIONES = "imagenes/tituloOpciones.png";
		 	public static final String BARRA_VIDA = "imagenes/barraVida.png";
		 	public static final String MARCO_VIDA = "imagenes/marcoVida.png";
		 	public static final String SHOTGUN = "imagenes/armas/shotgun.png";
		 	public static final String SNIPER = "imagenes/armas/sniper.png";
		 	
		 	public static final String BALA = "imagenes/bala.png";
		 	
		 	public static final String RIFLE = "imagenes/armas/rifle.png";
		 	
		 	public static final String HEALTH_BAR = "imagenes/healthBar.png";
		 	public static final String HEALTH_FRAME = "imagenes/healthFrame.png";
//		 	public static final String SIGHT = "imagenes/ui_crosshair.png";
		 	public static final String BULLET = "imagenes/bullet.png";
		 	public static final String PLAYER_1 = "imagenes/p1.png";
		 	public static final String PLAYER_2 = "imagenes/p2.png";
		 	public static final String GAMEOVER = "imagenes/gameOver.png";
		 	
		 	public static final String SHOTGUN_EXT = "imagenes/armas/shotgunExt.png";
		 	public static final String RIFLE_EXT = "imagenes/armas/rifleExt.png";
		 	public static final String SNIPER_EXT = "imagenes/armas/sniperExt.png";
		 	
		 	public static final String PLAYER_1_EXT = "imagenes/p1Ext.png";
		 	public static final String PLAYER_2_EXT = "imagenes/p2Ext.png";
		 	
		 	public static final String CURSOR = "imagenes/cs.png";
		 	public static final String JUGADORM = "imagenes/jugadorM.png";
		 	public static final String JUGADORM2 = "imagenes/jugadorM2.png";
		 	
		 	// Musica
		 	public static final String MUSICA_1 = "musica/ambient-music.ogg";
		 	public static final String MUSICA_2 = "musica/C418_Minecraft.ogg";
		 	public static final String MUSICA_3 = "musica/Chopin_Scherzo_No3.ogg";
		 	public static final String MUSICA_4 = "musica/Schubert_Impromptu_No3.ogg";
		 	public static final String MUSICA_5 = "musica/Schumann_Traumerei.ogg";
		 	public static final String MUSICA_JUEGO = "musica/game-music.ogg";
			
		 	// Mapas
		 	public static final String MAPA_1 = "mapas/primerMapa.tmx";
		 	
		 	// Atlas
		 	public static final String ATLAS_1 = "atlas/AtlasFF.atlas";
		 	public static final String ATLAS_2 = "atlas/AtlasEn.atlas";
		 	public static final String ATLAS = "atlas/Atlas.atlas";
		 	
		 	// Sonidos
		 	public static final String SHOOT = "sonidos/shootSound.ogg";
		 	public static final String RELOAD = "sonidos/reload.wav";
		 	
		 	public static final AssetManager manager = new AssetManager();
			
			public GameAssetManager() {
				cargarMusica();
				cargarSonidos();
				cargarImagenes();
				cargarAtlas();
				
				manager.finishLoading();

//		        manager.get(Recursos.MUSICAMENU, Music.class).setLooping(true);
//		        manager.get(ConstantesJuego.MUSICA_JUEGO, Music.class).setLooping(true);
			}

			private void cargarSonidos() {
//				manager.load("sonidos/coin.wav", Sound.class);
//				manager.load("sonidos/bump.wav", Sound.class);
//				manager.load("sonidos/break.wav", Sound.class);
				manager.load(SHOOT, Sound.class);
				manager.load(RELOAD, Sound.class);
			}

			private void cargarMusica() {
				manager.load(MUSICA_1, Music.class);
				manager.load(MUSICA_2, Music.class);
				manager.load(MUSICA_3, Music.class);
				manager.load(MUSICA_4, Music.class);
				manager.load(MUSICA_5, Music.class);
				manager.load(MUSICA_JUEGO, Music.class);
			}
			
			private void cargarImagenes() {
				manager.load(LOGO, Texture.class);
				manager.load(FONDO_MENU, Texture.class);
				manager.load(TITULO_MENU, Texture.class);
				manager.load(TITULO_OPCIONES, Texture.class);
				manager.load(MARCO_VIDA, Texture.class);
				manager.load(BARRA_VIDA, Texture.class);
				manager.load(SHOTGUN, Texture.class);
				manager.load(SNIPER, Texture.class);
				
				manager.load(BALA, Texture.class);
				manager.load(CURSOR, Texture.class);
				manager.load(JUGADORM, Texture.class);
				manager.load(JUGADORM2, Texture.class);
				
				manager.load(RIFLE, Texture.class);
				manager.load(BULLET, Texture.class);
				manager.load(HEALTH_BAR, Texture.class);
				manager.load(HEALTH_FRAME, Texture.class);
//				manager.load(SIGHT, Texture.class);
				manager.load(PLAYER_1, Texture.class);
				manager.load(PLAYER_2, Texture.class);
				manager.load(GAMEOVER, Texture.class);
				
				manager.load(SHOTGUN_EXT, Texture.class);
				manager.load(RIFLE_EXT, Texture.class);
				manager.load(SNIPER_EXT, Texture.class);
				
				manager.load(PLAYER_1_EXT, Texture.class);
				manager.load(PLAYER_2_EXT, Texture.class);
				
			}
			
			private void cargarAtlas() {
				manager.load(ATLAS_1, TextureAtlas.class);
				manager.load(ATLAS_2, TextureAtlas.class);
				manager.load(ATLAS, TextureAtlas.class);
			}
			
			public AssetManager getManager() {
				return manager;
			}
    
}