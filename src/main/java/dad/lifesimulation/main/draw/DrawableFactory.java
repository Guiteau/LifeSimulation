package dad.lifesimulation.main.draw;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dad.lifesimulation.main.entities.Entity;
import dad.lifesimulation.main.entities.EntityFinalType;
import dad.lifesimulation.main.utils.Coordinates;
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
	
	enum ReadyToDraw
	{
		WITH_COLOR,
		WITH_IMAGE
	}

	public DrawableFactory()
	{
		entity_color = new HashMap<>();
		entity_image = new HashMap<>();
		drawableEntities = new ArrayList<>();
	}
	
	public InitGameComponents getInitGameComponents() throws NotInitializer
	{
		if (initializer == null)
			throw new NotInitializer("Initializer game was not initialize yet");
		
		return initializer;
	}
	
	public void createRandomLevel()
	{
		initializer.generateRandomMap(100);
		initializer.getAllEntities().stream().forEach(x -> {
			try {
				storeNewDrawableEntity(x);
			} catch (NotColorOrImageChosen e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}
	
	public void loadGraphicsContext(GraphicsContext graphicsContext) {
		this.graphicsContext = graphicsContext;
		Dimension dim = new Dimension((int)graphicsContext.getCanvas().getWidth(), (int)graphicsContext.getCanvas().getHeight());
		initializer = new InitGameComponents(dim);
	}

	private void storeNewDrawableEntity(Entity entity) throws NotColorOrImageChosen {
		DrawableEntity drawableEntity = null;
		
		EnumSet<ReadyToDraw> flag = EnumSet.noneOf(ReadyToDraw.class);
		
		if (entity_color.containsKey(entity.getEntityType()))
		{
			drawableEntity = new DrawableEntity(entity, entity_color.get(entity.getEntityType()));
			flag.add(ReadyToDraw.WITH_COLOR);
		}

		if (entity_image.containsKey(entity.getEntityType()))
		{
			drawableEntity = new DrawableEntity(entity, entity_image.get(entity.getEntityType()));
			flag.add(ReadyToDraw.WITH_IMAGE);
		}
		
		if (flag.isEmpty())
			throw new NotColorOrImageChosen("Entity drawable: " + entity.getEntityType().toString() + " was not set with any color or image");

		drawableEntities.add(drawableEntity);
	}	

	public void setColor(EntityFinalType entityType, Color color) {
		entity_color.put(entityType, color);
	}

	public void setImage(EntityFinalType entityType, Image image) {
		entity_image.put(entityType, image);
	}
	
	public List<DrawableEntity> getDrawableEntities()
	{
		return drawableEntities;
	}
	
	public void createCellEntity(Coordinates coord, Dimension dim, Statistics stats, boolean hostil) {
		Entity cell = initializer.getNewCell(coord, dim, stats, hostil);
		
		try {
			storeNewDrawableEntity(cell);
		} catch (NotColorOrImageChosen e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void createSpikeEntity(Coordinates coord, Dimension dim) {
		Entity spikes = initializer.getNewSpikes(coord, dim);
		
		try {
			storeNewDrawableEntity(spikes);
		} catch (NotColorOrImageChosen e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void render()
	{
		drawableEntities.stream().forEach(de -> de.render(graphicsContext));
	}
}