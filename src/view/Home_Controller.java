package view;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.BoardDAO;
import model.BoardVO;
import model.MonthlyProfitDAO;
import model.MonthlyProfitVO;

public class Home_Controller implements Initializable {

	@FXML
	private LineChart<String, Number> linechart;

	@FXML
	private GridPane gridRank;

	@FXML
	private ListView<BoardVO> listRent;

	private ObservableList<BoardVO> boardObservableList;

	private ArrayList<BoardVO> boardVOs;

	private ArrayList<MonthlyProfitVO> monthlyProfits;

	private ArrayList<MonthlyProfitVO> monthlyProfitData;

	@FXML
	private AnchorPane ap;

	@FXML
	private Button profitMore;

	@FXML
	private Button categoryMore;

	@FXML
	private Button rentMore;

	@FXML
	private ImageView imageTest;

	public Home_Controller() {
		BoardDAO boardDAO = new BoardDAO();

		boardObservableList = FXCollections.observableArrayList();

		boardVOs = boardDAO.getMiniBoardList();

		for (BoardVO b : boardVOs) {
			boardObservableList.addAll(b);
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		monthlyProfitData = new ArrayList<MonthlyProfitVO>();
		
		for (int i = 1; i <= 12; i++) {
			int thisYear = 202100;
			monthlyProfitData.add(new MonthlyProfitVO(Integer.toString(thisYear + i), 0));
		}
		
		drawChart("20210101","20211231");
		listRent.setItems(boardObservableList);
		listRent.setCellFactory(boardListView -> new MiniBoardListViewCell());

		// String
		// path="C:\\Users\\user\\Desktop\\현대IT&E\\project\\How-about-this\\resources\\xbox.jpeg";
		// Image image = new Image(path);
		// imageTest.setImage(image);

	}

	public void handleClicks(ActionEvent actionEvent) {
		if (actionEvent.getSource() == profitMore) {
			loadPage("Profit");
		}
		if (actionEvent.getSource() == categoryMore) {
			loadPage("CategoryRank");
		}
		if (actionEvent.getSource() == rentMore) {
			loadPage("Rent");
		}
	}

	public void drawChart(String startDate, String endDate) {
		linechart.getData().clear();
		XYChart.Series<String, Number> series = new XYChart.Series<String, Number>();
		series.setName("Month Profit");

		MonthlyProfitDAO monthlyProfitDAO = new MonthlyProfitDAO();
		monthlyProfits = monthlyProfitDAO.getMonthlyProfit(startDate, endDate);

		for (MonthlyProfitVO m : monthlyProfits) {
			int row = Integer.parseInt(m.getMonth().substring(4, 6)) - 1;
			monthlyProfitData.set(row, m);
		}

		for (MonthlyProfitVO m : monthlyProfitData) {
			int month = Integer.parseInt(m.getMonth().substring(4, 6));

			series.getData().add(new XYChart.Data<String, Number>(Integer.toString(month) + "월", m.getTotal()));
		}

		linechart.getData().add(series);
	}

	private void loadPage(String page) {
		try {
			System.out.println("../view/" + page + ".fxml");
			Node node;
			node = (Node) FXMLLoader.load(getClass().getResource("../view/" + page + ".fxml"));
			ap.getChildren().setAll(node);
		} catch (IOException ex) {
			Logger.getLogger(SideBar_Controller.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}
