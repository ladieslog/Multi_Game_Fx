package NBaseballGame;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class GameStart implements Initializable {
	Parent root;
	public void setRoot(Parent root) {
		this.root = root;
	}
	
	
	public void start() {
		
		System.out.println("숫자야구게임으로 이동");
		try {
			Stage primaryStage = new Stage();
			FXMLLoader loader = 
					new FXMLLoader(getClass().getResource("../NBaseballGame/NBaseballGame.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			
			GameStart ctl = loader.getController();	
												
			ctl.setRoot(root);
			
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
		
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
	}	
}

