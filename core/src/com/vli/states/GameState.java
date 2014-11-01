package com.vli.states;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.vli.handlers.GameStateManager;
import com.vli.jumper.Jumper;

public abstract class GameState {

	protected GameStateManager gsm;
	protected Jumper game;
	protected SpriteBatch batch;
	protected OrthographicCamera cam, hudCam;
	
	public GameState(GameStateManager gsm){
		this.gsm = gsm;
		this.game = gsm.getGame();
		this.batch = this.game.getBatch();
		this.cam = this.game.getCamera();
		this.hudCam = this.game.getHudCamera();
	}
	
	public abstract void handleInput();
	public abstract void update(float delta);
	public abstract void render();
	public abstract void dispose();
	
}
