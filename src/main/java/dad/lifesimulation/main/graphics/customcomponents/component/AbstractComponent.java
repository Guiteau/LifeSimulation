package dad.lifesimulation.main.graphics.customcomponents.component;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;

public abstract class AbstractComponent extends GridPane implements Initializable {

	
	
	
	abstract void displayData();
	
	abstract void loadData();
	
	
	
}
