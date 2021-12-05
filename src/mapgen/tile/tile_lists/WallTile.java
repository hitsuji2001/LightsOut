package mapgen.tile.tile_lists;

import mapgen.tile.Tile;
import mapgen.tile.interfaces.NonWalkable;

import java.util.ArrayList;
import java.io.IOException;

public class WallTile extends Tile implements NonWalkable
{
    private ArrayList <Tile> wallTiles = new ArrayList<>();
    private Tile templatTile = new Tile();

    public WallTile()
    {
        try
        {
            this.loadTilesFromFiles("assets/map/wall/nonanimated/", this.wallTiles, this.templatTile);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public ArrayList <Tile> getAllWallTiles()
    {
        return this.wallTiles;
    }

    @Override
    public void setIsSolid()
    {
        this.templatTile.setIsSolid(true);
    }

    private enum WALL_VARIANT
    {
        BANNER_BLUE,
        BANNER_GREEN,
        BANNER_RED,
        BANNER_YELLOW,
        COLUMN_MID,
        COLUMN_TOP,
        CORNER_BOTTOM_LEFT,
        CORNER_BOTTOM_RIGHT,
        CORNER_FRONT_LEFT,
        CORNER_FRONT_RIGHT,
        CORNER_LEFT,
        CORNER_RIGHT,
        CORNER_TOP_LEFT,
        CORNER_TOP_RIGHT,
        COULMN_BASE,
        FOUNTAIN_TOP,
        GOO,
        GOO_BASE,
        HOLE_1,
        HOLE_2,
        INNER_CORNER_L_TOP_LEFT,
        INNER_CORNER_L_TOP_RIGTH,
        INNER_CORNER_MID_LEFT,
        INNER_CORNER_MID_RIGTH,
        INNER_CORNER_T_TOP_LEFT,
        INNER_CORNER_T_TOP_RIGTH,
        LEFT,
        MID,
        RIGHT,
        SIDE_FRONT_LEFT,
        SIDE_FRONT_RIGHT,
        SIDE_MID_LEFT,
        SIDE_MID_RIGHT,
        SIDE_TOP_LEFT,
        SIDE_TOP_RIGHT,
        TOP_LEFT,
        TOP_MID,
        TOP_RIGHT,
    };

}
