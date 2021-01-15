package dad.LifeSimulation.Main.World.Maps;

import java.util.List;

import dad.LifeSimulation.Main.Entities.Entity;
import dad.LifeSimulation.Main.Utils.Dimension;
import dad.LifeSimulation.Main.Utils.GameFunctions;

public class Map  implements GameFunctions{
	protected Dimension dimension;
	protected List <Entity>entities;
	
	public void update() {
		for (Entity e:entities) {
			e.update();
		}
	}
	

}
