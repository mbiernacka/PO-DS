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

import java.io.FileNotFoundException;

public class App extends Application {

    private AbstractWorldMap map;
    private final int CONSTRAINTS = 55;
    private final int SQUARESIZE = 50;
    private final int GRIDSIZE = 800;


    public void start(Stage primaryStage) throws FileNotFoundException {
        GridPane gridPane = new GridPane();
        gridPane.setGridLinesVisible(true);
        Vector2d lowerBound = map.calculateLowerBound();
        Vector2d upperBound = map.calculateUpperBound();

        drawXLabel(lowerBound, upperBound, gridPane);
        drawYLabel(lowerBound, upperBound, gridPane);
        drawXYLabel(gridPane);
        drawObjects(lowerBound, upperBound, gridPane);


        Scene scene = new Scene(gridPane, GRIDSIZE, GRIDSIZE);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

        // y label
    public void drawYLabel(Vector2d lowerBound, Vector2d upperBound, GridPane gridPane) {
        int m = 1;
        for (int y = upperBound.y; y >= lowerBound.y; y--) {
            gridPane.getRowConstraints().add(new RowConstraints(CONSTRAINTS));
            Label label = new Label(Integer.toString(y));
            label.setMinHeight(SQUARESIZE);
            label.setMinWidth(SQUARESIZE);
            label.setAlignment(Pos.CENTER);
            gridPane.add(label, 0, m, 1, 1);
            GridPane.setHalignment(label, HPos.CENTER);
            m++;
        }
    }

        // x label
        public void drawXLabel(Vector2d lowerBound, Vector2d upperBound, GridPane gridPane) {
            int n = 1;
            for (int x = lowerBound.x; x <= upperBound.x; x++) {
                gridPane.getColumnConstraints().add(new ColumnConstraints(CONSTRAINTS));
                Label label = new Label(Integer.toString(x));
                label.setMinHeight(SQUARESIZE);
                label.setMinWidth(SQUARESIZE);
                label.setAlignment(Pos.CENTER);
                gridPane.add(label, n, 0, 1, 1);
                GridPane.setHalignment(label, HPos.CENTER);
                n++;
            }
        }

        //add "x/y"
        public void drawXYLabel( GridPane gridPane) {

            Label labelXY = new Label("y/x");
            gridPane.add(labelXY, 0, 0);
            GridPane.setHalignment(labelXY, HPos.CENTER);
        }

        //add objects
        public void drawObjects(Vector2d lowerBound, Vector2d upperBound, GridPane gridPane) throws FileNotFoundException {
            int w = 1;
            for (int i = upperBound.y; i >= lowerBound.y; i--) {
                int p = 1;
                for (int j = lowerBound.x; j <= upperBound.x; j++) {
                    if (this.map.isOccupied(new Vector2d(j, i))) {
                        IMapElement object = (IMapElement) this.map.objectAt(new Vector2d(j, i));
                        if (object != null) {
                            GUIElementBox element = new GUIElementBox(object);
                            gridPane.add(element.vBox, p, w);
                            GridPane.setHalignment(element.vBox, HPos.CENTER);
                            GridPane.setHalignment(element.vBox, HPos.CENTER);
                        }

                    }
                    p++;
                }
                w++;
            }
        }



    public void init(){
        this.map = new GrassField(10);
        String[] args = getParameters().getRaw().toArray(new String[0]);
        MoveDirection[] directions = new OptionsParser().parse(args);
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4), new Vector2d(5,7)};
        SimulationEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
    }
}