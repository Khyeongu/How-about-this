package view;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import database.UserSession;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import model.BoardVO;
import model.MonthlyPostDAO;
import model.MonthlyPostVO;
import model.MonthlyProfitDAO;
import model.MonthlyProfitVO;

public class Profit_Controller implements Initializable{
	private UserSession session;
	
	
	@FXML
	private ComboBox<String> comboYear;
	
	@FXML
	private LineChart linechart;

	private ArrayList<MonthlyProfitVO> monthlyProfits;

	private ArrayList<MonthlyProfitVO> monthlyProfitData;
	
	private ArrayList<MonthlyPostVO> monthlyPosts;
	
	@FXML
	private ListView<String> profitList1;
	@FXML
	private ListView<String> profitList2;
	@FXML
	private ListView<String> profitList3;
	@FXML
	private ListView<String> profitList4;
	@FXML
	private ListView<String> profitList5;
	@FXML
	private ListView<String> profitList6;
	@FXML
	private ListView<String> profitList7;
	@FXML
	private ListView<String> profitList8;
	@FXML
	private ListView<String> profitList9;
	@FXML
	private ListView<String> profitList10;
	@FXML
	private ListView<String> profitList11;
	@FXML
	private ListView<String> profitList12;
	
	private ArrayList<ListView<String>> profitLists;
	
	@FXML
	private Label labelTotal1;
	@FXML
	private Label labelTotal2;
	@FXML
	private Label labelTotal3;
	@FXML
	private Label labelTotal4;
	@FXML
	private Label labelTotal5;
	@FXML
	private Label labelTotal6;
	@FXML
	private Label labelTotal7;
	@FXML
	private Label labelTotal8;
	@FXML
	private Label labelTotal9;
	@FXML
	private Label labelTotal10;
	@FXML
	private Label labelTotal11;
	@FXML
	private Label labelTotal12;
	@FXML
	private Label labelTotal;
	
	private ArrayList<Label> labelTotals;
	
	private ObservableList<String> list = FXCollections.observableArrayList("2021년", "2020년", "2019년", "2018년");
	private ObservableList<String> postlist = FXCollections.observableArrayList();
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		session = UserSession.getInstance();
		
		profitLists= new ArrayList<ListView<String>>();
		profitLists.add(profitList1);
		profitLists.add(profitList2);
		profitLists.add(profitList3);
		profitLists.add(profitList4);
		profitLists.add(profitList5);
		profitLists.add(profitList6);
		profitLists.add(profitList7);
		profitLists.add(profitList8);
		profitLists.add(profitList9);
		profitLists.add(profitList10);
		profitLists.add(profitList11);
		profitLists.add(profitList12);
		
		labelTotals= new ArrayList<Label>();
		labelTotals.add(labelTotal1);
		labelTotals.add(labelTotal2);
		labelTotals.add(labelTotal3);
		labelTotals.add(labelTotal4);
		labelTotals.add(labelTotal5);
		labelTotals.add(labelTotal6);
		labelTotals.add(labelTotal7);
		labelTotals.add(labelTotal8);
		labelTotals.add(labelTotal9);
		labelTotals.add(labelTotal10);
		labelTotals.add(labelTotal11);
		labelTotals.add(labelTotal12);
		
		monthlyProfitData = new ArrayList<MonthlyProfitVO>();
		
		for (int i = 1; i <= 12; i++) {
			int thisYear = 202100;
			monthlyProfitData.add(new MonthlyProfitVO(Integer.toString(thisYear + i), 0));
		}
		
		comboYear.setItems(list);
		comboYear.getSelectionModel().selectFirst();
		//drawChart("20210101","20211231");
		
		comboYear.valueProperty().addListener(new ChangeListener<String>() {
		      @Override
		      public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
		        System.out.println(observable + ", " + oldValue + ", " + newValue);
		        
		        String selectedYear=newValue.substring(0,4);
		        //drawChart(selectedYear+"0101", selectedYear+"1231");
		        drawChart(session.getMember().getId(), selectedYear+"0101", selectedYear+"1231");
				drawTable(session.getMember().getId(),selectedYear);
		      }
		    });
	}
	
	public void drawChart(int userId, String startDate, String endDate) {
		for (int i = 1; i <= 12; i++) {
			int thisYear = 202100;
			monthlyProfitData.set(i-1,new MonthlyProfitVO(Integer.toString(thisYear + i), 0));
		}
		
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
			
			labelTotals.get(month-1).setText(" "+Integer.toString(m.getTotal())+" 원");//테이블 총액 채우기
		}
		linechart.getData().add(series);
	}
	
	public void drawTable(int userId, String postYear) {
		for(int i=0; i<12; i++) {
				profitLists.get(i).getItems().clear();
			}
		MonthlyPostDAO monthlyPostDAO = new MonthlyPostDAO();
		monthlyPosts=monthlyPostDAO.getMonthlyPost(userId, postYear);
		
		for(MonthlyPostVO m : monthlyPosts) {
			
			postlist.removeAll(postlist);
			postlist.add(m.getTitle());
			
			int idx=Integer.parseInt(m.getTradeDay().substring(3))-1;
			for(int i=0; i<12; i++) {
				if(idx==i+1) {
					profitLists.get(idx).getItems().addAll(postlist);
				}
			}
		}
	}

	
}
