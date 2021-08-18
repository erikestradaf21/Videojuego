package com.empresa.mygame.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.empresa.mygame.MyGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		//config.title = "Otro titulo";
		//config.resizable = false;
		//config.foregroundFPS = 60; /*se fija para q no pueda ir por arriba de 60 FPS, puede ir por debajo*/
		/*cuadros por seg/cant de img por seg*//*+FPS menos rendimiento*//*TODO investigar FPS*/
		//System.out.println(config.foregroundFPS);
		//config.
		new LwjglApplication(new MyGame(), config);
		/*si la placa de video no maneja openGL "not Run"(puede pasar si no esta actuyalizado)*/
	}
}
