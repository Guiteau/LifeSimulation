package dad.lifesimulation.main.graphics.customcomponents;

import dad.lifesimulation.main.entities.actor.CellAdapter;
import dad.lifesimulation.main.entities.actor.JohnDoe;
import dad.lifesimulation.main.graphics.customcomponents.component.StatisticComponent;
import dad.lifesimulation.main.utils.InitGameComponents;
import dad.lifesimulation.main.world.maps.CanvasExample;
import dad.lifesimulation.main.world.maps.Map;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

	private CanvasExample controller;

	@Override
	public void start(Stage primaryStage) throws Exception {
		new StatisticComponent();

		controller = new CanvasExample();

		InitGameComponents level_creator = new InitGameComponents((int) controller.getCanvasElement().getWidth(),
				(int) controller.getCanvasElement().getHeight());

		Map map = level_creator.createMap(100);
		
		CellAdapter ca = new CellAdapter();
		JohnDoe jd = level_creator.randomJohnDoe();
		
		ca.loadCell(jd);
		
		map.insertEntity(jd);

		
		map.drawElements(controller.getCanvasElement().getGraphicsContext2D());

		Scene escena = new Scene(controller.getView());

		primaryStage.setScene(escena);
		primaryStage.setTitle("Canvas Ejemplo\t");
		primaryStage.show();
		
		
		while(true)
		{
			jd.move();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}
