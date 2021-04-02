package view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class Home_Controller implements Initializable{
	
	@FXML 
	LineChart<String, Number> linechart;
	
	@FXML
	private AnchorPane ap;
	
	@FXML
	private Button profitMore;
	
	@FXML
	private Button categoryMore;
	
	@FXML
	private Button rentMore;

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		drawChart();
		
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
	
	private void loadPage(String page) {
		try {
			System.out.println("../view/"+ page + ".fxml");
			Node node;
			node = (Node)FXMLLoader.load(getClass().getResource("../view/"+ page + ".fxml"));
			ap.getChildren().setAll(node);
		} catch (IOException ex) {
			Logger.getLogger(SideBar_Controller.class.getName()).log(Level.SEVERE, null, ex);
		}
	}


}
