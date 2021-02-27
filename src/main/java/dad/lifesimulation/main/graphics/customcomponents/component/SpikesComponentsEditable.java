package dad.lifesimulation.main.graphics.customcomponents.component;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class SpikesComponentsEditable extends EmptyComponent{

    @FXML
    private GridPane spikesComponentEditable;

    @FXML
    private TextField textFieldDamage, textFieldCoordinates, textFieldDimensions;

	public GridPane getSpikesComponentEditable() {
		return spikesComponentEditable;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	public SpikesComponentsEditable() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/spikesComponentEditable.fxml"));
			loader.setRoot(this);
			loader.setController(this);
			loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	protected void loadData() {};
	@Override
	protected void displayData() {}

	

    
}
