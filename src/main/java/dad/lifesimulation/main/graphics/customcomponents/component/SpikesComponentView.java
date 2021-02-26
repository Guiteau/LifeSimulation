package dad.lifesimulation.main.graphics.customcomponents.component;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class SpikesComponentView extends EmptyComponent {

    @FXML
    private GridPane spikesComponentView;

    @FXML
    private Label labelSetDamage, labelSetCoordinates, labelSetDimensions;
    
    public GridPane getSpikesComponentView() {
		return spikesComponentView;
	}

	public SpikesComponentView() {
		
    	try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/spikesComponentView.fxml"));
			loader.setRoot(this);
			loader.setController(this);
			loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
	}
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}
    
	
	@Override
	protected void loadData() {};
	@Override
	protected void displayData() {}

	@Override
	void changeView() {
		
	};
	
}
