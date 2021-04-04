package view;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import database.UserSession;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import model.BoardDAO;
import model.BoardVO;

public class MyPost_Controller implements Initializable {
	@FXML
	private ComboBox<String> cobMyPost;
	@FXML
	private Label labMyPost;
	@FXML
    private AnchorPane boardListAc;
	@FXML
	private ListView<BoardVO> boardVOListView;
	
	private UserSession test;
	private ObservableList<String> comboBoxList;
	private ObservableList<BoardVO> boardVOObservanbleList;	
	private BoardDAO boardDAO = new BoardDAO();	
	private int memberId = 0;

	
	public MyPost_Controller() {
		if (UserSession.getInstance() != null) {
			test = UserSession.getInstance();
			memberId = test.getMemberId();
			comboBoxList = FXCollections.observableArrayList("최근순", "오래된순");
		} else {
			System.out.println("로그인 되지 않았습니다. 로그인창으로 갑니다.");
			// 로그인창 가는 기능
		}
		
		ArrayList<BoardVO> boardList = new ArrayList<>();
		boardList = boardDAO.getMyBoardDesc(memberId);
		boardVOObservanbleList = FXCollections.observableArrayList();

		boardVOObservanbleList.setAll(boardList);
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		cobMyPost.setItems(comboBoxList);
		boardVOListView.setItems(boardVOObservanbleList);
		boardVOListView.setCellFactory(studentListView -> new MyPostListCell_Controller());
	}
	
	// 나의 게시물 정렬 방식 결정 메소드
	public void comboChanged(ActionEvent event) {
		String sortMethod = cobMyPost.getValue().toString();
		ArrayList<BoardVO> boardList = new ArrayList<>();
		
		if (sortMethod.equals("최근순")) {
			boardList = boardDAO.getMyBoardDesc(memberId);
			boardVOObservanbleList.setAll(boardList);
			
			System.out.println("최근순");
		} else if (sortMethod.equals("오래된순")) {
			boardList = boardDAO.getMyBoardAsc(memberId);
			boardVOObservanbleList.setAll(boardList);
			
			System.out.println("오래된 순");
		}
	}
}
