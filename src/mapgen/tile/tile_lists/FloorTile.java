package mapgen.tile.tile_lists;

import mapgen.tile.Tile;
import mapgen.tile.interfaces.Walkable;

import java.util.ArrayList;

import java.io.IOException;

public class FloorTile extends Tile implements Walkable
{
    private ArrayList <Tile> floorTiles = new ArrayList<>();
    private Tile templateTile = new Tile();

    public FloorTile()
    {
        try
        {
            this.loadTilesFromFiles("assets/map/floor/normalfloor/", this.floorTiles, this.templateTile);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public ArrayList <Tile> getAllFloorTiles()
    {
        return this.floorTiles;
    }

    @Override
    public void setIsSolid()
    {
        this.templateTile.setIsSolid(false);
    }

    private enum FLOOR_VARIANT
    {
        PLAIN,
        CRACKED_FLOOR,
        LITTLE_CRACKED_FLOOR,
        BIG_CRACKED_FLOOR,
        SEMI_CRACKED_FLOOR,
        BIG_HOLE,
        BROKEN_TOP_RIGHT,
        BROKEN_TOP_LEFT,
        SIZE
    };

}
