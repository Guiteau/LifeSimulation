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
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class CellStatsView2 extends GridPane implements Initializable {

	

	private StringProperty healthPointsProperty = new SimpleStringProperty();
	private StringProperty armorProperty = new SimpleStringProperty();
	private StringProperty energyProperty = new SimpleStringProperty();
	private StringProperty coordinatesProperty = new SimpleStringProperty();

	private StringProperty dimensionProperty = new SimpleStringProperty();
	 
	
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


	public CellStatsView2() {
		
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CellStatsView2.fxml"));
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
		
		this.healthPointsLB.textProperty().bindBidirectional(this.healthPointsProperty);
		this.armorPointsLB.textProperty().bindBidirectional(this.armorProperty);
		this.energyPointsLB.textProperty().bindBidirectional(this.energyProperty);
		
		this.coordinatesProperty.bindBidirectional(coordinatesLB.textProperty());
		this.dimensionProperty.bindBidirectional(dimensionLB.textProperty());
	}
	

	/**
	 * return the view of this object
	 * @return this (Object Type GridPane)
	 */
	public GridPane getView() {
		return this;
		
	}



	/**
	 * returns the  health property of this component
	 * @return healthProperty (Object type StringProperty)
	 */
	public final StringProperty healthPointsPropertyProperty() {
		return this.healthPointsProperty;
	}
	


	
	/**
	 * Receives a string that will be pass to the StringProperty health
	 * @param healthProperty (Object type String)
	 */
	public final void setHealthPointsProperty(final String healthPointsProperty) {
		this.healthPointsPropertyProperty().set(healthPointsProperty);
	}
	
	/**
	 * returns the armor property of this component
	 * @return armorProperty (Object type StringProperty)
	 */
	public final StringProperty armorPropertyProperty() {
		return this.armorProperty;
	}
	


	/**
	 * Receives a string that will be pass to the StringProperty armor
	 * @param armorProperty (Object type String)
	 */
	public final void setArmorProperty(final String armorProperty) {
		this.armorPropertyProperty().set(armorProperty);
	}
	
	/**
	 * returns the energy property of  this component
	 * @return energyProperty (Object type StringProperty)
	 */
	 
	public final StringProperty energyPropertyProperty() {
		return this.energyProperty;
	}
	

	
	
	/**
	 * Receives a string that will be pass to the StringProperty energy
	 * @param energyProperty (Object type String)
	 */
	public final void setEnergyProperty(final String energyProperty) {
		this.energyPropertyProperty().set(energyProperty);
	}
	
	/**
	 * returns the cell type of this component
	 * @return cellTypeCHB (Object type CheckBox)
	 */
	 
	public CheckBox getCellTypeCHB() {
		return cellTypeCHB;
	}
	/**
	 * returns the coordinates property of  this component
	 * @return coordinateProperty (Object type StringProperty)
	 */
	 
	public StringProperty getCoordinatesProperty() {
		return coordinatesProperty;
	}
	/**
	 * returns the dimension property of  this component
	 * @return dimensionProperty (Object type StringProperty)
	 */
	 
	public StringProperty getDimensionProperty() {
		return dimensionProperty;
	}
	/**
	 * Receives a string that will be pass to the StringProperty Coordinates
	 * @param coordinateProperty (Object type String)
	 */
	public void setCoordinatesProperty(StringProperty coordinatesProperty) {
		this.coordinatesProperty = coordinatesProperty;
	}
	/**
	 * Receives a string that will be pass to the StringProperty Dimension
	 * @param dimensionProperty (Object type String)
	 */
	public void setDimensionProperty(StringProperty dimensionProperty) {
		this.dimensionProperty = dimensionProperty;
	}
	
	
	

	
}
