package dad.lifesimulation.main.entities;

import dad.lifesimulation.main.utils.Coordinates;
import dad.lifesimulation.main.utils.Dimension;
import dad.lifesimulation.main.utils.GameFunctions;
import dad.lifesimulation.main.world.maps.Map;

public abstract class Entity implements GameFunctions {

	protected Coordinates coordinates;
	protected Dimension dimension;
	protected Boolean tangible;
	protected Map map;

	public Entity(Coordinates _coordinates, Dimension _dimension, Boolean _tangible) {
		this.coordinates = _coordinates;
		this.dimension = _dimension;
		this.tangible = _tangible;
		this.map = null;

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
		return _entidad.tangible
				&this.coordinates.getX() < _entidad.coordinates.getX() + _entidad.dimension.getWidth()
				& _entidad.coordinates.getX() < this.coordinates.getX() + this.dimension.getWidth()
				& this.coordinates.getY() < _entidad.coordinates.getY() + _entidad.dimension.getHeight()
				& _entidad.coordinates.getY() < this.coordinates.getY() + this.dimension.getHeight() ;

	}

	/**
	 * @return coordiantes (object type coordinates ) las coordenadas de esta
	 *         entidad
	 */

	public Coordinates getCoordinates() {
		return coordinates;
	}

	/**
	 * 
	 * @param coordinates (object type Coordinates ) asigna las coordenadas
	 *                    recibidas a esta entidad
	 */
	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}

	/**
	 * @return dimension (Object type Dimension) las dimensiones de esta entidad
	 */

	public Dimension getDimension() {
		return dimension;
	}

	/**
	 * 
	 * @param dimension (Object type Dimension)asigna las dimensiones recibidas a
	 *                  esta entidad
	 */
	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
	}
	/**
	 * 
	 * @return tangible (Object type Boolean ) true (si es tra)
	 */

	public Boolean getTangible() {
		return tangible;
	}

	public void setTangible(Boolean tangible) {
		this.tangible = tangible;
	}

}
