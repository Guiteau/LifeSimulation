package dad.lifesimulation.main.utils;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Coordinates implements Comparable<Coordinates> {
	private int X;
	private int Y;
	
	private PropertyChangeSupport support;
	public Coordinates() {
		this.Y = 0;
		this.X = 0;
		support = new PropertyChangeSupport(this);
	}
	public Coordinates(int _posX, int _posY) {
		this.Y = _posY;
		this.X = _posX;
		support = new PropertyChangeSupport(this);
	}

	/**
	 * 
	 * @return valor de coordenada X
	 */

	public int getX() {
		return X;
	}
	
	@Override
	public String toString() {
		return "Coordinates [X=" + X + ", Y=" + Y + "]";
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

	public void setX(int X) {
		int oldX = this.X;
		this.X = X;
		support.firePropertyChange("X", oldX, X);
	}

	/**
	 * 
	 * @param y valor de coordenada Y
	 */

	public void setY(int Y) {
		int oldY = this.Y;
		this.Y = Y;
		support.firePropertyChange("Y", oldY, Y);
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
	 */
	public void addToCoordinates(int _addX, int _addY) {
		this.setX(this.getX()+_addX);
		this.setY(this.getY()+_addY);
	}

	public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }

}
