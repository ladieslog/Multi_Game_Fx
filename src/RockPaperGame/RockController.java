package RockPaperGame;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import main.MainClass;

public class RockController implements Initializable{
	Parent root;
	RockService ro;
	AlertClass alert;
	RockPaperGame.MainClass ma;
	private int com;
	public int getCom() {
		com=(int)(Math.random()*3);
		return com;
	}
	public void setRoot(Parent root) {
		this.root = root;
	}
	
	public void rockPaperStart() {	// 게임 스타트
		start();
	}
	
	public void cancle() {			// 게임 나가기
		Stage primaryStage = (Stage)root.getScene().getWindow();
		primaryStage.close();	
		ma.cancle();
	}
	
	public void start() {
		TextField choice = (TextField)root.lookup("#choice");
		TextField choice01 = (TextField)root.lookup("#choice01");
		choice.getText();
		String a = String.valueOf(getCom());  		// 숫자 -> 문자열
		choice01.setText(a);
		System.out.println();
		int play = Integer.parseInt(choice.getText()); // 문자열 -> 숫자로
		int computer = Integer.parseInt(a);
		String msg = null;
		if(play == 0) {
			if(computer == 1) {
				msg = "Player 패배";
			}else if(computer == 2){
				msg = "Player 승리";
			}else if(computer == 0) {
				msg = "=== 무승부 ===";
			}
		}else if(play == 1) {
			Alert alert = new Alert(AlertType.INFORMATION);
			if(computer == 2) {
				msg = "Player 패배";
			}else if(computer == 0){
				msg = "Player 승리";
			}else if(computer == 1) {
				msg = "=== 무승부 ===";
			}
		}else if(play == 2) {
			Alert alert = new Alert(AlertType.INFORMATION);
			if(computer == 0) {
				msg = "Player 패배";
			}else if(computer == 1){
				msg = "Player 승리";
			}else if(computer == 2) {
				msg = "=== 무승부 ===";
			}
		}alert.alert(msg);
		}
			
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		ro = new RockService();
		alert = new AlertClass();
		ma = new RockPaperGame.MainClass();
	}
}
