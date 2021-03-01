package dad.lifesimulation.main.entities.actor;

import java.util.ArrayList;
import java.util.List;

import dad.lifesimulation.main.entities.Entity;
import dad.lifesimulation.main.entities.EntityFinalType;
import dad.lifesimulation.main.entities.element.Floor;
import dad.lifesimulation.main.utils.Coordinates;
import dad.lifesimulation.main.utils.Die;
import dad.lifesimulation.main.utils.Dimension;
import dad.lifesimulation.main.utils.Statistics;

public abstract class Actor extends Entity {

	protected Statistics statistics;
	protected Orientation orientation;
	protected Boolean hostilToOthers;
	protected DetectionRange detectionRangeNorth;
	protected DetectionRange detectionRangeSouth;
	protected DetectionRange detectionRangeWest;
	protected DetectionRange detectionRangeEast;
	protected List<DetectionRange> detectionRangeList;	
	
	/**
	 * Constructor.
	 * @param _coordinates
	 * @param _dimension
	 * @param _statistics
	 * @param hostilToOthers
	 * @param _orientation
	 */

	public Actor(Coordinates _coordinates, Dimension _dimension, Statistics _statistics, Boolean hostilToOthers,
			Orientation _orientation) {
		super(_coordinates, _dimension, false);
		this.statistics = _statistics;
		this.hostilToOthers = hostilToOthers;
		this.orientation = _orientation;
		detectionRangeList = new ArrayList<>();
		generateDetectionRange();
	}
	
	/**
	 * 
	 * @return true if Actor (Entity) can damage other entities
	 */
	
	public boolean isHostile()
	{
		return hostilToOthers;
	}
	
	/**
	 * set DetectionRange (object) for north, south, west and east orientation
	 */

	private void generateDetectionRange() {
		// North
		detectionRangeNorth = new DetectionRange(
				new Coordinates(this.getCoordinates().getX(), this.getCoordinates().getY() - 1),
				new Dimension(this.getDimension().getWidth(), 1));
		// south
		detectionRangeSouth = new DetectionRange(
				new Coordinates(this.getCoordinates().getX(),
						this.getCoordinates().getY() + this.dimension.getHeight()),
				new Dimension(this.getDimension().getWidth(), 1));
		// west
		detectionRangeWest = new DetectionRange(
				new Coordinates(this.getCoordinates().getX() - 1, this.getCoordinates().getY()),
				new Dimension(1, this.getDimension().getHeight()));

		// east
		detectionRangeEast = new DetectionRange(
				new Coordinates(this.getCoordinates().getX() + this.getDimension().getWidth() + 1,
						this.getCoordinates().getY()),
				new Dimension(1, this.getDimension().getHeight()));

		this.detectionRangeList.add(detectionRangeNorth);
		this.detectionRangeList.add(detectionRangeSouth);
		this.detectionRangeList.add(detectionRangeEast);
		this.detectionRangeList.add(detectionRangeWest);
	}

	/**
	 * 
	 * @return Statistics (object) of the Actor (object) entity. Int values. 
	 */

	public Statistics getStatistics() {
		return statistics;
	}

	/**
	 * The Actor (object) to any free location on the map
	 */

	protected void randomMove() {
		List<Orientation> availablePlaces = freePlaces();
		if (!availablePlaces.isEmpty()) {
			move(availablePlaces.get(Die.getDiscretValue(0, availablePlaces.size() - 1)));
		}

	}
	
	/**
	 * 
	 * @return the free locations around the Actor (object)
	 */

	private List<Orientation> freePlaces() {
		List<Orientation> freeDirections = new ArrayList<>();

		if (map.getImpenetrableEntities(this.detectionRangeNorth).isEmpty())
			freeDirections.add(Orientation.NORTH);
		if (map.getImpenetrableEntities(this.detectionRangeSouth).isEmpty())
			freeDirections.add(Orientation.SOUTH);
		if (map.getImpenetrableEntities(this.detectionRangeEast).isEmpty())
			freeDirections.add(Orientation.EAST);
		if (map.getImpenetrableEntities(this.detectionRangeWest).isEmpty())
			freeDirections.add(Orientation.WEST);
		
		return freeDirections;
	}

	/**
	 * Actor can move to north, south, west or east direction
	 * 
	 * @param _orientation to indicate Actor where to moves
	 */
	
	private void move(Orientation _orientation) {

		switch (_orientation) {
		case NORTH:
			this.detectionRangeList.stream().forEach(e -> {
				e.getCoordinates().addToCoordinates(0, -1);
			});
			this.coordinates.addToCoordinates(0, -1);
			break;
		case SOUTH:
			this.detectionRangeList.stream().forEach(e -> {
				e.getCoordinates().addToCoordinates(0, 1);
			});
			this.coordinates.addToCoordinates(0, 1);

			break;
		case EAST:
			this.detectionRangeList.stream().forEach(e -> {
				e.getCoordinates().addToCoordinates(1, 0);
			});
			this.coordinates.addToCoordinates(1, 0);
			break;
		case WEST:
			this.detectionRangeList.stream().forEach(e -> {
				e.getCoordinates().addToCoordinates(-1, 0);
			});
			this.coordinates.addToCoordinates(-1, 0);
			break;
		default:
			break;
		}

	}

	/**
	 * 
	 * @return Orientation (object)
	 */
	
	public Orientation getOrientation() {
		return orientation;
	}
	
	/**
	 * 
	 * @param floors list of Floor (object) to interact with the Actor
	 */
	
	protected void stepOnFloor(List<Floor> floors)
	{		
		floors.stream().forEach(f->f.interact(this));
	}
	



	protected void stepOnActors(List<Actor> actors)
	{
		actors.stream().forEach(a->this.interact(a));
	}

  /**
	 * Update the movement of the Actor (object), step on the floor and is removed if health is equals zero
	 * 
	 */

	@Override
	public void update() {
		randomMove();
		
		stepOnFloor(map.getFloorsIn(this));
		
		stepOnActors(map.getActorsIn(this));
		
		if (statistics.getHealth() < 0)
			deletable = true;
	}

}
