package dad.lifesimulation.main.entities.actor;

import dad.lifesimulation.main.entities.Entity;
import dad.lifesimulation.main.utils.Coordinates;
import dad.lifesimulation.main.utils.Dimension;

public class DetectionRange extends Entity{

	public DetectionRange(Coordinates _coordinates, Dimension _dimension) {
		super(_coordinates, _dimension, false);
		traspasable = true;
	}
	

	/**
	 * Updates the DetectionRange values
	 */
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Relation between the Entity (object type) and the DetectionRange (object type)
	 * 
	 * @param entity (Object) to interact with another Entity
	 */

	@Override
	public void interact(Entity entity) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Relation between the Actor (object type) and the DetectionRange (object type)
	 * 
	 * @param actor (Object) to interact with another Entity
	 */

	@Override
	public void interact(Actor actor) {
		// TODO Auto-generated method stub
		
	}

}
