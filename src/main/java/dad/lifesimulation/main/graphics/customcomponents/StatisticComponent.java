package dad.lifesimulation.main.graphics.customcomponents;

import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class StatisticComponent extends GridPane implements Initializable{
	@FXML
	private TextField tfCellType;

	@FXML
	private TextField tfHealthPoints;

	@FXML
	private TextField tfArmor;

	@FXML
	private TextField tfEnergy;

	@FXML
	private TextField tfCensus;

	public StatisticComponent() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/statisticView.fxml"));
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
	
}
