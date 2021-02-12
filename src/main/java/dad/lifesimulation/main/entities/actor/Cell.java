package dad.lifesimulation.main.entities.actor;

import dad.lifesimulation.main.utils.Coordinates;
import dad.lifesimulation.main.utils.Dimension;
import dad.lifesimulation.main.utils.Statistics;
import javafx.scene.paint.Color;

public class Cell extends Actor{

	public Cell(Coordinates _coordinates, Dimension _dimension, Statistics _statistics, Boolean hostilToOthers,
			Orientation _orientation, Color color) {
		super(_coordinates, _dimension, _statistics, hostilToOthers, _orientation);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		
	}

}
