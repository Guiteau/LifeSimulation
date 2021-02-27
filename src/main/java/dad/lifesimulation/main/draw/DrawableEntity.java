package dad.lifesimulation.main.draw;

import java.util.Optional;

import dad.lifesimulation.main.entities.Entity;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class DrawableEntity implements Drawn_I {
	private Entity entity;
	protected Optional<Image> maybe_image;
	protected Color color;
	
	public DrawableEntity(Entity entity, Color color)
	{
		this.entity = entity;
		entity.setDrawable(true);
		this.color = color;
		maybe_image = Optional.empty();
	}
	
	public DrawableEntity(Entity entity, Image image)
	{
		this.entity = entity;
		entity.setDrawable(true);
		this.color = Color.BLACK;
		loadImage(image);
	}

	@Override
	public void loadImage(Image image) {
		maybe_image = Optional.of(image);
	}
	

	@Override
	public void render(GraphicsContext gc) {
		if (maybe_image.isPresent())
			gc.drawImage(maybe_image.get(), entity.getCoordinates().getX(), entity.getCoordinates().getY(), entity.getDimension().getWidth(),
					entity.getDimension().getHeight());
		else {
			gc.setFill(color);
			gc.fillRect(entity.getCoordinates().getX(), entity.getCoordinates().getY(), entity.getDimension().getWidth(), entity.getDimension().getHeight());
			
		}
	}
}
