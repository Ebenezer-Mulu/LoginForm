import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class App extends Application{
    public static void main(String[] args) throws Exception {
       launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
      Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
      stage.initStyle(StageStyle.UNDECORATED);
      Scene scene = new Scene(root);
      stage.setScene(scene);
      stage.show();
        
    }
}
