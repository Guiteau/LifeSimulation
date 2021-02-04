package dad.lifesimulation.main.entities.actor.cell;

import dad.lifesimulation.main.entities.actor.Actor;
import dad.lifesimulation.main.entities.actor.Orientation;
import dad.lifesimulation.main.utils.Coordinates;
import dad.lifesimulation.main.utils.DetectionRange;
import dad.lifesimulation.main.utils.Dimension;
import dad.lifesimulation.main.utils.Statistics;

public class Agressive extends Actor {
	public Agressive(Coordinates _coordinates, Dimension _dimension, Statistics _statistics 
			 ) {
		super(_coordinates, _dimension, true, _statistics,Orientation.SOUTH);

	}

	public void update() {
	
		
	}
	

	

}
