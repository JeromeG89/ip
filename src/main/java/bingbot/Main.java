package bingbot;

import java.io.IOException;

import bingbot.ui.MainWindow;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * Represents a GUI for BingBot using FXML.
 */
public class Main extends Application {

    private BingBot bingBot = new BingBot();

    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/MainWindow.fxml"));
            AnchorPane ap = fxmlLoader.load();
            Scene scene = new Scene(ap);
            stage.setScene(scene);
            fxmlLoader.<MainWindow>getController().setBot(bingBot);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
