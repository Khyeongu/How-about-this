package view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class MyPostStatus_Controller {
	@FXML
	private Label labStatusMent;
	@FXML
	private Button btnBackAtStatusPopUp;
	
	@FXML
	private void closePopUp() {
	  try{
		  Stage stage = (Stage) btnBackAtStatusPopUp.getScene().getWindow();
		  stage.close();
	  }catch(Exception e) {
		  e.getMessage();
	  }
	}
}
