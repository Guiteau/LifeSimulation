package dad.lifesimulation.main.entities.actor;

import dad.lifesimulation.main.utils.Coordinates;
import dad.lifesimulation.main.utils.Dimension;
import dad.lifesimulation.main.utils.Statistics;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class JohnDoe extends Actor {

	public JohnDoe(Coordinates _coordinates, Dimension _dimension, Statistics _statistics,
			Boolean hostilToOthers) {
		super(_coordinates, _dimension, true, _statistics, hostilToOthers);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		
	}

	@Override
	public void render(GraphicsContext gc) {
		gc.setFill(Color.LIGHTBLUE);
		gc.setStroke(Color.BLACK);

		gc.fillRect(coordinates.getX(), coordinates.getY(), dimension.getWidth(), dimension.getHeight());
	}

	@Override
	public String toString() {
		return "JohnDoe [coordinates=" + coordinates + "]";
	}

}
