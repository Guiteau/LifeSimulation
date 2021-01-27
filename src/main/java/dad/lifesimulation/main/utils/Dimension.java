package dad.lifesimulation.main.utils;

public class Dimension {
	private int height;
	private int width;

	public Dimension(int _height, int _width) {
		this.height = _height;
		this.width = _width;
	}

	public Dimension() {
		this.height = 1;
		this.width = 1;
	}
	
	/**
	 * 
	 * @return altura de un objeto
	 */

	public int getHeight() {
		return height;
	}
	
	/**
	 * 
	 * @param height altura a establecer en un objeto
	 */

	public void setHeight(int height) {
		this.height = height;
	}
	
	/**
	 * 
	 * @return anchura de un objeto
	 */

	public int getWidth() {
		return width;
	}

	/**
	 * 
	 * @param _width anchura a establecer en un objeto
	 */
	
	public void setWidth(int _width) {
		this.width = _width;
	}

}
