package TheGame31;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TheGameStart {
	public void MainBill(){
		TheGame31();
	}
	private void TheGame31() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("GameEvent.fxml"));
			Parent randomRoot = loader.load();
			TheGameController tgc=new TheGameController();
			tgc.setRoot(randomRoot);
			
			Stage stage=new Stage();
			
			stage.setScene(new Scene(randomRoot));
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		} 
			
			
		
	}
	
	
	
	
	
}
