package Screens;

import com.JAM.game.JamDriver;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;

/**
 * Created by Happy-Saila on 8/24/2016.
 */
public class MenuScreen implements Screen {
    final JamDriver game;
    public final static OrthographicCamera camera = new OrthographicCamera();
    private Stage stage;
    private GameScreen gameScreen;
    private BitmapFont font;
    public static final float viewPortX=1000;
    public static final float viewPortY=1000;


//    private GameScreen gameScreen;

    public MenuScreen(JamDriver game){
        this.game = game;
        camera.setToOrtho(false, viewPortX, viewPortY);
        gameScreen = new GameScreen(game);
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.5f, 0.25f, 0.25f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        game.sb.setProjectionMatrix(camera.combined);

        game.sb.begin();
        game.font.draw(game.sb, "JAM", 430, 500);
        game.sb.end();

        if (Gdx.input.justTouched()){
            game.setScreen(gameScreen);
            dispose();
        }
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
}
