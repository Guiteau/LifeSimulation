package dad.lifesimulation.main.graphics.customcomponents;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;

public class MapCanvasController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Pane root;

    @FXML
    private Canvas canvas;
    
    /**
     * Initializes the FXML maptest and asserts the Pane and the Canvas
     */

    @FXML
    void initialize() {
        assert root != null : "fx:id=\"root\" was not injected: check your FXML file 'maptest.fxml'.";
        assert canvas != null : "fx:id=\"canvas\" was not injected: check your FXML file 'maptest.fxml'.";

    }
}
