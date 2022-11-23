package agh.ics.oop;

import java.util.Objects;

public class Animal {

    private MapDirection orientation;// =  MapDirection.NORTH;
    private Vector2d position;// = new Vector2d(2,2);
    private IWorldMap map;
    public Animal (IWorldMap map){
        this.map = map;
    }

    public Animal(IWorldMap map, Vector2d initialPosition){
        this.orientation = MapDirection.NORTH;
        this.position = initialPosition;
        this.map = map;
    }


    public MapDirection getOrientation() {
        return orientation;
    }

    public Vector2d getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return switch (this.orientation){
            case NORTH -> "N";
            case EAST -> "E";
            case SOUTH -> "S";
            case WEST -> "W";
        };
    }

    public boolean isAt(Vector2d position){
        return Objects.equals(this.position, position);
    }


    public void move(MoveDirection direction){
        Vector2d move = new Vector2d(0,0);
        MapDirection newOrientation = this.orientation;
        switch(direction){
            case LEFT -> newOrientation = newOrientation.previous();
            case RIGHT -> newOrientation = newOrientation.next();
            case BACKWARD -> move = this.orientation.toUnitVector().opposite();
            case FORWARD -> move = this.orientation.toUnitVector();
        }

        Vector2d newPosition = this.position.add(move);
        /*if(newPosition.follows(World.LOWER_BOUND) && newPosition.precedes(World.UPPER_BOUND)){
            this.position = newPosition;
            this.orientation = newOrientation;
        }*/

        this.orientation = newOrientation;
        this.position = map.canMoveTo(newPosition) ? newPosition : this.position;

    }
}
