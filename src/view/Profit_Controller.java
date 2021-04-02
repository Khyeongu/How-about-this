package view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

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
import javafx.scene.layout.AnchorPane;

public class Profit_Controller implements Initializable{
	
	
	
	@FXML
	private ComboBox comboYear;
	
	@FXML
	private LineChart linechart;
	
	
	
	private ObservableList<String> list = FXCollections.observableArrayList("2021년", "2020년", "2019년", "2018년");
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		comboYear.setItems(list);
		comboYear.getSelectionModel().selectFirst();
		drawChart();
		
	}
	
	public void drawChart() {
		linechart.getData().clear();
        XYChart.Series<String, Number> series = new XYChart.Series<String, Number>();
        series.getData().add(new XYChart.Data<String, Number>("1월", 50));
        series.getData().add(new XYChart.Data<String, Number>("2월", 50));
        series.getData().add(new XYChart.Data<String, Number>("3월", 30));
        series.getData().add(new XYChart.Data<String, Number>("4월", 60));
        series.getData().add(new XYChart.Data<String, Number>("5월", 90));
        series.getData().add(new XYChart.Data<String, Number>("6월", 130));
        series.getData().add(new XYChart.Data<String, Number>("7월", 70));
        series.getData().add(new XYChart.Data<String, Number>("8월", 20));
        series.getData().add(new XYChart.Data<String, Number>("9월", 30));
        series.getData().add(new XYChart.Data<String, Number>("10월", 60));
        series.getData().add(new XYChart.Data<String, Number>("11월", 80));
        series.getData().add(new XYChart.Data<String, Number>("12월", 10));
        series.setName("Month Profit");
        linechart.getData().add(series);

	}

	
}
