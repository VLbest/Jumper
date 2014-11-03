package com.vli.states;

import static com.vli.handlers.B2DVars.PPM;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.vli.handlers.B2DVars;
import com.vli.handlers.CustContactListenner;
import com.vli.handlers.GameStateManager;


public class Play extends GameState {

	private BitmapFont font;
	
	private World world;
	private Box2DDebugRenderer b2DRender;
	private BodyDef bDef;
	private Body body;
	private FixtureDef fixtureDef;
	
	private OrthographicCamera box2dCam;
	
	public Play(GameStateManager gsm) {
		super(gsm);
		this.font = new BitmapFont();
		
		this.world = new World(new Vector2(0, -9.81f), true);
		this.b2DRender = new Box2DDebugRenderer();
		world.setContactListener(new CustContactListenner());
		
		
		this.bDef = new BodyDef();
		this.bDef.position.set(200/PPM, 100/PPM);
		this.bDef.type = BodyType.StaticBody;
		this.body = this.world.createBody(this.bDef);
		this.fixtureDef = new FixtureDef();
		
		PolygonShape shape = new PolygonShape();
		shape.setAsBox(100/PPM, 10/PPM);
		
		this.fixtureDef.shape = shape;
		fixtureDef.filter.categoryBits = B2DVars.BIT_GROUND;
		fixtureDef.filter.maskBits = B2DVars.BIT_BOX | B2DVars.BIT_BALL;
		
		Fixture fix = body.createFixture(fixtureDef);
		fix.setUserData("ground");
		
		bDef.position.set(200/PPM, 400/PPM);
		this.bDef.type = BodyType.StaticBody;
		this.body = this.world.createBody(this.bDef);
		body.createFixture(fixtureDef);
		
		bDef.position.set(200/PPM, 300/PPM);
		bDef.type = BodyType.DynamicBody;
		this.body = this.world.createBody(this.bDef);
		
		shape.setAsBox(10/PPM, 10/PPM);
		fixtureDef.shape = shape;
		fixtureDef.restitution = 0.99f;
		fixtureDef.filter.categoryBits = B2DVars.BIT_BOX;
		fixtureDef.filter.maskBits = B2DVars.BIT_GROUND;
		fix = body.createFixture(fixtureDef);
		fix.setUserData("box");
		
		
		bDef.position.set(220/PPM, 200/PPM);
		body = world.createBody(bDef);
		CircleShape cShape = new CircleShape();
		cShape.setRadius(25/PPM);
		fixtureDef.shape = cShape;
		fixtureDef.filter.categoryBits = B2DVars.BIT_BALL;
		fixtureDef.filter.maskBits = B2DVars.BIT_GROUND;
		fix = body.createFixture(fixtureDef);
		fix.setUserData("ball");
		
		
		this.box2dCam = new OrthographicCamera();
		this.box2dCam.setToOrtho(false, Gdx.graphics.getWidth()/PPM, Gdx.graphics.getHeight()/PPM);
		
	}

	@Override
	public void handleInput() {

	}

	@Override
	public void update(float delta) {
		
		world.step(delta, 6, 2);
		
	}

	@Override
	public void render() {
		
		Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		this.b2DRender.render(this.world, this.box2dCam.combined);
	}

	@Override
	public void dispose() {

	}

}
