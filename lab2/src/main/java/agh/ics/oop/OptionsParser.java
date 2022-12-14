package agh.ics.oop;

import java.util.stream.Stream;

public class OptionsParser {

    // why does this not work? :(

    /*public static MoveDirection[] parse(String[] args){
        //calculate how many elements of str tab are correct commands
        int arrLength = args.length;
        int size = 0;
        for (int i=0; i < arrLength-1; i++){
            args[i] = args[i].toLowerCase();
            if(args[i].equals("f") | args[i].equals("b") | args[i].equals("r") | args[i].equals("l")){
                size++;
            } else if(args[i].equals("forward") | args[i].equals("backward") | args[i].equals("right") | args[i].equals("left")){
                size++;
            }
        }

        //array in which we store correct enum commands
        MoveDirection[] moves = new MoveDirection[size];

        //converts array of strings to array of enums of type MoveDirection
        for (int i=0; i <= arrLength-1; i++){
            args[i] = args[i].toLowerCase();
            switch (args[i].toLowerCase()){
                case "f", "forward" -> moves[i] = MoveDirection.FORWARD;
                case "b", "backward" -> moves[i] = MoveDirection.BACKWARD;
                case "r", "right" -> moves[i] = MoveDirection.RIGHT;
                case "l", "left" -> moves[i] = MoveDirection.LEFT;
                default -> {continue;}
            };
        }
        return moves;
    }*/

    ///////////////////////////////
    // but this works?
    public static MoveDirection[] parse(String[] directions) throws IllegalArgumentException{

        //calculate how many elements of str tab are correct commands
        int size = 0;
        for (String direction: directions){
            direction = direction.toLowerCase();
            if(direction.equals("f") | direction.equals("b") | direction.equals("r") | direction.equals("l")){
                size++;
            } else if (direction.equals("forward") | direction.equals("backward") | direction.equals("right") | direction.equals("left")){
                size++;
            } else {
                throw new IllegalArgumentException(direction + " is not legal move specification");
            }
        }

        //array in which we store correct enum commands
        MoveDirection[] moves = new MoveDirection[size];
        int i =0;
        //converts array of strings to array of enums of type MoveDirection
        for (String direction: directions){
            MoveDirection move;
            switch (direction.toLowerCase()){
                case "f", "forward" -> move = MoveDirection.FORWARD;
                case "b", "backward" -> move = MoveDirection.BACKWARD;
                case "r", "right" -> move = MoveDirection.RIGHT;
                case "l", "left" -> move = MoveDirection.LEFT;
                default -> {continue;}
            };
            moves[i] = move;
            i++;
        }
        return moves;


        /*
        //STREAMY - NAUCZY?? SI??

        return Stream.of(directions).map(instruction -> switch (instruction.toLowerCase()) {
            case "f", "forward" -> MoveDirection.FORWARD;
            case "b", "backward" ->  MoveDirection.BACKWARD;
            case "r", "right" ->   MoveDirection.RIGHT;
            case "l", "left" -> MoveDirection.LEFT;
            default -> null;
        }).filter(moveDirection -> moveDirection != null).toArray(MoveDirection[]::new);
         */

    }
}
