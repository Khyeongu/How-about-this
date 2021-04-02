package view;

import java.net.URL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import database.DBConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import model.BoardDAO;
import model.BoardVO;
import oracle.jdbc.OracleTypes;

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
	@FXML
	private VBox boardListVBox;
	
	// 객체 생성
	private BoardDAO boardDAO = new BoardDAO();
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		boardDAO.getAllBoardList();
	}
	
	// 카테고리별 버튼이 눌렸을 떄
	public void ctgBtnClicked(ActionEvent actionEvent) {
		int ctgId = 1;
		
		if (actionEvent.getSource() == btnAll) {
			boardDAO.getAllBoardList();
			System.out.println("pressed");
		} else if (actionEvent.getSource() == btnDigital) {
			ctgId = 2;
			boardDAO.getOneCtgBoardList(ctgId);
			System.out.println("pressed");
		} else if (actionEvent.getSource() == btnInterior) {
			ctgId = 3;
			boardDAO.getOneCtgBoardList(ctgId);
			System.out.println("pressed");
		} else if (actionEvent.getSource() == btnKids) {
			ctgId = 4;
			boardDAO.getOneCtgBoardList(ctgId);
			System.out.println("pressed");
		} else if (actionEvent.getSource() == btnSports) {
			ctgId = 5;
			boardDAO.getOneCtgBoardList(ctgId);
			System.out.println("pressed");
		} else if (actionEvent.getSource() == btnWomanThing) {
			ctgId = 6;
			boardDAO.getOneCtgBoardList(ctgId);
			System.out.println("pressed");
		} else if (actionEvent.getSource() == btnWomanCloth) {
			ctgId = 7;
			boardDAO.getOneCtgBoardList(ctgId);
			System.out.println("pressed");
		} else if (actionEvent.getSource() == btnManThing) {
			ctgId = 8;
			boardDAO.getOneCtgBoardList(ctgId);
			System.out.println("pressed");
		} else if (actionEvent.getSource() == btnHobby) {
			ctgId = 9;
			boardDAO.getOneCtgBoardList(ctgId);
			System.out.println("pressed");
		} else if (actionEvent.getSource() == btnBeauty) {
			ctgId = 10;
			boardDAO.getOneCtgBoardList(ctgId);
			System.out.println("pressed");
		} else if (actionEvent.getSource() == btnPet) {
			ctgId = 11;
			boardDAO.getOneCtgBoardList(ctgId);
			System.out.println("pressed");
		} else if (actionEvent.getSource() == btnBook) {
			ctgId = 12;
			boardDAO.getOneCtgBoardList(ctgId);
			System.out.println("pressed");
		} else if (actionEvent.getSource() == btnPlant) {
			ctgId = 13;
			boardDAO.getOneCtgBoardList(ctgId);
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
			System.out.println("../view/" + page + ".fxml");
			Node node;
			node = (Node) FXMLLoader.load(getClass().getResource("../view/" + page + ".fxml"));
			ap.getChildren().setAll(node);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
