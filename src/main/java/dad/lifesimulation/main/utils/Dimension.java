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

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int _width) {
		this.width = _width;
	}

}
