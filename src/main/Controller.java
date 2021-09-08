package main;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import randomNumber.MainRandomNumber;


public class Controller implements Initializable{
	
	Parent root;
	private MainRandomNumber mrn = new MainRandomNumber(); // 랜덤숫자맞추기게임 객체
	public void setRoot(Parent root) {
	 	this.root=root;
	
	 
 	}
 @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	// TODO Auto-generated method stub
	
	}
 
 	// 김준호 코드 연결
 	public void randomNumberGame() {
 		System.out.println("??");
 	}
}
