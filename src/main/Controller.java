package main;

import java.net.URL;
import java.util.ResourceBundle;
import TheGame31.Start;
import javafx.fxml.Initializable;
import javafx.scene.Parent;


public class Controller implements Initializable{
	private Start st =new Start();
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
 
 
}