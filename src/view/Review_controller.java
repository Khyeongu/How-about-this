package view;

import javafx.collections.FXCollections;
import javafx.scene.control.TextField;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
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
import model.CategoryRankDAO;
import model.CategoryRankVO;
import model.PostDAO;
import model.ReviewDAO;
import model.ReviewVO;
import database.UserSession;
import model.MemberVO;
import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Review_controller implements Initializable {

	@FXML
	private ChoiceBox<String> review_choiceBox;

	@FXML
	private TextField review_user;
	
	@FXML
	private TextField review_grade;
	
	@FXML
	private TextField review_text;
	
	@FXML
	private ListView<String> review_listview;
		
	@FXML
	private Button btnReview_post;
	
	//객체 생성
	private ReviewDAO reviewDAO = new ReviewDAO();
	private UserSession memberid;
		
	ObservableList<String> review_choicebox_list = FXCollections.observableArrayList();
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		memberid = UserSession.getInstance();
		
		review_ChoiceBox_init();
		review_textField_init();
		
		reviewDAO.getReviewList(memberid.getMember().getId());
		review_listview.setItems(FXCollections.observableArrayList(reviewDAO.review_merge_list));
	}

	private void review_textField_init() {
		reviewDAO.getMemberName(memberid.getMember().getId());
		review_user.setText(ReviewDAO.member_name); 
		reviewDAO.getMemberGrade(memberid.getMember().getId());
		review_grade.setText(ReviewDAO.member_grade); 
	}
	
	private void review_ChoiceBox_init() {
		review_choicebox_list.removeAll(review_choicebox_list);
		String review_choiceBox_value[] = { "5.0", "4.5", "4.0", "3.5", "3.0", "2.5", "2.0", "1.5", "1.0", "0.5", "0.0" };
		review_choicebox_list.addAll(review_choiceBox_value);
		review_choiceBox.setItems(review_choicebox_list);
		review_choiceBox.setValue(review_choiceBox_value[0]);
	}
	
	public void btnReviewPostClicked(ActionEvent actionEvent) {
		if (actionEvent.getSource() == btnReview_post) {
			ReviewDAO.reviewVO.setGrade(Float.parseFloat(review_choiceBox.getValue()));
			ReviewDAO.reviewVO.setContent(review_text.getText()); 
			ReviewDAO.reviewVO.setTime(Timestamp.valueOf(LocalDateTime.now()));
			ReviewDAO.reviewVO.setMemberId(memberid.getMember().getId());
			ReviewDAO.reviewPost(memberid.getMember().getId());	
		}
	}
}
