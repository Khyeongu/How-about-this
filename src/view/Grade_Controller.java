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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Grade_Controller implements Initializable {

	@FXML
	private TableView<Product> grade_tableview;
	
	@FXML
	private TableColumn<Product, Integer> table_view_number;
	
	@FXML
	private TableColumn<Product, String> table_view_contents;
	
	@FXML
	private TextField member_name_text;
	
	@FXML
	private TextField member_grade_text;
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		grade_init();
	}
	
	private void grade_init() {
		member_name_text.setText("User1");
		member_grade_text.setText("5.0");
	}

}
