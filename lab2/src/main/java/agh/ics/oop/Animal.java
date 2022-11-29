package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Animal implements Comparable<Animal> {

    private MapDirection orientation;
    private Vector2d position;
    private IWorldMap map;
    private List<IPositionChangeObserver> observerList;
    public Animal (IWorldMap map){
        this(map, new Vector2d(2,2));
    }
    private int order;

    public Animal(IWorldMap map, Vector2d initialPosition){
        this.orientation = MapDirection.NORTH;
        this.position = initialPosition;
        this.map = map;
        this.observerList = new ArrayList<>();
        this.addObserver((IPositionChangeObserver) map);
    }


    public MapDirection getOrientation() {
        return orientation;
    }

    public Vector2d getPosition() {
        return position;
    }

    public int getOrder() {
        return order;
    }
    public void setOrder(int order) {
        this.order = order;
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

        this.orientation = newOrientation;

        if(this.map.canMoveTo(newPosition)){
            this.positionChanged(this.position, newPosition);
            this.position =  newPosition;
        }
    }

    public void addObserver(IPositionChangeObserver observer){
        this.observerList.add(observer);
    }
    public void removeObserver(IPositionChangeObserver observer){
        this.observerList.remove(observer);
    }

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        for (IPositionChangeObserver observer: this.observerList){
            observer.positionChanged(oldPosition, newPosition);
        }
    }

    @Override
    public int compareTo(Animal animal){
        return this.order - animal.getOrder();
    }
}
