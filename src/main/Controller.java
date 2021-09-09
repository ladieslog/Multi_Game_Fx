package main;

import java.net.URL;
import java.util.ResourceBundle;
import TheGame31.TheGameStart;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.stage.Stage;
import NBaseballGame.NBaseballGameStart;

//import Lottery.Start;
//import RockPaperGame.RockMain;
//import randomNumber.MainRandomNumber;
 	
public class Controller implements Initializable{
	private TheGameStart st =new TheGameStart();
	NBaseballGameStart playball;
	//private MainRandomNumber mrn = new MainRandomNumber(); // 랜덤숫자맞추기게임 객체
	//RockMain ro;
	//Start start;
	
	Parent root;
	public void setRoot(Parent root) {
	 	this.root=root;	 
 	}

 @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	// TODO Auto-generated method stub
	 	playball = new NBaseballGameStart();
	}
 
 	public void Exit() {
 		Stage stage = (Stage)root.getScene().getWindow();
		stage.close();
 	}
 
 	public void TheGame31() {
 		st.MainBill();
 	}
 	
 	public void Playball() {	
		playball.start();			
	}
 	
 	/*
 	public void randomNumberGame() {
 		mrn.randomNumberGameStart();
 	}
 	public void rockPaper() {
		ro.rockPaper();
	}
 	
 	public void loterrystart() {
		start.lotteryGame();
	}
	*/
}