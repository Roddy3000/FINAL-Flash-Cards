import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FlashCards extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource(("myGui.fxml")));
        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("Flash Cards for JAVA 2!");
        primaryStage.show();

    }
}
