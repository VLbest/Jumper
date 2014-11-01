package com.vli.states;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.vli.handlers.GameStateManager;


public class Play extends GameState {

	private BitmapFont font;
	
	public Play(GameStateManager gsm) {
		super(gsm);
		this.font = new BitmapFont();
	}

	@Override
	public void handleInput() {

	}

	@Override
	public void update(float delta) {

	}

	@Override
	public void render() {
		this.batch.setProjectionMatrix(this.cam.combined);
		this.batch.begin();
		
		this.font.draw(this.batch, "State", 100, 20);
		
		this.batch.end();
	}

	@Override
	public void dispose() {

	}

}
