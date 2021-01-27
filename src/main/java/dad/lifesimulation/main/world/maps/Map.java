package dad.lifesimulation.main.world.maps;

import java.util.ArrayList;
import java.util.List;

import dad.lifesimulation.main.entities.Entity;
import dad.lifesimulation.main.entities.actor.Actor;
import dad.lifesimulation.main.utils.Dimension;
import dad.lifesimulation.main.utils.GameFunctions;
import javafx.scene.canvas.GraphicsContext;

public class Map implements GameFunctions {
	protected Dimension dimension;
	protected List<Entity> entities;
	protected List<Actor> actors;
	protected List<Entity> drawables;
	// 0jugador
	// 0 entidad pox poy update x-0 y-0

	// 1 entidad2 pox poy update x-0 y-0
	//
	
	public Map()
	{
		actors = new ArrayList<>();
		entities = new ArrayList<>();
		drawables = new ArrayList<>();
	}
	
	/**
	 * Actualiza la lista de objetos Entity
	 */
	
	public void update() {
		for (Entity e : entities) {
			e.update();
		}
	}
	
	/**
	 * 
	 * @param entity objeto de tipo entidad que se añade a la lista de entidades
	 */
	
	public void insertEntity(Entity entity)
	{
		entities.add(entity);
		if (entity.isDrawable())
			drawables.add(entity);
	}
	
	/**
	 * 
	 * @param actor objeto de tipo actor que se añade a la lista de actores
	 */
	
	public void insertEntity(Actor actor)
	{
		actors.add(actor);
		insertEntity((Entity)actor);
	}
	
	/**
	 * 
	 * @param entity objeto de tipo entidad
	 * @return lista de actores que estén colisionando con la entidad
	 */
	
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

	/**
	 * 
	 * @param entity objeto de tipo entidad
	 * @return lista de entidades que estén colisionando con la entidad
	 */
	
	public List<Entity> getEntitiesIn(Entity entity) {
		List<Entity> aux = new ArrayList<>();
		for (Entity e : entities) {
			if (e.colliding(entity)) {
				aux.add(e);
			}
		}
		return aux;
	}
	
	public void setEntities(List<Entity> listEntities){
		
		listEntities.stream().forEach(this::insertEntity);
		
	}

	public void drawElements(GraphicsContext graphicsContext2D) {
		drawables.stream().forEach(x->x.render(graphicsContext2D));
	}

}
