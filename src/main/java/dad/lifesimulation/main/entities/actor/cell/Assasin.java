package dad.lifesimulation.main.entities.actor.cell;

import dad.lifesimulation.main.entities.actor.Actor;
import dad.lifesimulation.main.utils.Coordinates;
import dad.lifesimulation.main.utils.Dimension;
import dad.lifesimulation.main.utils.Statistics;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Assasin extends Actor {
	private boolean hostilToPlayers;

	public Assasin(Coordinates _coordinates, Dimension _dimension, Statistics _statistics,
			Boolean hostilToOthers, Boolean _hostilToPlayers) {
		super(_coordinates, _dimension, _statistics, hostilToOthers);
		this.hostilToPlayers = _hostilToPlayers;
		
	}

	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(GraphicsContext gc) {
		gc.setFill(Color.RED);
		gc.setStroke(Color.BLACK);

		gc.fillRect(coordinates.getX(), coordinates.getY(), dimension.getWidth(), dimension.getHeight());
		
	}

}
