package Utils;

import Screens.GameScreen;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Created by Happy-Saila on 8/24/2016.
 */

//class used to create a grid for all creatable blocks
public class Grid {
    GridBlock[][] grid;
    World world = GameScreen.world;
    Box2DDebugRenderer debugRenderer = GameScreen.debugRenderer;

    public Grid(int x, int y){
        grid = new GridBlock[y][x];
//        for (int i = 0; i < y-1; i++) {
//            for (int j = 0; j < x-1; j++) {
//                grid[y][x]=new GridBlock(x,y);
////                System.out.println("x:"+i+" y: "+j);
//            }
//        }
        grid[0][0]=new GridBlock(0,0);
    }

    public void render(float delta){
//        for (GridBlock[] row : grid){
//            for(GridBlock block : row){
//                //draw the block
//                block.render(delta);
//            }
//        }
        grid[0][0].render(delta);
    }

    public void addGrid(int x, int y, GridBlock block){
        grid[y][x] = block;
    }
    public void removeGrid(int x, int y, GridBlock block){
        grid[y][x] = block;
    }
}
