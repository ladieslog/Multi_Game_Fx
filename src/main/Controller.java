package main;

import java.net.URL;
import java.util.ResourceBundle;

import TheGame31.TheGameStart;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import randomNumber.MainRandomNumber;
import javafx.stage.Stage;
import NBaseballGame.NBaseballGameStart;

import RockPaperGame.RockMain;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.stage.Stage;


//import Lottery.Start;
import randomNumber.MainRandomNumber;
 	
public class Controller implements Initializable{
	private TheGameStart st =new TheGameStart();
	NBaseballGameStart playball;
	private MainRandomNumber mrn = new MainRandomNumber(); // 랜덤숫자맞추기게임 객체
	//Start start;
	
	Parent root;
	RockMain ro;
	public void setRoot(Parent root) {
	 	this.root=root;	 
 	}


 @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	// TODO Auto-generated method stub
	 	playball = new NBaseballGameStart();
	 	ro = new RockMain();
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
	
	public void rockPaper() {
		ro.rockPaper();
		Stage primaryStage = (Stage)root.getScene().getWindow();
		primaryStage.close();
	}
 	
 	public void randomNumberGame() {
 		mrn.randomNumberGameStart();
 	}
 	/*
 	
 	public void loterrystart() {
		start.lotteryGame();
	}

	*/
}
