package randomNumber;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Parent;

public class ControllerRandomNumber implements Initializable{
	public static Parent root = null;
	private ServiceRandomNumber srn = new ServiceRandomNumber();
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	public void check() { // 정답 학인 이벤트
		srn.numCheck();
	}
	
	public void ranking() { // 랭킹 확인 이벤트
		
	}
	
	public void close() { // 닫기 이벤트
		srn.close();
	}
	
	public void setRoot(Parent root) {
		this.root = root;
	}
}
