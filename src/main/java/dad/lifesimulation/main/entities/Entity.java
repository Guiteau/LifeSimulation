package dad.lifesimulation.main.entities;

import java.util.Optional;

import dad.lifesimulation.main.utils.Coordinates;
import dad.lifesimulation.main.utils.Dimension;
import dad.lifesimulation.main.utils.GameFunctions;
import dad.lifesimulation.main.world.maps.Map;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public abstract class Entity implements GameFunctions, Drawn_I {

	protected Coordinates coordinates;
	protected Dimension dimension;
	protected Boolean tangible;
	protected Boolean drawable;
	protected Map map;
	protected Optional<Image> maybe_image;

	@Override
	public void loadImage(Image image) {
		maybe_image = Optional.of(image);
	}

	@Override
	public void render(GraphicsContext gc) {
		if (maybe_image.isPresent())
			gc.drawImage(maybe_image.get(), coordinates.getX(), coordinates.getY(), dimension.getWidth(),
					dimension.getHeight());
		else {
			gc.setFill(Color.WHITESMOKE);
			gc.setStroke(Color.BLACK);
			gc.rect(coordinates.getX(), coordinates.getY(), dimension.getWidth(), dimension.getHeight());
		}
	}

	public Entity(Coordinates _coordinates, Dimension _dimension, Boolean _tangible) {
		this.coordinates = _coordinates;
		this.dimension = _dimension;
		this.tangible = _tangible;
		this.map = null;
		this.drawable = false;
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
		return this.coordinates.getX() < _entidad.coordinates.getX() + _entidad.dimension.getWidth()
				& _entidad.coordinates.getX() < this.coordinates.getX() + this.dimension.getWidth()
				& this.coordinates.getY() < _entidad.coordinates.getY() + _entidad.dimension.getHeight()
				& _entidad.coordinates.getY() < this.coordinates.getY() + this.dimension.getHeight();

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
	
	@Override
	public boolean isDrawable()
	{
		return drawable;
	}
}
