package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Rent_Controller implements Initializable {
	private boolean heart = false;
	
	@FXML
	private AnchorPane ap;
	
	@FXML
    private ImageView productImg;
	
	@FXML
    private ImageView dueDateText;
	
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
	private TextArea conmentArea;
	
    @FXML
    private ImageView backImg;

    @FXML
    private ImageView updateImg;
    
    @FXML
    private ImageView profileImg;
    
    @FXML
    private ImageView heartImg;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	//뒤로가기 이미지 누르면 홈으로
    	backImg.setOnMouseClicked(event -> {
    		loadPage("Home");
    	});
    	
    	// 수정 버튼 누르면 Post 페이지로
    	updateImg.setOnMouseClicked(event -> {
    		loadPage("Post");
    	});
    	
    	// 프로필 사진 클릭하면 홈으로
    	profileImg.setOnMouseClicked(event ->{
    		loadPage("Home");
    	});
    	
    	// 하트 이미지 클릭 이벤트
    	heartImg.setOnMouseClicked(event ->{
    		if(heart) {
    			try {
					Image image = new Image(new FileInputStream("src/images/heart_blank.png"));
					heartImg.setImage(image);
	    			heart = false;
    			} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		} 
    		else {
    			try {
					Image image = new Image(new FileInputStream("src/images/heart.png"));
					heartImg.setImage(image);
	    			heart = true;
    			} catch (FileNotFoundException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    		}
    	});
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
}
