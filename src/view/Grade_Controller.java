package view;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.ReviewDAO;
import model.ReviewVO;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import database.UserSession;

public class Grade_Controller implements Initializable {

	@FXML
	private ListView<String> grade_listview;
	
	@FXML
	private TextField member_name_text;
	
	@FXML
	private TextField member_grade_text;
	
	private ReviewDAO reviewDAO = new ReviewDAO();
	private ReviewVO reviewVO = new ReviewVO();
	
	private UserSession memberid;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		memberid = UserSession.getInstance();
		grade_textfield_init(); 
		
		reviewDAO.getReviewList(memberid.getMember().getId());
		grade_listview.setItems(FXCollections.observableArrayList(reviewDAO.review_merge_list));
	}
	
	private void grade_textfield_init() {
		reviewDAO.getMemberName(memberid.getMember().getId());
		member_name_text.setText(ReviewDAO.member_name);
		reviewDAO.getMemberGrade(memberid.getMember().getId());
		member_grade_text.setText(ReviewDAO.member_grade);
	}

}
