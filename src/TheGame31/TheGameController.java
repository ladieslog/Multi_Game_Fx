package TheGame31;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TheGameController implements Initializable{
	public static Parent root;
	private TheGameAl tga=new TheGameAl();
	public void setRoot(Parent root) {
		this.root = root;
	}
	static int a=0,i=0,k=3,j;
	public void btnP() {
		System.out.println("플레이어의 숫자확인");
		TextField tfP=(TextField)root.lookup("#txtP");
		TextField tfC=(TextField)root.lookup("#txtC");
		TextField tfM=(TextField)root.lookup("#txtM");
		String vim =new String();
		
		vim="여긴 31게임입니다. 룰은 31를 먼저 외친쪽이 지는겁니다.";	
		tfM.setText(vim);
		vim="제가선공으로 하겠습니다. 1 2 를 외쳤습니다. 3부터 가능합니다.";
		tfM.setText(vim);
				
		try {
				
					a=Integer.parseInt(tfP.getText());
					System.out.println(i);
					System.out.println(k);
					tfM.setText(" 다음숫자를 외쳐주세요 (만약 거절 하고 싶으시면 0을 눌러주세요)");				
					
					if(i>2) {
						tfM.setText("더이상 숫자를 집어 넣을 수없습니다. 턴이 넘어갑니다.");
						
					}else if(a==k) {
						vim="숫자를 눌렀습니다.\\n";
						tfM.setText(vim);
						i++; k++;
					}else if(a!=k&&i==0) {
						tfM.setText("선택할수 없는 수이거나 어떤수도 입력하지 않았습니다. 1나라도 입력해야만합니다. ");
					}else if(a==0){
						tfM.setText("플레이어님의 턴이 넘어갑니다.");
						for(j=4;j>i;j--) {		
							tfC.appendText(k+" ");
							k++;
						}
						if(k==31) {
							tfM.setText("당신의 패배입니다. ");
							return;
						}
						i=0;
									
					}else  {
						
					}
			
		} catch (Exception e) {
			tfM.setText("다음숫자로 입력해주세요");
		}

		
}
	public void btnO() {
		System.out.println("게임을 종료합니다.");
		Stage stage = (Stage)root.getScene().getWindow();
		stage.close();
	}
	
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}
}
