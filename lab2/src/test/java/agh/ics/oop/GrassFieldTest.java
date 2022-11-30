package agh.ics.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GrassFieldTest {

    @Test
    public void canMoveToTest(){
        GrassField map = new GrassField(8);
        MapVisualizer mapVisualizer = new MapVisualizer(map);
        mapVisualizer.draw(new Vector2d(0,0), new Vector2d(10,10));
        Animal animal1 = new Animal(map, new Vector2d(3,2));
        Animal animal2 = new Animal(map, new Vector2d(2,2));
        map.place(animal1);
        map.place(animal2);

        assertAll(
                () -> assertFalse(map.canMoveTo(new Vector2d(3,2))),
                () -> assertTrue(map.canMoveTo(new Vector2d(1,1)))
        );
    }

    @Test
    public void objectAtTest(){
        GrassField map = new GrassField(8);
        Animal animal1 = new Animal(map, new Vector2d(3,2));
        Animal animal2 = new Animal(map, new Vector2d(2,2));
        map.place(animal1);
        map.place(animal2);
        assertAll(
                () -> assertEquals(animal1, map.objectAt(new Vector2d(3,2))),
                () -> assertEquals(animal2, map.objectAt(new Vector2d(2,2))),
                () -> assertEquals(null, map.objectAt(new Vector2d(1,1)))
        );
    }

    @Test
    public void isOccupiedTest(){
        GrassField map = new GrassField(8);
        Animal animal1 = new Animal(map, new Vector2d(3,2));
        Animal animal2 = new Animal(map, new Vector2d(2,2));
        map.place(animal1);
        map.place(animal2);
        assertAll(
                () -> assertTrue(map.isOccupied(new Vector2d(3,2))),
                () -> assertTrue(map.isOccupied(new Vector2d(2,2))),
                () -> assertFalse(map.isOccupied(new Vector2d(1,1)))
        );
    }

    @Test
    public void placeTest(){
        GrassField map = new GrassField(8);
        Animal animal1 = new Animal(map, new Vector2d(3,2));
        Animal animal2 = new Animal(map, new Vector2d(2,2));
        map.place(animal2);
        assertAll(
                () -> assertTrue(map.place(animal1)),
                () -> assertFalse(map.place(new Animal(map, new Vector2d(2,2))))
        );
    }

}
