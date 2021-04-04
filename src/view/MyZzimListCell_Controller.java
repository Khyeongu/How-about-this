package view;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

import database.UserSession;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import model.BoardVO;
import model.ZzimDAO;

public class MyZzimListCell_Controller extends ListCell<BoardVO> {
	@FXML
	private AnchorPane ap;
	@FXML
	private ImageView imgBoard;
	@FXML
	private Label labBoardTitle;
	@FXML
	private Label labBoardPrice;
	@FXML
	private Label labBoardTime;
	@FXML
	private Label labZzimStatus;
	@FXML
	private Button btnZzimHart;

	private FXMLLoader mLLoader;
	private ZzimDAO zzimDao = new ZzimDAO();
	
	@Override
	protected void updateItem(BoardVO boardVO, boolean empty) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		super.updateItem(boardVO, empty);

		if (empty || boardVO == null) {
			setText(null);
			setGraphic(null);

		} else {
			if (mLLoader == null) {
				mLLoader = new FXMLLoader(getClass().getResource("../view/MyZzimListCell.fxml"));
				mLLoader.setController(this);

				System.out.println(boardVO.getTitle());
				System.out.println(boardVO.getPrice());
				System.out.println(boardVO.getStatus());
				
				try {
					mLLoader.load();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			labBoardTitle.setText("상풍명 : " + boardVO.getTitle());
			labBoardPrice.setText("시간당 가격 : " + Integer.toString(boardVO.getPrice())+ "원");
			labBoardTime.setText("포스트 날짜 : " + sdf.format(boardVO.getTime()));
			
			String status = Character.toString(boardVO.getStatus());

			if (status.equals("0")) {
				status = "거래 가능";			
				
			} else {
				status = "거래 완료";
			}
			labZzimStatus.setText("거래 상황 : " + status);
			
			Image image = null;
			try {
				image = new Image(new FileInputStream(boardVO.getImageUrl()));
			} catch(Exception e) {
				e.getMessage();
			}
			imgBoard.setImage(image);
			
			UserSession test = UserSession.getInstance();
			int memberId = test.getMemberId();
			
			btnZzimHart.setOnAction( event -> {
				zzimDao.deleteZzim(boardVO.getId(), memberId);
				btnZzimHart.setVisible(false);
			});
			
			setText(null);
			setGraphic(ap);
		}
	}
}
