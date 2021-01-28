package dad.lifesimulation.main.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import dad.lifesimulation.main.entities.Entity;
import dad.lifesimulation.main.entities.actor.JohnDoe;
import dad.lifesimulation.main.entities.actor.cell.Assasin;
import dad.lifesimulation.main.entities.element.harmful.Spikes;
import dad.lifesimulation.main.world.maps.Map;
import javafx.scene.image.Image;

public class InitGameComponents {

	public final int MAPHEIGHT;
	public final int MAPWIDTH;

	public InitGameComponents(int width, int height)
	{
		MAPHEIGHT = height;
		MAPWIDTH = width;
	}
	
	public Map createMap() {
		Map map = new Map();
		//List<Entity> entities = new ArrayList<>(100);
		List<Entity> entities = new ArrayList<>();
		
		for (int i = 0 ; i< 100; i++)
			entities.add(this.assignRole());
		
		//entities.stream().forEach(this::assignRole);

		map.setEntities(entities);
		
		return map;
	}

	public Entity assignRole() {

		// 80% Spikes
		// 20% Enemies
		Entity entity;
		
		double random = Math.random();

		if (random <= 0.20) {

			entity = randomAssasin();

		} else {

			entity = randomSpikes();

		}
		
		return entity;
	}

	public JohnDoe randomJohnDoe() {
		Dimension dimension = new Dimension(5, 3);

		Coordinates coordinates = new Coordinates(Die.getDiscretValue(0, MAPWIDTH - dimension.getWidth()),
				Die.getDiscretValue(0, MAPWIDTH - dimension.getWidth()));

		Statistics statistics = new Statistics(100, 100, 30, 5);

		JohnDoe asesino = new JohnDoe(coordinates, dimension, statistics, true);

		return asesino;
	}

	public Assasin randomAssasin() {

		Dimension dimension = new Dimension(5, 3);

		Coordinates coordinates = new Coordinates(Die.getDiscretValue(0, MAPWIDTH - dimension.getWidth()),
				Die.getDiscretValue(0, MAPWIDTH - dimension.getWidth()));

		Statistics statistics = new Statistics(100, 100, 30, 5);

		Assasin asesino = new Assasin(coordinates, dimension, statistics, true, true);

		return asesino;

	}

	public Spikes randomSpikes() {

		Dimension dimension = new Dimension(Die.getDiscretValue(1, 3), Die.getDiscretValue(1, 3));

		Coordinates coordinates = new Coordinates(Die.getDiscretValue(0, MAPWIDTH - dimension.getWidth()),
				Die.getDiscretValue(0, MAPWIDTH - dimension.getWidth()));

		Spikes spikes = new Spikes(coordinates, dimension);


		spikes.loadImage(new Image("/images/spikes.png"));

		return spikes;

	}

}
