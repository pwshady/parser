import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import tornadofx.FX;

public class WVP extends Application {
    public void start(Stage stage){
        FX.registerApplication(this,stage);
        try {
            WebView wv = new WebView();
            WebEngine we = new WebEngine();
            we.load("https://www.google.com");
            Scene scene = new Scene(wv, wv.getPrefWidth(), wv.getPrefHeight());
            stage.setScene(scene);
            stage.show();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void main(String args[])
    {
        launch(args);
    }
}
