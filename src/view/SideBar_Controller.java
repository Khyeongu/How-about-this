package view;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SideBar_Controller implements Initializable {
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       

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
        	loadPage("Settings");
        }
        if (actionEvent.getSource() == btnSignout) {
        	Platform.exit();
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
