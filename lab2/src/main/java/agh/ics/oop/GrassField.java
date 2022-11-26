package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.lang.Math;

public class GrassField extends AbstractWorldMap implements IWorldMap{

    private List<Grass> grassList;

    public GrassField(int grassAmount){
        this.grassList = new ArrayList<>();

        int min = 0;
        int max = (int)(Math.sqrt(10*grassAmount));

        for (int i = 0; i < grassAmount; i++){

            //zamiast losowania zrobic liste pozycji (0,0),(1,0)..(n,n) i collections.shuffle i wybrac np x pierwszych
            //tak jest lepiej, bo z randomem jest niedeterministyczny
            int x = (int) ((Math.random() * (max - min + 1)) + min);
            int y = (int) ((Math.random() * (max - min + 1)) + min);
            Vector2d newGrassPosition = new Vector2d(x,y);

            int repeats = 0;
            for(Grass grass: grassList){
                if(grass.getPosition().equals(newGrassPosition)) {
                    i--;
                    repeats++;
                }
            }
            if(repeats == 0){
                grassList.add(new Grass(newGrassPosition));
            }
        }
    }

    public boolean canMoveTo(Vector2d position){
        Object obj = this.objectAt(position);
        return obj == null || obj instanceof Grass;
    }

    @Override
    public Object objectAt(Vector2d position){
        Object obj = super.objectAt(position);
        if (obj == null) {
            for (Grass grass : grassList) {
                if (grass.getPosition().equals(position)) {
                    return grass;
                }
            }
        }
        return obj;
    };

    @Override
    protected Vector2d calculateLowerBound(){
        Vector2d lowerBound = grassList.get(0).getPosition();

        for (Animal animal: animalList){
            lowerBound = lowerBound.lowerLeft(animal.getPosition());
        }

        for (Grass grass: grassList){
            lowerBound = lowerBound.lowerLeft(grass.getPosition());
        }

        return lowerBound;
    }

    @Override
    protected Vector2d calculateUpperBound(){
        Vector2d upperBound = grassList.get(0).getPosition();
        for (Animal animal: animalList){
            upperBound = upperBound.upperRight(animal.getPosition());
        }

        for (Grass grass: grassList){
            upperBound = upperBound.upperRight(grass.getPosition());
        }

        return upperBound;
    }
}
