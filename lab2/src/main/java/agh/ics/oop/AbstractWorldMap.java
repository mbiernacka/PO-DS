package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public abstract class AbstractWorldMap implements IWorldMap {
    protected List<Animal> animalList;
    protected final MapVisualizer mapVisualizer;
    protected Vector2d lowerLeft;
    protected Vector2d upperRight;


    protected AbstractWorldMap(){
        this. animalList = new ArrayList<>();
        this.mapVisualizer = new MapVisualizer(this);
    }

    public boolean place(Animal animal) {
            if(!canMoveTo(animal.getPosition())){
                return false;
            }
            animalList.add(animal);
            return true;
    }

    public String toString(){
        return mapVisualizer.draw(lowerLeft, upperRight);
    }

}


