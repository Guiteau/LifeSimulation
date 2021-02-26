package dad.lifesimulation.main.entities.element.neutral;

import dad.lifesimulation.main.entities.Entity;
import dad.lifesimulation.main.utils.Coordinates;
import dad.lifesimulation.main.utils.Dimension;

public class ImpenetrableWall extends Entity{

	public ImpenetrableWall(Coordinates _coordinates, Dimension _dimension, Boolean _tangible) {
		super(_coordinates, _dimension, true);
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
