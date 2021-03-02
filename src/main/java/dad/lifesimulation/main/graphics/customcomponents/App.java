package dad.lifesimulation.main.graphics.customcomponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import dad.lifesimulation.main.draw.DrawableFactory;
import dad.lifesimulation.main.entities.Entity;
import dad.lifesimulation.main.entities.EntityFinalType;
import dad.lifesimulation.main.utils.DataProvider;
import dad.lifesimulation.main.utils.EntityReport;
import dad.lifesimulation.main.utils.GUIGame;
import dad.lifesimulation.main.utils.InitGameComponents;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import ourExceptions.NotInitializer;

public class App extends Application {

	private PrincipalComponent controller;
	private GUIGame guigame;
	private InitGameComponents processingGame;
	public static final String DIRECTORY = "pdf";
	public static final String PDF_FILE = "pdf/entitiesLifeSimulation.pdf";
	public static final String JRXML_FILE = "/reports/entities.jrxml";
	DrawableFactory levelGUI_creator;
	private static Stage primaryStage;
	
	/**
	 * The main entry point for all JavaFX applications.
	 * The start method is called after the init method has returned,and after the system is ready for the application to begin running.
	 * This method loads all initial entities and creates a random level in addition to starts a Thread to maintain the map updated
	 */

	@Override
	public void start(Stage primaryStage) throws Exception {

		this.primaryStage = primaryStage;

		controller = new PrincipalComponent();

		levelGUI_creator = new DrawableFactory();

		levelGUI_creator.loadGraphicsContext(controller.getCanvasElement().getGraphicsContext2D());

		
		levelGUI_creator.setColor(EntityFinalType.CELL, Color.AQUA);
		levelGUI_creator.setColor(EntityFinalType.SPIKE, Color.GRAY);
		levelGUI_creator.setColor(EntityFinalType.WALL, Color.FUCHSIA);
		levelGUI_creator.setColor(EntityFinalType.FOOD, Color.RED);
		levelGUI_creator.setColor(EntityFinalType.UNKNOWN, Color.YELLOW);

		processingGame = levelGUI_creator.getInitGameComponents();
		guigame = new GUIGame(levelGUI_creator);

		controller.setGame(processingGame);
		controller.setGUIGame(guigame);
		controller.setFactory(levelGUI_creator);

		guigame.start();

		Thread thread_thinker = new Thread(processingGame, "thread_thinker");

		thread_thinker.start();

		// Platform.runLater(thread_thinker);

		Scene escena = new Scene(controller.getView());
		controller.setScene(escena);
		primaryStage.setScene(escena);
		primaryStage.getIcons().add(new Image("/images/lifeSimulationIcon.png"));
		primaryStage.setTitle("Life Simulation\t");
		primaryStage.setResizable(false); /// linea nueva
		primaryStage.show();

	}
	
	/**
	 * 
	 * @return current Stage container of JavaFX
	 */
	
	public static Stage getPrimaryStage() {
		return primaryStage;
	}
	
	/**
	 * Populates a list with all the entities report (type object) for the Jasper Report
	 * 
	 * @param entitiesList List of entities to take the values required of different types of entities
	 * @return a filled list with all values taken from different types of entities and stored in EntityReport objects
	 */

	public List<EntityReport> generateReportList(List<Entity> entitiesList) {

		List<EntityReport> listReportEntities = new ArrayList<>();

		for (Entity e : entitiesList) {

			EntityReport entityReport = new EntityReport(Integer.toString(e.getCoordinates().getX()),
					Integer.toString(e.getCoordinates().getY()), e.getTangible(), e.getDimension().getWidth(),
					e.getDimension().getWidth(), e.getEntityType());

			listReportEntities.add(entityReport);

		}

		return listReportEntities;

	}
	
	/**
	 * Generates the PDF report file
	 * 
	 * @throws JRException if JasperReport actions fail trying to compile or filling the report
	 */

	public static void generatePdf() throws JRException {

		JasperReport report = JasperCompileManager
				.compileReport(Main.class.getResourceAsStream("/reports/entities.jrxml"));

		Map<String, Object> parameters = new HashMap<String, Object>();

		parameters.put("Entity", "Life Simulation");

		JasperPrint print = JasperFillManager.fillReport(report, parameters,
				new JRBeanCollectionDataSource(DataProvider.getEntitiesListDataProvider()));
		/*
		 * File directoryCreationg =new File(DIRECTORY);
		 * System.out.println(directoryCreationg.exists());
		 * 
		 * if (!directoryCreationg.exists()) directoryCreationg.mkdir(); File
		 * pdfCreation = new File (PDF_FILE);
		 * 
		 * if (!pdfCreation.exists()) pdfCreation.createNewFile();
		 * 
		 * System.out.println(directoryCreationg.exists());
		 */

		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Save PDF report");
		fileChooser.getExtensionFilters().add(new ExtensionFilter("Report (.pdf)", ".pdf"));
		fileChooser.getExtensionFilters().add(new ExtensionFilter("Todos los archivos", ".*"));
		File archivoGuardado = fileChooser.showSaveDialog(App.getPrimaryStage());

		JasperExportManager.exportReportToPdfFile(print, archivoGuardado.getPath());

		// JasperExportManager.exportReportToPdfFile(print, pdfCreation.getPath());
		/**
		 * try { Desktop.getDesktop().open(pdfCreation); } catch (IOException e) {
		 * e.printStackTrace(); }
		 */

	}

	/**
	 * Launchs the app calling the static method launch() that detects from witch class it is called
	 * @param args The command line arguments.
	 **/
	
	public static void main(String[] args) throws JRException, IOException {
	
		launch(args);
	}

	/**
	 * Method called when the application should stop and generating an Alert Dialog asking user if would like to generate 
	 * a PDF report filled with all entities from the map
	 */
	
	@Override
	public void stop() {
		if (processingGame.isPaused())
			processingGame.toPause(false);

		processingGame.toExit(true);
		try {
			DataProvider.setEntitiesArrayData(
					generateReportList(levelGUI_creator.getInitGameComponents().getAllEntities()));

			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Generar reporte");
			alert.setHeaderText("");
			alert.setContentText("\n¿Quisieras guardar un reporte de las entidades del mapa?");

			alert.getDialogPane().setGraphic(new ImageView("/images/dialogAlertIcon.png"));

			Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();

			stage.getIcons().add(new Image("/images/lifeSimulationIcon.png"));

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK) {

				generatePdf();

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}
}
