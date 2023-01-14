package ui_layer;
import domain.MovieManager;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MovieApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        MovieManager movieManager = new MovieManager();
        ApplicationUI applicationUI = new ApplicationUI(movieManager);

        primaryStage.setScene(new Scene(applicationUI));
        primaryStage.getScene().getStylesheets().add(getClass().getResource("/data/style.css").toExternalForm());
        primaryStage.setTitle("Movie App");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
