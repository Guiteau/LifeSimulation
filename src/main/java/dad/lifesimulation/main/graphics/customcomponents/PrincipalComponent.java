package dad.lifesimulation.main.graphics.customcomponents;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dad.lifesimulation.main.draw.DrawableFactory;
import dad.lifesimulation.main.utils.Coordinates;
import dad.lifesimulation.main.utils.Dimension;
import dad.lifesimulation.main.utils.GUIGame;
import dad.lifesimulation.main.utils.InitGameComponents;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class PrincipalComponent {

	private GUIGame guigame;
	private InitGameComponents processingGame;
	private DrawableFactory drawableFactory;
	
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
    private Button edit;

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
    void btFastForward(ActionEvent event) {

    }

    

    @FXML
    void onClickedCanvas(MouseEvent event) {
    	if (btnAddCell.isSelected())
    	{
    		Coordinates coordinates = new Coordinates((int)event.getX(), (int)event.getY());
    		Dimension dimension = new Dimension(20, 20);
    		
    		drawableFactory.drawFromCanvas(true);
    		drawableFactory.createCellEntity(coordinates, dimension, false);
    		drawableFactory.drawFromCanvas(true);
    	}
    	
    	if (btnAddWall.isSelected())
    	{
    		Coordinates coordinates = new Coordinates((int)event.getX(), (int)event.getY());
    		Dimension dimension = new Dimension(20, 20);
    		
    		drawableFactory.drawFromCanvas(true);
    		drawableFactory.createWallEntity(coordinates, dimension);
    		drawableFactory.drawFromCanvas(true);
    	}
    	
    }

    @FXML
    void onPressedCanvas(MouseEvent event) {

    }
    
    @FXML
    void onPlayPause(ActionEvent event) {
    	if (pause.isSelected())
    	{
    		if (!guigame.isPaused())
        		guigame.toPause(true);
        	
        	if (!processingGame.isPaused())
        		processingGame.toPause(true);
    	}
    	else
    	{
    		if (guigame.isPaused())
        		guigame.toPause(false);
        	
        	if (processingGame.isPaused())
        		processingGame.toPause(false);
    	}
    		
    }
    
    public PrincipalComponent() {
    	try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/PrincipalComponent.fxml"));
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
        assert fastForward != null : "fx:id=\"fastForward\" was not injected: check your FXML file 'PrincipalComponent.fxml'.";
        assert btnAddCell != null : "fx:id=\"btnAddCell\" was not injected: check your FXML file 'PrincipalComponent.fxml'.";
        assert btnAddSpikes != null : "fx:id=\"btnAddSpikes\" was not injected: check your FXML file 'PrincipalComponent.fxml'.";
        assert btnAddWall != null : "fx:id=\"btnAddWall\" was not injected: check your FXML file 'PrincipalComponent.fxml'.";
        assert btnAddFood != null : "fx:id=\"btnAddFood\" was not injected: check your FXML file 'PrincipalComponent.fxml'.";
        assert btnDeleteEntity != null : "fx:id=\"btnDeleteEntity\" was not injected: check your FXML file 'PrincipalComponent.fxml'.";
        assert canvas != null : "fx:id=\"canvas\" was not injected: check your FXML file 'PrincipalComponent.fxml'.";
        System.out.println("_Inicializado");
    }
    
    public Canvas getCanvasElement()
    {
    	return canvas;
    }
    
    public Parent getView()
    {
    	return view;
    }
    
    public void setGame(InitGameComponents processingGame)
    {
    	this.processingGame = processingGame;
    }
    
    public void setGUIGame(GUIGame guiGame)
    {
    	this.guigame = guiGame;
    }

	public void setFactory(DrawableFactory levelGUI_creator) {
		this.drawableFactory = levelGUI_creator;		
	}
}
