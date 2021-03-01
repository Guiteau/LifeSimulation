package dad.lifesimulation.main.utils;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;

public class Coordinates implements Comparable<Coordinates>, Serializable{
	private int X;
	private int Y;
	
	private PropertyChangeSupport support;
	
	/**
	 * Constructor.
	 */
	
	public Coordinates() {
		this.Y = 0;
		this.X = 0;
		support = new PropertyChangeSupport(this);
	}
	
	/**
	 * Constructor.
	 * 
	 * @param _posX
	 * @param _posY
	 */
	
	public Coordinates(int _posX, int _posY) {
		this.Y = _posY;
		this.X = _posX;
		support = new PropertyChangeSupport(this);
	}

	/**
	 * 
	 * @return value of the X coordinate
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
	 * @return value of the coordinate Y
	 */

	public int getY() {
		return Y;
	}

	/**
	 * 
	 * @param coordinate X to set (int value)
	 */

	public void setX(int X) {
		int oldX = this.X;
		this.X = X;
		support.firePropertyChange("X", oldX, X);
	}

	/**
	 * 
	 * @param y coordinate Y to set (int value)
	 */

	public void setY(int Y) {
		int oldY = this.Y;
		this.Y = Y;
		support.firePropertyChange("Y", oldY, Y);
	}

	/**
	 * @param otherCoordinate Coordinates (object type)
	 * @return 1 if the values of coordinate X and Y matches, 0 if not 
	 */

	@Override
	public int compareTo(Coordinates otherCoordinate) {
		return this.X == otherCoordinate.X && this.Y == otherCoordinate.Y ? 1 : 0;
	}

	/**
	 * metodo que recibe dos parametros y los suma a  los valores X e Y
	 * 
	 * @param _addX coordinate X to set (int value)
	 * @param _addY coordinate Y to set (int value)
	 */
	public void addToCoordinates(int _addX, int _addY) {
		this.setX(this.getX()+_addX);
		this.setY(this.getY()+_addY);
	}
	
	/**
	 * Adds a new PropertyChangeListener to the initial PropertyChangeListener
	 * 
	 * @param listener PropertyChangeListener to be added
	 */

	public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

	/**
	 * Removes a PropertyChangeListener present in the initial PropertyChangeListener
	 * 
	 * @param listener PropertyChangeListener to be removed
	 */
	
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }

}
