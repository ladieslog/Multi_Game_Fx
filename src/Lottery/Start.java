package Lottery;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Start implements Initializable {
	Parent root;
	public Connection conn;
	private int base = 45;
	private static int ballNum = 6;
	private static int[] lots = new int[ballNum];
	
	public void setRoot(Parent root) {
		this.root = root;
	} 
	
	private static String sql1, sql2, sql3, sql4, sql5, sql6, sql7;
	
	
	public void score() {
		TextField num7 = (TextField)root.lookup("#num7");
		
		System.out.println("랜덤 추가 숫자 뽑기");
		
		while(true) {int bonus= rand();
	         if(!contain(bonus)) {
	                 System.out.println(bonus);
	                 num7.setText(String.valueOf(bonus));
	                 sql7 = num7.getText();
	                 break;
	         }
	     }
	}
	
	public void lotteryGame() {
		System.out.println("로또 게임으로 이동");
		
		try {
			Stage primaryStage = new Stage();
			FXMLLoader loader = 
					new FXMLLoader(getClass().getResource("../Lottery/GameEvent.fxml"));
			
			Parent root = loader.load();
			Scene scene = new Scene(root);
			
			Start ctl = loader.getController();
			ctl.setRoot(root);
			
			primaryStage.setTitle("로또 프로그램!!!");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void btngo() {
		System.out.println("버튼 입력");
		make();
		print();
		writeDB();
	}
	
	public void print() {
		 TextField num1 = (TextField)root.lookup("#num1");
	     TextField num2 = (TextField)root.lookup("#num2");
	     TextField num3 = (TextField)root.lookup("#num3");
	     TextField num4 = (TextField)root.lookup("#num4");
	     TextField num5 = (TextField)root.lookup("#num5");
	     TextField num6 = (TextField)root.lookup("#num6");
	     

		System.out.println("프린트 실행");
		for(int i = 0 ; i<lots.length; i++) {
			if(i==lots.length-1) {
				System.out.printf("%d", lots[i]);
				
				
			}else {
				System.out.printf("%d,",lots[i]);
			}
			if(i==0) {
				num1.setText(String.valueOf(lots[i]));
				sql1 = num1.getText();
			}
			else if(i==1) {
				num2.setText(String.valueOf(lots[i]));
				sql2 = num2.getText();
			}
			else if(i==2) {
				num3.setText(String.valueOf(lots[i]));
				sql3 = num3.getText();
			}
			else if(i==3) {
				num4.setText(String.valueOf(lots[i]));
				sql4 = num4.getText();
			}
			else if(i==4) {
				num5.setText(String.valueOf(lots[i]));
				sql5 = num5.getText();
			}
			else {
				num6.setText(String.valueOf(lots[i]));
				sql6 = num6.getText();
			}
		}
		score();
		System.out.println();
	}
	private int rand() {
		return (int)(Math.random()*base)+1;

	}
	public boolean contain(int n) {
		boolean isC=false;
		for(int i =0; i<lots.length; i++) {
			if(lots[i]==n) {
				isC=true;
				break;
			}
		}
		return isC;
	}
	
	public void make() {
		System.out.println("make 실행");
		Arrays.fill(lots, 0);
		int count=0;
		while(count!=ballNum) {
			int temp=rand();  //1~45
			if(!contain(temp)) {
				lots[count++]=temp;

			}
		}
		Arrays.sort(lots);
		
	}
	public void writeDB() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@210.221.253.215:1521:xe", "team03", "3333");
		} catch(Exception e) {
			e.printStackTrace();
		}
		String sql = "insert into Lottery(num1, num2, num3, num4, num5, num6, bonusnum) values(?,?,?,?,?,?,?)";
		int result = 0;
		try {
		PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, sql1);
			ps.setString(2, sql2);
			ps.setString(3, sql3);
			ps.setString(4, sql4);
			ps.setString(5, sql5);
			ps.setString(6, sql6);
			ps.setString(7, sql7);
			System.out.println("전송완료");
			result = ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	
		
	}
}

