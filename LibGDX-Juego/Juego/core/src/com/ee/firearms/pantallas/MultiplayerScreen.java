package com.ee.firearms.pantallas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.ee.firearms.FireArms;
import com.ee.firearms.GameAssetManager;
import com.ee.firearms.GameEventListener;
import com.ee.firearms.entidades.Character;
import com.ee.firearms.entidades.DamageEntity;
import com.ee.firearms.entidades.Player_1;
import com.ee.firearms.entidades.Player_2;
import com.ee.firearms.utiles.Utiles;

public class MultiplayerScreen extends AbstractScreen implements GameEventListener {

	private TiledMap map;
	private AssetManager manager;
	private OrthogonalTiledMapRenderer renderer;
	private OrthographicCamera cam;
	private Character[] characters;
	private int nJugador;
	
	public MultiplayerScreen(FireArms game, int personaje, int nArma) {
		super(game);
		nJugador = Utiles.nJugador;
		characters = new Character[2];
		
		Utiles.listener = this;
		
		Pixmap pmap = new Pixmap(Gdx.files.internal(GameAssetManager.CURSOR));
		Gdx.graphics.setCursor(Gdx.graphics.newCursor(pmap, 7, 7));
		cargarMundo();
		
		Utiles.cliente.enviarMensaje("personaje!" + personaje + "!" + nArma);
		
		
	}
	
	private void cargarMundo() {
		
		manager = new AssetManager();
		manager.setLoader(TiledMap.class, new TmxMapLoader());
		manager.load("mapas/mapa2.tmx", TiledMap.class);
		manager.finishLoading();
		map = manager.get("mapas/mapa2.tmx", TiledMap.class);
		renderer = new OrthogonalTiledMapRenderer(map);
		
		cam = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
	}
	
	private Character crearPersonaje(int personaje, int nArma) {

		MapLayer objLayer =  map.getLayers().get("players");
		RectangleMapObject spawn = (RectangleMapObject) objLayer.getObjects().get("P" + (personaje + 1));
		Vector2 spawnpoint = new Vector2(spawn.getRectangle().x, spawn.getRectangle().y);
		
		return (personaje == 0) ? new Player_1(spawnpoint.x, spawnpoint.y, nArma): new Player_2(spawnpoint.x, spawnpoint.y, nArma);
	}

	@Override
	public void show() {
		Gdx.input.setInputProcessor(Utiles.entrada);
	}
	
	private void update() {
		Vector3 mCoords = cam.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));
		Vector2 mPos = new Vector2(mCoords.x, mCoords.y);
		characters[nJugador].calculateSight(mPos);
		cam.position.x = characters[nJugador].getSprite().getX();
		cam.position.y = characters[nJugador].getSprite().getY();
		cam.update();
		renderer.setView(cam);
	}

	@Override
	public void render(float delta) {
//		Utiles.limpiarPantalla();
		super.render(delta);
		
		if (characters[nJugador] != null) {
			update();
		}
		
		Utiles.sb.setProjectionMatrix(cam.combined);
		Utiles.sb.begin();
		
			for (Character p : characters) {
				if (p != null) {
					p.draw();
				}
			}
			
			for (DamageEntity e : Utiles.globalDamageEntities) {
				e.draw();
			}
		Utiles.sb.end();
		
		renderer.render();
	}
	
	public void dispose() {
		Gdx.input.setInputProcessor(null);
		map.dispose();
		manager.dispose();
	}

	@Override
	public void asignarPersonaje(int nJugador, int nPersonaje, int nArma) {
		characters[nJugador] = crearPersonaje(nPersonaje, nArma);
	}


	@Override
	public void updatePersonaje(int nJugador, float screenX, float screenY, float mouseX, float mouseY) {
		if(characters[nJugador] != null) {
			characters[nJugador].update(screenX, screenY);
			if(nJugador != Utiles.nJugador) { // solo actualizar mira del contrincante
				characters[nJugador].setSight(new Vector2(mouseX, mouseY));
			}
		}
	}

	@Override
	public void ataquePersonaje(int nPersonaje) {
		characters[nPersonaje].attack();
	}
	
	@Override
	public void dañarPersonaje(int nPersonaje, int daño) {
		characters[nPersonaje].cambiarVida(daño);
	}

	@Override
	public void updateEntidadDaño(int nEnt, float posX, float posY, float deg) {
		
		try {
			Utiles.globalDamageEntities.get(nEnt).update(posX, posY, deg);
		} catch (IndexOutOfBoundsException e) { }
	}
	
	@Override
	public void destruirEntidadDaño(int nEnt) {
		try {
			Utiles.globalDamageEntities.removeIndex(nEnt);
		} catch (IndexOutOfBoundsException e) { }
	}
	
	@Override
	public void fin(int ganador) {
		dispose();
		Utiles.globalDamageEntities.clear();
		Utiles.sb.setProjectionMatrix(new Matrix4().setToOrtho2D(0, 0, Gdx.graphics.getWidth(),  Gdx.graphics.getHeight()));
		game.setScreen(new GameOverScreen(game, characters[ganador].getClass().getName()));
	}

}
