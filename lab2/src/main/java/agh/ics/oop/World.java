package agh.ics.oop;

public class World {
    public static void main(String[] args){

       /* Direction[] directions = new Direction[args.length]; //creates empty array of given directions
        directions = convertStringsToEnums(args);   //assigns values converted from string array to our main enum array

        System.out.println("System wystartował");
        run(directions);
        System.out.println("System zakończył działanie");*/

        //code for lab2
        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(1,2);
        System.out.println(position2);
        System.out.println(position1.add(position2));
        System.out.println(position1.equals(position2));

        System.out.println(MapDirection.EAST.toString());
        System.out.println(MapDirection.WEST.next());
        System.out.println(MapDirection.NORTH.previous());
        System.out.println(MapDirection.SOUTH.toUnitVector());
    }

    //method that tells in what way the animal moves
    public static void run(Direction[] directions){
        //prints entered moves
        /*for(int i=0; i <= directions.length-1; i++){
            System.out.print(directions[i]);
            if(i!= directions.length -1){
                System.out.print(", ");
            }
        }*/

        System.out.println();
        System.out.println("Start");

       for (Direction direction: directions){
            String text = switch (direction){
                case FORWARD -> "Zwierzak idzie do przodu";
                case BACKWARD -> "Zwierzak idzie do tyłu";
                case LEFT -> "Zwierzak idzie w lewo";
                case RIGHT -> "Zwierzak idzie w prawo";
                default -> null;
            };

            if (text != null) {
                System.out.println(text);
            }
        }
        System.out.println("Stop");
    }

    //method that converts array of strings to array of enums of type Direction
    public static Direction[] convertStringsToEnums (String[] args) {
        int arrLength = args.length;
        Direction[] directions = new Direction[arrLength];
        for(int i =0; i<=arrLength-1; i++){
            switch (args[i]){
                case "f" -> directions[i] = Direction.FORWARD;
                case "b" -> directions[i] = Direction.BACKWARD;
                case "l" -> directions[i] = Direction.LEFT;
                case "r" -> directions[i] = Direction.RIGHT;
                default -> directions[i] = Direction.IGNORE;
            }
        }
        return directions;
    }

}
