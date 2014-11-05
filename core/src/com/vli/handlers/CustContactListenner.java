package com.vli.handlers;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;

public class CustContactListenner implements ContactListener{
	
	private boolean playerOnGround;
	
	@Override
	public void beginContact(Contact contact) {
		Fixture fa = contact.getFixtureA();
		Fixture fb = contact.getFixtureB();
		
		if(fa.getUserData() != null && fa.getUserData().equals("foot")){ playerOnGround = true; }
		if(fb.getUserData() != null && fb.getUserData().equals("foot")){ playerOnGround = true; }		
	}

	@Override
	public void endContact(Contact contact) {
		Fixture fa = contact.getFixtureA();
		Fixture fb = contact.getFixtureB();
		
		if(fa.getUserData() != null && fa.getUserData().equals("foot")){ playerOnGround = false; }
		if(fb.getUserData() != null && fb.getUserData().equals("foot")){ playerOnGround = false; }	
	}

	@Override
	public void preSolve(Contact contact, Manifold oldManifold) {
		//System.out.println(" preSolve ");
	}

	@Override
	public void postSolve(Contact contact, ContactImpulse impulse) {
		//System.out.println(" postSolve ");
	}
	
	public boolean isPlayerOnGround() {		return playerOnGround; 		}

}
