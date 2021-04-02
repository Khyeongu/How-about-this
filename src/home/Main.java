package home;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {
    private double x, y;

    @Override
    public void start(Stage primaryStage) throws Exception {\
    	/**
    	* 안티앨리어싱 적용(폰트를 부드럽게)
    	*/
    	System.setProperty("prism.lcdtext", "false"); // 폰트파일 로드전에 실행

    	Font.loadFont(getClass().getResourceAsStream("Jalnan.ttf"), 10);

    	Parent root = FXMLLoader.load(getClass().getResource("../view/Login.fxml"));

        primaryStage.setScene(new Scene(root));
        //set stage borderless
        primaryStage.initStyle(StageStyle.UNDECORATED);

        //drag it here
        root.setOnMousePressed(event -> {
            x = event.getSceneX();
            y = event.getSceneY();
        });
        root.setOnMouseDragged(event -> {

            primaryStage.setX(event.getScreenX() - x);
            primaryStage.setY(event.getScreenY() - y);

        });
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}