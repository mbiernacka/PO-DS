package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap {

    private final int width;
    private final int height;
    private final List<Animal> animalList;

    public RectangularMap(int width, int height){
        this.width = width;
        this.height = height;
        this.animalList = new ArrayList<>();
    }

    public boolean canMoveTo(Vector2d position){
        if(position.follows(World.LOWER_BOUND) && position.precedes(World.UPPER_BOUND) && (isOccupied(position) == false)){
            return true;
        };
        return false;
    }

    public boolean place(Animal animal){
        if(isOccupied(animal.getPosition())){
            return false;
        }
            animalList.add(animal);
            return true;
    }
    public boolean isOccupied(Vector2d position){
        return objectAt(position) != null;
    };

    public Object objectAt(Vector2d position){
        for (Animal animal: animalList){
            if (animal.getPosition().equals(position)){
                return animal;
            }
        }
    return null;
    };
}
