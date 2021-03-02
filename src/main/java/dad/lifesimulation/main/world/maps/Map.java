package dad.lifesimulation.main.world.maps;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import dad.lifesimulation.main.entities.Entity;
import dad.lifesimulation.main.entities.actor.Actor;
import dad.lifesimulation.main.entities.element.Floor;
import dad.lifesimulation.main.utils.DataProvider;
import dad.lifesimulation.main.utils.Dimension;

public class Map implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1816945806286216523L;
	protected Dimension dimension;
	protected List<Entity> entities;
	protected List<Actor> actors;
	protected List<Floor> floors;
	
	/**
	 * Constructor.
	 */

	public Map() {
		actors = new ArrayList<>();
		entities = new ArrayList<>();
		floors = new ArrayList<>();
	}
	
	/**
	 * Clear the entities of the map and empties the dimension
	 */
	
	public void clear()
	{
		actors.clear();
		entities.clear();
		dimension = null;
	}
	
	/**
	 * 
	 * @return all the entities (object types) of the map
	 */
	
	public List<Entity> getAllEntities()
	{
		return entities;
	}
	
	/**
	 * 
	 * @return tha map Dimension (object type)
	 */

	public Dimension getDimension() {
		return dimension;
	}
	
	/**
	 * 
	 * @param dimension Dimension (object type) to set the width and the height of the map
	 */

	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
	}

	/**
	 * Updates the list of entities of the map and deletes all the deletable entities
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
	
	/**
	 * Adds a new Floor object to the lists of entities
	 * 
	 * @param floor Floor (object type) to be added to the list of the entities of the map
	 */
	
	public void insertEntity(Floor floor) {
		System.out.println("Metiste un suelo" + floor.getClass());
		
		floors.add(floor);
		insertEntity((Entity) floor);
	}
	
	/**
	 * Adds a new Actor object to the lists of entities
	 * 
	 * @param actor Actor (object type) to be added to the actors list
	 */

	public void insertEntity(Actor actor) {
		System.out.println("Metiste un actor" + actor.getClass());
		
		actors.add(actor);
		insertEntity((Entity) actor);
	}

	/**
	 * Adds a new Entity object to the lists of entities
	 * 
	 * @param entity Entity (object type) to be added to the list of entities
	 */

	public void insertEntity(Entity entity) {
		entity.setMap(this);
		entities.add(entity);
	}



	/**
	 * All the actors on the map near the Entity
	 * 
	 * @param entity Entity (object type) 
	 * @return a list of actors that are colliding with the entity
	 */

	public List<Actor> getActorsIn(Entity entity) {
		List<Actor> aux = new ArrayList<>();
		for (Actor e : actors) {
			if (entity.colliding(e) && !(entity == e)) {
				aux.add(e);
			}
		}
		return aux;
	}
	
	/**
	 * All the impenetrable entities on the map near the Entity
	 * 
	 * @param entity Entity (object type) 
	 * @return a list of Entity that are impenetrable and colliding with the entity
	 */
	
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
	 * @param entity Entity (object type) 
	 * @return list of entities that are colliding with the Entity (object type)
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
	
	/**
	 * Returns all the floors below the entity 
	 * 
	 * @param entity 
	 * @return the list of floors (object types) on the map
	 */
	
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
	
	/**
	 * Populates with new entities the entities available on the map
	 * 
	 * @param listEntities A list of entities to be inserted in the map
	 */

	public void setEntities(List<Entity> listEntities) {
		for (Entity e : listEntities)
		{
			insertEntity(e);
		}
		
	}
	
	/**
	 * 
	 * @return a list of all entities that can be drawabled
	 */

	public List<Entity> getDrawableEntities() {
		List<Entity> aux = new ArrayList<>();

		entities.stream().forEach(e -> {
			if (e.isDrawable()) {
				aux.add(e);
			}
		});

		return aux;
	}
	
	/**
	 * Remove an entity of the map
	 * 
	 * @param entity Entity (object type) to be removed from the list of entities
	 */
	
	public void delete(Entity entity)
	{
		if (entities.contains(entity))
			entities.remove(entity);
		
		if (actors.contains(entity))
			actors.remove(entity);
		
		if (floors.contains(entity))
			floors.remove(entity);
		
	}
	
	/**
	 * Removes all entities from the map passed by parameter
	 * 
	 * @param entitiesIn A list of entities to be removed from the list of entities
	 */

	public void delete(List<Entity> entitiesIn) {
		for(Entity e: entitiesIn)
			delete(e);
	}

}
