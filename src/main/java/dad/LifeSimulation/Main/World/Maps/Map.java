package dad.LifeSimulation.Main.World.Maps;

import java.util.ArrayList;
import java.util.List;

import dad.LifeSimulation.Main.Entities.Entity;
import dad.LifeSimulation.Main.Utils.Coordinates;
import dad.LifeSimulation.Main.Utils.Dimension;
import dad.LifeSimulation.Main.Utils.GameFunctions;

public class Map implements GameFunctions {
	protected Dimension dimension;
	protected List<Entity> entities;
	// 0jugador
	// 0 entidad pox poy update x-0 y-0

	// 1 entidad2 pox poy update x-0 y-0
	//
	public void update() {
		for (Entity e : entities) {
			e.update();
		}
	}

	public List<Entity> getNearEntities(Coordinates _coordinates) {
		List<Entity> aux = new ArrayList<>();
		for (Entity e : entities) {
			if (_coordinates.compareTo(e.getCoordinates()) == 1) {
				aux.add(e);
			}
		}
		return aux;
	}

}
