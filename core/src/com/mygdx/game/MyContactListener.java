package com.mygdx.game;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;

public class MyContactListener implements ContactListener{
	private boolean worldChanged = false;
	public String lastDoor;
	public void beginContact(Contact c){
		Fixture fa = c.getFixtureA();
		Fixture fb = c.getFixtureB();
		
		if(fa.getUserData() != null)
			if(fa.getUserData().equals("8-10door") || fa.getUserData().equals("8-10Exit"))
				{
					worldChanged = true;
					lastDoor = (String)fa.getUserData();
				}
	}
	public void endContact(Contact c){}
	public void preSolve(Contact c, Manifold m){}
	public void postSolve(Contact c, ContactImpulse ci){}
	public boolean worldChanged(){
		boolean returnVar = worldChanged;
		worldChanged = false;
		return returnVar;
	}
}