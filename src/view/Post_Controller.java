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
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.PostVO;
import model.PostDAO;

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
	
	@FXML
	private DatePicker post_start_date; // local date
	
	@FXML
	private DatePicker post_end_date; // local date
	
//	private PostVO postVO = new PostVO();
//	private PostDAO postDAO = new PostDAO();
	
//	LocalDate to_date = LocalDate.now();
//	LocalTime to_time = LocalTime.now();
	
	String img_url_save;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		postTextField_init();
		
	}
	
	//testfield init
	public void postTextField_init() {
		post_title.setPromptText("제목을 입력해주세요.");
		post_price.setPromptText("가격을 입력해주세요.");
		post_title.setPromptText("제목을 입력해주세요");
		post_contents.setPromptText("본문을 입력해주세요.");
	}
	
	//post 버튼 클릭
	public void btnPostClicked(ActionEvent actionEvent) {
		if (actionEvent.getSource() == btnpost) {
			PostDAO.postVO.setId(3);
			PostDAO.postVO.setTitle(post_title.getText());
			PostDAO.postVO.setContent(post_contents.getText());
			PostDAO.postVO.setPrice(Integer.parseInt(post_price.getText()));
			PostDAO.postVO.setStatus(Boolean.toString(post_nego.isSelected()));
			PostDAO.postVO.setTime(Timestamp.valueOf(LocalDateTime.now()));
			PostDAO.postVO.setStart_date(post_start_date.getValue()); //local date
			PostDAO.postVO.setEnd_date(post_end_date.getValue());    //local date
			PostDAO.postVO.setImage_url(img_url_save);
			PostDAO.postVO.setCategory_id(3); //유저가 고를수있게
			PostDAO.postVO.setMember_id(10);   //유저 세션값 입력
			
			PostDAO.insertBoardPost();
			
		}
	}
	
	
	 // 사진 선택하고 선택한 이미지 띄우기
	 public void fileChoose() {
	        // 사진 선택 창
	        FileChooser fc = new FileChooser();
	        fc.setTitle("이미지 선택");
	        fc.setInitialDirectory(new File("C:/")); // default 디렉토리 설정
	        
	        // 선택한 파일 정보 추출
	        // 확장자 제한
	        ExtensionFilter imgType = new ExtensionFilter("image file", "*.jpg", "*.gif", "*.png", "*jpeg");
	        //fc.getExtensionFilters().add(imgType);
	        fc.getExtensionFilters().addAll(imgType);
	         
	        File selectedFile =  fc.showOpenDialog(null); // showOpenDialog는 창을 띄우는데 어느 위치에 띄울건지 인자를 받고
	                                                                // 그리고 선택한 파일의 경로값을 반환한다.
	        //System.out.println(selectedFile);               // 선택한 경로가 출력된다.
	         
	        img_url_save = selectedFile.toString();
	        
	        // 파일을 InputStream으로 읽어옴
	        try {
	            // 파일 읽어오기
	            FileInputStream fis = new FileInputStream(selectedFile);
	            BufferedInputStream bis = new BufferedInputStream(fis);
	            // 이미지 생성하기
	            Image img = new Image(bis);
	            // 이미지 띄우기
	            post_img.setImage(img);
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        }
	    }

}
