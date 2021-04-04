package view;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import database.UserSession;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import model.BoardDAO;
import model.BoardVO;

public class MyZzim_Controller implements Initializable {
	@FXML
	private ComboBox<String> cobMyZzim;
	@FXML
	private Label labZzim;
	@FXML
    private AnchorPane boardListAc;
	@FXML
	private ListView<BoardVO> boardVOListView;
	
	private UserSession test;
//	private ObservableList<String> comboBoxList;
	private ObservableList<BoardVO> boardVOObservanbleList;	
	private BoardDAO boardDAO = new BoardDAO();	
	private int memberId = 0;
	
	public MyZzim_Controller() {
		if (UserSession.getInstance() != null) {
			test = UserSession.getInstance();
			memberId = test.getMemberId();
//			comboBoxList = FXCollections.observableArrayList("최근순", "오래된순");
		} else {
			System.out.println("로그인 되지 않았습니다. 로그인창으로 갑니다.");
			// 로그인창 가는 기능
		}
		//System.out.println("memberid: " + memberId);
//		ArrayList<BoardVO> boardList = new ArrayList<>();
		ArrayList<BoardVO> boardList = new ArrayList<>();
		boardList = boardDAO.getMyZzimList(memberId);
		boardVOObservanbleList = FXCollections.observableArrayList();

		boardVOObservanbleList.setAll(boardList);
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		boardVOListView.setItems(boardVOObservanbleList);
		boardVOListView.setCellFactory(studentListView -> new MyZzimListCell_Controller());
		
	}
}