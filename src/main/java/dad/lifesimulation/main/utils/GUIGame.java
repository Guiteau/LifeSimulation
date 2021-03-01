package dad.lifesimulation.main.utils;


import dad.lifesimulation.main.draw.DrawableFactory;
import javafx.animation.AnimationTimer;

public class GUIGame extends AnimationTimer {

	DrawableFactory levelGUI_creator;
	
	/**
	 * Constructor.
	 * 
	 * @param levelGUI_creator
	 */

	public GUIGame(DrawableFactory levelGUI_creator) {
		this.levelGUI_creator = levelGUI_creator;
		
	}
	
	/**
	 * Renders the DrawableFactory (object type)
	 */
	
	@Override
	public void handle(long now) {
		levelGUI_creator.render();
	}

	

}
