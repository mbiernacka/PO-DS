package agh.ics.oop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public abstract class AbstractWorldMap implements IWorldMap {
    protected List<Animal> animalList;
    protected final MapVisualizer mapVisualizer;

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
        return mapVisualizer.draw(calculateLowerBound(), calculateUpperBound());
    }

    public List<Animal> getAnimals(){
        return Collections.unmodifiableList(animalList);
    }

    public Object objectAt(Vector2d position){
        for (Animal animal: getAnimals()){
            if (animal.getPosition().equals(position)){
                return animal;
            }
        }
        return null;
    }

    protected abstract Vector2d calculateLowerBound();
    protected abstract Vector2d calculateUpperBound();

}


