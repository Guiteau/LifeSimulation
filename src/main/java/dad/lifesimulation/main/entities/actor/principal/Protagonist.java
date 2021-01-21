package dad.lifesimulation.main.entities.actor.principal;

import dad.lifesimulation.main.entities.actor.Actor;
import dad.lifesimulation.main.utils.Coordinates;
import dad.lifesimulation.main.utils.Dimension;
import dad.lifesimulation.main.utils.Statistics;

public class Protagonist extends Actor {

	protected Boolean hostilToEnemies;

	public Protagonist(Coordinates _coordinates, Dimension _dimension, Boolean _tangible, Statistics _statistics,
			Boolean hostilToOthers, Boolean _hostilToEnemies) {
		super(_coordinates, _dimension, _tangible, _statistics, hostilToOthers);
		this.hostilToEnemies = _hostilToEnemies;

	}

//a rellenar
	
	public void update() {
		// TODO Auto-generated method stub

	}

}
