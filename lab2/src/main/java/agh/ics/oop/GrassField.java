package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.lang.Math;
import java.util.HashMap;
import java.util.Map;

public class GrassField extends AbstractWorldMap {
    private HashMap<Vector2d, Grass> grassMap;
    public final MapBoundary mapBoundary;

    public GrassField(int grassAmount){
        this.grassMap = new HashMap<>();
        this.mapBoundary = new MapBoundary();
        int min = 0;
        int max = (int)(Math.sqrt(10*grassAmount));

        for (int i = 0; i < grassAmount; i++){
            int x = (int) ((Math.random() * (max - min + 1)) + min);
            int y = (int) ((Math.random() * (max - min + 1)) + min);
            Vector2d newGrassPosition = new Vector2d(x,y);

            int repeats = 0;
            if(this.grassMap.containsKey(newGrassPosition)){
                    i--;
                    repeats++;
                }
            if(repeats == 0){
                grassMap.put(newGrassPosition, new Grass(newGrassPosition));
                mapBoundary.place(newGrassPosition);
            }
        }
    }

    @Override
    public boolean canMoveTo(Vector2d position){
        Object obj = this.objectAt(position);
        return obj == null || obj instanceof Grass;
    }

    @Override
    public Object objectAt(Vector2d position){
        Object obj = super.objectAt(position);
        if (obj instanceof Animal) {
            return obj;
        }
        return grassMap.getOrDefault(position, null);

    };

    @Override
    public Vector2d calculateLowerBound(){
        return this.mapBoundary.getLowerLeft();
    }

    @Override
    public Vector2d calculateUpperBound(){
        return this.mapBoundary.getUpperRight();
    }

    @Override
    public void place(Animal animal){
        super.place(animal);
        mapBoundary.place(animal.getPosition());
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        super.positionChanged(oldPosition, newPosition);
        this.mapBoundary.positionChanged(oldPosition,newPosition);
    }
}
