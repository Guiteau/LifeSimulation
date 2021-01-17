package dad.LifeSimulation.Main.Entities.Actor.Principal;

import dad.LifeSimulation.Main.Entities.Actor.Actor;
import dad.LifeSimulation.Main.Utils.Coordinates;
import dad.LifeSimulation.Main.Utils.Dimension;
import dad.LifeSimulation.Main.Utils.Statistics;

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
