package main;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import NBaseballGame.GameStart;


public class Controller implements Initializable{
	GameStart playball;
	Parent root;
	public void setRoot(Parent root) {
	 	this.root=root;
	
 	}
	
	public void Playball() {	
		playball.start();			
	}
	
 @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	// TODO Auto-generated method stub
	 	playball = new GameStart();
	}
}
