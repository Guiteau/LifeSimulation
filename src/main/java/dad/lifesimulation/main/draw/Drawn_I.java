package dad.lifesimulation.main.draw;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public interface Drawn_I {
	
	/**
	 * @param gc GraphicsContext to be rendered
	 */
	
	public void render(GraphicsContext gc);
	
	/**
	 * 
	 * @param image image to be set in a DrawableEntity (object type)
	 */
	
	public void loadImage(Image image);
}
