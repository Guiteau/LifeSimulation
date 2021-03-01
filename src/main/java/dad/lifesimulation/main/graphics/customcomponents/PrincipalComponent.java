package dad.lifesimulation.main.graphics.customcomponents;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import dad.lifesimulation.main.draw.DrawableFactory;
import dad.lifesimulation.main.entities.actor.Cell;
import dad.lifesimulation.main.graphics.customcomponents.component.CellStatsView;
import dad.lifesimulation.main.graphics.customcomponents.component.CellStatsView2;
import dad.lifesimulation.main.graphics.customcomponents.component.CellStatsViewEditable;
import dad.lifesimulation.main.utils.Coordinates;
import dad.lifesimulation.main.utils.Dimension;
import dad.lifesimulation.main.utils.GUIGame;
import dad.lifesimulation.main.utils.InitGameComponents;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.ImageCursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class PrincipalComponent {

	private GUIGame guigame;
	private InitGameComponents processingGame;
	private DrawableFactory drawableFactory;
	/**
	 * @FXML private Tab visualizeTab;
	 * 
	 * @FXML private Tab editableTab;
	 **/
	private CellStatsView cellView;
	private CellStatsViewEditable cellEditable;

	private Scene scene;
	@FXML
	private ToggleGroup editor;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private GridPane view;

	@FXML
	private ToggleButton pause;

	@FXML
	private ToggleButton edit;

	@FXML
	private Button fastForward;

	@FXML
	private ToggleButton btnAddCell;

	@FXML
	private ToggleButton btnAddSpikes;

	@FXML
	private ToggleButton btnAddWall;

	@FXML
	private ToggleButton btnAddFood;

	@FXML
	private ToggleButton btnDeleteEntity;

	@FXML
	private Canvas canvas;

	@FXML
	private CellStatsView2 statsPane;

	@FXML
	void btFastForward(ActionEvent event) {

	}
	
    @FXML
    void onAddCell(ActionEvent event) {
    	if (btnAddCell.isSelected())
    	{
    		Image image = new Image(getClass().getResource("/images/cellResized.png").toString());
    		scene.setCursor(new ImageCursor(image));
    	}
    	else
    		scene.setCursor(Cursor.DEFAULT);
    }

    @FXML
    void onAddFood(ActionEvent event) {
    	if (btnAddFood.isSelected())
    	{
    		Image image = new Image(getClass().getResource("/images/foodResized.png").toString());
    		scene.setCursor(new ImageCursor(image));
    	}
    	else
    		scene.setCursor(Cursor.DEFAULT);
    }
    
    @FXML
    void onAddSpikes(ActionEvent event) {
    	if (btnAddSpikes.isSelected())
    	{
    		Image image = new Image(getClass().getResource("/images/spikeVerticalResized.png").toString());
    		scene.setCursor(new ImageCursor(image));
    	}
    	else
    		scene.setCursor(Cursor.DEFAULT);
    }
  
    @FXML
    void onAddWall(ActionEvent event) {
    	if (btnAddWall.isSelected())
    	{
    		Image image = new Image(getClass().getResource("/images/wall_resized.png").toString());
    		scene.setCursor(new ImageCursor(image));
    	}
    	else
    		scene.setCursor(Cursor.DEFAULT);
    }

    @FXML
    void onDeleteTool(ActionEvent event) {
    	if (btnDeleteEntity.isSelected())
    	{
    		Image image = new Image(getClass().getResource("/images/rubberResized.png").toString());
    		scene.setCursor(new ImageCursor(image));
    	}
    	else
    		scene.setCursor(Cursor.DEFAULT);
    }

	private void editorMode(MouseEvent event) {

		if (!btnDeleteEntity.isSelected()) {
			Coordinates coordinates = new Coordinates((int) event.getX(), (int) event.getY());
			Dimension dimension = new Dimension(20, 20);
			coordinates.setX(coordinates.getX() - dimension.getWidth()/2);
			coordinates.setY(coordinates.getY() - dimension.getHeight()/2);
			
			if (btnAddCell.isSelected()) {
				drawableFactory.drawFromCanvas(true);
				drawableFactory.createCellEntity(coordinates, dimension, false);
				drawableFactory.drawFromCanvas(false);
			}

			else if (btnAddWall.isSelected()) {

				drawableFactory.drawFromCanvas(true);
				drawableFactory.createWallEntity(coordinates, dimension);
				drawableFactory.drawFromCanvas(false);
			}

			else if (btnAddFood.isSelected()) {

				drawableFactory.drawFromCanvas(true);
				drawableFactory.createFoodEntity(coordinates, dimension);
				drawableFactory.drawFromCanvas(false);
			}

			else if (btnAddSpikes.isSelected()) {

				drawableFactory.drawFromCanvas(true);
				drawableFactory.createSpikeEntity(coordinates, dimension);
				drawableFactory.drawFromCanvas(false);
			}
		}
		else
			drawableFactory.deleteIn(new Coordinates((int)event.getX(), (int)event.getY()));

	}

	@FXML
	void onEdit(ActionEvent event) {
		btnAddCell.setDisable(!edit.isSelected());
		btnAddSpikes.setDisable(!edit.isSelected());
		btnAddFood.setDisable(!edit.isSelected());
		btnAddWall.setDisable(!edit.isSelected());
		btnDeleteEntity.setDisable(!edit.isSelected());
		
		if (!edit.isSelected())
	    	scene.setCursor(Cursor.DEFAULT);
	}

	@FXML
	void onPlayPause(ActionEvent event) {
		if (pause.isSelected()) {
			guigame.stop();
			if (!processingGame.isPaused())
				processingGame.toPause(true);
		} else {
			guigame.start();

			if (processingGame.isPaused())
				processingGame.toPause(false);
		}
	}

	@FXML
	void onPressedCanvas(MouseEvent event) {
		if (edit.isSelected())
			editorMode(event);
		else {
			Coordinates coordinates = new Coordinates((int) event.getX(), (int) event.getY());
			Optional<Cell> maybe_cell = processingGame.getCellIn(coordinates);

			if (maybe_cell.isPresent())
				bindCell(maybe_cell.get());
		}
	}

	private void bindCell(Cell cell) {
		this.statsPane.getCoordinatesProperty().setValue(cell.getCoordinates().toString());
		this.statsPane.getDimensionProperty().setValue(cell.getDimension().toString());
		this.statsPane.setArmorProperty((Integer.toString(cell.getStatistics().getArmor())));
		this.statsPane.setEnergyProperty((Integer.toString(cell.getStatistics().getEnergy())));
		this.statsPane.setHealthPointsProperty((Integer.toString(cell.getStatistics().getHealth())));
		this.statsPane.getCellTypeCHB().setSelected(cell.isHostile());
	}

	public PrincipalComponent() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/test.fxml"));
			// FXMLLoader loader = new
			// FXMLLoader(getClass().getResource("/fxml/PrincipalComponent2.fxml"));
			// loader.setRoot(this);
			loader.setController(this);
			loader.load();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	void initialize() {
		assert view != null : "fx:id=\"view\" was not injected: check your FXML file 'PrincipalComponent.fxml'.";
		assert pause != null : "fx:id=\"pause\" was not injected: check your FXML file 'PrincipalComponent.fxml'.";
		assert edit != null : "fx:id=\"play\" was not injected: check your FXML file 'PrincipalComponent.fxml'.";
		assert fastForward != null
				: "fx:id=\"fastForward\" was not injected: check your FXML file 'PrincipalComponent.fxml'.";
		assert btnAddCell != null
				: "fx:id=\"btnAddCell\" was not injected: check your FXML file 'PrincipalComponent.fxml'.";
		assert btnAddSpikes != null
				: "fx:id=\"btnAddSpikes\" was not injected: check your FXML file 'PrincipalComponent.fxml'.";
		assert btnAddWall != null
				: "fx:id=\"btnAddWall\" was not injected: check your FXML file 'PrincipalComponent.fxml'.";
		assert btnAddFood != null
				: "fx:id=\"btnAddFood\" was not injected: check your FXML file 'PrincipalComponent.fxml'.";
		assert btnDeleteEntity != null
				: "fx:id=\"btnDeleteEntity\" was not injected: check your FXML file 'PrincipalComponent.fxml'.";
		assert canvas != null : "fx:id=\"canvas\" was not injected: check your FXML file 'PrincipalComponent.fxml'.";
		System.out.println("_Inicializado");
		cellEditable = new CellStatsViewEditable();
		cellView = new CellStatsView();
		// this.editableTab.setContent(cellEditable.getView());
		// this.visualizeTab.setContent(cellView.getView());
		btnAddCell.setDisable(!edit.isSelected());
		btnAddSpikes.setDisable(!edit.isSelected());
		btnAddFood.setDisable(!edit.isSelected());
		btnAddWall.setDisable(!edit.isSelected());
		btnDeleteEntity.setDisable(!edit.isSelected());
	}

	public Canvas getCanvasElement() {
		return canvas;
	}

	public Parent getView() {
		return view;
	}

	public void setGame(InitGameComponents processingGame) {
		this.processingGame = processingGame;
	}

	public void setGUIGame(GUIGame guiGame) {
		this.guigame = guiGame;
	}

	public void setFactory(DrawableFactory levelGUI_creator) {
		this.drawableFactory = levelGUI_creator;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}
}
