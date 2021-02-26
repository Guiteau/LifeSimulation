package dad.lifesimulation.main.graphics.customcomponents.component;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class MagicFoodEditableVerison extends emptyComponent {

	@FXML
	private GridPane view;

	@FXML
	private TextField healthTF;

	@FXML
	private TextField armorTF;

	@FXML
	private TextField energyTF;

	public MagicFoodEditableVerison() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MagicFoodEditableVersion.fxml"));
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
