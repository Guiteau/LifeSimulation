package dad.lifesimulation.main.graphics.customcomponents;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class StatisticComponent extends GridPane implements Initializable {

	private StringProperty cellTypeProperty = new SimpleStringProperty();
	private StringProperty healthPointsProperty = new SimpleStringProperty();
	private StringProperty armorProperty = new SimpleStringProperty();
	private StringProperty energyProperty = new SimpleStringProperty();
	private StringProperty censusProeprty = new SimpleStringProperty();

	@FXML
	private Label lbCellType;

	@FXML
	private Label lbHealthPoints;

	@FXML
	private Label lbArmor;

	@FXML
	private Label lbEnergy;

	@FXML
	private Label lbCensus;

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
		this.cellTypeProperty.bindBidirectional(lbCellType.textProperty());
		this.healthPointsProperty.bindBidirectional(lbHealthPoints.textProperty());
		this.armorProperty.bindBidirectional(lbArmor.textProperty());
		this.energyProperty.bindBidirectional(lbEnergy.textProperty());
		this.censusProeprty.bindBidirectional(lbCensus.textProperty());
	}
	


	public final StringProperty cellTypePropertyProperty() {
		return this.cellTypeProperty;
	}

	public final String getCellTypeProperty() {
		return this.cellTypePropertyProperty().get();
	}

	public final void setCellTypeProperty(final String cellTypeProperty) {
		this.cellTypePropertyProperty().set(cellTypeProperty);
	}

	public final StringProperty healthPointsPropertyProperty() {
		return this.healthPointsProperty;
	}

	public final String getHealthPointsProperty() {
		return this.healthPointsPropertyProperty().get();
	}

	public final void setHealthPointsProperty(final String healthPointsProperty) {
		this.healthPointsPropertyProperty().set(healthPointsProperty);
	}

	public final StringProperty armorPropertyProperty() {
		return this.armorProperty;
	}

	public final String getArmorProperty() {
		return this.armorPropertyProperty().get();
	}

	public final void setArmorProperty(final String armorProperty) {
		this.armorPropertyProperty().set(armorProperty);
	}

	public final StringProperty energyPropertyProperty() {
		return this.energyProperty;
	}

	public final String getEnergyProperty() {
		return this.energyPropertyProperty().get();
	}

	public final void setEnergyProperty(final String energyProperty) {
		this.energyPropertyProperty().set(energyProperty);
	}

	public final StringProperty censusProeprtyProperty() {
		return this.censusProeprty;
	}

	public final String getCensusProeprty() {
		return this.censusProeprtyProperty().get();
	}

	public final void setCensusProeprty(final String censusProeprty) {
		this.censusProeprtyProperty().set(censusProeprty);
	}

}
