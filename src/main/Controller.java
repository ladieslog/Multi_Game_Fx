package main;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import Lottery.Start;

public class Controller implements Initializable{
	Start start;
	Parent root;
	public void setRoot(Parent root) {
	 	this.root=root;
 	}
	public void loterrystart() {
		start.lotteryGame();
	}
	
 @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	// TODO Auto-generated method stub
	 	start = new Start();
	}
}
