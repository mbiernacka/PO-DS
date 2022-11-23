package agh.ics.oop;

import java.util.ArrayList;

public class SimulationEngine implements IEngine{

    private final MoveDirection[] moves;
    private final IWorldMap map;
    public final ArrayList<Animal> animalList;

    public SimulationEngine(MoveDirection[] moves, IWorldMap map, Vector2d[] animalsFirstPositions){
        this.moves = moves;
        this.map = map;
        this.animalList = new ArrayList<>();

        for (Vector2d vector: animalsFirstPositions){
            Animal animal = new Animal(this.map, vector);
            if(this.map.place(animal)){
                this.animalList.add(animal);
            }
            //this.map.place(animal);
        }
    }

    public void run(){
        System.out.println(this.map);
        int numberOfAnimals = this.animalList.size();
        for(int i = 0; i < moves.length; i++){
            Animal animal = this.animalList.get(i%numberOfAnimals);
            MoveDirection newMove = moves[i];
            animal.move(newMove);

            System.out.println(("Zwierze nr " + (i%numberOfAnimals + 1) + " wykonuje ruch: " + newMove));
            System.out.println("Pozcja: " + animal.getPosition().toString());
            System.out.println(this.map);
        }
    }
}
