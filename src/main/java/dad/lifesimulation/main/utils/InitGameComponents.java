package dad.lifesimulation.main.utils;

import java.util.List;

import dad.lifesimulation.main.entities.Entity;
import dad.lifesimulation.main.entities.actor.Actor;
import dad.lifesimulation.main.entities.actor.Cell;
import dad.lifesimulation.main.entities.actor.Orientation;
import dad.lifesimulation.main.entities.element.harmful.Spikes;
import dad.lifesimulation.main.world.maps.Map;

public class InitGameComponents extends GameFunctions {

	private Map map;

	public InitGameComponents(Dimension dim) {
		map = new Map();
		map.setDimension(dim);
	}

	public Map generateRandomMap(int n_elements) {

		for (int i = 0; i < n_elements; i++)
		{
			switch (Die.getDiscretValue(1, 3)) {
			case 1:
				map.insertEntity(randomSpikes());
				break;
			case 2:
				map.insertEntity((Actor)aggresiveCell("las agresivas"));
				break;
			case 3:
				map.insertEntity((Actor)pacificCell("las pacíficas"));
				break;
			default:
				
			}
		}

		return map;
	}

	public void clearMap() {
		map.clear();
	}

	public List<Entity> getAllEntities() {
		return map.getAllEntities();
	}

	public Cell getNewCell(Coordinates coord, Dimension dim, Statistics stats, boolean hostil) {
		Cell cell = new Cell(coord, dim, stats, hostil, Orientation.SOUTH);
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

		// map.insertEntity(spikes);

		return spikes;
	}

	public Spikes randomSpikes() {
		Dimension dimension = randomDimension(10, 10);
		Coordinates coordinates = randomCoordinates(dimension);
		Spikes spikes = new Spikes(coordinates, dimension);
		return spikes;
	}



	public Cell aggresiveCell(String cell_id) {
		Dimension dimension = randomDimension(3, 3);
		Coordinates coordinates = randomCoordinates(dimension);
		Statistics statistiscs = randomStatistics(8);
		Orientation orientation = randomOrientation();
		Cell cell = new Cell(coordinates, dimension, statistiscs, true, orientation);

		// map.insertEntity(cell);
		return cell;
	}

	public Cell pacificCell(String cell_id) {
		Dimension dimension = randomDimension(3, 3);
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
					Thread.sleep(500);
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
}
