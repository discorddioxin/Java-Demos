package fx.appthread;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * This code will freeze the GUI! Use your IDE to stop the program
 */
public class FXApplicationThreadDemo extends Application {

    @Override
    public void start(Stage primaryStage) {
        TextField field = new TextField();
        field.setDisable(true);

        Button button = new Button("Start");
        button.setOnAction(event -> {
            Thread thread = new Thread(() -> {
                for (long l = 0; l < Long.MAX_VALUE; l++)
                    if (l % 31 == 0) {
                        long value = l; // variable must be "effectively final"
                        Platform.runLater(() -> field.setText(String.valueOf(value)));
                    }
            });

            thread.start();
        });

        BorderPane pane = new BorderPane();
        pane.setTop(field);
        pane.setBottom(button);

        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}