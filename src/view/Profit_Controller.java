package view;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

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
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import model.BoardVO;
import model.MonthlyPostDAO;
import model.MonthlyPostVO;
import model.MonthlyProfitDAO;
import model.MonthlyProfitVO;

public class Profit_Controller implements Initializable{
	
	
	
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
	
	private ObservableList<String> list = FXCollections.observableArrayList("2021년", "2020년", "2019년", "2018년");
	private ObservableList<String> postlist = FXCollections.observableArrayList();
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
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
		        drawChart(selectedYear+"0101", selectedYear+"1231");
				drawTable(selectedYear);
		      }
		    });
	}
	
	public void drawChart(String startDate, String endDate) {
		for (int i = 1; i <= 12; i++) {
			int thisYear = 202100;
			monthlyProfitData.set(i-1,new MonthlyProfitVO(Integer.toString(thisYear + i), 0));
		}
		
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
	
	public void drawTable(String postYear) {
		for(int i=0; i<12; i++) {
				profitLists.get(i).getItems().clear();
			}
		MonthlyPostDAO monthlyPostDAO = new MonthlyPostDAO();
		monthlyPosts=monthlyPostDAO.getMonthlyPost(postYear);
		
		for(MonthlyPostVO m : monthlyPosts) {
			
			postlist.removeAll(postlist);
			postlist.add(m.getTitle());
			
			int idx=Integer.parseInt(m.getTradeDay().substring(3))-1;
			for(int i=0; i<12; i++) {
				if(idx==i+1) {
					profitLists.get(idx).getItems().addAll(postlist);
				}
			}
			
			
//			if(m.getTradeDay().substring(3).contentEquals("01")) {
//				profitList1.getItems().addAll(postlist);
//			}
//			if(m.getTradeDay().substring(3).contentEquals("05")) {
//				profitList5.getItems().addAll(postlist);
//			}
//			if(m.getTradeDay().substring(3).contentEquals("06")) {
//				profitList6.getItems().addAll(postlist);
//			}
		}
	}

	
}
