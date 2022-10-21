package agh.ics.oop;

public class Animal {
    public MapDirection getOrientation() {
        return orientation;
    }

    public Vector2d getPosition() {
        return position;
    }

    private MapDirection orientation =  MapDirection.NORTH;
   private Vector2d position = new Vector2d(2,2);

    @Override
    public String toString() {
        return "Animal{" +
                "orientation=" + orientation +
                ", position=" + position +
                '}';
    }

    public boolean isAt(Vector2d position){
        return this.position.equals(position);
    }


    public void move(MoveDirection direction){
        Vector2d move = new Vector2d(0,0);
        MapDirection newOrientation = this.orientation;
        switch(direction){
            case LEFT -> newOrientation = newOrientation.previous();
            case RIGHT -> newOrientation=newOrientation.next();
            case BACKWARD -> move = this.orientation.toUnitVector().opposite();
            case FORWARD -> move = this.orientation.toUnitVector();
        }

        Vector2d newPosition = this.position.add(move);
        if(newPosition.follows(new Vector2d(0,0)) && newPosition.precedes(new Vector2d(4,4))){
            this.position = newPosition;
            this.orientation = newOrientation;
        }
    }
}
