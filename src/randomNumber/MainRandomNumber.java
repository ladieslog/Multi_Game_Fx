package randomNumber;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainRandomNumber {
	public void randomNumberGameStart() {
		randomNumberScene();
	}
	
	private void randomNumberScene() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("EventRandomNumber.fxml"));
			Parent randomRoot = loader.load();
			
			ControllerRandomNumber cr = new ControllerRandomNumber();
			cr.setRoot(randomRoot);
			
			Stage stage = new Stage();
			stage.setScene(new Scene(randomRoot));
			
			stage.setResizable(false);
		
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
