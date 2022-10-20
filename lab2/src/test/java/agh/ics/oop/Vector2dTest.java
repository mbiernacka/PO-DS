package agh.ics.oop;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Vector2dTest {

    //fajną praktyką jest układanie kontentu testu na częsci: given, when, then

    //equals() tests
    @Test
    void objectAreEqual(){
        Vector2d vector1 = new Vector2d(3,7);
        Vector2d vector2 = new Vector2d(3,7);
        assertEquals(vector1, vector2);
    }

    @Test
    void objectAreNotEqual(){
        Vector2d vector1 = new Vector2d(7,7);
        Vector2d vector2 = new Vector2d(4,1);
        assertNotEquals(vector1, vector2);
    }

    //toString() test
    @Test
    void toStringTest(){
        Vector2d vector = new Vector2d(3,7);
        String expected = "(3, 7)";
        assertEquals(expected, vector.toString());
    }

    //precedes() tests
    @Test
    void vector1PrecedesVector2(){
        Vector2d vector1 = new Vector2d(1,4);
        Vector2d vector2 = new Vector2d(3,7);
        assertTrue(vector1.precedes(vector2));
    }

    @Test
    void vector1DoesNotPrecedeVector2(){
        Vector2d vector1 = new Vector2d(1,8);
        Vector2d vector2 = new Vector2d(3,7);
        assertFalse(vector1.precedes(vector2));
    }

    //follows test
    @Test
    void vector1FollowsVector2(){
        Vector2d vector1 = new Vector2d(5,8);
        Vector2d vector2 = new Vector2d(3,7);
        assertTrue(vector1.follows(vector2));
    }

    @Test
    void vector1DoesNotFollowVector2(){
        Vector2d vector1 = new Vector2d(1,8);
        Vector2d vector2 = new Vector2d(3,7);
        assertFalse(vector1.follows(vector2));
    }

    //upperRight() tests
    @Test
    void upperRightTest(){
        Vector2d vector1 = new Vector2d(1,8);
        Vector2d vector2 = new Vector2d(3,7);
        assertEquals(new Vector2d(3,8), vector1.upperRight(vector2));
    }

    //lowerLeft() tets
    @Test
    void lowerLeftTest(){
        Vector2d vector1 = new Vector2d(1,8);
        Vector2d vector2 = new Vector2d(3,7);
        assertEquals(new Vector2d(1,7), vector1.lowerLeft(vector2));
    }

    //add() test
    @Test
    void vectors3And5Plus4and9Equals7And14Vector(){
        Vector2d vector1 = new Vector2d(3,5);
        Vector2d vector2 = new Vector2d(4,9);
        assertEquals(new Vector2d(7,14), vector1.add(vector2));
    }

    //substract() tets
    @Test
    void vectors3And5Minus1and2Equals2And3Vector(){
        Vector2d vector1 = new Vector2d(3,5);
        Vector2d vector2 = new Vector2d(1,2);
        assertEquals(new Vector2d(2,3), vector1.substract(vector2));
    }

    //opposite() test
    @Test
    void oppositeTest(){
        Vector2d vector2d = new Vector2d(3,-5);
        assertEquals(new Vector2d(-3,5), vector2d.opposite());
    }
}