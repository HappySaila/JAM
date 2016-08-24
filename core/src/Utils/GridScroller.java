package Utils;

import Sprites.Player;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

/**
 * Created by Happy-Saila on 8/24/2016.
 */
//this class will controll which blocks in the grid should be active
public class GridScroller {
    //need to know which current block we are on
    private int x;
    private int y;
    private Grid grid;
    private Player player;

    public GridScroller(Grid grid, Player player){
        this.x = 0;
        this.y = 0;
        this.grid = grid;
        this.player = player;
    }

    public void update(float delta){
        if (player.build){
            checkInput();
        }
    }

    private void checkInput(){
        if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT)){
            x-=1;
            grid.getGrid()[x][y].getBlock().setActive(true);
            grid.getGrid()[x+1][y].getBlock().setActive(false);
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)){
            x+=1;
            grid.getGrid()[x][y].getBlock().setActive(true);
            grid.getGrid()[x-1][y].getBlock().setActive(false);
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.UP)){
            y+=1;
            grid.getGrid()[x][y].getBlock().setActive(true);
            grid.getGrid()[x][y-1].getBlock().setActive(false);
        }
    }
}
