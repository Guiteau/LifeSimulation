package dad.lifesimulation.main.draw;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dad.lifesimulation.main.entities.Entity;
import dad.lifesimulation.main.entities.EntityType;
import dad.lifesimulation.main.utils.Coordinates;
import dad.lifesimulation.main.utils.Dimension;
import dad.lifesimulation.main.utils.InitGameComponents;
import dad.lifesimulation.main.utils.Statistics;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class InitDrawableGameComponents {
	private List<DrawableEntity> drawableEntities;
	private GraphicsContext graphicsContext;
	private InitGameComponents initializer;
	private Map<EntityType, Color> entity_color;
	private Map<EntityType, Image> entity_image;

	public InitDrawableGameComponents()
	{
		entity_color = new HashMap<>();
		entity_image = new HashMap<>();
		drawableEntities = new ArrayList<>();
	}
	
	public void loadGraphicsContext(GraphicsContext graphicsContext) {
		this.graphicsContext = graphicsContext;
		Dimension dim = new Dimension((int)graphicsContext.getCanvas().getWidth(), (int)graphicsContext.getCanvas().getHeight());
		initializer = new InitGameComponents(dim);
		initializer.generateRandomMap(100);
		
		initializer.getAllEntities().stream().forEach(x -> storeNewDrawableEntity(x));
	}

	private void storeNewDrawableEntity(Entity entity) {
		DrawableEntity drawableEntity = null;

		if (entity_color.containsKey(entity.getEntityType()))
			drawableEntity = new DrawableEntity(entity, entity_color.get(entity.getEntityType()));

		if (entity_image.containsKey(entity.getEntityType()))
			drawableEntity = new DrawableEntity(entity, entity_image.get(entity.getEntityType()));

		drawableEntities.add(drawableEntity);
	}

	public void createCellEntity(Coordinates coord, Dimension dim, Statistics stats, boolean hostil) {
		Entity cell = initializer.getNewCell(coord, dim, stats, hostil);
		
		storeNewDrawableEntity(cell);
	}

	public void createSpikeEntity(Coordinates coord, Dimension dim) {
		Entity spikes = initializer.getNewSpikes(coord, dim);
		
		storeNewDrawableEntity(spikes);
	}

	public void setColor(EntityType entityType, Color color) {
		entity_color.put(entityType, color);
	}

	public void setImage(EntityType entityType, Image image) {
		entity_image.put(entityType, image);
	}

	public void render() {
		drawableEntities.stream().forEach(de -> de.render(graphicsContext));
	}
}
