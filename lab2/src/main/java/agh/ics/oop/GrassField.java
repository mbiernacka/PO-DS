package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.lang.Math;

public class GrassField extends AbstractWorldMap implements IWorldMap{

    private int grassAmount;
    private List<Grass> grassList;


    public GrassField(int grassAmount){
        this.grassAmount = grassAmount;
        this.grassList = new ArrayList<>();
        this.lowerLeft = null;
        this.upperRight = null;

        int min = 0;
        int max = (int)(Math.sqrt(10*this.grassAmount));

        for (int i = 0; i < this.grassAmount; i++){

            int x = (int) ((Math.random() * (max - min + 1)) + min);
            int y = (int) ((Math.random() * (max - min + 1)) + min);
            Vector2d newGrassPosition = new Vector2d(x,y);

            if(this.lowerLeft == null){
                this.lowerLeft = newGrassPosition;
            }
            if(this.upperRight == null){
                this.upperRight = newGrassPosition;
            }

            int repeats = 0;
            for(Grass grass: grassList){
                if(grass.getPosition().equals(newGrassPosition)) {
                    i--;
                    repeats++;
                }
            }

            if(repeats == 0){
                grassList.add(new Grass(newGrassPosition));
                this.lowerLeft = this.lowerLeft.lowerLeft(newGrassPosition);
                this.upperRight = this.upperRight.upperRight(newGrassPosition);
            }
        }
    }

    public boolean canMoveTo(Vector2d position){
        for (Animal animal: animalList){
            if (animal.getPosition().equals(position)){
                return false;
            }
        }

        for(Grass grass: grassList){
            if(grass.getPosition().equals(position)){
                grassList.remove(grass);
                break;
            }
        }

        this.lowerLeft = this.lowerLeft.lowerLeft(position);
        this.upperRight = this.upperRight.upperRight(position);
        return true;
    }


    //ma zwracac dla zwierzecia i trawy, bo w rysowaniu sie go wykorzystuje
    public boolean isOccupied(Vector2d position) {
        for (Animal animal: animalList){
            if (animal.getPosition().equals(position)){
                return true;
            }
        }
        for(Grass grass: grassList){
            if (grass.getPosition().equals(position)){
                return true;
            }
        }
        return false;
    }

    //ma zwracac dla zwierzecia i trawy, bo w rysowaniu sie go wykorzystuje
    public Object objectAt(Vector2d position){
        for (Animal animal: animalList){
            Vector2d animalPosition = animal.getPosition();

            if (animalPosition.equals(position)){
                return animal;
            }
        }
        for(Grass grass: grassList){
            if(grass.getPosition().equals(position)){
                return grass;            }
        }
        return null;
    };


}
