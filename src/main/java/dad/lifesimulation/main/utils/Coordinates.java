package dad.lifesimulation.main.utils;

public class Coordinates implements Comparable<Coordinates> {
	private int X;
	private int Y;

	Coordinates(int _posX, int _posY) {
		this.Y = _posY;
		this.X = _posX;
	}

	public int getX() {
		return X;
	}

	public int getY() {
		return Y;
	}

	public void setX(int x) {
		X = x;
	}

	public void setY(int y) {
		Y = y;
	}

	@Override
	public int compareTo(Coordinates otherCoordinate) {
		return this.X == otherCoordinate.X && this.Y == otherCoordinate.Y ? 1 : 0;
	}

}
