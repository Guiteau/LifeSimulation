package dad.lifesimulation.main.entities.actor;

import dad.lifesimulation.main.utils.Coordinates;
import dad.lifesimulation.main.utils.Dimension;
import dad.lifesimulation.main.utils.Statistics;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class JohnDoe extends Actor {

	public JohnDoe(Coordinates _coordinates, Dimension _dimension, Statistics _statistics,
			Boolean hostilToOthers) {
		super(_coordinates, _dimension, _statistics, hostilToOthers, Orientation.SOUTH);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		randomMove();
	}

	

	@Override
	public String toString() {
		return "JohnDoe [coordinates=" + coordinates + "]";
	}
}
