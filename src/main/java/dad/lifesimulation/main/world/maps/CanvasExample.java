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

	public CanvasExample() throws IOException {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/canvasTest.fxml"));
		loader.setController(this);
		loader.load();
		
		GraphicsContext gc = canvasElement.getGraphicsContext2D();
		gc.setFill(Color.BLACK);
		gc.setStroke(Color.GREEN);
		gc.rect(200, 100, 100, 50);
		
	/*	Rectangle rectangle = new Rectangle(100, 100, 300, 150);
		rectangle.setFill(Color.BLUE);*/
		
		
		
     	gc.fillRect(200, 100, 100, 50);
		
	//	Rectangle rectangle = new Rectangle();
		
		
		
	}

	public AnchorPane getView() {
		return anchorPane;
	}

	public Canvas getCanvasElement() {
		return canvasElement;
	}
    
    
	
}
