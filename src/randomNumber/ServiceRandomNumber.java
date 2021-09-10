package randomNumber;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ServiceRandomNumber {
	private int random = (int) ((Math.random() * 100) + 1); // 랜덤 숫자
	private int count = 0; // 시도 횟수
	private boolean sw = true; // 스위치 변수
	
	public void numCheck() {
		TextField numText = (TextField) ControllerRandomNumber.root.lookup("#num");
		Label checkText = (Label) ControllerRandomNumber.root.lookup("#checkText");
		// 체크 이벤트 마저 작성해야함, 숫자가 아닌 문자 입력시 경고 문자 뜨도록
		if(sw == false) { // sw가 false면 사용자가 이미 답은 맞춘 경우이므로 실행 X
			return;
		}
		
		int num = 0;
		
		try {
			num = Integer.parseInt(numText.getText());
		} catch(Exception e) { // 숫자가 아닌 문자 입력시 실행 X
			checkText.setText("숫자를 입력해주세요");
			return;
		}
		
		if(num <= 0 || num > 100) { // 사용자가 수치를 벗어난 수 입력시 실행 X
			checkText.setText("1~100까지의 수를 입력해주세요");
			return;
		}
		
		count++;
		if(num < random) {
			checkText.setText("입력하신 숫자가 더 작습니다");
		} else if (num > random) {
			checkText.setText("입력하신 숫자가 더 큽니다");
		} else {
			checkText.setText("정답입니다 ! (시도 횟수 : " + count + ")");
			sw = false;
		}
		
	}
	
	public void close() {
		Stage stage = (Stage) ControllerRandomNumber.root.getScene().getWindow();
		stage.close();
	}
	
}
