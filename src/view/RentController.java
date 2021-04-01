package view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class RentController implements Initializable {
	// 카테고리별 버튼
	@FXML
	private Button btnAll;
	@FXML
	private Button btnDigital;
	@FXML
	private Button btnInterior;
	@FXML
	private Button btnKids;
	@FXML
	private Button btnSports;
	@FXML
	private Button btnWomanThing;
	@FXML
	private Button btnWomanCloth;
	@FXML
	private Button btnManThing;
	@FXML
	private Button btnHobby;
	@FXML
	private Button btnBeauty;
	@FXML
	private Button btnPet;
	@FXML
	private Button btnBook;
	@FXML
	private Button btnPlant;
	// 나머지 객체
	@FXML
	private AnchorPane ap;
	// 검색하는 버튼
	@FXML
	private Button btnFinder;
	// 검색어 입력 textField
	@FXML
	private TextField textField;
	// 오른쪽 밑 floating btn
	@FXML
	private Button btnFloating;
	@FXML
	private Label lab_ctg;
	
	// 카테고리별 버튼이 눌렸을 떄
	public void ctgBtnClicked(ActionEvent actionEvent) {
		if (actionEvent.getSource() == btnAll) {
			// 리스트 내용과 정렬 방식 쿼리문(pl/sql)
			System.out.println("pressed");
		} else if (actionEvent.getSource() == btnDigital) {
			System.out.println("pressed");
		} else if (actionEvent.getSource() == btnInterior) {
			System.out.println("pressed");
		} else if (actionEvent.getSource() == btnKids) {
			System.out.println("pressed");
		} else if (actionEvent.getSource() == btnSports) {
			System.out.println("pressed");
		} else if (actionEvent.getSource() == btnWomanThing) {
			System.out.println("pressed");
		} else if (actionEvent.getSource() == btnWomanCloth) {
			System.out.println("pressed");
		} else if (actionEvent.getSource() == btnManThing) {
			System.out.println("pressed");
		} else if (actionEvent.getSource() == btnHobby) {
			System.out.println("pressed");
		} else if (actionEvent.getSource() == btnBeauty) {
			System.out.println("pressed");
		} else if (actionEvent.getSource() == btnPet) {
			System.out.println("pressed");
		} else if (actionEvent.getSource() == btnBook) {
			System.out.println("pressed");
		} else if (actionEvent.getSource() == btnPlant) {
			System.out.println("pressed");
		}	
	}
	
	// find아이콘 click시
	public void findClicked(ActionEvent actionEvent) {
		if (actionEvent.getSource() == btnFinder) {
			System.out.println("right");
			findWindow();
		}
	}

	// 검색어를 입력하세요 창
	public void findWindow() {
		System.out.println("findWindow 호출");
		btnFinder.setOpacity(1);
	}
	
	// floating 버튼 클릭시
	public void btnFloatingClicked(ActionEvent actionEvent) {
		System.out.println("floating버튼 clicked");
		loadPage("Post");
	}
	
	// 다른 페이지로 이동 메소드
	private void loadPage(String page) {
		try {
//			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/" + page + ".fxml"));
//			Parent root1 = (Parent) fxmlLoader.load();
//			Stage stage = new Stage();
//			stage.setScene(new Scene(root1));
//			stage.setTitle("hahhoho");
//			stage.show();
			System.out.println("../view/" + page + ".fxml");
			Node node;
			node = (Node) FXMLLoader.load(getClass().getResource("../view/" + page + ".fxml"));
			ap.getChildren().setAll(node);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// 전체 카테고리의 리스트를 정렬하여 보여주기(select -, -, -, -,... from 게시글 테이블sort by id desc); - 전체 리스트는 최근순
	}
}
