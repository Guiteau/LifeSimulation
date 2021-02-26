package dad.lifesimulation.main.graphics.customcomponents.component;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;

public abstract class abstractComponent extends GridPane implements Initializable {

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	abstract void displayData();
	
	abstract void loadData();
	
	abstract void changeView(GridPane _view);
	
}
