package controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.BoardDAO;
import model.BoardVO;

public class MyPostListCell_Controller extends ListCell<BoardVO> {
	@FXML
	private AnchorPane ap;
	@FXML
	private ImageView imageView;
	@FXML
	private Label labTitle;
	@FXML
	private Label labPrice;
	@FXML
	private Label labTime;
	@FXML
	private Label labStatus;
	@FXML
	private Button btnStatus;

	private FXMLLoader mLLoader;
	private BoardDAO boardDAO = new BoardDAO();

	@Override
	protected void updateItem(BoardVO boardVO, boolean empty) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		super.updateItem(boardVO, empty);

		if (empty || boardVO == null) {
			setText(null);
			setGraphic(null);

		} else {
			if (mLLoader == null) {
				mLLoader = new FXMLLoader(getClass().getResource("../view/MyPostListCell.fxml"));
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

			labTitle.setText("상풍명 : " + boardVO.getTitle());
			labPrice.setText("시간당 가격 : " + Integer.toString(boardVO.getPrice()) + "원");
			labTime.setText("포스트 날짜 : " + sdf.format(boardVO.getTime()));

			String status = Character.toString(boardVO.getStatus());

			if (status.equals("0")) {
				status = "거래 가능";
				btnStatus.setVisible(true);

				btnStatus.setOnAction(event -> {
					boardDAO.updateStatus(boardVO.getId());
					btnStatus.setVisible(false);

					try {
						FXMLLoader loader = new FXMLLoader(getClass().getResource("MyPostStatus.fxml"));
						Stage stage = new Stage();
						stage.initStyle(StageStyle.UNDECORATED);
						Parent root = (Parent) loader.load();
						stage.setTitle("popup");
						stage.setScene(new Scene(root));
						stage.show();
						labStatus.setText("거래 완료");
					} catch (Exception e) {
						e.getMessage();
					}
				});

			} else {
				status = "거래 완료";
				btnStatus.setVisible(false);
			}

			labStatus.setText("거래 상황 : " + status);

			Image image = null;
			try {
				image = new Image(new FileInputStream(boardVO.getImageUrl()));
			} catch (Exception e) {
				e.getMessage();
			}
			imageView.setImage(image);

			setText(null);
			setGraphic(ap);
		}
	}
}
