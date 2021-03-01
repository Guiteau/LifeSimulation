package dad.lifesimulation.main.entities.element.harmful;

import java.util.List;

import dad.lifesimulation.main.entities.Entity;
import dad.lifesimulation.main.entities.EntityFinalType;
import dad.lifesimulation.main.entities.actor.Actor;
import dad.lifesimulation.main.entities.element.Floor;
import dad.lifesimulation.main.entities.element.FloorType;
import dad.lifesimulation.main.utils.Coordinates;
import dad.lifesimulation.main.utils.Dimension;

public class Spikes extends Floor {
	private final int DAMAGE = 5;
	
	/**
	 * Constructor.
	 * @param _coordinates
	 * @param _dimension
	 */

	public Spikes(Coordinates _coordinates, Dimension _dimension) {
		super(_coordinates, _dimension, FloorType.HARMFUL);
		// TODO Auto-generated constructor stub
		drawable = true;
		entityType = EntityFinalType.SPIKE;
	}

	/**
	 * A list of actor entities that are colliding with the Spikes object is loaded and the damage (5) is applied.
	 */

	public void update() {
		List<Actor> temporalList = map.getActorsIn(this);

		for (Actor actor : temporalList)
			actor.getStatistics().damageReceive(DAMAGE);
	}

	/**
	 * 
	 * @param entity (Object) to interact with the spikes entity
	 */
	
	@Override
	public void interact(Entity entity) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * 
	 * @param actor (Object) to interact with the spikes entity
	 */

	@Override
	public void interact(Actor actor) {
		System.out.println("Estoy pinchando");
		actor.getStatistics().damageReceive(DAMAGE);

	}
}
