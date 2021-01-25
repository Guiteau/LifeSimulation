package dad.lifesimulation.main.utils;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import dad.lifesimulation.main.entities.Entity;
import dad.lifesimulation.main.entities.actor.cell.Assasin;
import dad.lifesimulation.main.entities.element.harmful.Spikes;
import dad.lifesimulation.main.world.maps.Map;

public class InitGameComponents {

	public static final int MAPHEIGHT = 300;
	public static final int MAPWIDTH = 400;

	public void init() {

		Map mapa = new Map();
		
		Stream<Entity> streamEntities = Stream.of(new Entity[100]);

		streamEntities.forEach(this::assignRole);
		
		streamEntities.collect(Collectors.toList());
		
		
	}

	public void assignRole(Entity entidad) {

		// 80% Spikes
		// 20% Enemies

		double random = Math.random();

		if (random <= 0.20) {

			entidad = randomAssasin();

		} else {

			entidad = randomSpikes();
			
		} 

	}

	public static Assasin randomAssasin() {

		Dimension dimension = new Dimension(5, 3);

		Coordinates coordinates = new Coordinates(Die.getDiscretValue(0, MAPWIDTH - dimension.getWidth()),
				Die.getDiscretValue(0, MAPWIDTH - dimension.getWidth()));

		Statistics statistics = new Statistics(100, 100, 30, 5);

		Assasin asesino = new Assasin(coordinates, dimension, statistics, true, true);

		return asesino;

	}

	public static Spikes randomSpikes() {

		Dimension dimension = new Dimension(Die.getDiscretValue(1, 3), Die.getDiscretValue(1, 3));

		Coordinates coordinates = new Coordinates(Die.getDiscretValue(0, MAPWIDTH - dimension.getWidth()),
				Die.getDiscretValue(0, MAPWIDTH - dimension.getWidth()));

		Spikes spikes = new Spikes(coordinates, dimension);
		
		return spikes;

	}

}
