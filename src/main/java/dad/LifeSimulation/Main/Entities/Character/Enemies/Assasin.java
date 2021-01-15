package dad.LifeSimulation.Main.Entities.Character.Enemies;

import dad.LifeSimulation.Main.Entities.Character.Character;
import dad.LifeSimulation.Main.Utils.Coordinates;
import dad.LifeSimulation.Main.Utils.Dimension;
import dad.LifeSimulation.Main.Utils.Statistics;

public class Assasin extends Character {
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
