package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class PostComplete_Controller {
		@FXML
		private Label labStaMent;
		@FXML
		private Button btnBack;
		
		@FXML
		private void closePopUp() {
		  try{
			  Stage stage = (Stage) btnBack.getScene().getWindow();
			  stage.close();
		  }catch(Exception e) {
			  e.getMessage();
		  }
		}
	

}
