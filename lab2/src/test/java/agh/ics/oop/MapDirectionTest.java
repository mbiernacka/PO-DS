package agh.ics.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MapDirectionTest {

    @Test
    void NextForNorthIsEast(){
        MapDirection dir = MapDirection.NORTH;
        assertEquals(MapDirection.EAST, dir.next());
    }
    @Test
    void NextForEastIsSouth(){
        assertEquals(MapDirection.SOUTH, MapDirection.EAST.next());
    }
    @Test
    void NextForSouthIsWest(){
        assertEquals(MapDirection.WEST, MapDirection.SOUTH.next());
    }
    @Test
    void NextForWestIsNorth(){
        assertEquals(MapDirection.NORTH, MapDirection.WEST.next());
    }

    @Test
    void previousForNorthIsWest(){
        assertEquals(MapDirection.WEST, MapDirection.NORTH.previous());
    }
    @Test
    void previousForEastIsNorth(){
        assertEquals(MapDirection.NORTH, MapDirection.EAST.previous());
    }
    @Test
    void previousForSouthIsEast(){
        assertEquals(MapDirection.EAST, MapDirection.SOUTH.previous());
    }
    @Test
    void previousForWestIsSouth(){
        assertEquals(MapDirection.SOUTH, MapDirection.WEST.previous());
    }
}
