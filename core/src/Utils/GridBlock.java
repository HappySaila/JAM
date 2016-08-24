package Utils;

import Screens.GameScreen;
import com.badlogic.gdx.physics.box2d.*;

/**
 * Created by Happy-Saila on 8/24/2016.
 */
public class GridBlock {
    private int x;
    private int y;
    private static final int PPM =GameScreen.PPM;
    private final float size =30;
    private Body body;
    World world = GameScreen.world;
    Box2DDebugRenderer debugRenderer = GameScreen.debugRenderer;
    public String blockState;

    public GridBlock(int x, int y){
        this.x = x;
        this.y = y;
        createBlock();
    }

    public void createBlock(){
        BodyDef bdef = new BodyDef();
        bdef.type = BodyDef.BodyType.StaticBody;
        body = world.createBody(bdef);

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(size  /PPM,size  /PPM);

        FixtureDef fdef = new FixtureDef();
        fdef.shape = shape;
        body.createFixture(fdef);
    }

    public Body getBlock(){
        return body;
    }
    public void render(float delta){
        world.step(delta,6,2);
        debugRenderer.render(world, GameScreen.camera.combined);
    }
}
