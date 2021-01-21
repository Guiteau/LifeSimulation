package dad.lifesimulation.main.world.maps;

import java.util.ArrayList;
import java.util.List;

import dad.lifesimulation.main.entities.Entity;
import dad.lifesimulation.main.entities.actor.Actor;
import dad.lifesimulation.main.utils.Coordinates;
import dad.lifesimulation.main.utils.Dimension;
import dad.lifesimulation.main.utils.GameFunctions;

public class Map implements GameFunctions {
	protected Dimension dimension;
	protected List<Entity> entities;
	protected List<Actor> actors;
	// 0jugador
	// 0 entidad pox poy update x-0 y-0

	// 1 entidad2 pox poy update x-0 y-0
	//
	
	public Map()
	{
		actors = new ArrayList<>();
		entities = new ArrayList<>();
	}
	
	public void update() {
		for (Entity e : entities) {
			e.update();
		}
	}
	
	public void insertEntity(Entity entity)
	{
		entities.add(entity);
	}
	
	public void insertEntity(Actor actor)
	{
		actors.add(actor);
		insertEntity((Entity)actor);
	}
	
	public List<Actor> getActorsIn(Entity entity)
	{
		List<Actor> aux = new ArrayList<>();
		for (Actor e : actors) {
			if (e.colliding(entity)) {
				aux.add(e);
			}
		}
		return aux;
	}

	public List<Entity> getEntitiesIn(Entity entity) {
		List<Entity> aux = new ArrayList<>();
		for (Entity e : entities) {
			if (e.colliding(entity)) {
				aux.add(e);
			}
		}
		return aux;
	}

}
