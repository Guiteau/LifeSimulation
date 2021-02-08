package dad.lifesimulation.main.entities.actor;

import dad.lifesimulation.main.entities.Entity;
import dad.lifesimulation.main.utils.Coordinates;
import dad.lifesimulation.main.utils.Dimension;
import dad.lifesimulation.main.utils.Statistics;

public abstract class Actor extends Entity {
	
	protected Statistics statistics;
	
	protected Orientation orientation;
	
	protected Boolean hostilToOthers;

	public Actor(Coordinates _coordinates, Dimension _dimension,  Statistics _statistics,
			Boolean hostilToOthers, Orientation _orientation) {
		super(_coordinates, _dimension, false);
		this.statistics = _statistics;
		this.hostilToOthers = hostilToOthers;
		this.drawable = true;
		this.orientation = _orientation;
	}

	/**
	 * 
	 * @return objeto de tipo estadísticas de la entidad Actor(contiene atributos con valores enteros)
	 */
	
	public Statistics getStatistics() {
		return statistics;
	}
	/**
	 * 
	 * */
	
	protected void randomMove() {
		
	}

	public Orientation getOrientation() {
		return orientation;
	}

	
	

}
