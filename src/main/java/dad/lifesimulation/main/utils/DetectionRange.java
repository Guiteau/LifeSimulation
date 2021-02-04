package dad.lifesimulation.main.utils;

import java.util.ArrayList;
import java.util.List;

import dad.lifesimulation.main.entities.Entity;

public class DetectionRange extends Entity {
	List<Coordinates> freeCoordinates;

	public DetectionRange(Coordinates _coordinates, int _range) {
		super(_coordinates, new Dimension(2 * _range + 1, 2 * _range + 1), false);
		freeCoordinates = new ArrayList<>();

	}

	/**
	 * 
	 * @param list
	 * @return
	 */

	private void getFieldOfView(List<Entity> list) {

		List<Coordinates> aux = new ArrayList<>();

		for (Entity mapEntities : list) {
			if (this.colliding(mapEntities)) {
				aux.add(mapEntities.getCoordinates());

			}

		}

	}

	@Override
	public void update() {
		getFieldOfView(map.getEntitiesIn(this));
	}

	public List<Coordinates> getFreeCoordinates() {
		return this.freeCoordinates;
	}

}
