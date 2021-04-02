package view;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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

public class CategoryRank_Controller implements Initializable {

	@FXML
	private TableView<Product> categoryRank_tableview;

	@FXML
	private TableColumn<Product, Integer> table_view_rank;

	@FXML
	private TableColumn<Product, String> table_view_category;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		TableView_init();
	}

	private void TableView_init() {
		table_view_rank.setCellValueFactory(new PropertyValueFactory<>("category_rank"));
		table_view_category.setCellValueFactory(new PropertyValueFactory<>("category_name"));
		categoryRank_tableview.setItems(getProduct());
	}         

	// product sample data 
	public ObservableList<Product> getProduct() {
		ObservableList<Product> products = FXCollections.observableArrayList();
		products.add(new Product(1,"category1"));
		products.add(new Product(2,"category2"));
		products.add(new Product(3,"category3"));
		products.add(new Product(4,"category4"));
		products.add(new Product(5,"category5"));
		return products;
	}

}
