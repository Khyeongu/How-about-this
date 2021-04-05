package controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import model.BoardVO;

public class MiniBoardListViewCell extends ListCell<BoardVO> {
	@FXML
	private ImageView imageProduct;
	
	@FXML
	private Label labelTitle;
	
	@FXML
	private Label labelPrice;
	
	@FXML
	private AnchorPane ap;
	
	private FXMLLoader mLLoader;
	
	@Override
	protected void updateItem(BoardVO board, boolean empty) {
		super.updateItem(board, empty);
		
		
		if(empty || board ==null) {
			setText(null);
			setGraphic(null);
		}
		else {
			if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("../view/MiniBoardListCell.fxml"));
                mLLoader.setController(this);

                try {
                    mLLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
			try {
				Image image = new Image(new FileInputStream(board.getImageUrl()));
				imageProduct.setImage(image);                
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(board.getImageUrl());
			labelTitle.setText(board.getTitle());
			labelPrice.setText(Integer.toString(board.getPrice())+" 원");
			
			setText(null);
			setGraphic(ap);
		}
	}
}
