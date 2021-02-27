package dad.lifesimulation.main.graphics.customcomponents.component;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dad.lifesimulation.main.entities.actor.Cell;
import dad.lifesimulation.main.utils.Coordinates;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.adapter.JavaBeanObjectProperty;
import javafx.beans.property.adapter.JavaBeanObjectPropertyBuilder;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class CellStatsView extends EmptyComponent {
	Cell auxCell ;
	
	private StringProperty cellTypeProperty = new SimpleStringProperty();
	private StringProperty healthPointsProperty = new SimpleStringProperty();
	private StringProperty armorProperty = new SimpleStringProperty();
	private StringProperty energyProperty = new SimpleStringProperty();
	private StringProperty coordinatesProperty = new SimpleStringProperty();
	private StringProperty dimensionProperty = new SimpleStringProperty();
	 	@FXML
	    private GridPane view;

	    @FXML
	    private CheckBox cellTypeCHB;

	    @FXML
	    private Label healthPointsLB;

	    @FXML
	    private Label energyPointsLB;

	    @FXML
	    private Label armorPointsLB;

	    @FXML
	    private Label coordinatesLB;

	    @FXML
	    private Label dimensionLB;


	public CellStatsView() {
		
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
		
		this.healthPointsProperty.bindBidirectional(healthPointsLB.textProperty());
		this.armorProperty.bindBidirectional(armorPointsLB.textProperty());
		this.energyProperty.bindBidirectional(energyPointsLB.textProperty());
		this.coordinatesProperty.bindBidirectional(coordinatesLB.textProperty());
		this.dimensionProperty.bindBidirectional(dimensionLB.textProperty());
	}
	
	
	@SuppressWarnings("unchecked") //bad api
	public void loadCell(Cell _cell) {
		
		JavaBeanObjectProperty<Coordinates> propCoordinates;
		try {
			propCoordinates= JavaBeanObjectPropertyBuilder.create().bean(_cell.getCoordinates()).name("coordinates").build();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	@Override
	public GridPane getView() {
		return this;
		
	}	

	
	@Override
	public void displayData() {	
	}
	@Override
	public void loadData() {	
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
	

	public final StringProperty coordinatesPropertyProperty() {
		return this.coordinatesProperty;
	}
	

	public final String getCoordinatesProperty() {
		return this.coordinatesPropertyProperty().get();
	}
	

	public final void setCoordinatesProperty(final String coordinatesProperty) {
		this.coordinatesPropertyProperty().set(coordinatesProperty);
	}
	

	public final StringProperty dimensionPropertyProperty() {
		return this.dimensionProperty;
	}
	

	public final String getDimensionProperty() {
		return this.dimensionPropertyProperty().get();
	}
	

	public final void setDimensionProperty(final String dimensionProperty) {
		this.dimensionPropertyProperty().set(dimensionProperty);
	}
	
	
}
