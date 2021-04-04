package view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class MyZzim_Controller implements Initializable {
	@FXML
	private ComboBox<String> comboBox;
	@FXML
	private ListView<String> listView;
	@FXML
	private Label labZzim;
	
	private ObservableList<String> comboBoxList = FXCollections.observableArrayList("최근순", "오래된순");
	private ObservableList<String> myPostList;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		comboBox.setItems(comboBoxList);

//		listView.getItems().addAll("딸기1","딸기2","딸기3","딸기4");
//		listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		
	}
	//ListView<String> listview= new ListView<>();
	

	// 나의 게시물 정렬 방식 결정 메소드
	public void comboChanged(ActionEvent event) {
		String sortMethod = comboBox.getValue().toString();
		//myPostList = listView.getSelectionModel().getSelectedItems();
		
		if (sortMethod.equals("최근순")) {
			System.out.println(sortMethod);
		} else if (sortMethod.equals("오래된순")) {
			System.out.println(sortMethod);
		}
		
//		for (String list : myPostList) {
//			System.out.println(list);
//		}
	}
}