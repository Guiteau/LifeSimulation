package dad.lifesimulation.main.entities.element.helpful;

import java.util.List;

import dad.lifesimulation.main.entities.actor.Actor;
import dad.lifesimulation.main.entities.element.Floor;
import dad.lifesimulation.main.entities.element.Type;
import dad.lifesimulation.main.utils.Coordinates;
import dad.lifesimulation.main.utils.Dimension;

public class MagicFood extends Floor {
	private final int HEALTH_BONUS = 5;
	private final int ENERGY_BONUS = 5;
	private final int ARMOR_BONUS = 5;

	public MagicFood(Coordinates _coordinates, Dimension _dimension) {
		super(_coordinates, _dimension, Type.HELPFUL);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {

		List<Actor> temporalList = map.getActorsIn(this);

		for (Actor actor : temporalList) {
			actor.getStatistics().healthReceive(HEALTH_BONUS);
			actor.getStatistics().armorReceive(ARMOR_BONUS);
			actor.getStatistics().energyReceive(ENERGY_BONUS);

		}

	}
}
