package dad.lifesimulation.main.utils;

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

	public InitGameComponents(Dimension dim) {
		map = new Map();
		map.setDimension(dim);
		automaticMapInsert = false;
	}
	
	public void setAutomaticMapInsert(boolean automaticMapInsert)
	{
		this.automaticMapInsert = automaticMapInsert;
	}

	public void generateSimpleMap() {
		map.insertEntity(getNewWall(new Coordinates(47, 29), new Dimension(307, 55)));
		map.insertEntity(getNewWall(new Coordinates(34, 11), new Dimension(52, 209)));
		map.insertEntity(getNewWall(new Coordinates(54,250), new Dimension(212, 35)));
		map.insertEntity(getNewWall(new Coordinates(90, 235), new Dimension(37, 152)));
		map.insertEntity(getNewCell(new Coordinates(120, 100), new Dimension(100, 100), randomStatistics(8), false));
	}

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

	public void clearMap() {
		map.clear();
	}

	public List<Entity> getAllEntities() {
		return map.getAllEntities();
	}

	public Cell getNewCell(Coordinates coord, Dimension dim, Statistics stats, boolean hostil) {
		Cell cell = new Cell(coord, dim, stats, hostil, Orientation.SOUTH);
		if (automaticMapInsert)
			map.insertEntity(cell);
		return cell;
	}
	
	public Cell getNewCell(Coordinates coord, Dimension dim, boolean hostil) {
		Cell cell = new Cell(coord, dim, randomStatistics(8), hostil, Orientation.SOUTH);
		if (automaticMapInsert)
			map.insertEntity(cell);
		return cell;
	}

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

	public Spikes getNewSpikes(Coordinates coord, Dimension dim) {
		Spikes spikes = new Spikes(coord, dim);

		if (automaticMapInsert)
			map.insertEntity(spikes);
		
		return spikes;
	}

	public Spikes randomSpikes() {
		Dimension dimension = randomDimension(20, 50);
		Coordinates coordinates = randomCoordinates(dimension);
		Spikes spikes = new Spikes(coordinates, dimension);
		
		if (automaticMapInsert)
			map.insertEntity(spikes);
		
		return spikes;
	}

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

	public Cell pacificCell(String cell_id) {
		Dimension dimension = randomDimension(20, 50);
		Coordinates coordinates = randomCoordinates(dimension);
		Statistics statistiscs = randomStatistics(8);
		Orientation orientation = randomOrientation();

		Cell cell = new Cell(coordinates, dimension, statistiscs, false, orientation);

		return cell;
	}

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

	private Statistics randomStatistics(int maxValue) {
		return new Statistics(Die.getDiscretValue(1, maxValue), Die.getDiscretValue(1, maxValue),
				Die.getDiscretValue(1, maxValue), Die.getDiscretValue(1, maxValue));
	}

	private Dimension randomDimension(int maxX, int maxY) {
		return new Dimension(Die.getDiscretValue(1, maxX), Die.getDiscretValue(1, maxY));
	}

	private Coordinates randomCoordinates(Dimension dimensionEntity) {
		return new Coordinates(Die.getDiscretValue(0, map.getDimension().getWidth() - dimensionEntity.getWidth()),
				Die.getDiscretValue(0, map.getDimension().getHeight() - dimensionEntity.getHeight()));
	}

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

	public Entity getNewWall(Coordinates coord, Dimension dim) {
		ImpenetrableWall wall = new ImpenetrableWall(coord, dim);
		
		if (automaticMapInsert)
			map.insertEntity(wall);
		
		return wall;
	}

	public MagicFood getNewFood(Coordinates coordinates, Dimension dimension) {
		MagicFood magicFood = new MagicFood(coordinates, dimension);
		
		if (automaticMapInsert)
			map.insertEntity(magicFood);
		
		return magicFood;
	}

	public void deleteIn(Coordinates coordinates) {
		DetectionRange dr = new DetectionRange(coordinates, new Dimension(1,1));
		map.delete(map.getEntitiesIn(dr));
	}
	
	public List<Entity> getEntitiesIn(Coordinates coordinates)
	{
		DetectionRange dr = new DetectionRange(coordinates, new Dimension(1,1));
		return map.getEntitiesIn(dr);
	}

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
}
