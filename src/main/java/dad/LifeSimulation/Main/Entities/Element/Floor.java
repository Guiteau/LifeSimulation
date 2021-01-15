package dad.LifeSimulation.Main.Entities.Element;

import dad.LifeSimulation.Main.Entities.Entity;
import dad.LifeSimulation.Main.Utils.Coordinates;
import dad.LifeSimulation.Main.Utils.Dimension;

public abstract class Floor extends Entity {
	protected Type type ;

	public Floor(Coordinates _coordinates, Dimension _dimension,Type _type) {
		super(_coordinates, _dimension, false);
		this.type=_type;
	
	}

}
