package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Review_controller implements Initializable {

	@FXML
	private ChoiceBox<String> review_choiceBox;

	ObservableList<String> list = FXCollections.observableArrayList();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ChoiceBox_init();

//		String review_choiceBox_value = review_choiceBox.getValue();
//		if(review_choiceBox_value == "5.0") {
//			//code
//		}
	}

	private void ChoiceBox_init() {
		list.removeAll(list);
		String choiceBox_list[] = { "5.0", "4.5", "4.0", "3.5", "3.0", "2.5", "2.0", "1.5", "1.0", "0.5", "0.0" };
		list.addAll(choiceBox_list);
		review_choiceBox.setItems(list);
		review_choiceBox.setValue(choiceBox_list[0]);
	}

}
