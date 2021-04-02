package fx.worker;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class TaskDemo extends Application {

    @Override
    public void start(Stage primaryStage) {
        TextField field = new TextField();
        field.setDisable(true);

        Button button = new Button("Start");
        button.setOnAction(event -> {
            Task<Long> task = new Task<Long>() {
                @Override
                protected Long call() {
                    long l = 0;

                    for (; l < Long.MAX_VALUE; l++)
                        if (l % 31 == 0) {
                            updateValue(l);
                        }

                    return l;
                }
            };

            task.valueProperty().addListener((observableValue, oldValue, newValue) -> field.setText(String.valueOf(newValue)));
            Thread thread = new Thread(task);
            thread.setDaemon(true); // !! Important to ensure program closes when user closes window !!
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