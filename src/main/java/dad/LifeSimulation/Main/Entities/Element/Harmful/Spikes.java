package dad.LifeSimulation.Main.Entities.Element.Harmful;

import java.util.ArrayList;
import java.util.List;

import dad.LifeSimulation.Main.Entities.Entity;
import dad.LifeSimulation.Main.Entities.Actor.Actor;
import dad.LifeSimulation.Main.Entities.Element.Floor;
import dad.LifeSimulation.Main.Entities.Element.Type;
import dad.LifeSimulation.Main.Utils.Coordinates;
import dad.LifeSimulation.Main.Utils.Dimension;

public class Spikes extends Floor {
	private final int DAMAGE = 5;

	public Spikes(Coordinates _coordinates, Dimension _dimension) {
		super(_coordinates, _dimension, Type.HARMFUL);
		// TODO Auto-generated constructor stub
	}

	public void update() {
		List<Entity> temporalList = this.map.getNearEntities(this.coordinates);
		for (Entity e : temporalList) {
			if (e instanceof Actor) {
				Actor auxActor = (Actor) e;
				auxActor.getStatistics().damageReceive(DAMAGE);
			}
		}

	}

}
