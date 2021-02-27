package dad.lifesimulation.main.graphics.customcomponents.component;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class StatisticComponentEditable extends EmptyComponent {

	@FXML
	private GridPane view;

	@FXML
	private TextField healthInput;

	@FXML
	private TextField armorInput;

	@FXML
	private TextField energyInput;

	@FXML
	private ComboBox<?> cbCellTypeInput;

	@FXML
	private TextField heightDimensionInput;

	@FXML
	private TextField widthDimensionInput;

	@FXML
	private TextField xCoordinateInput;

	@FXML
	private TextField yCoordinateInput;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	public StatisticComponentEditable() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/statisticViewEditableVersion.fxml"));
			loader.setRoot(this);
			loader.setController(this);
			loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void loadData() {

	}

	@Override
	protected void displayData() {

	}
	
}
