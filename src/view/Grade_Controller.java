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

public class Grade_Controller implements Initializable {

	@FXML
	private ListView<String> grade_listview;
	
	@FXML
	private TextField member_name_text;
	
	@FXML
	private TextField member_grade_text;
	
	private ReviewDAO reviewDAO = new ReviewDAO();
	private ReviewVO reviewVO = new ReviewVO();
	
	int memberid = 1;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		grade_textfield_init(); 
		
		reviewDAO.getReviewList(memberid); //로그인한 member의 member_id를 파라미터로
		grade_listview.setItems(FXCollections.observableArrayList(reviewDAO.review_merge_list));
	}
	
	private void grade_textfield_init() {
		reviewDAO.getMemberName(memberid);
		member_name_text.setText(ReviewDAO.member_name); //로그인한 member의 name
		reviewDAO.getMemberGrade(memberid);
		member_grade_text.setText(ReviewDAO.member_grade);  //member의 grade 표시
	}

}
