package dad.LifeSimulation.Main.Entities.Character;

import dad.LifeSimulation.Main.Entities.Entity;
import dad.LifeSimulation.Main.Utils.Coordinates;
import dad.LifeSimulation.Main.Utils.Dimension;
import dad.LifeSimulation.Main.Utils.Statistics;

public abstract class Character extends Entity {
	protected Statistics statistics;
	protected Boolean hostilToOthers;

	public Character(Coordinates _coordinates, Dimension _dimension, Boolean _tangible, Statistics _statistics,
			Boolean hostilToOthers) {
		super(_coordinates, _dimension, _tangible);
		this.statistics = _statistics;
		this.hostilToOthers = hostilToOthers;
	}

}
