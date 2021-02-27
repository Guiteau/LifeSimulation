package dad.lifesimulation.main.graphics.customcomponents.component;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

public class SampleComponent {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    public  SampleComponent() {
    	try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/samplecomponent.fxml"));
	    	loader.setController(this);
	    	loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

    @FXML
    void initialize() {

    }
}
