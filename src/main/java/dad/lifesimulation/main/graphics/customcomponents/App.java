package dad.lifesimulation.main.graphics.customcomponents;

import dad.lifesimulation.main.world.maps.CanvasExample;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application{
	
	private CanvasExample controller;

	@Override
	public void start(Stage primaryStage) throws Exception {
		new StatisticComponent();
		
		controller = new CanvasExample();
		
		Scene escena = new Scene(controller.getView());

		primaryStage.setScene(escena);
		primaryStage.setTitle("Canvas Ejemplo\t");
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);		
	}

}
