package com.vli.handlers;


import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;

public class CustInputProcessor extends InputAdapter{

	@Override
	public boolean keyDown(int keycode) {
		if(keycode == Keys.UP){		CustInput.setKey(CustInput.BT1, true);	}
		if(keycode == Keys.DOWN){		CustInput.setKey(CustInput.BT2, true);	}
		return true;
	}
	
	@Override
	public boolean keyUp(int keycode) {
		if(keycode == Keys.UP){		CustInput.setKey(CustInput.BT1, false);	}
		if(keycode == Keys.DOWN){		CustInput.setKey(CustInput.BT2, false);	}
		return true;
	}
	
}
