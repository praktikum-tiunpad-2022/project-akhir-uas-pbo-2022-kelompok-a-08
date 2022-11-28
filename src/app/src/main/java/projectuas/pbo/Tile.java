package projectuas.pbo;

import javafx.scene.shape.Rectangle;

public class Tile extends Rectangle {
    private String value;

    Tile() {
        this.value="";
    }

    Tile(String val, double width, double height) {
        super(width, height);
        this.value=val;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
