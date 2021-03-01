package dad.lifesimulation.main.entities.element.helpful;

import dad.lifesimulation.main.entities.Entity;
import dad.lifesimulation.main.entities.EntityFinalType;
import dad.lifesimulation.main.entities.actor.Actor;
import dad.lifesimulation.main.entities.element.Floor;
import dad.lifesimulation.main.entities.element.FloorType;
import dad.lifesimulation.main.utils.Coordinates;
import dad.lifesimulation.main.utils.Dimension;

public class MagicFood extends Floor {
	private final int HEALTH_BONUS = 5;
	private final int ENERGY_BONUS = 5;
	private final int ARMOR_BONUS = 5;
	
	/**
	 * Constructor.
	 * @param _coordinates
	 * @param _dimension
	 */

	public MagicFood(Coordinates _coordinates, Dimension _dimension) {
		super(_coordinates, _dimension, FloorType.HELPFUL);
		entityType=EntityFinalType.FOOD;
		tangible = true;
		traspasable = true;
	}

	/**
	 * Updates the MagicFood values
	 */
	
	@Override
	public void update() {
	}
	
	/**
	 * 
	 * @param entity (Object) to interact with the MagicFood entity
	 */

	@Override
	public void interact(Entity entity) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * 
	 * @param actor (Object) to update their statistics (health, armor and energy)
	 */


	@Override
	public void interact(Actor actor) {
		System.out.println("Me están comiendo");
		actor.getStatistics().healthReceive(HEALTH_BONUS);
		actor.getStatistics().armorReceive(ARMOR_BONUS);
		actor.getStatistics().energyReceive(ENERGY_BONUS);
		deletable = true;
	}
	
}
