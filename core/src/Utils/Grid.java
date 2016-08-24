package Utils;

/**
 * Created by Happy-Saila on 8/24/2016.
 */

//class used to create a grid for all creatable blocks
public class Grid {
    GridBlock[][] grid;

    public Grid(int x, int y){
        grid = new GridBlock[][][y][x];
    }

    public void render(float delta){
        for (GridBlock[] row : grid){
            for(GridBlock block : row){
                //draw the block
            }
        }
    }

    public void addGrid(int x, int y, GridBlock block){
        grid[y][x] = block;
    }
    public void removeGrid(int x, int y){
        grid[y][x] = block;
    }
}
