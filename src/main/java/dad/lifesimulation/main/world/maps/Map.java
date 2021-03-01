package dad.lifesimulation.main.world.maps;

import java.util.ArrayList;
import java.util.List;

import dad.lifesimulation.main.entities.Entity;
import dad.lifesimulation.main.entities.actor.Actor;
import dad.lifesimulation.main.entities.element.Floor;
import dad.lifesimulation.main.utils.DataProvider;
import dad.lifesimulation.main.utils.Dimension;

public class Map {
	protected Dimension dimension;
	protected List<Entity> entities;
	protected List<Actor> actors;
	protected List<Floor> floors;

	public Map() {
		actors = new ArrayList<>();
		entities = new ArrayList<>();
		floors = new ArrayList<>();
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

		List<Entity> entitiesToDelete = new ArrayList<>();
		
		for (Entity e : entities)
		{
			if (e.isDeletable())
				entitiesToDelete.add(e);
			else		
				e.update();
		}
		
		if (!entitiesToDelete.isEmpty())
			delete(entitiesToDelete);
		
	}
	
	public void insertEntity(Floor floor) {
		System.out.println("Metiste un suelo" + floor.getClass());
		
		floors.add(floor);
		insertEntity((Entity) floor);
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
			if (entity.colliding(e)) {
				aux.add(e);
			}
		}
		return aux;
	}
	
	public List<Entity> getImpenetrableEntities(Entity entity)
	{
		List<Entity> aux = new ArrayList<>();
		for (Entity e : entities) {
			if (entity.colliding(e) && !e.isTraspasable()) {
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
			if (entity.collidingAll(e)) {
				aux.add(e);
			}
		}
		return aux;
	}
	
	public List<Floor> getFloorsIn(Entity entity)
	{
		List<Floor> aux = new ArrayList<>();
		for (Floor f : floors) {
			if (entity.overIt(f)) {
				aux.add(f);
			}
		}
		
		return aux;
	}

	public void setEntities(List<Entity> listEntities) {
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
	
	public void delete(Entity entity)
	{
		if (entities.contains(entity))
			entities.remove(entity);
		
		if (actors.contains(entity))
			actors.remove(entity);
		
		if (floors.contains(entity))
			floors.remove(entity);
		
	}

	public void delete(List<Entity> entitiesIn) {
		for(Entity e: entitiesIn)
			delete(e);
	}

}
