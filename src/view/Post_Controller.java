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
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import database.UserSession;
import model.PostVO;
import model.PostDAO;

public class Post_Controller implements Initializable {
	@FXML
	private Pane post_pane;
	@FXML
	private TextField post_title;
	@FXML
	private TextField post_price;
	@FXML
	private Button btnpost;
	@FXML
	private CheckBox post_nego;
	@FXML
	private ChoiceBox<String> post_choicebox;
	@FXML
	private Button btnimg;
	@FXML
	private TextArea post_contents;
	@FXML
	private ImageView post_img;
	@FXML
	private DatePicker post_start_date;
	@FXML
	private DatePicker post_end_date;
	
	private UserSession memberid;
	String img_url_save;
	String post_choiceBox_value[] = { "디지털/가전", "가구/인테리어", "유아동/유아도서", "스포츠/레저", "여성잡화", "여성의류", "남성패션/잡화", "게임/취미",
			"뷰티/미용", "반려동물용품", "도서/티켓/음반", "식물", "기타" };
	
	ObservableList<String> post_choicebox_list = FXCollections.observableArrayList();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		memberid = UserSession.getInstance();
		post_ChoiceBox_init();
		postTextField_init();

	}

	public void postTextField_init() {
		post_title.setPromptText("제목을 입력해주세요.");
		post_price.setPromptText("가격을 입력해주세요.");
		post_title.setPromptText("제목을 입력해주세요");
		post_contents.setPromptText("본문을 입력해주세요.");
	}

	private void post_ChoiceBox_init() {
		post_choicebox_list.removeAll(post_choicebox_list);
		post_choicebox_list.addAll(post_choiceBox_value);
		post_choicebox.setItems(post_choicebox_list);
	}

	public void btnBoardPostClicked(ActionEvent actionEvent) {
		if (actionEvent.getSource() == btnpost) {
			PostDAO.postVO.setTitle(post_title.getText());
			PostDAO.postVO.setContent(post_contents.getText());
			PostDAO.postVO.setPrice(Integer.parseInt(post_price.getText()));
			PostDAO.postVO.setStatus(post_nego.isSelected());

			java.util.Date start_date = java.util.Date
					.from(post_start_date.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
			java.util.Date end_date = java.util.Date
					.from(post_end_date.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());

			PostDAO.postVO.setTime(Timestamp.valueOf(LocalDateTime.now()));
			PostDAO.postVO.setStart_date(start_date);
			PostDAO.postVO.setEnd_date(end_date);
			PostDAO.postVO.setImage_url(img_url_save);
	
			for (int i = 0; i < 13; i++) {
				if (post_choicebox.getValue().equals(post_choiceBox_value[i])) {
					PostDAO.postVO.setCategory_id(i+1);
				}
			}
	
			PostDAO.insertBoardPost(memberid.getMember().getId());
			loadPage("Post");

		}
	}

	public void fileChoose() {
		FileChooser fc = new FileChooser();
		fc.setTitle("이미지 선택");
		fc.setInitialDirectory(new File("C:/"));
		ExtensionFilter imgType = new ExtensionFilter("image file", "*.jpg", "*.gif", "*.png", "*jpeg");
		fc.getExtensionFilters().addAll(imgType);

		File selectedFile = fc.showOpenDialog(null);
		System.out.println(selectedFile);

		img_url_save = selectedFile.toString();

		try {
			FileInputStream fis = new FileInputStream(selectedFile);
			BufferedInputStream bis = new BufferedInputStream(fis);
			Image img = new Image(bis);
			post_img.setImage(img);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private void loadPage(String page) {
		try {
			System.out.println(page + ".fxml");
			Node node;
			node = (Node) FXMLLoader.load(getClass().getResource(page + ".fxml"));
			post_pane.getChildren().setAll(node);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
