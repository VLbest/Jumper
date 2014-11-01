package com.vli.handlers;

import java.util.Stack;

import com.vli.jumper.Jumper;
import com.vli.states.GameState;
import com.vli.states.Play;

public class GameStateManager {
	
	private Jumper game;
	private Stack<GameState> gameStates;
	private static final int PLAY = 1;
	
	public GameStateManager(Jumper game){
		this.game = game;
		this.gameStates = new Stack<GameState>();
		this.pushState(this.PLAY);
	}

	public void update(float delta){
		this.gameStates.peek().update(delta);
	}
	
	public void render(){
		this.gameStates.peek().render();
	}
	
	public Jumper getGame(){ return this.game; }
	
	public void pushState(int state) {
		this.gameStates.push(this.getGameState(state));
	}
	
	public void popState(){
		GameState gameState = this.gameStates.pop();
		gameState.dispose();
	}
	
	private GameState getGameState(int state){
		if(state == this.PLAY) return new Play(this);
		return null;
	}
	
	public void setState(int state){
		popState();
		pushState(state);
	}
	
}
