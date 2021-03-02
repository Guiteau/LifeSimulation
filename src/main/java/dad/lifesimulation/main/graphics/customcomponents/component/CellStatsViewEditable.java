package dad.lifesimulation.main.graphics.customcomponents.component;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class CellStatsViewEditable extends GridPane implements Initializable {

	@FXML
	private CheckBox cellTypeCHB;

	@FXML
	private TextField healthPointsTF;

	@FXML
	private TextField energyPointsTF;

	@FXML
	private TextField armorPointsTF;
	
	@FXML
	private TextField damagePointsTF;

	@FXML
	private TextField widthTF;

	@FXML
	private TextField heightTF;
	
	/**
	 * 
	 * @param location the path location
	 * @param resources a resource from the project
	 */

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	/**
	 * Constructor.
	 * Loads the CellStatsViewEditable.fxml
	 */
	
	public CellStatsViewEditable() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CellStatsViewEditable.fxml"));
			loader.setRoot(this);
			loader.setController(this);
			loader.load();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @return the current GirdPane
	 */

	public GridPane getView() {
		return this;
	}
	
	/**
	 * 
	 * @return the current Checkbox of cell type
	 */

	public CheckBox getCellTypeCHB() {
		return cellTypeCHB;
	}
	
	/**
	 * 
	 * @return the current TextField of health points
	 */

	public TextField getHealthPointsTF() {
		return healthPointsTF;
	}
	
	/**
	 * 
	 * @return the current TextField of energy points
	 */

	public TextField getEnergyPointsTF() {
		return energyPointsTF;
	}

	/**
	 * 
	 * @return the current TextField of armor points
	 */
	
	public TextField getArmorPointsTF() {
		return armorPointsTF;
	}
	

	/**
	 * 
	 * @return the current TextField of the width
	 */

	public TextField getWidthTF() {
		return widthTF;
	}
	
	/**
	 * 
	 * @return the current TextField of the height
	 */

	public TextField getHeightTF() {
		return heightTF;
	}

	public TextField getDamagePointsTF() {
		return damagePointsTF;
	}
	

}