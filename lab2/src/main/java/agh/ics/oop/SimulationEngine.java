package agh.ics.oop;

import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SimulationEngine implements IEngine{

    private final MoveDirection[] moves;
    private final AbstractWorldMap map;
    //private final GridPane gridPane;

    public SimulationEngine(MoveDirection[] moves, AbstractWorldMap map, Vector2d[] animalsFirstPositions){
        this.moves = moves;
        this.map = map;
        //this.gridPane = gridPane;
        for (Vector2d vector: animalsFirstPositions){
            Animal animal = new Animal(this.map, vector);
            this.map.place(animal);
        }
    }

    public void run(){
        System.out.println(this.map);
        int numberOfAnimals = this.map.getAnimalMap().size();

        LinkedHashMap<Vector2d, Animal> sortedMap = this.map.getAnimalMap().entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (prev, next) -> next, LinkedHashMap::new));

//        for(int i = 0; i < moves.length; i++){
//            Animal animal = l.get()i%numberOfAnimals];
//            MoveDirection newMove = moves[i];
//            animal.move(newMove);
//
//            System.out.println(("Zwierze nr " + (i%numberOfAnimals + 1) + " wykonuje ruch: " + newMove));
//            System.out.println("Pozcja: " + animal.getPosition().toString());
//            System.out.println(this.map);

        int i=0;
        while (i < moves.length) {
            for (Map.Entry<Vector2d, Animal> set : sortedMap.entrySet()) {
                System.out.println(("Zwierze nr " + (i%numberOfAnimals + 1) + " wykonuje ruch: " + moves[i]));
                set.getValue().move(moves[i]);
                System.out.println(this.map);
                i++;

                //to niekoniecznie chyba musi byc tu
//                try {
//                    Thread.sleep(300);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//                System.out.println(map);
                if (i == moves.length) { break;}
            }
        }
    }
}
