package agh.ics.oop;

public class Animal {
   private MapDirection orientation =  MapDirection.NORTH;
    //zwrocic uwqge na modyfikatory dostepu
    //mozemy wygenerpwac gettery i settery
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

    /*public void move(MoveDirection direction) {
        while (this.position.x >= 0 && this.position.y >= 0 && this.position.x <= 4 && this.position.y <= 4) {
            if (direction.equals(MoveDirection.LEFT)) {
                switch (this.orientation) {
                    case NORTH -> orientation = MapDirection.WEST;
                    case WEST -> orientation = MapDirection.SOUTH;
                    case SOUTH -> orientation = MapDirection.EAST;
                    case EAST -> orientation = MapDirection.NORTH;
                    default -> {
                    }
                } break;
            } else if (direction.equals(MoveDirection.RIGHT)) {
                switch (this.orientation) {
                    case NORTH -> orientation = MapDirection.EAST;
                    case WEST -> orientation = MapDirection.NORTH;
                    case SOUTH -> orientation = MapDirection.WEST;
                    case EAST -> orientation = MapDirection.SOUTH;
                    default -> {
                    }
                } break;
            } else if (direction.equals(MoveDirection.FORWARD)) {
                switch (this.orientation) {
                    case NORTH -> position = new Vector2d(position.x, position.y + 1);
                    case WEST -> position = new Vector2d(position.x - 1, position.y);
                    case SOUTH -> position = new Vector2d(position.x, position.y - 1);
                    case EAST -> position = new Vector2d(position.x + 1, position.y + 1);
                    default -> {
                    }
                } break;
            } else if (direction.equals(MoveDirection.BACKWARD)) {
                switch (this.orientation) {
                    case NORTH -> position = new Vector2d(position.x, position.y - 1);
                    case WEST -> position = new Vector2d(position.x + 1, position.y);
                    case SOUTH -> position = new Vector2d(position.x, position.y + 1);
                    case EAST -> position = new Vector2d(position.x + 1, position.y - 1);
                    default -> {
                    }
                }break;
            }
        }
    }*/

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
