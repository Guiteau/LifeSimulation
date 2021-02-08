package dad.lifesimulation.main.entities.actor;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;

public class CellAdapter {
	private ObjectProperty<JohnDoe> johndoe_property;
	private IntegerProperty x;
	private IntegerProperty y;
	private IntegerProperty w;
	private IntegerProperty h;
	
	
	
	public void loadCell(JohnDoe cell)
	{
		johndoe_property.set(cell);
		johndoe_property.addListener((o, ov, nv) ->{
			System.out.println(nv.getCoordinates());
		});
	}
}
