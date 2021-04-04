package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import database.UserSession;

public class SideBar_Controller implements Initializable {
	private UserSession session;
	
	@FXML
	private AnchorPane ap;

    @FXML
    private VBox pnItems = null;
    
    @FXML
	private Button btnMyPost;
	
	@FXML
	private Button btnMyZzim;
	
    @FXML
    private Button btnHome;

    @FXML
    private Button btnRent;

    @FXML
    private Button btnProfit;

    @FXML
    private Button btnCategoryRank;

    @FXML
    private Button btnPost;

    @FXML
    private Button btnSettings;

    @FXML
    private Button btnSignout;
    
    @FXML
    private Label labelName;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	//로그인 세션 가져오기
    			session = UserSession.getInstance();
    			labelName.setText(session.getMember().getName()+" 님");
    	loadPage("Home");

    }


    public void handleClicks(ActionEvent actionEvent) {
        if (actionEvent.getSource() == btnHome) {
            loadPage("Home");
        }
        if (actionEvent.getSource() == btnRent) {
        	loadPage("Rent");
        }
        if (actionEvent.getSource() == btnProfit) {
        	loadPage("Profit");
        }
        if (actionEvent.getSource() == btnCategoryRank) {
        	loadPage("CategoryRank");
        }
        if (actionEvent.getSource() == btnPost) {
        	loadPage("Post");
        }
        if (actionEvent.getSource() == btnSettings) {
        	//loadPage("Settings");
        	loadPage("Review");
        }
        if (actionEvent.getSource() == btnSignout) {
        	//Platform.exit();
        	loadPage("Grade");
        }
        if (actionEvent.getSource() == btnMyPost) {
        	loadPage("MyPost");
        }
        if (actionEvent.getSource() == btnMyZzim) {
        	loadPage("MyZzim");
        }
    }
    
	private void loadPage(String page) {
		try {
			System.out.println("../view/" + page + ".fxml");
			Node node;
			node = (Node) FXMLLoader.load(getClass().getResource("../view/" + page + ".fxml"));
			ap.getChildren().setAll(node);
		} catch (IOException ex) {
			Logger.getLogger(SideBar_Controller.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
