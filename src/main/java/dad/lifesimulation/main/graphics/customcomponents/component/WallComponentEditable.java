package dad.lifesimulation.main.graphics.customcomponents.component;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class WallComponentEditable extends EmptyComponent {
	
    @FXML
    private GridPane wallComponentEditable;

    @FXML
    private TextField textFieldTangible, textFieldCoordinates, textFieldDimensions;

    
	public GridPane getWallComponentEditable() {
		return wallComponentEditable;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	public WallComponentEditable() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/wallComponentEditable.fxml"));
			loader.setRoot(this);
			loader.setController(this);
			loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void displayData() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void loadData() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changeView(GridPane _view) {
		// TODO Auto-generated method stub
		
	}

}
