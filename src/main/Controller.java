package main;

import java.net.URL;
import java.util.ResourceBundle;
import TheGame31.TheGameStart;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
//import Lottery.Start;
//import RockPaperGame.RockMain;
//import randomNumber.MainRandomNumber;
//import NBaseballGame.GameStart;

public class Controller implements Initializable{
	private TheGameStart st =new TheGameStart();
	//private MainRandomNumber mrn = new MainRandomNumber(); // 랜덤숫자맞추기게임 객체
	//RockMain ro;
	//Start start;
	//GameStart playball;
	Parent root;
	public void setRoot(Parent root) {
	 	this.root=root;	 
 	}

 @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	// TODO Auto-generated method stub
	 
	}
 
 	public void TheGame31() {
 		st.MainBill();
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
 	public void Playball() {	
		playball.start();			
	}*/
 	
 
 
}