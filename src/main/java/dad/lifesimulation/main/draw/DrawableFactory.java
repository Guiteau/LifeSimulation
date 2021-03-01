package dad.lifesimulation.main.draw;

import java.io.File;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import dad.lifesimulation.main.entities.Entity;
import dad.lifesimulation.main.entities.EntityFinalType;
import dad.lifesimulation.main.utils.Coordinates;
import dad.lifesimulation.main.utils.DataProvider;
import dad.lifesimulation.main.utils.Dimension;
import dad.lifesimulation.main.utils.InitGameComponents;
import dad.lifesimulation.main.utils.Statistics;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import ourExceptions.NotColorOrImageChosen;
import ourExceptions.NotInitializer;

public class DrawableFactory {
	private List<DrawableEntity> drawableEntities;
	private GraphicsContext graphicsContext;
	private InitGameComponents initializer;
	private Map<EntityFinalType, Color> entity_color;
	private Map<EntityFinalType, Image> entity_image;

	enum ReadyToDraw {
		WITH_COLOR, WITH_IMAGE
	}
	
	/**
	 * Constructor.
	 */

	public DrawableFactory() {
		entity_color = new HashMap<>();
		entity_image = new HashMap<>();
		drawableEntities = new ArrayList<>();
	}
	
	/**
	 * 
	 * @param drawcanvas true to automatical insertions on map
	 */

	public void drawFromCanvas(boolean drawcanvas) {
		initializer.setAutomaticMapInsert(drawcanvas);
	}
	
	/**
	 * 
	 * @return current InitGameComponents (object type)
	 * @throws NotInitializer if the initializaer is null
	 */

	public InitGameComponents getInitGameComponents() throws NotInitializer {
		if (initializer == null)
			throw new NotInitializer("Initializer game was not initialize yet");

		return initializer;
	}
	

	/**
	 * 
	 * @param binMap File (object type) with a map stored to load it 
	 */
	
	public void loadLevel(File binMap)
	{
		initializer.loadMap(binMap);
		initializer.getAllEntities().stream().forEach(x -> {
			try {
				storeNewDrawableEntity(x);
			} catch (NotColorOrImageChosen e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}

	/**
	 *  Generates a random level with a simple map and several entities on it
	 */

	public void createRandomLevel() {
		// initializer.generateRandomMap(100);
		initializer.generateSimpleMap();
		initializer.getAllEntities().stream().forEach(x -> {
			try {
				storeNewDrawableEntity(x);
			} catch (NotColorOrImageChosen e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	
	}
	
	/**
	 * 
	 * @param entity Entity to check if exists in the Drawable entities list
	 * @return Optional empty if there is not present the Entity as drawable
	 */
	
	private Optional<DrawableEntity> getDrawableEntityIfExist(Entity entity)
	{
		Optional<DrawableEntity> opt = Optional.empty();
		
		for (DrawableEntity de : drawableEntities)
		{
			if (de.getEntity().equals(entity))
			{
				opt = Optional.of(de);
				break;
			}
		}
		
		return opt;
	}
	
	/**
	 * Set a GraphicContext (object type) and initializes the InitGameComponents
	 * 
	 * @param graphicsContext to set
	 */

	public void loadGraphicsContext(GraphicsContext graphicsContext) {
		this.graphicsContext = graphicsContext;
		Dimension dim = new Dimension((int) graphicsContext.getCanvas().getWidth(),
				(int) graphicsContext.getCanvas().getHeight());
		initializer = new InitGameComponents(dim);
	}
	
	/**
	 * 
	 * Add a new DrawableEntity (object type) to the list of the drawable entities
	 * 
	 * @param entity Entity to be added
	 * @throws NotColorOrImageChosen if the entity does not have an image or a color
	 */

	private void storeNewDrawableEntity(Entity entity) throws NotColorOrImageChosen {
		DrawableEntity drawableEntity = null;

		EnumSet<ReadyToDraw> flag = EnumSet.noneOf(ReadyToDraw.class);

		if (entity_color.containsKey(entity.getEntityType())) {
			drawableEntity = new DrawableEntity(entity, entity_color.get(entity.getEntityType()));
			flag.add(ReadyToDraw.WITH_COLOR);
		}

		if (entity_image.containsKey(entity.getEntityType())) {
			drawableEntity = new DrawableEntity(entity, entity_image.get(entity.getEntityType()));
			flag.add(ReadyToDraw.WITH_IMAGE);
		}

		if (flag.isEmpty())
			throw new NotColorOrImageChosen(
					"Entity drawable: " + entity.getEntityType().toString() + " was not set with any color or image");

		drawableEntities.add(drawableEntity);
	}
	
	/**
	 * 
	 * @param entityType Entity to be set with a color (CELL, SPIKE, WALL, FOOD, UNKNOWN)
	 * @param color to set (Color object type)
	 */

	public void setColor(EntityFinalType entityType, Color color) {
		entity_color.put(entityType, color);
	}
	
	/**
	 *  
	 * @param entityType Entity to be set with an image (CELL, SPIKE, WALL, FOOD, UNKNOWN)
	 * @param image to set (Image object type)
	 */

	public void setImage(EntityFinalType entityType, Image image) {
		entity_image.put(entityType, image);
	}
	
	/**
	 * 
	 * @return the list of drawable entities stored
	 */

	public List<DrawableEntity> getDrawableEntities() {
		return drawableEntities;
	}
	
	/**
	 * 
	 * @param coord Coordinates (object type) for the wall
	 * @param dim  Dimension (object type) for the wall
	 */

	public void createWallEntity(Coordinates coord, Dimension dim) {
		Entity wall = initializer.getNewWall(coord, dim);

		try {
			storeNewDrawableEntity(wall);
		} catch (NotColorOrImageChosen e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param coord coord Coordinates (object type) of the new Cell object to be stored on the drawable entities list
	 * @param dim Dimension (object type) of the new Cell object to be stored on the drawable entities list
	 * @param stats Statistics (object type) of the new Cell object to be stored on the drawable entities list
	 * @param hostil true if cell object can damage others, false if not
	 */

	public void createCellEntity(Coordinates coord, Dimension dim, Statistics stats, boolean hostil) {
		Entity cell = initializer.getNewCell(coord, dim, stats, hostil);

		try {
			storeNewDrawableEntity(cell);
		} catch (NotColorOrImageChosen e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param coord Coordinates (object type) of the new Cell object to be stored on the drawable entities list
	 * @param dim Dimension (object type) of the new Cell object to be stored on the drawable entities list
	 * @param hostil true if cell object can damage others, false if not
	 */

	public void createCellEntity(Coordinates coord, Dimension dim, boolean hostil) {
		Entity cell = initializer.getNewCell(coord, dim, hostil);

		try {
			storeNewDrawableEntity(cell);
		} catch (NotColorOrImageChosen e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param coord Coordinates (object type) of the new food Entity (object type) to be stored on the drawable entities list
	 * @param dim Dimension (object type) of the new food Entity (object type) to be stored on the drawable entities list
	 */
	
	public void createFoodEntity(Coordinates coord, Dimension dim)
	{
		Entity food = initializer.getNewFood(coord, dim);

		try {
			storeNewDrawableEntity(food);
		} catch (NotColorOrImageChosen e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param coord Coordinates (object type) of the new Spikes object to be stored on the drawable entities list
	 * @param dim Dimension (object type) of the new Spikes object to be stored on the drawable entities list
	 */

	public void createSpikeEntity(Coordinates coord, Dimension dim) {
		Entity spikes = initializer.getNewSpikes(coord, dim);

		try {
			storeNewDrawableEntity(spikes);
		} catch (NotColorOrImageChosen e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * render the graphic context
	 */

	public void render() {
		
		graphicsContext.setFill(Color.BLACK);
		graphicsContext.fillRect(0, 0, graphicsContext.getCanvas().getWidth(), graphicsContext.getCanvas().getHeight());
		
		for (DrawableEntity de: drawableEntities)
		{
			if (de.getEntity().isDeletable())
				drawableEntities.remove(de);
		}
		
		drawableEntities.stream().forEach(x->x.render(graphicsContext));
		
	}

	/**
	 * 
	 * @param coordinates Coordinates (object type) to delete in the drawable entities list stored
	 */

	public void deleteIn(Coordinates coordinates) {
		List<Entity> entities = initializer.getEntitiesIn(coordinates);
		
		System.out.println(entities);
		
		for (Entity e : entities)
		{
			Optional<DrawableEntity> maybe_drawableEntity = getDrawableEntityIfExist(e);
			if (maybe_drawableEntity.isPresent())
				drawableEntities.remove(maybe_drawableEntity.get());
		}
		
		initializer.deleteIn(coordinates);
	}
}
