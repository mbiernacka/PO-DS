package agh.ics.oop;

public class Grass implements IMapElement{

    private final Vector2d position;

    public Grass(Vector2d position) {
        this.position = position;
    }

    public Vector2d getPosition(){
        return this.position;
    }

    public String getTexture(){
        return "src/main/resources/grass.png";
    }

    @Override
    public String toString(){
        return "*";
    }

    public String getLabel(){
        return "Grass";
    }
}
