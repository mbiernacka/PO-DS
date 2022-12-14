//package agh.ics.oop;
//
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;
//
//public class RectangularMapTest {
//
//    @Test
//    public void canMoveToTest(){
//        RectangularMap map = new RectangularMap(5,7);
//        Animal animal1 = new Animal(map, new Vector2d(3,2));
//        Animal animal2 = new Animal(map, new Vector2d(2,2));
//        map.place(animal1);
//        map.place(animal2);
//
//        assertAll(
//                () -> assertFalse(map.canMoveTo(new Vector2d(3,2))),
//                () -> assertTrue(map.canMoveTo(new Vector2d(1,1)))
//        );
//    }
//
//    @Test
//    public void objectAtTest(){
//        RectangularMap map = new RectangularMap(5,7);
//        Animal animal1 = new Animal(map, new Vector2d(3,2));
//        Animal animal2 = new Animal(map, new Vector2d(2,2));
//        map.place(animal1);
//        map.place(animal2);
//        assertAll(
//                () -> assertEquals(animal1, map.objectAt(new Vector2d(3,2))),
//                () -> assertEquals(animal2, map.objectAt(new Vector2d(2,2))),
//                () -> assertEquals(null, map.objectAt(new Vector2d(1,1)))
//        );
//    }
//
//    @Test
//    public void isOccupiedTest(){
//        RectangularMap map = new RectangularMap(5,7);
//        Animal animal1 = new Animal(map, new Vector2d(3,2));
//        Animal animal2 = new Animal(map, new Vector2d(2,2));
//        map.place(animal1);
//        map.place(animal2);
//        assertAll(
//                () -> assertTrue(map.isOccupied(new Vector2d(3,2))),
//                () -> assertTrue(map.isOccupied(new Vector2d(2,2))),
//                () -> assertFalse(map.isOccupied(new Vector2d(1,1)))
//        );
//    }
//
//    @Test
//    public void placeTest(){
//        RectangularMap map = new RectangularMap(5,7);
//        Animal animal1 = new Animal(map, new Vector2d(3,2));
//        Animal animal2 = new Animal(map, new Vector2d(2,2));
//        map.place(animal2);
//        assertAll(
//                () -> assertTrue(map.place(animal1)),
//                () -> assertFalse(map.place(new Animal(map, new Vector2d(2,2))))
//        );
//    }
//
//}
