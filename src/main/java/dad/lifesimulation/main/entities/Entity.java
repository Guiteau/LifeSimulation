package dad.lifesimulation.main.entities;

import dad.lifesimulation.main.utils.Coordinates;
import dad.lifesimulation.main.utils.Dimension;
import dad.lifesimulation.main.utils.GameFunctions;
import dad.lifesimulation.main.world.maps.Map;

public abstract class Entity implements GameFunctions{

	protected Coordinates coordinates;
	protected Dimension dimension;
	protected Boolean tangible;
	protected Map map;

	public Entity(Coordinates _coordinates, Dimension _dimension, Boolean _tangible) {
		this.coordinates = _coordinates;
		this.dimension = _dimension;
		this.tangible = _tangible;
		this.map=null;

	}
	
	//DIEGO

	public boolean colliding(Entity _entidad) {
		return 
		 this.coordinates.getX() < _entidad.coordinates.getX() + _entidad.dimension.getWidth() & 
		 _entidad.coordinates.getX() < this.coordinates.getX() + this.dimension.getWidth()&
		 this.coordinates.getY()<_entidad.coordinates.getY()+_entidad.dimension.getHeight()&
		 _entidad.coordinates.getY()<this.coordinates.getY()+this.dimension.getHeight();

	} // pensarlo bien

	public Coordinates getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}

	public Dimension getDimension() {
		return dimension;
	}

	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
	}

	public Boolean getTangible() {
		return tangible;
	}

	public void setTangible(Boolean tangible) {
		this.tangible = tangible;
	}

}
