package dad.lifesimulation.main.entities.element.harmful;

import java.util.List;

import dad.lifesimulation.main.entities.actor.Actor;
import dad.lifesimulation.main.entities.element.Floor;
import dad.lifesimulation.main.entities.element.Type;
import dad.lifesimulation.main.utils.Coordinates;
import dad.lifesimulation.main.utils.Dimension;

public class Spikes extends Floor {
	private final int DAMAGE = 5;

	public Spikes(Coordinates _coordinates, Dimension _dimension) {
		super(_coordinates, _dimension, Type.HARMFUL);
		// TODO Auto-generated constructor stub
	}

	public void update() {
		List<Actor> temporalList = map.getActorsIn(this);
		
		for (Actor actor : temporalList)
			actor.getStatistics().damageReceive(DAMAGE);
	}
}
