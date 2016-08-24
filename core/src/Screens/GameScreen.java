package Screens;

import Sprites.Player;
import Utils.Grid;
import Utils.GridBlock;
import com.JAM.game.JamDriver;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

/**
 * Created by Happy-Saila on 8/24/2016.
 */
public class GameScreen implements Screen {
    final JamDriver game;
    public static World world;
    public final static float PPM = 100;
    public static Box2DDebugRenderer debugRenderer;
    public static final OrthographicCamera camera = new OrthographicCamera(MenuScreen.viewPortX/PPM,
            MenuScreen.viewPortY/PPM);
    private Player[] players;
    private int numberPlayers;
    public static final float xZero = -MenuScreen.viewPortX/PPM;
    public static final float yZero = -MenuScreen.viewPortY/PPM;
    private Grid grid;
    private Texture img = new Texture("block.png");


    public GameScreen(JamDriver game){
        this.game = game;
        numberPlayers = 1;
        players = new Player[1];
        world = new World(new Vector2(0,-10f), true);
        debugRenderer = new Box2DDebugRenderer();
        //generate static box2D
        createField();
        System.out.println((int)(MenuScreen.viewPortX/ GridBlock.size) +" : "+ (int)(MenuScreen.viewPortY/ GridBlock.size));
        grid = new Grid( (int)(MenuScreen.viewPortY/ GridBlock.size) , (int)(MenuScreen.viewPortX/ GridBlock.size));
//        grid = new Grid(1,1);
        players[0] = new Player(grid);
    }

    private void createField(){
        Body floor;
//        Body ceiling;
        Body right;
        Body left;
        BodyDef bdef = new BodyDef();
        bdef.type = BodyDef.BodyType.StaticBody;
        //create objects with specific bdef
        bdef.position.set( (-MenuScreen.viewPortX/2)  /PPM, (-MenuScreen.viewPortY/2)  /PPM);
        floor = world.createBody(bdef);
        right = world.createBody(bdef);
        bdef.position.set( (MenuScreen.viewPortX/2 - MenuScreen.viewPortY/2/100)  /PPM, (-MenuScreen.viewPortY/2)  /PPM);
        left= world.createBody(bdef);

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(MenuScreen.viewPortX/PPM,(MenuScreen.viewPortY/100)/PPM);
        PolygonShape shape2 = new PolygonShape();
        shape2.setAsBox((MenuScreen.viewPortY/100)/PPM,MenuScreen.viewPortX/PPM);

        FixtureDef fdef = new FixtureDef();
        fdef.shape = shape;
        floor.createFixture(fdef);
        fdef.shape = shape2;
        right.createFixture(fdef);
        left.createFixture(fdef);


    }
    @Override
    public void render(float delta) {
        update(delta);
        Gdx.gl.glClearColor(0.7f, 0.25f, 0.25f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        for (Player p: players){
            p.render(delta);
        }
        grid.render(delta);

        JamDriver.sb.begin();
        for (GridBlock[] row : grid.getGrid()){
            for (GridBlock b: row){
                if (b.getBlock().isActive()){
                    b.render(delta);
                }
            }
        }
        JamDriver.sb.draw(img,0,0);
        JamDriver.sb.end();
    }
    public void update(float delta){
        world.step(delta, 6,2);
        debugRenderer.render(world, camera.combined);
    }


    //region implemented methods
    @Override
    public void show() {

    }
    @Override
    public void resize(int width, int height) {

    }
    @Override
    public void pause() {

    }
    @Override
    public void resume() {

    }
    @Override
    public void hide() {

    }
    @Override
    public void dispose() {

    }
    //endregion

}
