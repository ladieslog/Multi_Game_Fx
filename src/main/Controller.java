package main;

import java.net.URL;
import java.util.ResourceBundle;

import RockPaperGame.RockMain;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.stage.Stage;


public class Controller implements Initializable{
	
	Parent root;
	RockMain ro;
	public void setRoot(Parent root) {
	 	this.root=root;
	
	 
 	}
	
	public void rockPaper() {
		ro.rockPaper();
		Stage primaryStage = (Stage)root.getScene().getWindow();
		primaryStage.close();
	}
	
 @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	// TODO Auto-generated method stub
	ro = new RockMain();
	}
}
