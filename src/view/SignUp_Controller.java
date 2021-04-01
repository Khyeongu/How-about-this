package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class SignUp_Controller implements Initializable {
	
	@FXML
	private AnchorPane ap;
	
	@FXML
	private VBox titleBox;
	
	@FXML
	private Label titleText;
	
	@FXML
	private HBox signUpBox;
	
	@FXML
	private VBox textBox;
	
	@FXML
	private Label idText;
	
	@FXML
	private Label pwText;
	
	@FXML
	private Label nameText;
	
	@FXML
	private Label phoneNoText;
	
	@FXML
	private Label birthText;
	
	@FXML
	private Label nickNameText;
	
	@FXML
	private VBox inputBox;
	
	@FXML
	private BorderPane idBP;
	
	@FXML
	private TextField idField;
	
	@FXML
	private BorderPane pwBP;
	
	@FXML
	private TextField pwField;
	
	@FXML
	private BorderPane nameBP;
	
	@FXML
	private TextField nameField;
	
	@FXML
	private BorderPane phoneNoBP;
	
	@FXML
	private TextField phoneNoField;
	
	@FXML
	private BorderPane birthBP;
	
	@FXML
	private TextField birthField;
	
	@FXML
	private BorderPane nickNameBP;
	
	@FXML
	private TextField nickNameField;
	
	@FXML
	private VBox checkBox;
	
	@FXML
	private BorderPane idCheckBP;
	
	@FXML
	private Button idCheckBtn;
	
	@FXML
	private BorderPane nickNameCheckBP;
	
	@FXML
	private Button nickNameCheckBtn;
	
	@FXML
	private Button signUpBtn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       

    }
    
    public void clickAction(ActionEvent actionEvent) {
        if (actionEvent.getSource() == idCheckBtn) {
        }
        if (actionEvent.getSource() == nickNameCheckBtn) {
        }
        if(actionEvent.getSource() == signUpBtn) {
    	    Stage stageNow = (Stage) signUpBtn.getScene().getWindow();
    	    stageNow.close();
        }
    }
}
