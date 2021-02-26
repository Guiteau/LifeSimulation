package dad.lifesimulation.main.graphics.customcomponents.component;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class EditionMenuComponent extends EmptyComponent {
	
    @FXML
    private GridPane editionMenuView;

    @FXML
    private Button buttonCell, buttonSpikes, buttonWall, buttonFood, buttonDelete;

	public EditionMenuComponent() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/editionMenuComponent.fxml"));
			loader.setRoot(this);
			loader.setController(this);
			loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}
	
	
	public GridPane getEditionMenuView() {
		return editionMenuView;
	}

	@Override
	protected void loadData() {};
	@Override
	protected void displayData() {}
	
	@Override
	void changeView() {
		// TODO Auto-generated method stub
		
	};
	
    @FXML
    void onButtonCellAction(ActionEvent event) {

    }

    @FXML
    void onButtonDeleteAction(ActionEvent event) {

    }

    @FXML
    void onButtonFoodAction(ActionEvent event) {

    }

    @FXML
    void onButtonSpikesAction(ActionEvent event) {

    }

    @FXML
    void onButtonWallAction(ActionEvent event) {

    }
}
