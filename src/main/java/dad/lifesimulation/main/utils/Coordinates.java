package dad.lifesimulation.main.utils;

public class Coordinates implements Comparable<Coordinates> {
	private int X;
	private int Y;

	public Coordinates(int _posX, int _posY) {
		this.Y = _posY;
		this.X = _posX;
	}

	/**
	 * 
	 * @return valor de coordenada X
	 */

	public int getX() {
		return X;
	}

	/**
	 * 
	 * @return valor de coordenada Y
	 */

	public int getY() {
		return Y;
	}

	/**
	 * 
	 * @param x valor de coordenada X
	 */

	public void setX(int x) {
		X = x;
	}

	/**
	 * 
	 * @param y valor de coordenada Y
	 */

	public void setY(int y) {
		Y = y;
	}

	/**
	 * @param otherCoordinate objeto coordenadas
	 * @return 1 si los valores de la coordenada X,Y coinciden, 0 si no coinciden
	 */

	@Override
	public int compareTo(Coordinates otherCoordinate) {
		return this.X == otherCoordinate.X && this.Y == otherCoordinate.Y ? 1 : 0;
	}

	/**
	 * metodo que recibe dos parametros y los suma a  los valores X e Y
	 * 
	 * @param _addX (int) valor entero para sumar al atributo this.X
	 * @param _addY (int) valor entero para sumar al atributo this.Y
	 * @return (Object type Coordinates) devuelve un nuevo objeto
	 */
	public Coordinates addToCoordinates(int _addX, int _addY) {
		return new Coordinates(this.X += _addX,this.Y += _addY);
	}
	@Override
	public String toString() {
		return "X=|"+this.getX()+"|"+"Y=|"+this.getY();
		
	}

}
