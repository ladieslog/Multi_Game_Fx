package NBaseballGame;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class GameStart implements Initializable {
	static int cnt = 1;
	static int[] ans = {0, 0, 0};
	public Connection conn;
	Parent root;
	public void setRoot(Parent root) {
		this.root = root;
	}
	
	public void start() {
		System.out.println("숫자야구게임으로 이동");
		randomNum();
		try {
			Stage primaryStage = new Stage();
			FXMLLoader loader = 
					new FXMLLoader(getClass().getResource("../NBaseballGame/NBaseballGame.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			GameStart ctl = loader.getController();						
			ctl.setRoot(root);
			primaryStage.setTitle("NBaseballGame!!!");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void exitGame() {
		Stage stage = (Stage)root.getScene().getWindow();
		stage.close();
	}
	
	public void infoGame() {
		try {
			Stage primaryStage = new Stage();
			FXMLLoader loader = 
					new FXMLLoader(getClass().getResource("../NBaseballGame/InfoGame.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			GameStart ctl = loader.getController();								
			ctl.setRoot(root);
			primaryStage.setTitle("NBaseballGame 설명");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void randomNum() {
		Random rand = new Random();
		
	    for (int i = 0; i < 3; i++){
	        boolean overlap = true;
	        while (overlap) {
	            boolean fail = false;
	            int num = rand.nextInt(9)+1;
	            for (int j = 0; j < i; j++){
	                if (num == ans[j]){
	                    fail = true;
	                    break;
	                }
	            }
	            if (!fail) {
	                ans[i] = num;
	                overlap = false;
	            }
	        }
	    }
	    System.out.println("정답 : " + ans[0] + ans[1] + ans[2]);
	}
	
	public void enterNum() {
		int strike = 0, ball =0;
	    boolean overlap = true; 
	    int[] try_arr = new int[3];
		boolean correct = false;
		
        TextField usernum1 = (TextField)root.lookup("#usernum1");
        TextField usernum2 = (TextField)root.lookup("#usernum2");
        TextField usernum3 = (TextField)root.lookup("#usernum3");
        TextField result = (TextField)root.lookup("#result");
        TextField inning = (TextField)root.lookup("#inning");

        
        try_arr[0] = Integer.parseInt(usernum1.getText());
        try_arr[1] = Integer.parseInt(usernum2.getText());
        try_arr[2] = Integer.parseInt(usernum3.getText());
        usernum1.setText("");
        usernum2.setText("");
        usernum3.setText("");
        System.out.println("입력한 숫자 : " + try_arr[0] +""+ try_arr[1] +""+ try_arr[2]);
        
        if(try_arr[0] > 9 || try_arr[1] > 9 || try_arr[2] > 9 ) {
        	alertMethod("한 칸에 1~9의 숫자만 가능합니다.\n다시 입력해주세요.");
        	cnt--;
        }
        
        if (try_arr[0] == 0 || try_arr[1] == 0 || try_arr[2] == 0) {
        	alertMethod("한 칸에 1~9의 숫자만 가능합니다.\n다시 입력해주세요.");
        	cnt--;
        }
       
        else if (!(try_arr[0] == try_arr[1] || try_arr[0] == try_arr[2] || try_arr[1] == try_arr[2])) 
            overlap = false;
        
        else {
        	alertMethod("중복된 숫자가 존재합니다.\n다시 입력해주세요.");
        	cnt--;
        }
        
        if (ans[0] == try_arr[0] && ans[1] == try_arr[1] && ans[2] == try_arr[2]) {
        	strike = 3; ball = 0;
        	System.out.println("결과 : " + strike + " Strike - " + ball + " Ball");
            result.setText("3Strike!!! 게임끝!!!");
            save();
        	correct = true;
        }	
        else {
            for (int i = 0; i < 3; i++){
                for (int j = 0; j < 3; j++){
                    if (try_arr[i] == ans[j]){
                    	if (i == j) 
                    		strike++;
                        else 
                        	ball++;
                    }
                }
            }
            System.out.println("결과 : " + strike + " Strike - " + ball + " Ball");
            result.setText(try_arr[0] +""+ try_arr[1] +""+ try_arr[2] + " => " + strike + " Strike " + ball + " Ball");
        }
       
        inning.setText("< " + ++cnt + " 이닝 >");
      
	}
	
	public void alertMethod(String msg) {
		Alert alert =new Alert(AlertType.INFORMATION);	
		alert.setContentText(msg);	
		alert.show();	
	}
	
	public void save() {
		exitGame();
		try {
			Stage primaryStage = new Stage();
			FXMLLoader loader = 
					new FXMLLoader(getClass().getResource("../NBaseballGame/SaveBoard.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			GameStart ctl = loader.getController();						
			ctl.setRoot(root);
			primaryStage.setTitle("SaveBoard");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void saveAndExit() {
		TextField username = (TextField)root.lookup("#username");
		TextField feeling = (TextField)root.lookup("#feeling");
		if(username.getText().isEmpty()) 
			alertMethod("플레이어 이름이 입력되지 않았습니다.\n입력해주세요.");
		else if(feeling.getText().isEmpty())
			alertMethod("한줄평이 입력되지 않았습니다.\n입력해주세요.");
		else {
			writeDB(--cnt);
			
		}
	}
	
	public void writeDB(int cnt) {
		TextField username = (TextField)root.lookup("#username");
		TextField feeling = (TextField)root.lookup("#feeling");
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@210.221.253.215:1521:xe", "team03", "3333");
		} catch(Exception e) {
			e.printStackTrace();
		}
		String sql = "insert into NBaseBallGameRecord(username,inning,feeling) values(?,?,?)";
		int result = 0;
		try {
		PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username.getText());
			ps.setString(2, String.valueOf(cnt));
			ps.setString(3, feeling.getText());
			result = ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		exitGame();
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
			
	}	
}

