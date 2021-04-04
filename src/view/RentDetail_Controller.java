package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import model.BoardDAO;
import model.BoardVO;
import model.RentDetailDAO;
import model.RentDetailVO;
import model.ReplyDAO;
import model.ReplyVO;
import model.ZzimDAO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import database.UserSession;

public class RentDetail_Controller implements Initializable {
	private boolean heart = false;
	private static int board_id;
	
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
		@FXML
		private Button btnEtc;
		@FXML
		private Label lab_ctg;
	
	@FXML
	private AnchorPane ap;
	
	@FXML
    private ImageView productImg;
	
	@FXML
    private Label dueDateText;
	
	@FXML
    private Label titleText;
	
	@FXML
    private Label explainTitleText;
	
	@FXML
    private Label priceText;
	
	@FXML
    private Label phoneNoText;
	
	@FXML
    private Label statusText;
	
	@FXML
    private Label contentText;
	
	@FXML
    private Label nickNameText;
	
	@FXML
	private AnchorPane replyList;
	
    @FXML
    private ImageView backImg;

    @FXML
    private ImageView updateImg;
    
    @FXML
    private ImageView profileImg;
    
    @FXML
    private ImageView heartImg;
    
    @FXML
    private TextField replyText;
    
    @FXML
    private Button replyBtn;
    
    private UserSession user;
    
    private RentDetailVO rdvo;
    
    private RentDetailDAO rentDetailDAO = new RentDetailDAO();
    
    private ReplyDAO replyDAO = new ReplyDAO();
    
	private ObservableList<ReplyVO> replyVOObservanbleList = FXCollections.observableArrayList();
	
	private ArrayList<ReplyVO> replyVOList;
	
	private ListView<ReplyVO> listView = new ListView<>();
	
	private ZzimDAO zzimDAO = new ZzimDAO();
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	// board 정보 생성
    	rdvo = rentDetailDAO.getBoardById(board_id);
    	
    	titleText.setText(rdvo.getTitle());
    	explainTitleText.setText(rdvo.getTitle());
    	dueDateText.setText(rdvo.getStartDate().toString() + " " + rdvo.getEndDate().toString());
    	contentText.setText(rdvo.getContent());
    	phoneNoText.setText(rdvo.getPhoneNumber());
    	nickNameText.setText(rdvo.getNickName());
    	priceText.setText("시간당 가격 : " + rdvo.getPrice() + "원");
    	
    	try {
    		Image img = new Image(new FileInputStream(rdvo.getImageUrl()));
    		productImg.setImage(img);
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	user = UserSession.getInstance();
    	
    	if(rdvo.isStatus()) {
    		statusText.setText("대여 가능");
    	} else statusText.setText("대여 불가능");
    	
    	if(rentDetailDAO.isZzim(user.getMember().getId(), board_id)) {
    		try {
				Image image = new Image(new FileInputStream("src/images/hart1.png"));
				heartImg.setImage(image);
    			heart = true;
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}else {
    		try {
				Image image = new Image(new FileInputStream("src/images/hart2.png"));
				heartImg.setImage(image);
    			heart = false;
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	
    	replyVOList = replyDAO.getAllReplyList(board_id);
    	replyVOObservanbleList.setAll(replyVOList);
    	getReplyList();
    	
    	
    	//뒤로가기 이미지 누르면 홈으로
    	backImg.setOnMouseClicked(event -> {
    		loadPage("Rent");
    	});
    	
    	// 수정 버튼 누르면 Post 페이지로
    	updateImg.setOnMouseClicked(event -> {
    		loadPage("Post");
    	});
    	
    	// 프로필 사진 클릭하면 홈으로
    	profileImg.setOnMouseClicked(event ->{
    		int mem_id = rentDetailDAO.getMemberId(board_id);
    		if(mem_id != 0) {
    			Review_controller.setMemberId(mem_id);
        		loadPage("Review");
    		}
    	});
    	
    	// 하트 이미지 클릭 이벤트
    	heartImg.setOnMouseClicked(event ->{
    		UserSession session = UserSession.getInstance();
    		if(heart) {
    			try {
    				zzimDAO.deleteZzim(board_id, session.getMember().getId());
    				
					Image image = new Image(new FileInputStream("src/images/hart2.png"));
					heartImg.setImage(image);
	    			heart = false;
    			} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		} 
    		else {
    			try {
    				zzimDAO.insertZzim(board_id, session.getMember().getId());
    				
					Image image = new Image(new FileInputStream("src/images/hart1.png"));
					heartImg.setImage(image);
	    			heart = true;
    			} catch (FileNotFoundException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    		}
    	});
    }
    
    
 // reply리스트 뿌리는 메소드
 	public void getReplyList() {
 		listView.setPrefSize(replyList.getPrefWidth(), replyList.getPrefHeight());
 		listView.setItems(replyVOObservanbleList);
 		listView.setCellFactory(replyVOList -> new ListCell<ReplyVO>() {
 			@Override
 			public void updateItem(ReplyVO item, boolean empty) {
 				super.updateItem(item, empty);

 				if (empty || item == null) {
 					setText(null);
 					setGraphic(null);
 				} else {
 					System.out.println(item.getContent());
 					System.out.println(item.getTime().toString());
 					setText(null);
 					setGraphic(null);
 					setText(item.getContent() + "\n" + item.getTime().toString());
 				}
 			}
 		});
 		replyList.getChildren().setAll(listView);
 	}
 	
 	public void addReply(ActionEvent actionEvent) {
 		if(actionEvent.getSource() == replyBtn) {
 			if(!replyText.getText().equals("")) {
 				replyDAO.addReply(replyText.getText(), board_id);
 				
 				replyVOList = replyDAO.getAllReplyList(board_id);
 		    	replyVOObservanbleList.setAll(replyVOList);
 		    	getReplyList();
 		    	
 		    	replyText.setText("");
 			}
 		} else if(actionEvent.getSource() == replyText) {
 			replyBtn.fire();
 		}
 	}
 	
 // 카테고리별 버튼이 눌렸을 떄
 	public void ctgBtnClicked(ActionEvent actionEvent) {
 		int ctgId = 0;
 		if (actionEvent.getSource() == btnAll) {
 			ctgId = 0;
 			System.out.println("All pressed");
 		} else if (actionEvent.getSource() == btnDigital) {
 			ctgId = 1;
 			System.out.println("btnDigital pressed");
 		} else if (actionEvent.getSource() == btnInterior) {
 			ctgId = 2;
 			System.out.println("btnInterior pressed");
 		} else if (actionEvent.getSource() == btnKids) {
 			ctgId = 3;
 			System.out.println("pressed");
 		} else if (actionEvent.getSource() == btnSports) {
 			ctgId = 4;
 			System.out.println("pressed");
 		} else if (actionEvent.getSource() == btnWomanThing) {
 			ctgId = 5;
 			System.out.println("pressed");
 		} else if (actionEvent.getSource() == btnWomanCloth) {
 			ctgId = 6;
 			System.out.println("pressed");
 		} else if (actionEvent.getSource() == btnManThing) {
 			ctgId = 7;
 			System.out.println("pressed");
 		} else if (actionEvent.getSource() == btnHobby) {
 			ctgId = 8;
 			System.out.println("pressed");
 		} else if (actionEvent.getSource() == btnBeauty) {
 			ctgId = 9;
 			System.out.println("pressed");
 		} else if (actionEvent.getSource() == btnPet) {
 			ctgId = 10;
 			System.out.println("pressed");
 		} else if (actionEvent.getSource() == btnBook) {
 			ctgId = 11;
 			System.out.println("pressed");
 		} else if (actionEvent.getSource() == btnPlant) {
 			ctgId = 12;
 			System.out.println("pressed");
 		} else if (actionEvent.getSource() == btnEtc) {
 			ctgId = 13;
 			System.out.println("pressed");
 		} 
 		
 		try {
			loadPage("Rent");
			
			System.out.println("btnAll pressed");
		} catch(Exception e) {
			e.printStackTrace();
		}
 	}
    
    private void loadPage(String page) {
		try {
			System.out.println("../view/"+ page + ".fxml");
			Node node;
			node = (Node)FXMLLoader.load(getClass().getResource("../view/"+ page + ".fxml"));
			ap.getChildren().setAll(node);
		} catch (IOException ex) {
			Logger.getLogger(SideBar_Controller.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public static void initData(int id) {
		board_id = id;
		System.out.println("값 받음 : " + board_id);
	}
}
