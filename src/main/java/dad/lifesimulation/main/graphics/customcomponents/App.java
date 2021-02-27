package dad.lifesimulation.main.graphics.customcomponents;

import dad.lifesimulation.main.draw.DrawableFactory;
import dad.lifesimulation.main.entities.EntityFinalType;
import dad.lifesimulation.main.utils.GUIGame;
import dad.lifesimulation.main.utils.InitGameComponents;
import dad.lifesimulation.main.world.maps.CanvasExample;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class App extends Application {

	private PrincipalComponent controller;
	private GUIGame guigame;
	private InitGameComponents processingGame;

	@Override
	public void start(Stage primaryStage) throws Exception {

		controller = new PrincipalComponent();
		
		DrawableFactory levelGUI_creator = new DrawableFactory();
		
		levelGUI_creator.loadGraphicsContext(controller.getCanvasElement().getGraphicsContext2D());
		
		levelGUI_creator.setColor(EntityFinalType.CELL, Color.AQUA);
		levelGUI_creator.setColor(EntityFinalType.SPIKE, Color.GRAY);
		levelGUI_creator.setColor(EntityFinalType.WALL, Color.FUCHSIA);
		levelGUI_creator.setColor(EntityFinalType.FOOD, Color.RED);
		levelGUI_creator.setColor(EntityFinalType.UNKNOWN, Color.YELLOW);
		
		levelGUI_creator.createRandomLevel();
		
		processingGame = levelGUI_creator.getInitGameComponents();
		guigame = new GUIGame(levelGUI_creator);
		
		controller.setGame(processingGame);
		controller.setGUIGame(guigame);
		controller.setFactory(levelGUI_creator);
		
		//Thread thread_drawer = new Thread(guigame, "thread_drawer");
		
		guigame.start();
		
		Thread thread_thinker = new Thread(processingGame, "thread_thinker");
		
		thread_thinker.start();
		
		
		Scene escena = new Scene(controller.getView());
		primaryStage.setScene(escena);
		primaryStage.setTitle("Canvas Ejemplo\t");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void stop()
	{
		if (processingGame.isPaused())
			processingGame.toPause(false);
		
		processingGame.toExit(true);
	}

}
