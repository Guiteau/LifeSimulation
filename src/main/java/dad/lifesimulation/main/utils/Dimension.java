package dad.lifesimulation.main.utils;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;

public class Dimension implements Serializable {
	private int height;
	private int width;

	private PropertyChangeSupport support;
	
	/**
	 * Constructor
	 * @param _width
	 * @param _height
	 */
	
	public Dimension(int _width, int _height) {
		this.height = _height;
		this.width = _width;
		support = new PropertyChangeSupport(this);
	}

	/**
	 * Constructor.
	 */
	
	public Dimension() {
		this.height = 1;
		this.width = 1;
		support = new PropertyChangeSupport(this);
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
		int oldHeight = this.height; 
		this.height = height;
		support.firePropertyChange("height", oldHeight, height);
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
	 * @param _width width to set (int value)
	 */
	
	public void setWidth(int width) {
		int oldWidth = this.width; 
		this.width = width;
		support.firePropertyChange("width", oldWidth, width);
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
    
    /**
     * @return an String with the width and the height
     */
    
    public String toString() {
    	return "Width = "+this.width+" Height = "+this.height;
    }
}
