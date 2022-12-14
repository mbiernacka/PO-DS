package agh.ics.oop;

import javafx.scene.layout.GridPane;

import java.util.*;
import java.util.stream.Collectors;

public class SimulationEngine implements IEngine{

    private MoveDirection[] moves;
    private final AbstractWorldMap map;
    private final List<IAppObserver> observerList;
    private int moveDelay;


    public SimulationEngine(MoveDirection[] moves, AbstractWorldMap map, Vector2d[] animalsFirstPositions){
        this.moves = moves;
        this.map = map;
        this.observerList = new ArrayList<>();
        for (Vector2d vector: animalsFirstPositions){
            Animal animal = new Animal(this.map, vector);
            this.map.place(animal);
        }
    }

    public SimulationEngine(AbstractWorldMap map, Vector2d[] animalsFirstPositions){
        this.map = map;
        this.observerList = new ArrayList<>();
        for (Vector2d vector: animalsFirstPositions){
            Animal animal = new Animal(this.map, vector);
            this.map.place(animal);
        }
    }
    public void setDirections(MoveDirection[] moves) {
        this.moves = moves;
    }
    public void addObserver(IAppObserver observer){
        this.observerList.add(observer);
    }


    public void run(){
        System.out.println(this.map);
        int numberOfAnimals = this.map.getAnimalMap().size();

        LinkedHashMap<Vector2d, Animal> sortedMap = this.map.getAnimalMap().entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (prev, next) -> next, LinkedHashMap::new));

        int i=0;
        while (i < moves.length) {
            for (Map.Entry<Vector2d, Animal> set : sortedMap.entrySet()) {
                System.out.println(("Zwierze nr " + (i%numberOfAnimals + 1) + " wykonuje ruch: " + moves[i]));
                set.getValue().move(moves[i]);
                System.out.println(this.map);
                this.notifyObservers();
                i++;

                try {
                    Thread.sleep(moveDelay);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if (i == moves.length) { break;}
            }
        }
    }

    public void setDelay(int delay) {
        moveDelay = delay;
    }
    public void notifyObservers(){
        for (IAppObserver observer: this.observerList){
            observer.positionAppChanged();
        }
    }
}
