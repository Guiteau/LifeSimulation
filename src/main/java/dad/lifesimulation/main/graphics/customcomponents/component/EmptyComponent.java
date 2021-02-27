package dad.lifesimulation.main.graphics.customcomponents.component;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;

public class EmptyComponent extends AbstractComponent {
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}
	
	public EmptyComponent() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/BaseComponentView.fxml"));
			loader.setRoot(this);
			loader.setController(this);
			loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public GridPane getView() {
		return this;
	}

	@Override
	protected void loadData() {
	};

	@Override
	protected void displayData() {
	}
	

	

}
