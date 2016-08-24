package Utils;

import Screens.GameScreen;
import com.badlogic.gdx.physics.box2d.*;

/**
 * Created by Happy-Saila on 8/24/2016.
 */
public class GridBlock {
    private int x;
    private int y;
    private final int size = 30 /GameScreen.PPM;
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
        shape.setAsBox(size,size);

        FixtureDef fdef = new FixtureDef();
        fdef.shape = shape;
        body.createFixture(fdef);
    }

    public Body getBlock(){
        return body;
    }
}
