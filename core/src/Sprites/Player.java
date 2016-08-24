package Sprites;

import Screens.GameScreen;
import Screens.MenuScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

/**
 * Created by Happy-Saila on 8/24/2016.
 */
public class Player {
    private World world = GameScreen.world;
    private Box2DDebugRenderer debugRenderer = GameScreen.debugRenderer;
    private static final float size = 20;
    private final int PPM = GameScreen.PPM;
    private Body player;
    private final static int speed = 5;

    public Player(){
        //create player
        createBox();
    }

    private void createBox(){
        BodyDef bdef = new BodyDef();
        bdef.type = BodyDef.BodyType.DynamicBody;
//        bdef.position.set(0/PPM, 400/PPM);
        player = world.createBody(bdef);

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(size/PPM, size/PPM);

        FixtureDef fdef = new FixtureDef();
        fdef.shape = shape;
        fdef.friction =0;
        player.createFixture(fdef);
    }

    public void render(float delta){
        update(delta);
        world.step(delta, 6, 2);
        debugRenderer.render(world, GameScreen.camera.combined);
    }
    public void update(float delta){
        horizantal();
    }
    public void horizantal(){
        int xForce = 0;
        int yForce = 0;
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            xForce=-1;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            xForce=1;
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.UP)){
            yForce=1;
        }
        player.setLinearVelocity(xForce*speed, player.getLinearVelocity().y+(yForce*speed));
    }
}
