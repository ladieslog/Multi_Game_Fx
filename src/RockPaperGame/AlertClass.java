package RockPaperGame;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class AlertClass {
	public static void alert(String msg) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("");				
		alert.setHeaderText("=== 경기결과 ===");	
		alert.setContentText(msg);
		alert.show();
	}
}
