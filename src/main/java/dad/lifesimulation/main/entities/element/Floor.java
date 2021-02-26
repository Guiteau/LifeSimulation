package dad.lifesimulation.main.entities.element;

import dad.lifesimulation.main.entities.Entity;
import dad.lifesimulation.main.utils.Coordinates;
import dad.lifesimulation.main.utils.Dimension;

public abstract class Floor extends Entity {
	protected FloorType type ;

	public Floor(Coordinates _coordinates, Dimension _dimension,FloorType _type) {
		super(_coordinates, _dimension, false);
		this.type=_type;
	
	}

}
