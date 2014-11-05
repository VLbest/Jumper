package com.vli.jumper;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.vli.handlers.CustInput;
import com.vli.handlers.CustInputProcessor;
import com.vli.handlers.GameStateManager;


public class Jumper extends Game{
	
	private SpriteBatch batch;
	private OrthographicCamera cam, hudCam;
	private GameStateManager gsm;
	
	public static final float FPS_STEP = 1/60f;
	private float accum;
	
	@Override
	public void create() {
		
		Gdx.input.setInputProcessor(new CustInputProcessor());
		
		this.batch = new SpriteBatch();
		
		this.cam = new OrthographicCamera();
		this.cam.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		
		this.hudCam = new OrthographicCamera();
		this.hudCam.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		
		this.gsm = new GameStateManager(this);
	}
	
	@Override
	public void render() {
		this.accum += Gdx.graphics.getDeltaTime();
		while (this.accum >= this.FPS_STEP) {
			this.accum -= this.FPS_STEP;
			this.gsm.update(FPS_STEP);
			this.gsm.render();
			CustInput.update();
		}
	}
	
	
	public SpriteBatch getBatch() { return this.batch; }
	public OrthographicCamera getCamera() { return this.cam; }
	public OrthographicCamera getHudCamera() { return this.hudCam; }

}
