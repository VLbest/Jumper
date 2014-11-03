package com.vli.handlers;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;

public class CustContactListenner implements ContactListener{

	@Override
	public void beginContact(Contact contact) {
		System.out.println(" beginContact ");
		Fixture fa = contact.getFixtureA();
		Fixture fb = contact.getFixtureB();
		
		System.out.println(" beginContact: "+fa.getUserData()+" and "+fb.getUserData());
		
	}

	@Override
	public void endContact(Contact contact) {
		Fixture fa = contact.getFixtureA();
		Fixture fb = contact.getFixtureB();
		System.out.println(" endContact: "+fa.getUserData()+" and "+fb.getUserData());
	}

	@Override
	public void preSolve(Contact contact, Manifold oldManifold) {
		//System.out.println(" preSolve ");
	}

	@Override
	public void postSolve(Contact contact, ContactImpulse impulse) {
		//System.out.println(" postSolve ");
	}


}
