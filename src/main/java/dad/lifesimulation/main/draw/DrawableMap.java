package dad.lifesimulation.main.draw;

import java.util.ArrayList;
import java.util.List;

import dad.lifesimulation.main.world.maps.Map;

public class DrawableMap {
	private List<DrawableEntity> drawableEntities;
	
	public DrawableMap(Map map) {
		map.getDrawableEntities().stream().forEach(e->drawableEntities.add(new DrawableEntity(e)));
	}
}
