package dad.lifesimulation.main.entities;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import dad.lifesimulation.main.entities.actor.Actor;
import dad.lifesimulation.main.utils.Coordinates;
import dad.lifesimulation.main.utils.Dimension;
import dad.lifesimulation.main.world.maps.Map;

public abstract class Entity {

	protected Coordinates coordinates;
	protected Dimension dimension;
	protected Boolean tangible;
	protected Boolean drawable;
	protected Boolean debugging;
	protected EntityFinalType entityType;
	protected Map map;
	protected PropertyChangeSupport support;
	protected Boolean deletable;
	protected Boolean traspasable;

	public abstract void update();

	public Entity(Coordinates _coordinates, Dimension _dimension, Boolean _tangible) {
		this.coordinates = _coordinates;
		this.dimension = _dimension;
		this.tangible = _tangible;
		this.map = null;
		this.entityType = EntityFinalType.UNKNOWN;
		this.drawable = false;
		this.debugging = false;
		this.support = new PropertyChangeSupport(this);
		this.deletable = false;
		this.traspasable = true;
	}
	
	public abstract void interact(Entity entity);
	
	public abstract void interact(Actor actor);
	
	public void setDeletable(boolean deletable)
	{
		this.deletable = deletable; 
	}

	/**
	 * recibe un objeto tipo entidad o un hijo de esta , para comprobar si la
	 * entidad principal esta colisionando con la recibida, mediante un algoritmo de
	 * deteccion de colisiones 2d
	 * 
	 * @param _entidad un objeto de tipo entidad
	 * @return True (si colisionan) , False (si no colisionan)
	 */
	public boolean colliding(Entity _entidad) {
		return 	_entidad.tangible
				& this.coordinates.getX() < _entidad.coordinates.getX() + _entidad.dimension.getWidth()
				& _entidad.coordinates.getX() < this.coordinates.getX() + this.dimension.getWidth()
				& this.coordinates.getY() < _entidad.coordinates.getY() + _entidad.dimension.getHeight()
				& _entidad.coordinates.getY() < this.coordinates.getY() + this.dimension.getHeight();

	}
	
	public boolean overIt(Entity _entidad)
	{
		return _entidad.traspasable
				& this.coordinates.getX() < _entidad.coordinates.getX() + _entidad.dimension.getWidth()
				& _entidad.coordinates.getX() < this.coordinates.getX() + this.dimension.getWidth()
				& this.coordinates.getY() < _entidad.coordinates.getY() + _entidad.dimension.getHeight()
				& _entidad.coordinates.getY() < this.coordinates.getY() + this.dimension.getHeight();
	}

	/**
	 * @return coordinates current Coordinates (X, Y)
	 */

	public Coordinates getCoordinates() {
		return coordinates;
	}

	/**
	 * 
	 * @param coordinates Coordinates to set (Object type) 
	 */
	public void setCoordinates(Coordinates _coordinates) {
		
		Coordinates oldCoordinates = this.coordinates;
		this.coordinates = _coordinates;
		support.firePropertyChange("coordinates", oldCoordinates, _coordinates);

	}

	/**
	 * @return dimension (Object type Dimension) las dimensiones de esta entidad
	 */

	public Dimension getDimension() {
		return dimension;
	}

	/**
	 * 
	 * @param dimension Dimension to set (Object type)
	 */
	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
	}

	/**
	 * 
	 * @return true if the Entity can be touchable by others false if not 
	 */

	public Boolean getTangible() {
		return tangible;
	}

	/**
	 * 
	 * @param tangible tangible to set (true or false)
	 */
	
	public void setTangible(Boolean tangible) {
		this.tangible = tangible;
	}
	
	/**
	 * 
	 * @param drawable drawable to set (true or false)
	 */

	public void setDrawable(Boolean drawable) {
		this.drawable = drawable;
	}

	/**
	 * 
	 * @return true entity can be drawable false if not
	 */
	
	public boolean isDrawable() {
		return this.drawable;
	}
	
	/**
	 * 
	 * @return entity type (CELL, SPIKE, WALL, FOOD or UNKNOWN) 
	 */

	public EntityFinalType getEntityType() {
		return this.entityType;
	}
	
	/**
	 * 
	 * @param map map to set (Object)
	 */

	public void setMap(Map map) {
		this.map = map;
	}
	
	/**
	 * 
	 * @return true if entity is being debugging false if not
	 */

	public boolean isDebugging() {
		return debugging;
	}
	
	/**
	 * 
	 * @return 
	 */
	
	public boolean isDeletable()
	{
		return deletable;
	}

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		support.addPropertyChangeListener(listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		support.removePropertyChangeListener(listener);
	}
		
	public boolean isTraspasable()
	{
		return traspasable;
	}
}
