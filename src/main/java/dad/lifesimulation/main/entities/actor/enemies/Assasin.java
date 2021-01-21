package dad.lifesimulation.main.entities.actor.enemies;

import dad.lifesimulation.main.entities.actor.Actor;
import dad.lifesimulation.main.utils.Coordinates;
import dad.lifesimulation.main.utils.Dimension;
import dad.lifesimulation.main.utils.Statistics;

public class Assasin extends Actor {
	private boolean hostilToPlayers;

	public Assasin(Coordinates _coordinates, Dimension _dimension, Boolean _tangible, Statistics _statistics,
			Boolean hostilToOthers, Boolean _hostilToPlayers) {
		super(_coordinates, _dimension, _tangible, _statistics, hostilToOthers);
		this.hostilToPlayers = _hostilToPlayers;

	}

	public void update() {
		// TODO Auto-generated method stub
		
	}



}
