package RockPaperGame;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.Controller;

public class MainClass {
	
	public void cancle() {
		System.out.println("main 이동");
		try {
			Stage primaryStage = new Stage();
			FXMLLoader loader = 
					new FXMLLoader(getClass().getResource("/main/MainEvent.fxml"));

			Parent root = loader.load();
			Scene scene = new Scene(root);

			Controller ctl = loader.getController();
			ctl.setRoot(root);
			
			primaryStage.setScene(scene);
			primaryStage.show();		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
