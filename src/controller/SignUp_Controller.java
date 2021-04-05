package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.MemberDAO;
import model.MemberVO;

import java.net.URL;
import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
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
	private PasswordField pwField;
	
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
	private DatePicker birthField;
	
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
	
	private MemberDAO memberDAO = new MemberDAO();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       

    }
    
    public void clickAction(ActionEvent actionEvent) {
        if (actionEvent.getSource() == idCheckBtn) {
        	String id = idField.getText();
        	
        	if(memberDAO.idCheck(id) && !id.equals("")) {
        		System.out.println("사용 가능한 ID");
        	}
        	else {
        		System.out.println("사용 불가능한 ID");
        		idField.setText("");
        	}
        }
        if (actionEvent.getSource() == nickNameCheckBtn) {
        	String nickName = nickNameField.getText();
        	
        	if(memberDAO.nickNameCheck(nickName) && !nickName.equals("")) System.out.println("사용 가능한 닉네임");
        	else {
        		System.out.println("사용 불가능한 닉넴");
        		nickNameField.setText("");
        	}
        }
        if(actionEvent.getSource() == signUpBtn) {
        	if(!idField.getText().equals("") && !nickNameField.getText().equals("")) {
        		MemberVO mem = new MemberVO();
        		
        		mem.setLoginId(idField.getText());
        		mem.setLoginPassword(pwField.getText());
        		mem.setName(nameField.getText());
        		mem.setPhoneNumber(phoneNoField.getText());
        		mem.setNickName(nickNameField.getText());
        		
        		java.util.Date date = 
        				java.util.Date.from(birthField.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
        		mem.setBirthdate(date);
        		
        		memberDAO.signUp(mem);
        		
        		Stage stageNow = (Stage) signUpBtn.getScene().getWindow();
        	    stageNow.close();
        	}
        }
    }
}
