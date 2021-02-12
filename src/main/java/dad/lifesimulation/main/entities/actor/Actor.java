package dad.lifesimulation.main.entities.actor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import dad.lifesimulation.main.entities.Entity;
import dad.lifesimulation.main.utils.Coordinates;
import dad.lifesimulation.main.utils.Die;
import dad.lifesimulation.main.utils.Dimension;
import dad.lifesimulation.main.utils.Statistics;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Actor extends Entity {

	protected Statistics statistics;
	protected Orientation orientation;
	protected Boolean hostilToOthers;
	protected DetectionRange detectionRangeNorth;
	protected DetectionRange detectionRangeSouth;
	protected DetectionRange detectionRangeWest;
	protected DetectionRange detectionRangeEast;
	protected List<DetectionRange> detectionRangeList;
	protected Color color;
	

	public Actor(Coordinates _coordinates, Dimension _dimension, Statistics _statistics, Boolean hostilToOthers,
			Orientation _orientation, Color color) {
		super(_coordinates, _dimension, false);
		this.statistics = _statistics;
		this.hostilToOthers = hostilToOthers;
		this.drawable = true;
		this.orientation = _orientation;
		detectionRangeList = new ArrayList<>();
		generateDetectionRange();
		this.color = color;
	}

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
	 * @return objeto de tipo estadísticas de la entidad Actor(contiene atributos
	 *         con valores enteros)
	 */

	public Statistics getStatistics() {
		return statistics;
	}

	/**
	 * 
	 * */

	protected void randomMove() {
		List<Orientation> availableOrientations = freeOrientation();
		if (!availableOrientations.isEmpty()) {
			move(availableOrientations.get(Die.getDiscretValue(0, availableOrientations.size())));

		}

	}

	private List<Orientation> freeOrientation() {
		List<Orientation> freeDirections = new ArrayList<>();

		if (map.getEntitiesIn(this.detectionRangeNorth).isEmpty())
			freeDirections.add(Orientation.NORTH);
		if (map.getEntitiesIn(this.detectionRangeSouth).isEmpty())
			freeDirections.add(Orientation.SOUTH);
		if (map.getEntitiesIn(this.detectionRangeEast).isEmpty())
			freeDirections.add(Orientation.EAST);
		if (map.getEntitiesIn(this.detectionRangeWest).isEmpty())
			freeDirections.add(Orientation.WEST);

		return freeDirections;
	}

	private void move(Orientation _orientation) {

		switch (_orientation) {
		case NORTH:
			this.detectionRangeList.stream().forEach(e -> {
				e.getCoordinates().addToCoordinates(0, -1);
			});
			this.coordinates.addToCoordinates(0, 1);
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

	public Orientation getOrientation() {
		return orientation;
	}
	
	@Override
	public void render(GraphicsContext gc) {
		gc.setFill(this.color);
		gc.setStroke(Color.BLACK);

		gc.fillRect(coordinates.getX(), coordinates.getY(), dimension.getWidth(), dimension.getHeight());
	}


}
