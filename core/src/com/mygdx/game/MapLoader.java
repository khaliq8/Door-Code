package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;

public class MapLoader {
	static BodyDef bdef = new BodyDef();
	static FixtureDef fdef = new FixtureDef();
	static PolygonShape shape = new PolygonShape();
	public static void load(String loc){

		switch (loc)
		{
		case "8-10door": //entering the 8-ten store
			MyGdxGame.img = new Texture("8-Ten.png");
			bdef.position.set(-10,0);
			bdef.type = BodyDef.BodyType.StaticBody;
			fdef.isSensor = true;
			shape.setAsBox(2, 3);
			fdef.shape = shape;
			MyGdxGame.world.createBody(bdef).createFixture(fdef).setUserData("8-10Exit");
			break;
		case "8-10Exit": //leaving the 8-ten store
			loadCity(-40,-100);

			break;
		}
	}
	private static void loadCity(float x, float y){
		MyGdxGame.img = new Texture ("city v7c.png");
		MyGdxGame.cityX = x;
		MyGdxGame.cityY = y;
		bdef.position.set(20, 20);
		fdef.isSensor = true;
		shape.setAsBox(2, 3);
		fdef.shape = shape;
		MyGdxGame.world.createBody(bdef).createFixture(fdef).setUserData("8-10door");
	}

}
