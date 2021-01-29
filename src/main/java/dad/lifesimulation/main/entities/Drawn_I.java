package dad.lifesimulation.main.entities;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public interface Drawn_I {
	public void render(GraphicsContext gc);
	public void loadImage(Image image);
	public boolean isDrawable();
}
