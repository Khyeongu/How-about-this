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
import model.ReviewDAO;
import model.ReviewVO;

import java.io.IOException;
import java.net.URL;
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
	private Button btnPost;
	
	//객체 생성
	private ReviewDAO reviewDAO = new ReviewDAO();
	private ReviewVO reviewVO = new ReviewVO();
	
	ObservableList<String> choicebox_list = FXCollections.observableArrayList();
	
	int memberid = 1;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		review_ChoiceBox_init();
		review_textField_init();
		
		reviewDAO.getReviewList(memberid); //로그인한 member의 member_id를 파라미터로
		review_listview.setItems(FXCollections.observableArrayList(reviewDAO.review_merge_list));
		
//		String review_choiceBox_value = review_choiceBox.getValue();
//		if(review_choiceBox_value == "5.0") {
//			//code
//		}
	}

	private void review_textField_init() {
		reviewDAO.getMemberName(memberid);
		review_user.setText(ReviewDAO.member_name); //로그인한 member의 name
		reviewDAO.getMemberGrade(memberid);
		review_grade.setText(ReviewDAO.member_grade);  //member의 grade 표시
	}
	
	private void review_ChoiceBox_init() {
		choicebox_list.removeAll(choicebox_list);
		String choiceBox_value[] = { "5.0", "4.5", "4.0", "3.5", "3.0", "2.5", "2.0", "1.5", "1.0", "0.5", "0.0" };
		choicebox_list.addAll(choiceBox_value);
		review_choiceBox.setItems(choicebox_list);
		review_choiceBox.setValue(choiceBox_value[0]);
	}

}
