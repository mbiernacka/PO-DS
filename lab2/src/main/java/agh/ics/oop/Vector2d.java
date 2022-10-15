package agh.ics.oop;

public class Vector2d {

    public final int x;
    public final int y;

    public Vector2d(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(%d, %d)".formatted(x,y);
    }

   /* public Vector2d add(Vector2d other){
       // return new Vector2d(x:x + other.x, y:y + other.y)
    }*/

    //test comment

}
