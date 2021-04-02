package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
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

public class Post_Controller implements Initializable {
	@FXML
	private TextField post_title;
	
	@FXML
	private TextField post_price;
	
	@FXML
	private Button btnpost;
	
	@FXML
	private CheckBox post_nego;
	
	@FXML
	private Button btnimg;
	
	@FXML
	private TextArea post_contents;
	
	@FXML
	private ImageView post_img;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		postTextFiled_init();
	}
	
	public void postTextFiled_init() {
		post_title.setPromptText("제목을 입력해주세요.");
		post_price.setPromptText("가격을 입력해주세요.");
		post_title.setPromptText("제목을 입력해주세요");
		post_contents.setPromptText("본문을 입력해주세요.");
	}

}
