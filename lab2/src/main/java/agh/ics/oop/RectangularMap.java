package agh.ics.oop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RectangularMap extends AbstractWorldMap implements IWorldMap {

    private final int width;
    private final int height;

    public RectangularMap(int width, int height){
        this.width = width;
        this.height = height;
        upperRight = new Vector2d(width-1,height-1);
        lowerLeft = new Vector2d(0,0);
    }

    public boolean canMoveTo(Vector2d position){
        if(position.follows(lowerLeft) && position.precedes(upperRight) && (isOccupied(position) == false)){
            return true;
        };
        return false;
    }

    public Object objectAt(Vector2d position){
        for (Animal animal: animalList){
            if (animal.getPosition().equals(position)){
                return animal;
            }
        }
        //streamy
        //return animalList.stream().filter(animal -> animal.isAt(position)).findFirst().orElse(null);
    return null;
    };

     public boolean isOccupied(Vector2d position) {
        return objectAt(position) != null;
        //streamy
        //return animalList.stream().anyMatch(animal -> animal.isAt(position));
    }


    //tego użyć zamiast powtarzać dwóch takich samych list zwierząt
    public List<Animal> getAnimals(){
        //return List.copyOf(animalList);
        //alternatywnie, ale to lepiej:
        return Collections.unmodifiableList(animalList);
    }
}
