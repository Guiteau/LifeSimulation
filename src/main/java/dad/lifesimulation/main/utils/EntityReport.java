package dad.lifesimulation.main.utils;

import dad.lifesimulation.main.entities.EntityFinalType;

public class EntityReport {
	
	private String coordinate_x;
	private String coordinate_y;
	private boolean tangible;
	private int width;
	private int height;
	private EntityFinalType type;
	
	public EntityReport(String coordinate_x, String coordinate_y, boolean tangible, int width, int height,
			EntityFinalType type) {
		super();
		this.coordinate_x = "[X] " + coordinate_x;
		this.coordinate_y = "[Y] " + coordinate_y;
		this.tangible = tangible;
		this.width = width;
		this.height = height;
		this.type = type;
	}
	public String getCoordinate_x() {
		return coordinate_x;
	}
	public void setCoordinate_x(String coordinate_x) {
		this.coordinate_x = coordinate_x;
	}
	public String getCoordinate_y() {
		return coordinate_y;
	}
	public void setCoordinate_y(String coordinate_y) {
		this.coordinate_y = coordinate_y;
	}
	public boolean isTangible() {
		return tangible;
	}
	public void setTangible(boolean tangible) {
		this.tangible = tangible;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public EntityFinalType getType() {
		return type;
	}
	public void setType(EntityFinalType type) {
		this.type = type;
	}
	
}
