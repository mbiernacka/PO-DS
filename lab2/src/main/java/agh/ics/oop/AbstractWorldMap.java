package agh.ics.oop;

import java.util.*;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver{
    protected Map<Vector2d, Animal> animalMap;
    protected final MapVisualizer mapVisualizer;

    protected AbstractWorldMap(){
        this.animalMap = new HashMap<>();
        this.mapVisualizer = new MapVisualizer(this);
    }

    public boolean place(Animal animal) {
        Vector2d position = animal.getPosition();
            if(!canMoveTo(position)){
                return false;
            }
            this.animalMap.put(position, animal);
            animal.setOrder(this.animalMap.size());
            return true;
    }

    public String toString(){
        return mapVisualizer.draw(calculateLowerBound(), calculateUpperBound());
    }

    public Object objectAt(Vector2d position){
        return this.animalMap.getOrDefault(position, null);
    }

    protected abstract Vector2d calculateLowerBound();
    protected abstract Vector2d calculateUpperBound();

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        Animal animal = (Animal) this.objectAt(oldPosition);
        this.animalMap.remove(oldPosition);
        this.animalMap.put(newPosition, animal);
    }

    public Map<Vector2d, Animal> getAnimalMap() {
        return Map.copyOf(this.animalMap);
    }
}


