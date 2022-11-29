package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.lang.Math;
import java.util.HashMap;
import java.util.Map;

public class GrassField extends AbstractWorldMap implements IPositionChangeObserver{

    //private List<Grass> grassList;
    private HashMap<Vector2d, Grass> grassMap;

    public GrassField(int grassAmount){
        //this.grassList = new ArrayList<>();
        this.grassMap = new HashMap<>();
        int min = 0;
        int max = (int)(Math.sqrt(10*grassAmount));

        for (int i = 0; i < grassAmount; i++){

            //zamiast losowania zrobic liste pozycji (0,0),(1,0)..(n,n) i collections.shuffle i wybrac np x pierwszych
            //tak jest lepiej, bo z randomem jest niedeterministyczny
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
    protected Vector2d calculateLowerBound(){
        //Vector2d lowerBound = grassMap.get(0).getPosition();
        Vector2d lowerBound = grassMap.get(grassMap.keySet().toArray()[0]).getPosition();
        for (Vector2d position: animalMap.keySet()){
            lowerBound = lowerBound.lowerLeft(position);
        }

        for (Vector2d position: grassMap.keySet()){
            lowerBound = lowerBound.lowerLeft(position);
        }

        return lowerBound;
    }

    @Override
    protected Vector2d calculateUpperBound(){
        Vector2d upperBound = grassMap.get(grassMap.keySet().toArray()[0]).getPosition();

        for (Vector2d position: animalMap.keySet()){
            upperBound = upperBound.upperRight(position);
        }

        for (Vector2d position: grassMap.keySet()){
            upperBound = upperBound.upperRight(position);
        }
        return upperBound;
    }
}
