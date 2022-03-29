package com.ee.firearms.utiles;

import com.badlogic.gdx.InputProcessor;

public class ServerInputter implements InputProcessor {
	
	@Override
	public boolean keyDown(int keycode) {
		
		String msg = "tecla!P!";
		
		if(keycode == BotonConfig.LEFT) {
			msg += "izq";
		}
		if(keycode == BotonConfig.RIGHT) {
			msg += "der";
		}
		if(keycode == BotonConfig.UP) {
			msg += "arr";
		}
		if(keycode == BotonConfig.RELOAD) {
			msg += "rel";
		}
		if(keycode == BotonConfig.HABIL1) {
			msg += "hb1";
		}
		
		if(msg.endsWith("!")) {
			msg += "undef";
		}
		
		Utiles.cliente.enviarMensaje(msg);
		
		return true;
	}

	@Override
	public boolean keyUp(int keycode) {

		String msg = "tecla!S!";
		
		if(keycode == BotonConfig.LEFT) {
			msg += "izq";
		}
		if(keycode == BotonConfig.RIGHT) {
			msg += "der";
		}
		if(keycode == BotonConfig.UP) {
			msg += "arr";
		}
		if(keycode == BotonConfig.RELOAD) {
			msg += "rel";
		}
		if(keycode == BotonConfig.HABIL1) {
			msg += "hb1";
		}
		
		if(msg.endsWith("!")) {
			msg += "undef";
		}
		
		Utiles.cliente.enviarMensaje(msg);
		
		return true;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		
		String msg = "tecla!P!";
		if(button == BotonConfig.LMB) {
			msg += "lmb";
		}
		if(button == BotonConfig.RMB) {
			msg += "rmb";
		}
		
		Utiles.cliente.enviarMensaje(msg);
		
		return true;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		String msg = "tecla!S!";
		if(button == BotonConfig.LMB) {
			msg += "lmb";
		}
		if(button == BotonConfig.RMB) {
			msg += "rmb";
		}
		
		Utiles.cliente.enviarMensaje(msg);
		
		return true;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(float amountX, float amountY) {
		// TODO Auto-generated method stub
		return false;
	}

}
