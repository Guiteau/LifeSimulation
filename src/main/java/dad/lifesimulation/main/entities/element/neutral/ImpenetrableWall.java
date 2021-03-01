package dad.lifesimulation.main.entities.element.neutral;

import dad.lifesimulation.main.entities.Entity;
import dad.lifesimulation.main.entities.EntityFinalType;
import dad.lifesimulation.main.entities.actor.Actor;
import dad.lifesimulation.main.utils.Coordinates;
import dad.lifesimulation.main.utils.Dimension;

public class ImpenetrableWall extends Entity{

	public ImpenetrableWall(Coordinates _coordinates, Dimension _dimension) {
		super(_coordinates, _dimension, true);
		entityType = EntityFinalType.WALL;
		drawable = true;
		traspasable = false;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void interact(Entity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void interact(Actor actor) {
		// TODO Auto-generated method stub
		
	}

}
