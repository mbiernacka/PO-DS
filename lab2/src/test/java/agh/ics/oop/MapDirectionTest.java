package agh.ics.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MapDirectionTest {

    @Test
    void NextDirectionTest(){
        assertAll(
                ()-> assertEquals(MapDirection.SOUTH, MapDirection.EAST.next()),
                ()-> assertEquals(MapDirection.WEST, MapDirection.SOUTH.next()),
                ()-> assertEquals(MapDirection.NORTH, MapDirection.WEST.next()),
                ()-> assertEquals(MapDirection.EAST, MapDirection.NORTH.next())
        );
    }

    @Test
    void PreviousDirectionTest(){
        assertAll(
                ()-> assertEquals(MapDirection.NORTH, MapDirection.EAST.previous()),
                ()-> assertEquals(MapDirection.EAST, MapDirection.SOUTH.previous()),
                ()-> assertEquals(MapDirection.SOUTH, MapDirection.WEST.previous()),
                ()-> assertEquals(MapDirection.WEST, MapDirection.NORTH.previous())
        );
    }
}
