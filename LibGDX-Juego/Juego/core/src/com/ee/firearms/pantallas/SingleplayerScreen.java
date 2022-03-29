package com.ee.firearms.pantallas;

import com.ee.firearms.FireArms;

public class SingleplayerScreen extends AbstractScreen {

	public SingleplayerScreen(FireArms game) {
		super(game);
		// TODO Auto-generated constructor stub
	}

//	private TextureAtlas atlas;
//    private PrimerMapa mapa;
//    private OrthographicCamera gamecam;
//    private Viewport gamePort;
//
//    private World world;
//    private Box2DDebugRenderer b2dr;
//    B2WorldCreator creator;
//
//    private Jugador jugador;
//    private Enemigo enemigo;
//    
//    private Music music;
//    
//    public Game game;
//    public FireArms core;
//	
//	protected PantallaUnJugador(FireArms game) {
//		super(game);
//		this.game = game;
//		atlas = new TextureAtlas(JuegoAssetManager.ATLAS);
//
//        gamecam = new OrthographicCamera();
//
//        gamePort = new FitViewport(Constantes.V_WIDTH / Constantes.PPM, Constantes.V_HEIGHT / Constantes.PPM, gamecam);
//
//        mapa = new PrimerMapa();
//
//        gamecam.position.set(gamePort.getWorldWidth() / 2, gamePort.getWorldHeight() / 2, 0);
//
//        world = new World(new Vector2(0, Constantes.GRAVEDAD), true);
//        b2dr = new Box2DDebugRenderer();
//        creator = new B2WorldCreator(this, mapa);
//	
//        jugador = new Jugador(this, 1000);
//        enemigo = new Fantasma(this, 32, 48);
//        
//        world.setContactListener(new WorldContactListener());
//
//        music = JuegoAssetManager.manager.get(JuegoAssetManager.MUSICA_JUEGO);
//        music.setLooping(true);
//        music.play();
//	}
//
//	@Override
//	public void render(float delta) {
//		update(delta);
//
//		Utiles.limpiarPantalla();
//
//        mapa.render();
//
////        b2dr.render(world, gamecam.combined); // TODO Quitar
//
//        Utiles.sb.setProjectionMatrix(gamecam.combined);
//        Utiles.sb.begin();
//        jugador.draw(Utiles.sb);
//        jugador.dibujarVida(Utiles.sb);
//        enemigo.draw(Utiles.sb);
//        Utiles.sb.end();
//
//	}
//	
//    public void update(float dt){
//        handleInput(dt);
//
//        world.step(1 / 60f, 6, 2);
//
//        jugador.update(dt, jugador.b2body.getPosition().x, jugador.b2body.getPosition().y);
//        enemigo.update(dt);
//        
//        gamecam.position.x = jugador.b2body.getPosition().x;
//        gamecam.update();
//        mapa.update(gamecam);
//    }
//    
//    public void handleInput(float dt){
//            if (Gdx.input.isKeyJustPressed(Input.Keys.UP))
//                jugador.jump();
//            if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && jugador.b2body.getLinearVelocity().x <= 2)
//                jugador.b2body.applyLinearImpulse(new Vector2(0.1f, 0), jugador.b2body.getWorldCenter(), true);
//            if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && jugador.b2body.getLinearVelocity().x >= -2)
//                jugador.b2body.applyLinearImpulse(new Vector2(-0.1f, 0), jugador.b2body.getWorldCenter(), true);
//            if (Gdx.input.isKeyPressed(Input.Keys.SPACE))
//                jugador.attack();
//    }
//
//    @Override
//    public void resize(int width, int height) {
//        gamePort.update(width,height);
//    }
//
//    public World getWorld(){
//        return world;
//    }
//
//    @Override
//    public void pause() {
//
//    }
//
//    @Override
//    public void resume() {
//
//    }
//
//    @Override
//    public void hide() {
//
//    }
//
//    @Override
//    public void dispose() {
////        mapa.getMap().dispose();
////        mapa.getRenderer().dispose();
//        world.dispose();
//        b2dr.dispose();
//    }
//    
//    public TextureAtlas getAtlas(){
//        return atlas;
//    }

}
