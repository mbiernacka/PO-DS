package agh.ics.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EngineTest {

    @Test //regular situation
    public void simulationTest1(){
        String[] args = {"f", "l", "r", "b", "f","f"};
        MoveDirection[] directions = OptionsParser.parse(args);
        AbstractWorldMap map = new RectangularMap(6, 5);
        Vector2d[] positions = { new Vector2d(1,2), new Vector2d(5,4) };
        SimulationEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        Vector2d[] goalPositions = {new Vector2d(2,3), new Vector2d(4,4)};
        MapDirection[] goalDirections = {MapDirection.EAST, MapDirection.WEST};

        for(int i = 0; i < map.getAnimalMap().size(); i++) {
            Animal animal = map.getAnimalMap().get(i);
            assertEquals(animal.getPosition(), goalPositions[i]);
            assertEquals(animal.getOrientation(), goalDirections[i]);
        }
    }

//    @Test //animal collision
//    public void simulationTest2(){
//        String[] args = {"r", "f", "f", "l", "r","f", "b", "b"};
//        MoveDirection[] directions = OptionsParser.parse(args);
//        AbstractWorldMap map = new RectangularMap(4, 6);
//        Vector2d[] positions = { new Vector2d(1,3), new Vector2d(2,2) };
//        SimulationEngine engine = new SimulationEngine(directions, map, positions);
//        engine.run();
//
//        Vector2d[] goalPositions = {new Vector2d(1,4), new Vector2d(3,3)};
//        MapDirection[] goalDirections = {MapDirection.SOUTH, MapDirection.WEST};
//
//        for(int i = 0; i < engine.animalList.size(); i++) {
//            Animal animal = engine.animalList.get(i);
//            assertEquals(animal.getPosition(), goalPositions[i]);
//            assertEquals(animal.getOrientation(), goalDirections[i]);
//        }
//    }

    @Test //animal cannot be placed on the map
    public void simulationTest3(){
        String[] args = {"l", "f","f", "f", "f"};
        MoveDirection[] directions = OptionsParser.parse(args);
        IWorldMap map = new RectangularMap(4, 6);
        Vector2d pos1 = new Vector2d(1,1);
        Vector2d pos2 = new Vector2d(1,1);
//        Vector2d[] positions = { new Vector2d(1,3), new Vector2d(1,3) };
//        SimulationEngine engine = new SimulationEngine(directions, map, positions);
//        engine.run();
//
//        Vector2d[] goalPositions = {new Vector2d(0,3)};
//        MapDirection[] goalDirections = {MapDirection.WEST};
//
//        for(int i = 0; i < engine.animalList.size(); i++) {
//            Animal animal = engine.animalList.get(i);
//            assertEquals(animal.getPosition(), goalPositions[i]);
//            assertEquals(animal.getOrientation(), goalDirections[i]);
            map.place(new Animal(map, pos1));
        Exception ex = assertThrows(IllegalArgumentException.class, () -> map.place(new Animal(map, pos2)));
        assertTrue(ex.getMessage().contains("You cannot move"));

    }

}
