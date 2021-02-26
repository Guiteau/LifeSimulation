package dad.lifesimulation.main.graphics.customcomponents.component;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class MagicFoodComponent extends emptyComponent {

    @FXML
    private GridPane view;

    @FXML
    private Label lbHealth;

    @FXML
    private Label lbArmor;

    @FXML
    private Label lbEnergy;
    
    public MagicFoodComponent() {
    	try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MagicFoodView.fxml"));
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
    	
    }
}
