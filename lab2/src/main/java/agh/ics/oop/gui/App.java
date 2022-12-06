package agh.ics.oop.gui;
import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class App extends Application {

    private AbstractWorldMap map;

    public void start(Stage primaryStage){
        GridPane gridPane = new GridPane();
        gridPane.setGridLinesVisible(true);
        Vector2d lowerBound = map.calculateLowerBound();
        Vector2d upperBound = map.calculateUpperBound();
        int m = 1;
        int n = 1;
        final int squareSize = 20;

        // y label
        for(int y = upperBound.y; y >= lowerBound.y; y--){
            gridPane.getRowConstraints().add(new RowConstraints(20));
            Label label = new Label(Integer.toString(y));
            label.setMinHeight(squareSize);
            label.setMinWidth(squareSize);
            label.setAlignment(Pos.CENTER);
            gridPane.add(label, 0, m, 1, 1);
            GridPane.setHalignment(label, HPos.CENTER);
            m++;
        }

        // x label
        for(int x = lowerBound.x; x <= upperBound.x; x++){
            gridPane.getColumnConstraints().add(new ColumnConstraints(20));
            Label label = new Label(Integer.toString(x));
            label.setMinHeight(squareSize);
            label.setMinWidth(squareSize);
            label.setAlignment(Pos.CENTER);
            gridPane.add(label, n, 0, 1, 1);
            GridPane.setHalignment(label, HPos.CENTER);
            n++;
        }

        //add "x/y"
        Label labelXY = new Label("y/x");
        gridPane.add(labelXY, 0,0);
        GridPane.setHalignment(labelXY, HPos.CENTER);


        //add objects
        int w =1;
        for(int i = upperBound.y; i >= lowerBound.y; i--){
            int p =1;
            for (int j = lowerBound.x; j <= upperBound.x; j++){
                Label labelObject = new Label(drawObject(new Vector2d(j, i)));
                gridPane.add(labelObject,p,w);
                GridPane.setHalignment(labelObject, HPos.CENTER);
                GridPane.setHalignment(labelObject, HPos.CENTER);
                p++;
            }
            w++;
        }

        Scene scene = new Scene(gridPane, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    //draw objects
    private String drawObject(Vector2d currentPosition) {
        String result = null;
        if (this.map.isOccupied(currentPosition)) {
            Object object = this.map.objectAt(currentPosition);
            if (object != null) {
                result = object.toString();
            }
                return result;
            }
            return null;
        }

    public void init(){
        this.map = new GrassField(10);
        String[] args = getParameters().getRaw().toArray(new String[0]);
        MoveDirection[] directions = new OptionsParser().parse(args);
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
        SimulationEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
    }
}




