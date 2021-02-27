package dad.lifesimulation.main.world.maps;

import java.util.ArrayList;
import java.util.List;

import dad.lifesimulation.main.entities.Entity;
import dad.lifesimulation.main.entities.actor.Actor;
import dad.lifesimulation.main.utils.Dimension;

public class Map {
	protected Dimension dimension;
	protected List<Entity> entities;
	protected List<Actor> actors;

	public Map() {
		actors = new ArrayList<>();
		entities = new ArrayList<>();
	}
	
	public void clear()
	{
		actors.clear();
		entities.clear();
		dimension = null;
	}
	
	public List<Entity> getAllEntities()
	{
		return entities;
	}

	public Dimension getDimension() {
		return dimension;
	}

	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
	}

	/**
	 * Actualiza la lista de objetos Entity
	 */

	public void update() {

		entities.stream().forEach(x -> x.update());
	}
	
	/**
	 * 
	 * @param actor objeto de tipo actor que se añade a la lista de actores
	 */

	public void insertEntity(Actor actor) {
		System.out.println("Metiste un actor" + actor.getClass());
		
		actors.add(actor);
		insertEntity((Entity) actor);
	}

	/**
	 * 
	 * @param entity objeto de tipo entidad que se añade a la lista de entidades
	 */

	public void insertEntity(Entity entity) {
		entity.setMap(this);
		entities.add(entity);
	}



	/**
	 * 
	 * @param entity objeto de tipo entidad
	 * @return lista de actores que estén colisionando con la entidad
	 */

	public List<Actor> getActorsIn(Entity entity) {
		List<Actor> aux = new ArrayList<>();
		for (Actor e : actors) {
			if (e.colliding(entity)) {
				aux.add(e);
			}
		}
		return aux;
	}

	/**
	 * 
	 * @param entity objeto de tipo entidad
	 * @return lista de entidades que estén colisionando con la entidad
	 */

	public List<Entity> getEntitiesIn(Entity entity) {
		List<Entity> aux = new ArrayList<>();
		for (Entity e : entities) {
			if (entity.colliding(e)) {
				aux.add(e);
			}
		}
		return aux;
	}

	public void setEntities(List<Entity> listEntities) {
		//listEntities.stream().forEach(this::insertEntity);
		for (Entity e : listEntities)
		{
			insertEntity(e);
		}
	}

	public List<Entity> getDrawableEntities() {
		List<Entity> aux = new ArrayList<>();

		entities.stream().forEach(e -> {
			if (e.isDrawable()) {
				aux.add(e);
			}
		});

		return aux;
	}

}
