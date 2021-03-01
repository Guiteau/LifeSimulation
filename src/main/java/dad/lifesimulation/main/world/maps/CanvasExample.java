package dad.lifesimulation.main.world.maps;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class CanvasExample{

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Canvas canvasElement;
    
    /** 
     * Constructor.
     * @throws IOException if FXML file fails
     */

	public CanvasExample() throws IOException {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/canvasTest.fxml"));
		loader.setController(this);
		loader.load();
	}
	
	/**
	 * 
	 * @return the main view of the FXML
	 */

	public AnchorPane getView() {
		return anchorPane;
	}

	/**
	 * 
	 * @return the Canvas present in the FXML
	 */
	
	public Canvas getCanvasElement() {
		return canvasElement;
	}
}
