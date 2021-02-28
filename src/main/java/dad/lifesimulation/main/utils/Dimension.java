package dad.lifesimulation.main.utils;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Dimension {
	private int height;
	private int width;

	private PropertyChangeSupport support;
	
	public Dimension(int _width, int _height) {
		this.height = _height;
		this.width = _width;
		support = new PropertyChangeSupport(this);
	}

	public Dimension() {
		this.height = 1;
		this.width = 1;
		support = new PropertyChangeSupport(this);
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
		int oldHeight = this.height; 
		this.height = height;
		support.firePropertyChange("height", oldHeight, height);
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
	
	public void setWidth(int width) {
		int oldWidth = this.width; 
		this.width = width;
		support.firePropertyChange("width", oldWidth, width);
	}
	
	public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }
    public String toString() {
    	return "Width = "+this.width+" Height = "+this.height;
    }
}
