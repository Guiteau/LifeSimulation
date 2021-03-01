package dad.lifesimulation.main.utils;

import dad.lifesimulation.main.entities.EntityFinalType;

public class EntityReport {
	
	private String coordinate_x;
	private String coordinate_y;
	private boolean tangible;
	private int width;
	private int height;
	private EntityFinalType type;
	
	/**
	 * Constructor.
	 * 
	 * @param coordinate_x
	 * @param coordinate_y
	 * @param tangible
	 * @param width
	 * @param height
	 * @param type
	 */
	
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
	
	/**
	 * 
	 * @return current X value (int value)
	 */
	
	public String getCoordinate_x() {
		return coordinate_x;
	}
	
	/**
	 * 
	 * @param coordinate_x coordinate X to set (int value)
	 */
	
	public void setCoordinate_x(String coordinate_x) {
		this.coordinate_x = coordinate_x;
	}
	
	/**
	 * 
	 * @return current Y value (int value)
	 */
	
	public String getCoordinate_y() {
		return coordinate_y;
	}
	
	/**
	 * 
	 * @param coordinate_y coordinate Y to set (int value)
	 */
	
	public void setCoordinate_y(String coordinate_y) {
		this.coordinate_y = coordinate_y;
	}
	
	/**
	 *
	 * @return true if the Entity (object type) can be crossable
	 */
	
	public boolean isTangible() {
		return tangible;
	}
	
	/**
	 * 
	 * @param tangible tangible to set (true or false)
	 */
	
	public void setTangible(boolean tangible) {
		this.tangible = tangible;
	}
	
	/**
	 * 
	 * @return current width (int value)
	 */
	
	public int getWidth() {
		return width;
	}
	
	/**
	 * 
	 * @param width width to set (int value)
	 */
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	/**
	 * 
	 * @return current height (int value)
	 */

	
	public int getHeight() {
		return height;
	}
	
	/**
	 * 
	 * @param height height to set (int value)
	 */	
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	/**
	 * 
	 * @return entity type (CELL, SPIKE, WALL, FOOD or UNKNOWN) 
	 */
	
	public EntityFinalType getType() {
		return type;
	}
	
	/**
	 * 
	 * @param type to set (CELL, SPIKE, WALL, FOOD or UNKNOWN)
	 */
	
	public void setType(EntityFinalType type) {
		this.type = type;
	}
	
}
