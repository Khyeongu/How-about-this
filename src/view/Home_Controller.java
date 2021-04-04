package view;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import database.UserSession;
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
import javafx.scene.control.Label;
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
import model.TradeRecordDAO;
import model.TradeRecordVO;

public class Home_Controller implements Initializable {
	private UserSession session;

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
	
	@FXML
	private Label labelName;
	
	@FXML
	private Label labelRank1;
	@FXML
	private Label labelRank2;
	@FXML
	private Label labelRank3;
	@FXML
	private Label labelRank4;
	@FXML
	private Label labelRank5;
	
	private ArrayList<Label> labelRanks;

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
		//로그이 세션 가져오기
		session = UserSession.getInstance();
		labelName.setText(session.getMember().getName()+" 님");
		//System.out.println(session.getMember().getId());
		labelRanks = new ArrayList<Label>();
		labelRanks.add(labelRank1);
		labelRanks.add(labelRank2);
		labelRanks.add(labelRank3);
		labelRanks.add(labelRank4);
		labelRanks.add(labelRank5);
		
		monthlyProfitData = new ArrayList<MonthlyProfitVO>();
		
		//월별 수익 arraylist 초기화
		for (int i = 1; i <= 12; i++) {
			int thisYear = 202100;
			monthlyProfitData.add(new MonthlyProfitVO(Integer.toString(thisYear + i), 0));
		}
		
		//차트 그리기
		drawChart(session.getMember().getId() , "20210101","20211231");
		drawCategoryRank();
		
		//렌트 게시판 미리보기
		listRent.setItems(boardObservableList);
		listRent.setCellFactory(boardListView -> new MiniBoardListViewCell());
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
	
	public void drawCategoryRank() {
		Map<String, String> mapCategory = new HashMap<>();
		mapCategory.put("0", "전체");
		mapCategory.put("1", "디지털/가전");
		mapCategory.put("2", "가구/인테리어");
		mapCategory.put("3", "유아동/유아도서");
		mapCategory.put("4", "스포츠/레저");
		mapCategory.put("5", "여성잡화");
		mapCategory.put("6", "여성의류");
		mapCategory.put("7", "남성패션/잡화");
		mapCategory.put("8", "게임/취미");
		mapCategory.put("9", "뷰티/미용");
		mapCategory.put("10", "반려동물용품");
		mapCategory.put("11", "도서/티켓/음반");
		mapCategory.put("12", "식물");
		mapCategory.put("13", "기타");
		
		ArrayList<TradeRecordVO> categoryRanks = new ArrayList<>();
		TradeRecordDAO tradeRecordDAO = new TradeRecordDAO();
		categoryRanks=tradeRecordDAO.getCategoryRank();
		
		int idx=0;
		for(TradeRecordVO t : categoryRanks) {
			
			labelRanks.get(idx).setText(mapCategory.get(Integer.toString(t.getCategoryId())));
			idx++;
		}
	}

	public void drawChart(int userId, String startDate, String endDate) {
		linechart.getData().clear();
		XYChart.Series<String, Number> series = new XYChart.Series<String, Number>();
		series.setName("Month Profit");

		MonthlyProfitDAO monthlyProfitDAO = new MonthlyProfitDAO();
		monthlyProfits = monthlyProfitDAO.getMonthlyProfit(userId, startDate, endDate);

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
