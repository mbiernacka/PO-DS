package agh.ics.oop;

public class World {
    public static void main(String[] args){

        /*MoveDirection[] directions; //creates empty array of given directions
        directions = convertStringsToEnums(args);   //assigns values converted from string array to our main enum array

        System.out.println("System wystartował");
        run(directions);
        System.out.println("System zakończył działanie");

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
        System.out.println(MapDirection.SOUTH.toUnitVector());*/

        //code for lab3
        Animal animal1 = new Animal();
        System.out.println(animal1.toString());
        animal1.move(MoveDirection.RIGHT);
        animal1.move(MoveDirection.FORWARD);
        animal1.move(MoveDirection.FORWARD);
        animal1.move(MoveDirection.FORWARD);
        System.out.println(animal1.toString());

        MoveDirection[] directions = OptionsParser.parse(args);
        for(int i = 0; i <= directions.length -1; i++){
            animal1.move(directions[i]);
        }
        System.out.println(animal1.toString());
    }

    //method that tells in what way the animal moves
    public static void run(MoveDirection[] directions){
        //prints entered moves
        /*for(int i=0; i <= directions.length-1; i++){
            System.out.print(directions[i]);
            if(i!= directions.length -1){
                System.out.print(", ");
            }
        }*/

        System.out.println();
        System.out.println("Start");

       for (MoveDirection direction: directions){
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
    public static MoveDirection[] convertStringsToEnums (String[] args) {
        int arrLength = args.length;
        MoveDirection[] directions = new MoveDirection[arrLength];
        for(int i =0; i<=arrLength-1; i++){
            switch (args[i]){
                case "f" -> directions[i] = MoveDirection.FORWARD;
                case "b" -> directions[i] = MoveDirection.BACKWARD;
                case "l" -> directions[i] = MoveDirection.LEFT;
                case "r" -> directions[i] = MoveDirection.RIGHT;
            }
        }
        return directions;
    }

}

/* Odp na pytanie w zad 10 (bardzo ogólnie)
 Może odpowiednim rozwiązaniem byłoby zaimplementowanie klasy Mapa, która miałaby oznaczone pola dostępne na niej.
 W momencie, gdy zwierzę pojawiałoby się na danym polu zmieniałby się jego status na zajęty.
 Wtedy kolejne zwierzę przed zmienieniem swojej pozycji na inną sprawdzałoby inną metodą czy dane miejsce jest już zajęte.
 */
