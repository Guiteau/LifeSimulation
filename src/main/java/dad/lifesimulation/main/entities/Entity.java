package dad.lifesimulation.main.entities;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;

import dad.lifesimulation.main.entities.actor.Actor;
import dad.lifesimulation.main.utils.Coordinates;
import dad.lifesimulation.main.utils.Dimension;
import dad.lifesimulation.main.world.maps.Map;

public abstract class Entity  implements Serializable{

	protected Coordinates coordinates;
	protected Dimension dimension;
	@Override
	public String toString() {
		return "Entity [coordinates=" + coordinates + ", dimension=" + dimension + ", tangible=" + tangible
				+ ", drawable=" + drawable + ", debugging=" + debugging + ", entityType=" + entityType + ", support="
				+ support + ", deletable=" + deletable + ", traspasable=" + traspasable + "]";
	}

	protected Boolean tangible;
	protected Boolean drawable;
	protected Boolean debugging;
	protected EntityFinalType entityType;
	protected Map map;
	protected PropertyChangeSupport support;
	protected Boolean deletable;
	protected Boolean traspasable;
	
	/**
	 * Updates the Entity values
	 */

	public abstract void update();
	
	/**
	 * Constructor. 
	 * @param _coordinates
	 * @param _dimension
	 * @param _tangible
	 */

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
	
	/**
	 * Relation between a Entity (object type) and the Entity (object type)
	 * 
	 * @param entity (Object) to interact with another Entity
	 */
	
	public abstract void interact(Entity entity);
	
	/**
	 * Relation between the Actor (object type) and the Entity (object type)
	 * 
	 * @param actor (Object) to interact with another Entity
	 */
	
	public abstract void interact(Actor actor);
	
	/**
	 * 
	 * @param deletable true for Entity be erasable, false if not
	 */
	
	public void setDeletable(boolean deletable)
	{
		this.deletable = deletable; 
	}

	/**
	 * Checks if the main Entity is colliding with it applying a 2D colliding algorythm
	 * 
	 * @param _entidad Entity (object type) 
	 * @return true if collide, false if not
	 */
	
	public boolean colliding(Entity _entidad) {
		return 	_entidad.tangible
				& this.coordinates.getX() < _entidad.coordinates.getX() + _entidad.dimension.getWidth()
				& _entidad.coordinates.getX() < this.coordinates.getX() + this.dimension.getWidth()
				& this.coordinates.getY() < _entidad.coordinates.getY() + _entidad.dimension.getHeight()
				& _entidad.coordinates.getY() < this.coordinates.getY() + this.dimension.getHeight();

	}
	
	/**
	 *  Checks all the entities colliding with it applying a 2D colliding algorythm
	 *  
	 * @param _entidad Entity (object type) 
	 * @return true if collide, false if not
	 */

	public boolean collidingAll(Entity _entidad)
	{
		return 	
				this.coordinates.getX() < _entidad.coordinates.getX() + _entidad.dimension.getWidth()
				& _entidad.coordinates.getX() < this.coordinates.getX() + this.dimension.getWidth()
				& this.coordinates.getY() < _entidad.coordinates.getY() + _entidad.dimension.getHeight()
				& _entidad.coordinates.getY() < this.coordinates.getY() + this.dimension.getHeight();
	}

	/**
	 * True if Entity (object type) is over another Entity
	 * 
	 * @param _entidad Entity (object) to check if the main Entity is over it
	 * @return true if Entity (object) is over main Entity, false if not
	 */
	
	public boolean overIt(Entity _entidad)
	{
		return _entidad.traspasable
				& this.coordinates.getX() < _entidad.coordinates.getX() + _entidad.dimension.getWidth()
				& _entidad.coordinates.getX() < this.coordinates.getX() + this.dimension.getWidth()
				& this.coordinates.getY() < _entidad.coordinates.getY() + _entidad.dimension.getHeight()
				& _entidad.coordinates.getY() < this.coordinates.getY() + this.dimension.getHeight();
	}

	/**
	 * @return coordinates current Coordinates object (X, Y)
	 */

	public Coordinates getCoordinates() {
		return coordinates;
	}

	/**
	 * 
	 * @param coordinates Coordinates to set (object type) 
	 */
	public void setCoordinates(Coordinates _coordinates) {
		
		Coordinates oldCoordinates = this.coordinates;
		this.coordinates = _coordinates;
		support.firePropertyChange("coordinates", oldCoordinates, _coordinates);

	}

	/**
	 * @return dimension (object type Dimension) las dimensiones de esta entidad
	 */

	public Dimension getDimension() {
		return dimension;
	}

	/**
	 * 
	 * @param dimension Dimension (object type) to set
	 */
	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
	}

	/**
	 * 
	 * @return true if the Entity can be touchable by others, false if not 
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
	 * @param drawable Drawable (object type) to set (true or false)
	 */

	public void setDrawable(Boolean drawable) {
		this.drawable = drawable;
	}

	/**
	 * 
	 * @return true if Entity can be drawable false if not
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
	 * @param map Map to set (object)
	 */

	public void setMap(Map map) {
		this.map = map;
	}
	
	/**
	 * 
	 * @return true if Entity (object) is being debugging false if not
	 */

	public boolean isDebugging() {
		return debugging;
	}
	
	/**
	 * 
	 * @return true if Entity (object) can be erasable, false if not
	 */
	
	public boolean isDeletable()
	{
		return deletable;
	}

	/**
	 * Add a PropertyChangeListener to the listener list. 
	 * The same listener object may be added more than once, and will be calledas many times as it is added.
	 * 
	 * @param listener PropertyChangeListener
	 */
	
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		support.addPropertyChangeListener(listener);
	}

	/**
	 * Remove a PropertyChangeListener from the listener list.This removes a PropertyChangeListener that was registered for all properties.
	 * 
	 * @param listener PropertyChangeListener 
	 */
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		support.removePropertyChangeListener(listener);
	}
		
	/**
	 * 
	 * @return true Entity can be crossable by others, false if not
	 */
	
	public boolean isTraspasable()
	{
		return traspasable;
	}
}
