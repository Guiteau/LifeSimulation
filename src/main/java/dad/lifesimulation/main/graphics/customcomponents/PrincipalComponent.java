package dad.lifesimulation.main.graphics.customcomponents;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import dad.lifesimulation.main.draw.DrawableFactory;
import dad.lifesimulation.main.entities.actor.Cell;
import dad.lifesimulation.main.graphics.customcomponents.component.CellStatsView2;
import dad.lifesimulation.main.graphics.customcomponents.component.CellStatsViewEditable;
import dad.lifesimulation.main.utils.Coordinates;
import dad.lifesimulation.main.utils.Dimension;
import dad.lifesimulation.main.utils.GUIGame;
import dad.lifesimulation.main.utils.InitGameComponents;
import dad.lifesimulation.main.utils.Statistics;
import javafx.event.ActionEvent;
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
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class PrincipalComponent {

	private GUIGame guigame;
	private InitGameComponents processingGame;
	private DrawableFactory drawableFactory;

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
	private Button guardar;

	@FXML
	private Button cargar;

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
	private CellStatsViewEditable editableStatsPane;
	
	/**
	 * 
	 * @param event when load button is clicked
	 */

	@FXML
	void onCargarBTN(ActionEvent event) {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Save Map");
		fileChooser.getExtensionFilters().add(new ExtensionFilter("Map (.map)", ".map"));
		File archivoGuardado = fileChooser.showOpenDialog(App.getPrimaryStage());
		drawableFactory.loadLevel(archivoGuardado);
	}
	
	/**
	 * 
	 * @param event when save button is clicked
	 */

	@FXML
	void onGuardarBTN(ActionEvent event) {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Save Map");
		fileChooser.getExtensionFilters().add(new ExtensionFilter("Map (.map)", ".map"));
		File archivoGuardado = fileChooser.showSaveDialog(App.getPrimaryStage());
		processingGame.spitMap(archivoGuardado);
	}
	
	/**
	 * 
	 * @param event when cell button is clicked
	 */

	@FXML
	void onAddCell(ActionEvent event) {
		if (btnAddCell.isSelected()) {
			Image image = new Image(getClass().getResource("/images/cellResized.png").toString());
			scene.setCursor(new ImageCursor(image));
		} else
			scene.setCursor(Cursor.DEFAULT);
	}
	
	/**
	 * 
	 * @param event when button food is clicked
	 */

	@FXML
	void onAddFood(ActionEvent event) {
		if (btnAddFood.isSelected()) {
			Image image = new Image(getClass().getResource("/images/foodResized.png").toString());
			scene.setCursor(new ImageCursor(image));
		} else
			scene.setCursor(Cursor.DEFAULT);
	}
	
	/**
	 * 
	 * @param event when spikes button is clicked
	 */

	@FXML
	void onAddSpikes(ActionEvent event) {
		if (btnAddSpikes.isSelected()) {
			Image image = new Image(getClass().getResource("/images/spikeVerticalResized.png").toString());
			scene.setCursor(new ImageCursor(image));
		} else
			scene.setCursor(Cursor.DEFAULT);
	}

	/**
	 * 
	 * @param event when left mouse button is clicked on Canvas
	 */


	@FXML
	void onAddWall(ActionEvent event) {
		if (btnAddWall.isSelected()) {
			Image image = new Image(getClass().getResource("/images/wall_resized.png").toString());
			scene.setCursor(new ImageCursor(image));
		} else
			scene.setCursor(Cursor.DEFAULT);
	}
	
	/**
	 * 
	 * @param event when rubber button is clicked
	 */

	@FXML
	void onDeleteTool(ActionEvent event) {
		if (btnDeleteEntity.isSelected()) {
			Image image = new Image(getClass().getResource("/images/rubberResized.png").toString());
			scene.setCursor(new ImageCursor(image));
		} else
			scene.setCursor(Cursor.DEFAULT);
	}

	/**
	 * If editor mode is enabled the entities can be placed on canvas
	 * 
	 * @param event when left mouse button is clicked
	 */

	private void editorMode(MouseEvent event) {

		if (!btnDeleteEntity.isSelected()) {
			
			int w = Integer.parseInt(editableStatsPane.getWidthTF().textProperty().get());
			int h = Integer.parseInt(editableStatsPane.getHeightTF().textProperty().get());
			Coordinates coordinates = new Coordinates((int)event.getX(), (int)event.getY());
			Dimension dimension = new Dimension(w, h);
			coordinates.setX(coordinates.getX() - dimension.getWidth() / 2);
			coordinates.setY(coordinates.getY() - dimension.getHeight() / 2);

			if (btnAddCell.isSelected()) {
				int energy = Integer.parseInt(editableStatsPane.getEnergyPointsTF().textProperty().get());
				int health = Integer.parseInt(editableStatsPane.getHealthPointsTF().textProperty().get());
				int armor = Integer.parseInt(editableStatsPane.getArmorPointsTF().textProperty().get());
				int damage = Integer.parseInt(editableStatsPane.getDamagePointsTF().textProperty().get());
				
				
				
				Statistics stats = new Statistics(energy, health, armor, damage);
				
				drawableFactory.drawFromCanvas(true);
				drawableFactory.createCellEntity(coordinates, dimension, editableStatsPane.getCellTypeCHB().isSelected(), stats);
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
		} else
			drawableFactory.deleteIn(new Coordinates((int) event.getX(), (int) event.getY()));

	}

	/**
	* 
	* @param event when edit button is clicked
	*/

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

	/**
	 * 
	 * @param event when play button is clicked
	 */

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
	
	/**
	 * Captures the left click of the mouse over the canvas
	 * 
	 * @param event from left mouse button is clicked
	 */

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

	/**
	 * Binds the cell to statistics pane components
	 * 
	 * @param cell Cell entity (object type)
	 */

	private void bindCell(Cell cell) {
		this.statsPane.getCoordinatesProperty().setValue(cell.getCoordinates().toString());
		this.statsPane.getDimensionProperty().setValue(cell.getDimension().toString());
		this.statsPane.setArmorProperty((Integer.toString(cell.getStatistics().getArmor())));
		this.statsPane.setEnergyProperty((Integer.toString(cell.getStatistics().getEnergy())));
		this.statsPane.setHealthPointsProperty((Integer.toString(cell.getStatistics().getHealth())));
		this.statsPane.getCellTypeCHB().setSelected(cell.isHostile());
	}
	
	/**
	 * Constructor.
	 */
	public PrincipalComponent() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/principalComponent.fxml"));

			loader.setController(this);
			loader.load();

		} catch (IOException e) {

			e.printStackTrace();
		}
	}


	/**
	 * Initializes the FXML principalComponent and asserts the graphics components
	 * present
	 */

	@FXML
	void initialize() {

		System.out.println("_Inicializado");

		btnAddCell.setDisable(!edit.isSelected());
		btnAddSpikes.setDisable(!edit.isSelected());
		btnAddFood.setDisable(!edit.isSelected());
		btnAddWall.setDisable(!edit.isSelected());
		btnDeleteEntity.setDisable(!edit.isSelected());
	}

	/**
	 * 
	 * @return current Canvas (object type)
	 */

	public Canvas getCanvasElement() {
		return canvas;
	}

	/**
	 * 
	 * @return current Parent (Gridpane type)
	 */

	public Parent getView() {
		return view;
	}

	/**
	 * 
	 * @param processingGame InitGameComponents to set
	 */

	public void setGame(InitGameComponents processingGame) {
		this.processingGame = processingGame;
	}

	/**
	 * 
	 * @param guiGame GUIGame to set
	 */

	public void setGUIGame(GUIGame guiGame) {
		this.guigame = guiGame;
	}

	/**
	 * 
	 * @param levelGUI_creator DrawableFactory to set
	 */

	public void setFactory(DrawableFactory levelGUI_creator) {
		this.drawableFactory = levelGUI_creator;
	}

	/**
	 * 
	 * @param scene Scene to set
	 */

	public void setScene(Scene scene) {

		this.scene = scene;
	}
}
