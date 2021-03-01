package dad.lifesimulation.main.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Optional;

import dad.lifesimulation.main.entities.Entity;
import dad.lifesimulation.main.entities.EntityFinalType;
import dad.lifesimulation.main.entities.actor.Actor;
import dad.lifesimulation.main.entities.actor.Cell;
import dad.lifesimulation.main.entities.actor.DetectionRange;
import dad.lifesimulation.main.entities.actor.Orientation;
import dad.lifesimulation.main.entities.element.harmful.Spikes;
import dad.lifesimulation.main.entities.element.helpful.MagicFood;
import dad.lifesimulation.main.entities.element.neutral.ImpenetrableWall;
import dad.lifesimulation.main.world.maps.Map;
import javafx.scene.chart.PieChart.Data;

public class InitGameComponents extends GameFunctions {

	private Map map;
	private boolean automaticMapInsert;
	
	/**
	 * Constructor.
	 * @param dim
	 */

	public InitGameComponents(Dimension dim) {
		map = new Map();
		map.setDimension(dim);
		automaticMapInsert = false;
	}
	
	/**
	 * 
	 * @param automaticMapInsert automaticMapInsert to set (true or false)
	 */
	
	public void setAutomaticMapInsert(boolean automaticMapInsert)
	{
		this.automaticMapInsert = automaticMapInsert;
	}
	
	/**
	 * 
	 * Creates a map with only five entities always with the same coordinates and dimensions
	 */

	public void generateSimpleMap() {
		map.insertEntity(getNewWall(new Coordinates(47, 29), new Dimension(307, 55)));
		map.insertEntity(getNewWall(new Coordinates(34, 11), new Dimension(52, 209)));
		map.insertEntity(getNewWall(new Coordinates(54,250), new Dimension(212, 35)));
		map.insertEntity(getNewWall(new Coordinates(90, 235), new Dimension(37, 152)));
		map.insertEntity(getNewCell(new Coordinates(120, 100), new Dimension(100, 100), randomStatistics(8), true));
	}
	
	/**
	 * Populates the map with several entities generated randomly
	 * 
	 * @param n_elements number of entities to be placed on the map
	 */

	public void generateRandomMap(int n_elements) {

		for (int i = 0; i < n_elements; i++) {
			switch (Die.getDiscretValue(1, 3)) {
			case 1:
				map.insertEntity(randomSpikes());
				break;
			case 2:
				map.insertEntity(aggresiveCell("las agresivas"));
				break;
			case 3:
				map.insertEntity(pacificCell("las pacíficas"));
				break;
			default:

			}
		}
		
	}
	
	/**
	 * Empties the map of its entities
	 */

	public void clearMap() {
		map.clear();
	}
	
	/**
	 * 
	 * @return The list of entities contained in the map
	 */

	public List<Entity> getAllEntities() {
		return map.getAllEntities();
	}

	/**
	 * Creates a new Cell (object type)
	 * 
	 * @param coord Coordinates (object type) to place the cell on the map
	 * @param dim Dimension (object type) for the height and the width of the cell
	 * @param stats Statistics (object type) for the health, armor, energy and damage.
	 * @param hostil true if the Cell (object type) can damage other cells
	 * @return A new Cell (Entity type)
	 */
	
	public Cell getNewCell(Coordinates coord, Dimension dim, Statistics stats, boolean hostil) {
		Cell cell = new Cell(coord, dim, stats, hostil, Orientation.SOUTH);
		if (automaticMapInsert)
			map.insertEntity(cell);
		return cell;
	}
	
	/**
	 * Creates a new Cell (Entity type)
	 * 
	 * @param coord Coordinates (object type) to place the cell on the map
	 * @param dim Dimension (object type) for the height and the width of the cell
	 * @param hostil true if the Cell (object type) can damage other cells
	 * @return A new Cell (Entity type)
	 */
	
	public Cell getNewCell(Coordinates coord, Dimension dim, boolean hostil) {
		Cell cell = new Cell(coord, dim, randomStatistics(8), hostil, Orientation.SOUTH);
		if (automaticMapInsert)
			map.insertEntity(cell);
		return cell;
	}

	/**
	 * Generates an Entity type (Entity type) choosed randomly (Spikes, Cell hostile, Cell not hostile)
	 * 
	 * @return A new Entity (object type)
	 */
	
	public Entity randomEntity() {
		switch (Die.getDiscretValue(1, 3)) {
		case 1:
			return randomSpikes();
		case 2:
			return aggresiveCell("las agresivas");
		case 3:
			return pacificCell("las pacíficas");
		default:
			return null;
		}
	}
	
	/**
	 * Generates a new Spikes entity
	 * 
	 * @param coord Coordinates (object type) to place the spikes on the map
	 * @param dim Dimension (Entity type) for the height and the width of the spikes
	 * @return a new Spikes (Entity type)
	 */

	public Spikes getNewSpikes(Coordinates coord, Dimension dim) {
		Spikes spikes = new Spikes(coord, dim);

		if (automaticMapInsert)
			map.insertEntity(spikes);
		
		return spikes;
	}

	/**
	 * Generates a new Spikes (Entity type) with random coordinates and dimensions
	 * 
	 * @return a new Spikes (Entity type)
	 */
	
	public Spikes randomSpikes() {
		Dimension dimension = randomDimension(20, 50);
		Coordinates coordinates = randomCoordinates(dimension);
		Spikes spikes = new Spikes(coordinates, dimension);
		
		if (automaticMapInsert)
			map.insertEntity(spikes);
		
		return spikes;
	}
	
	/**
	 * Generates a new Cell (Entity type) that can damage other cells
	 * 
	 * @param cell_id String type to assign an identifier
	 * @return a new Cell (Entity type) 
	 */

	public Cell aggresiveCell(String cell_id) {
		Dimension dimension = randomDimension(20, 50);
		Coordinates coordinates = randomCoordinates(dimension);
		Statistics statistiscs = randomStatistics(8);
		Orientation orientation = randomOrientation();
		Cell cell = new Cell(coordinates, dimension, statistiscs, true, orientation);
		
		if (automaticMapInsert)
			map.insertEntity(cell);

		return cell;
	}
	
	/**
	 * Generates a new Cell (Entity type) that can't damage other cells
	 * 
	 * @param cell_id String type to assign an identifier
	 * @return a new Cell (Entity type) 
	 */

	public Cell pacificCell(String cell_id) {
		Dimension dimension = randomDimension(20, 50);
		Coordinates coordinates = randomCoordinates(dimension);
		Statistics statistiscs = randomStatistics(8);
		Orientation orientation = randomOrientation();

		Cell cell = new Cell(coordinates, dimension, statistiscs, false, orientation);

		return cell;
	}
	
	/**
	 * Generates a new Orientation (object type) 
	 * 
	 * @return an Orientation Enum type with a random value assigned (NORTH, SOUTH, EAST, WEST)
	 */

	private Orientation randomOrientation() {
		switch (Die.getDiscretValue(1, 4)) {
		case 1:
			return Orientation.NORTH;
		case 2:
			return Orientation.SOUTH;
		case 3:
			return Orientation.EAST;
		case 4:
			return Orientation.WEST;
		default:
			return Orientation.SOUTH;
		}
	}

	
	/**
	 * 
	 * @param maxValue maximum amount of statistics to apply to a Statistics object
	 * @return Statistics object with values randomly generated
	 */
	
	private Statistics randomStatistics(int maxValue) {
		return new Statistics(Die.getDiscretValue(1, maxValue), Die.getDiscretValue(1, maxValue),
				Die.getDiscretValue(1, maxValue), Die.getDiscretValue(1, maxValue));
	}
	
	/**
	 * 
	 * @param maxX maximum value for the width
	 * @param maxY maximum value for the height
	 * @return Dimension object with values randomly generated
	 */

	private Dimension randomDimension(int maxX, int maxY) {
		return new Dimension(Die.getDiscretValue(1, maxX), Die.getDiscretValue(1, maxY));
	}

	/**
	 * Generates random Coordinates
	 * 
	 * @param dimensionEntity Dimension (object type)
	 * @return Coordinates object with values randomly generated
	 */
	
	private Coordinates randomCoordinates(Dimension dimensionEntity) {
		return new Coordinates(Die.getDiscretValue(0, map.getDimension().getWidth() - dimensionEntity.getWidth()),
				Die.getDiscretValue(0, map.getDimension().getHeight() - dimensionEntity.getHeight()));
	}

	/**
	 * Processes the Game running status and it is pending if the program is stopped in execution to lock the resource
	 */
	
	@Override
	public void run() {
		System.out.println("...Estoy procesando el juego");
		synchronized (pauseLock) {
			while (!exit.get()) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				map.update();

				try {
					if (pause.get()) {
						synchronized (pauseLock) {
							System.out.println("Pausé el juego");
							pauseLock.wait();
						}
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("...Terminé de procesar el juego");
	}
	
	/**
	 * Generates a new Wall object
	 * 
	 * @param coord Coordinates (object type) where wall will be placed in map
	 * @param dim Dimension (object type) which height and width the wall will have
	 * @return A new Wall (object type)
	 */

	public Entity getNewWall(Coordinates coord, Dimension dim) {
		ImpenetrableWall wall = new ImpenetrableWall(coord, dim);
		
		if (automaticMapInsert)
			map.insertEntity(wall);
		
		return wall;
	}
	
	/**
	 * Generates a new MagicFood object
	 * 
	 * @param coordinates Coordinates object where the food will be placed in map 
	 * @param dimension Dimension (object type) which height and width the wall will have
	 * @return A new MagicFood (object type)
	 */

	public MagicFood getNewFood(Coordinates coordinates, Dimension dimension) {
		MagicFood magicFood = new MagicFood(coordinates, dimension);
		
		if (automaticMapInsert)
			map.insertEntity(magicFood);
		
		return magicFood;
	}
	
	/**
	 *  @param File received with a new map to be loaded
	 */

	public void spitMap(File f)
	{
		FileOutputStream fileOut;
		try {
			fileOut = new FileOutputStream(f);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(map);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		         
	}

	/**
	 * Indicates to the map where it has to delete all the entities around
	 * 
	 * @param coordinates Coordinates (object type) where to erase on the map
	 */

	public void deleteIn(Coordinates coordinates) {
		DetectionRange dr = new DetectionRange(coordinates, new Dimension(1,1));
		map.delete(map.getEntitiesIn(dr));
	}
	
	/**
	 * Which entities in the map are around the coordinates received
	 * 
	 * @param coordinates Coordinates (object type) to search on the map 
	 * @return A list of entities near the coordinates received
	 */
	
	public List<Entity> getEntitiesIn(Coordinates coordinates)
	{
		DetectionRange dr = new DetectionRange(coordinates, new Dimension(1,1));
		return map.getEntitiesIn(dr);
	}
	
	/**
	 * Search for cells present at a map coordinates
	 * 
	 * @param coordinates Coordinates (object type) to search on the map 
	 * @return An Optional filled with a cell if there were a value, if not is empty
	 */

	public Optional<Cell> getCellIn(Coordinates coordinates) {
		DetectionRange dr = new DetectionRange(coordinates, new Dimension(1,1));
		List<Actor> actors = map.getActorsIn(dr);
		
		for (Actor a : actors)
		{
			if (a.getEntityType() == EntityFinalType.CELL)
				return Optional.of((Cell)a);
		}
		
		return Optional.empty();
	}

	public void loadMap(File binMap) {
		try {
			FileInputStream in = new FileInputStream(binMap);
			ObjectInputStream oin = new ObjectInputStream(in);
			map = (Map) oin.readObject();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
